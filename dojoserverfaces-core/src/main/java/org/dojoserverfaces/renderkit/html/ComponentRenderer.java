/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.renderkit.html;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

import org.dojoserverfaces.component.dojo.DojoScriptBlockComponent;
import org.dojoserverfaces.constants.ChildrenRenderType;
import org.dojoserverfaces.widget.DojoType;
import org.dojoserverfaces.widget.DojoWidget;
import org.dojoserverfaces.widget.PostBackHandler;
import org.dojoserverfaces.widget.property.DojoClass;
import org.dojoserverfaces.widget.property.PostCreateScript;
import org.dojoserverfaces.widget.property.Property;
import org.dojoserverfaces.widget.property.PropertyCollection;

@FacesRenderer(rendererType = "dojoserverfaces.renderer.default", componentFamily = "dojoserverfaces.component.default")
public class ComponentRenderer extends Renderer {

    /**
     * Add init script to configure the dojo widget.
     * 
     * @param facesContext
     */
    protected void addInitScriptToScriptBlock(FacesContext facesContext,
            UIComponent component) {
        DojoWidget dojoWidget = (DojoWidget) component;
        Collection<Property> postCreateProperties = new ArrayList<Property>();
        DojoType dojoType = dojoWidget.getWidgetType();
        StringBuilder widgetInitialization = new StringBuilder();
        DojoScriptBlockComponent initScriptBlock = DojoScriptBlockComponent
                .findInitBlockComponent(facesContext.getViewRoot());
        widgetInitialization.append(getWidgetCreationScript(component,
                postCreateProperties));
        if (dojoType.isDijit()) {
            widgetInitialization.append(".startup();");
            initScriptBlock.addWidgetCreateScript(widgetInitialization
                    .toString());
            if (null != postCreateProperties) {
                StringBuilder postWidgetCreation = new StringBuilder();
                for (Property property : postCreateProperties) {
                    String postCreate = ((PostCreateScript) property)
                            .getPostCreateInitialization(component);
                    postWidgetCreation.append(postCreate);
                }
                if (postWidgetCreation.length() > 0) {
                    initScriptBlock
                            .addPostWidgetCreateScript(postWidgetCreation
                                    .toString());
                }
            }
        }
        else {
            // then it must be an object that will be a widget property
            // so make it a field of the giant addOnLoad function being
            // generated
            StringBuilder widgetCreation = new StringBuilder(
                    DojoScriptBlockComponent
                            .getGlobalReference((DojoWidget) component))
                    .append("=").append(widgetInitialization.toString())
                    .append(';');
            widgetInitialization = widgetCreation;
            if (null != postCreateProperties) {
                for (Property property : postCreateProperties) {
                    widgetInitialization.append(((PostCreateScript) property)
                            .getPostCreateInitialization(component));
                }
            }
            initScriptBlock.addCreateGlobalSpaceScript();
            initScriptBlock.addPreWidgetCreateScript(widgetInitialization
                    .toString());
        }
        // move add requires to the end because require modules depend on
        // widgets we used
        // some widgets's property (like inlineEditBox's editor property) is set
        // in the getWidgetCreationScript method
        // so move it to the end it does not have bad influence on other widgets
        addComponentRequires(initScriptBlock, component);
    }

    /**
     * 
     * @param initScriptBlock
     * @param component
     * @param postCreateProperties
     * @return
     */
    private String getWidgetCreationScript(UIComponent component,
            Collection<Property> postCreateProperties) {
        DojoWidget dojoWidget = (DojoWidget) component;
        DojoType dojoType = dojoWidget.getWidgetType();
        Collection<Property> properties = dojoWidget.getPropertyHandlers();
        StringBuilder widgetInitialization = new StringBuilder("");
        widgetInitialization.append("new ").append(dojoType.geTypeName())
                .append("({");
        String jsonPropertySetting;
        boolean addComma = false;
        for (Property property : properties) {
            if (null != (jsonPropertySetting = property
                    .getAsJsonPropertySetting(component))) {
                if (addComma) {
                    widgetInitialization.append(',');
                }
                widgetInitialization.append(jsonPropertySetting);
                addComma = true;
            }
            // let's save any properties that also have init code
            // to run after the widget is created
            if (property instanceof PostCreateScript) {
                postCreateProperties.add(property);
            }
        }

        if (dojoType.isDijit()) {
            // constructor takes element id as second arg
            widgetInitialization.append("},\"").append(component.getClientId())
                    .append("\")");
        }
        else {
            widgetInitialization.append("})");
        }
        return widgetInitialization.toString();
    }

