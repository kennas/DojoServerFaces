/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.dojo;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PreRenderViewEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

import org.dojoserverfaces.component.DojoResource;
import org.dojoserverfaces.widget.DojoWidget;

/**
 * This component will be used to collect and then emit javascript required by
 * DojoServerFaces components. It will be a "transient" component. This
 * postpones its rendering till the end of the body tag. By that point all of
 * the DojoServerFaces tags should have posted their script.
 * 
 */
public final class DojoScriptBlockComponent extends DojoResource implements
        SystemEventListener {

    private static final String INIT_BLOCK_ID = "_dojoserverfaces_initscript";
    private static final String DESTROY_BLOCK_ID = "_dojoserverfaces_destroyscript";
    private static final String BODY_END = "body";
    private static final String BODY_BEGIN = "head";

    // The Javascript global space of Dojo Server Faces Library.
    private static final String DSF_SPACE = "dojo.faceslib";

    /**
     * Get reference for a global scoped dojo object
     * 
     * @param dojoObject
     *            A global scoped dojo object
     * @return Global reference of this dojo object on client side
     */
    public static String getGlobalReference(DojoWidget dojoObject) {
        if (!(dojoObject instanceof UIComponent)) {
            return null;
        }
        return new StringBuilder(DSF_SPACE).append("[\"")
                .append(((UIComponent) dojoObject).getClientId()).append("\"]")
                .toString();
    }

    /**
     * @param view
     *            to which to add a script block component
     */
    public static void addScriptBlockToView(UIViewRoot view) {
        /*
         * There are two situations we need to handle when adding a script block
         * component to the view: 1) full page rendering - In this case we'll
         * just add a component as a view resource and let the view manage it'r
         * rendering. 2) partial page rendering - In this case we need to add
         * this component to the list of those to be rendered as part of the
         * partial update.
         * 
         * We now handle two separate blocks, one for the initialization of
         * widgets and another for destroying existing widgets.
         * 
         * Some care needs to be taken here. We have run in to odd situations
         * adding the component as a resource for a partial update. There are
         * differences between Sun and MyFaces
         */
        FacesContext context = FacesContext.getCurrentInstance();
        PartialViewContext pvContext = context.getPartialViewContext();
        boolean partialUpdate = (null != pvContext)
                && pvContext.isAjaxRequest();
        DojoScriptBlockComponent sb = null;
        // check for an existing init script block
        sb = findInitBlockComponent(view.getComponentResources(context,
                partialUpdate ? BODY_BEGIN : BODY_END));
        if (null == sb) {
            // we need a block for destroy code used for partial updates
            sb = new DojoScriptBlockComponent(DESTROY_BLOCK_ID);
            if (partialUpdate) {
                // add it so it will render before any components
                view.addComponentResource(context, sb, BODY_BEGIN);
                // build the destroy code
                for (String id : pvContext.getRenderIds()) {
                    checkAndAddDestroyScript(sb, view.findComponent(id));
                }
                // add block to list of ids to render
                pvContext.getRenderIds().add(sb.getId());
            }
            else {
                // we need always emit a destroy block element because an
                // ajax update (above) needs to replace something but it
                // will contain no script code
                view.addComponentResource(context, sb, BODY_END);
            }
            // create a block to hold init code
            sb = new DojoScriptBlockComponent(INIT_BLOCK_ID);
            if (partialUpdate) {
                // Partial update is tricky, unlike Sun's RI MyFaces does
                // not render "resources" in the "body" at the end for a partial
                // update
                // At this time we will add the component to the head
                // just to store it somewhere. We will move it prior to
                // rendering.
                view.addComponentResource(context, sb, BODY_BEGIN);
                // add block to list of ids to render
                pvContext.getRenderIds().add(sb.getId());
            }
            else {
                view.addComponentResource(context, sb, BODY_END);
            }
        }
    }

    /**
     * Check the given component for being a DojoWidget and if so append destroy
     * code to the script block
     * 
     * @param scriptBlock
     * @param component
     */
    private static void checkAndAddDestroyScript(
            DojoScriptBlockComponent scriptBlock, UIComponent component) {
        if (component instanceof DojoWidget) {
            if (((DojoWidget) component).getWidgetType().isDijit()) {
                scriptBlock.addWidgetDestroyForId(component.getClientId());
            }
            else {
                FacesContext.getCurrentInstance().getExternalContext()
                        .log("Dojo objects cannot be refreshed using ajax.");
                // any clean up necessary for dojo objects? or is the
                // assumption that over writing the global will make the old
                // object a garbage collect candidate?
            }
            return;
            // TODO: we abort here assuming the destroy will wipe out all
            // children, is this appropriate?
        }
        // recurse through children looking for more widgets to destroy
        for (Iterator<UIComponent> i = component.getFacetsAndChildren(); i
                .hasNext();) {
            checkAndAddDestroyScript(scriptBlock, i.next());
        }
    }

    /**
     * @param view
     * @return the script block component used for this view's init widget
     *         scripts
     */
    public static DojoScriptBlockComponent findInitBlockComponent(
            UIViewRoot view) {
        /*
         * depending on full or partial rendering the block's location will be
         * different. It is expected that this function is first called from a
         * component rendered which will be after init block has been moved to
         * its proper location
         */
        return isAjaxUpdate(FacesContext.getCurrentInstance()) ? findInitBlockComponent(view
                .getChildren())
                : (DojoScriptBlockComponent) findResourceComponent(view,
                        INIT_BLOCK_ID, BODY_END);

    }

    /**
     * @param view
     * @return The script block component used for this view's destroy widget
     *         scripts. If null then there is no destroying to be done.
     */
    public static DojoScriptBlockComponent findDestroyBlockComponent(
            UIViewRoot view) {
        /*
         * depending on full or partial rendering the block's location will be
         * different
         */
        return (DojoScriptBlockComponent) findResourceComponent(view,
                DESTROY_BLOCK_ID,
                isAjaxUpdate(FacesContext.getCurrentInstance()) ? BODY_BEGIN
                        : BODY_END);
    }

    private static DojoScriptBlockComponent findInitBlockComponent(
            List<UIComponent> compList) {
        for (UIComponent comp : compList) {
            if (INIT_BLOCK_ID == comp.getId()) {
                return (DojoScriptBlockComponent) comp;
            }
        }
        return null;
    }

    private static boolean isAjaxUpdate(FacesContext context) {
        PartialViewContext pvContext = context.getPartialViewContext();
        return (null != pvContext) && pvContext.isAjaxRequest();
    }

    /*
     * This component is transient, the following local vars are only used to
     * build and render the script block
     */
    private HashSet<String> requiredModulesAdded = new HashSet<String>();
    private StringBuilder requiresScriptBlock = new StringBuilder();
    private HashSet<String> requiredThemeFilesAdded = new HashSet<String>();
    private StringBuilder requiredThemeFilesScriptBlock = new StringBuilder();
    private StringBuilder createGlobalSpaceScriptBlock = new StringBuilder();
    private StringBuilder preWidgetCreateScriptBlock = new StringBuilder();
    private StringBuilder destroyWidgetsScriptBlock = new StringBuilder();
    private StringBuilder createWidgetsScriptBlock = new StringBuilder();
    private StringBuilder postWidgetCreateScriptBlock = new StringBuilder();

    public DojoScriptBlockComponent(String id) {
        super();
        setId(id);
        // We need to move the init script block prior to rendering a
        // partialUpdate.
        if (id.equals(INIT_BLOCK_ID)) {
            getFacesContext().getViewRoot().subscribeToViewEvent(
                    javax.faces.event.PreRenderViewEvent.class, this);
        }
    }

    /*
     * @see
     * javax.faces.event.SystemEventListener#isListenerForSource(java.lang.Object
     * )
     */
    @Override
    public boolean isListenerForSource(Object source) {
        if (source instanceof UIViewRoot) {
            // only care about the view's pre-render
            return true;
        }
        return false;
    }

    /*
     * @see
     * javax.faces.event.SystemEventListener#processEvent(javax.faces.event.
     * SystemEvent)
     */
    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {
        // it is expected we only subscribed to this event for the init block
        // component
        if (event instanceof PreRenderViewEvent) {
            if (isAjaxUpdate(getFacesContext())) {
                // make sure init block is at the end
                final UIViewRoot viewRoot = getFacesContext().getViewRoot();
                // remove from temp location
                viewRoot.removeComponentResource(getFacesContext(), this,
                        BODY_BEGIN);
                // move to the end
                viewRoot.getChildren().add(this);
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.faces.component.UIComponent#encodeAll(javax.faces.context.FacesContext
     * )
     */
    @Override
    public void encodeAll(FacesContext context) throws IOException {
        char[] newline = { '\r', '\n' };
        ResponseWriter writer = context.getResponseWriter();
        /*
         * We will emitted the script block wrapped in a DIV. This will allow
         * the jsf ajax update to process it.
         */
        writer.startElement("div", null);
        writer.writeAttribute("id", getClientId(context), null);

        if ((requiresScriptBlock.length() > 0)
                || (createGlobalSpaceScriptBlock.length() > 0)
                || (preWidgetCreateScriptBlock.length() > 0)
                || (destroyWidgetsScriptBlock.length() > 0)
                || (createWidgetsScriptBlock.length() > 0)
                || (postWidgetCreateScriptBlock.length() > 0)
                || (requiredThemeFilesScriptBlock.length() > 0)) {
            writer.startElement("script", null);
            writer.writeAttribute("type", "text/javascript", null);
            boolean ajaxUpdate = isAjaxUpdate(context);
            if (!ajaxUpdate) {
                writer.write("//");
                writer.startCDATA();
                writer.write(newline);
            }

            StringBuilder initScript = new StringBuilder(
                    requiresScriptBlock.toString());
            initScript.append(getRequiredThemeFiles());
            if (!ajaxUpdate) {
                initScript.append("dojo.addOnLoad(function(){");
            }
            initScript.append("try{");
            if (createGlobalSpaceScriptBlock.length() > 0) {
                initScript.append(createGlobalSpaceScriptBlock.toString());
            }
            if (preWidgetCreateScriptBlock.length() > 0) {
                initScript.append(preWidgetCreateScriptBlock.toString());
            }
            if (destroyWidgetsScriptBlock.length() > 0) {
                // needed as added destroy statements used
                initScript.append("var w;");
                initScript.append(destroyWidgetsScriptBlock.toString());
            }
            if (createWidgetsScriptBlock.length() > 0) {
                initScript.append(createWidgetsScriptBlock.toString());
            }
            if (postWidgetCreateScriptBlock.length() > 0) {
                initScript.append(postWidgetCreateScriptBlock.toString());
            }
            initScript.append("}catch(e){console.log(e);}");
            if (!ajaxUpdate) {
                initScript
                        .append("dojo.publish('dojoserverfaces-init-complete');");
            }
            if (!ajaxUpdate) {
                initScript.append("});");
            }
            writer.write(initScript.toString());
            if (!ajaxUpdate) {
                writer.write(newline);
                writer.write("//");
                writer.endCDATA();
            }
            writer.endElement("script");
        }
        writer.endElement("div");
    }

    /**
     * Add script to load the required module.
     * 
     * @param requiredModule
     */
    public void addRequires(String requiredModule) {
        if (!requiredModulesAdded.contains(requiredModule)) {
            requiresScriptBlock.append("dojo.require(\"")
                    .append(requiredModule).append("\");");
            requiredModulesAdded.add(requiredModule);
        }
    }

    public void addRequiredThemeFiles(String requiredThemeFile) {
        if (!requiredThemeFilesAdded.contains(requiredThemeFile)) {
            if (requiredThemeFilesScriptBlock.length() == 0) {
                // 'base' theme file will be auto added
                requiredThemeFilesScriptBlock
                        .append("dojox.mobile.themeFiles=['base'");
            }
            requiredThemeFilesScriptBlock.append(",'")
                    .append(requiredThemeFile).append("'");
        }
    }

    private String getRequiredThemeFiles() {
        if (requiredThemeFilesScriptBlock.length() > 0) {
            // we need to ensure dojox.mobile.deviceTheme is after
            // dojox.mobile.themeFiles
            requiredThemeFilesScriptBlock
                    .append("];dojo.require(\"dojox.mobile.deviceTheme\");");
        }
        return requiredThemeFilesScriptBlock.toString();
    }

    /**
     * Add script to create the global space object.
     */
    public void addCreateGlobalSpaceScript() {
        if (createGlobalSpaceScriptBlock.length() == 0) {
            createGlobalSpaceScriptBlock.append("if(!").append(DSF_SPACE)
                    .append("){").append(DSF_SPACE).append("={};}");
        }
    }

    /**
     * Add the subscription script.
     * 
     * @param script
     *            subscription script.
     */
    public void addPreWidgetCreateScript(String script) {
        preWidgetCreateScriptBlock.append(script);
    }

    /**
     * Add script to destroy the indicated widget. However we want to keep an
     * element representing the component for jsf to find and replace.
     * 
     * @param widgetId
     */
    public void addWidgetDestroyForId(String widgetId) {
        destroyWidgetsScriptBlock.append("w=dijit.byId(\"").append(widgetId)
                .append("\");if(null!=w){dojo.create('div', {id:'")
                .append(widgetId)
                .append("'}, w.domNode, 'before');w.destroyRecursive();}");
    }

    /**
     * Add the script to initialize a widget.
     * 
     * @param script
     *            to add as part of the "onload" event handler.
     */
    public void addWidgetCreateScript(String script) {
        createWidgetsScriptBlock.append(script);
    }
    /**
     * Add the script to initialize a widget.
     * 
     * @param script
     *            to add as part of the "onload" event handler.
     */
    public void addPostWidgetCreateScript(String script) {
        postWidgetCreateScriptBlock.append(script);
    }
}