    // handle component's children
    private void addComponentChildren(FacesContext facesContext,
            UIComponent component) {
        DojoScriptBlockComponent initScriptBlock = DojoScriptBlockComponent
                .findInitBlockComponent(facesContext.getViewRoot());
        String componentId = component.getId();
        StringBuilder parentScript = new StringBuilder("var ");
        parentScript.append(componentId).append(" = dijit.byId('")
                .append(component.getClientId()).append("');");
        initScriptBlock.addWidgetCreateScript(parentScript.toString());
        for (UIComponent child : component.getChildren()) {
            addComponentRequires(initScriptBlock, child);
            this.addChildToWidgetCreateScriptBlock(initScriptBlock,
                    componentId,
                    getWidgetCreationScript(child, new ArrayList<Property>()));
        }

    }

    private void addComponentRequires(DojoScriptBlockComponent initScriptBlock,
            UIComponent component) {
        DojoWidget dojoWidget = (DojoWidget) component;
        Collection<Property> properties = dojoWidget.getPropertyHandlers();
        initScriptBlock.addRequires(dojoWidget.getWidgetType().geTypeName());
        // let's first see if any property actually requires a dojo class
        addPropertyRequires(initScriptBlock, component, properties.iterator());

    }

    private void addPropertyRequires(DojoScriptBlockComponent initScriptBlock,
            UIComponent component, Iterator<Property> propertyIterator) {
        Property property;
        while (propertyIterator.hasNext()) {
            property = propertyIterator.next();
            if (property.isSet(component)) {
                if (property instanceof DojoClass
                        && ((DojoClass) property).getDojoType(component) != null) {
                    initScriptBlock.addRequires(((DojoClass) property)
                            .getDojoType(component));
                }
                else if (property instanceof PropertyCollection) {
                    addPropertyRequires(initScriptBlock, component,
                            ((PropertyCollection) property).iterator(component));
                }
            }
        }
    }

    /**
     * 
     * @param initScriptBlock
     * @param parentId
     * @param childScript
     */
    private void addChildToWidgetCreateScriptBlock(
            DojoScriptBlockComponent initScriptBlock, String parentId,
            String childScript) {
        StringBuilder addChildScript = new StringBuilder();
        addChildScript = new StringBuilder(parentId);
        addChildScript.append(".addChild(");
        addChildScript.append(childScript).append(");");
        initScriptBlock.addWidgetCreateScript(addChildScript.toString());

    }

    @Override
    public void encodeBegin(FacesContext context, UIComponent component)
            throws IOException {
        DojoWidget dojoWidget = (DojoWidget) component;

        if (dojoWidget.getWidgetType().isDijit()) {
            ResponseWriter writer = context.getResponseWriter();
            // render the element to which we'll attach a dojo widget
            writer.write(dojoWidget.getElement().getElement(context, component));
        }
        // just in case the "component" implicit object ("cc") is used in an
        // expression
        // of a child tag (e.g. "#{cc.clientId)"), we need to make it available
        // ...
        component.pushComponentToEL(context, component);
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) {

    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component)
            throws IOException {
        DojoWidget dojoWidget = (DojoWidget) component;

        component.popComponentFromEL(context);
        if (dojoWidget.getWidgetType().isDijit()) {
            String closeTag = dojoWidget.getElement().getElementClose(context,
                    component);
            if (null != closeTag) {
                ResponseWriter writer = context.getResponseWriter();
                writer.write(closeTag);
            }
        }
        addInitScriptToScriptBlock(context, component);
        if (dojoWidget.getRenderChildrenType().equals(
                ChildrenRenderType.USE_ADD_CHILD)) {
            addComponentChildren(context, component);
        }
    }

    @Override
    public final void decode(FacesContext context, UIComponent component) {
        PostBackHandler postBackHandler;

        if (!component.isRendered()) {
            return;
        }

        postBackHandler = ((DojoWidget) component).getPostBackHandler();
        if (null == postBackHandler) {
            return;
        }

        // TODO: in standard JSF is a component was disabled or readonly
        // then no submitted value is retrieved. However that does not take
        // into account the javascript may be used on the client to "enable"
        // the field for input. Hmm, what to do? Probably better to follow
        // standard JSF

        postBackHandler.retrievePostBackValue(context, component);

        // TODO: If there are any attached client behaviors we need to also
        // decode those.
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.faces.render.Renderer#getConvertedValue(javax.faces.context.
     * FacesContext, javax.faces.component.UIComponent, java.lang.Object)
     */
    @Override
    public Object getConvertedValue(FacesContext context,
            UIComponent component, Object submittedValue)
            throws ConverterException {
        PostBackHandler postBackHandler;

        postBackHandler = ((DojoWidget) component).getPostBackHandler();
        if (null == postBackHandler) {
            return null;
        }

        return postBackHandler.convertPostBackValue(context, component,
                submittedValue);
    }
}
