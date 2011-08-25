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
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

import org.dojoserverfaces.component.dojo.DojoScriptBlockComponent;
import org.dojoserverfaces.constants.RendersChildren;
import org.dojoserverfaces.widget.DojoType;
import org.dojoserverfaces.widget.DojoWidget;
import org.dojoserverfaces.widget.PostBackHandler;
import org.dojoserverfaces.widget.property.DojoClass;
import org.dojoserverfaces.widget.property.PostCreateScript;
import org.dojoserverfaces.widget.property.Property;
import org.dojoserverfaces.widget.property.PropertyCollection;

@FacesRenderer(rendererType = "dojoserverfaces.renderer.default", componentFamily = "dojoserverfaces.component.default")
public class ComponentRenderer extends Renderer {

    private static final Object START_UP_CONTAINER_ID = "org.dojoserverfaces.START_UP_CONTAINER_ID";

    /**
     * Add init script to configure the dojo widget.
     * 
     * @param facesContext
     */
    protected void addInitScriptToScriptBlock(FacesContext facesContext,
            UIComponent component) {
        DojoWidget dojoWidget = (DojoWidget) component;
        StringBuilder widgetPostCreateInitializationScript = new StringBuilder();
        DojoType dojoType = dojoWidget.getWidgetType();
        StringBuilder widgetInitialization = new StringBuilder();
        String varName = null;
        DojoScriptBlockComponent initScriptBlock = DojoScriptBlockComponent
                .findInitBlockComponent(facesContext.getViewRoot());
        if (dojoWidget.getRenderChildrenType().equals(
                RendersChildren.YES_USE_ADD_CHILD)) {
            varName = component.getId();
            widgetInitialization.append("var ").append(varName).append("=");
        }
        getWidgetInitializationScript(component, widgetInitialization,
                widgetPostCreateInitializationScript);
        if (dojoType.isDijit()) {
            // since all the widget who has children isDijit=true
            // I write here.
            if (dojoWidget.getRenderChildrenType().equals(
                    RendersChildren.YES_USE_ADD_CHILD)) {
                widgetInitialization.append(";");
                addComponentChildren(initScriptBlock, component,
                        widgetInitialization,
                        widgetPostCreateInitializationScript, varName);
                widgetInitialization.append(varName);
            }

            String startUpContainerId = (String) facesContext.getAttributes()
                    .get(START_UP_CONTAINER_ID);
            if (startUpContainerId == null
                    || component.getId().equals(startUpContainerId)) {
                widgetInitialization.append(".startup();");
            }
            else {
                widgetInitialization.append(";");
            }
            initScriptBlock.addWidgetCreateScript(widgetInitialization
                    .toString());
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
            initScriptBlock.addCreateGlobalSpaceScript();
            initScriptBlock.addPreWidgetCreateScript(widgetCreation.toString());
        }
        addComponentRequires(initScriptBlock, component);
        if (widgetPostCreateInitializationScript.length() > 0) {
            initScriptBlock
                    .addPostWidgetCreateScript(widgetPostCreateInitializationScript
                            .toString());
        }
    }

    /**
     * 
     * @param initScriptBlock
     * @param component
     * @param postCreateProperties
     * @return
     */
    private void getWidgetInitializationScript(UIComponent component,
            StringBuilder widgetCreateScript,
            StringBuilder widgetPostCreateInitializationScript) {
        DojoWidget dojoWidget = (DojoWidget) component;
        DojoType dojoType = dojoWidget.getWidgetType();
        Collection<Property> properties = dojoWidget.getPropertyHandlers();
        Collection<Property> postCreateProperties = new ArrayList<Property>();
        widgetCreateScript.append("new ").append(dojoType.geTypeName())
                .append("({");
        String jsonPropertySetting;
        boolean addComma = false;
        for (Property property : properties) {
            if (null != (jsonPropertySetting = property
                    .getAsJsonPropertySetting(component))) {
                if (addComma) {
                    widgetCreateScript.append(',');
                }
                widgetCreateScript.append(jsonPropertySetting);
                addComma = true;
            }
            // let's save any properties that also have init code
            // to run after the widget is created
            if (property instanceof PostCreateScript) {
                postCreateProperties.add(property);
            }
        }
        if (null != postCreateProperties) {
            for (Property property : postCreateProperties) {
                String postCreate = ((PostCreateScript) property)
                        .getPostCreateInitialization(component);
                widgetPostCreateInitializationScript.append(postCreate);
            }
        }
        if (dojoType.isDijit()) {
            // constructor takes element id as second arg
            widgetCreateScript.append("},\"").append(component.getClientId())
                    .append("\")");
        }
        else {
            widgetCreateScript.append("})");
        }
    }

    // handle component's children
    private void addComponentChildren(DojoScriptBlockComponent initScriptBlock,
            UIComponent component, StringBuilder widgetInitialization,
            StringBuilder postWidgetInitialization, String varName) {
        for (UIComponent child : component.getChildren()) {
            StringBuilder childCreation = new StringBuilder();
            StringBuilder postChildCreation = new StringBuilder();
            getWidgetInitializationScript(child, childCreation,
                    postChildCreation);
            // do we need this?
            postWidgetInitialization.append(postChildCreation);
            widgetInitialization.append(varName).append(".addChild(")
                    .append(childCreation.toString()).append(");");
            addComponentRequires(initScriptBlock, child);
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

        if (dojoWidget.isContainer()
                && !context.getAttributes().containsKey(START_UP_CONTAINER_ID)) {
            context.getAttributes().put(START_UP_CONTAINER_ID,
                    component.getId());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.faces.render.Renderer#encodeChildren(javax.faces.context.FacesContext
     * , javax.faces.component.UIComponent) It only called if
     * component.getRendersChildren() is true and we do nothing here .It will be
     * called after encodeBegin and before encodeEnd
     */
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

        if (component.getId().equals(
                context.getAttributes().get(START_UP_CONTAINER_ID))) {
            context.getAttributes().remove(START_UP_CONTAINER_ID);
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

        // If there are any attached client behaviors we need to also
        // decode those.
        if (component instanceof ClientBehaviorHolder) {
            decodeClientBehaviors(context, component);
        }
    }

    public void decodeClientBehaviors(FacesContext context,
            UIComponent component) {
        if (!(component instanceof ClientBehaviorHolder)) {
            return;
        }
        Map<String, List<ClientBehavior>> clientBehaviorMap = ((ClientBehaviorHolder) component)
                .getClientBehaviors();
        if (clientBehaviorMap == null || clientBehaviorMap.isEmpty()) {
            return;
        }

        Map<String, String> paramMap = context.getExternalContext()
                .getRequestParameterMap();
        // Just decode the behaviors bound to postback event?
        String eventName = paramMap.get("javax.faces.behavior.event");
        if (eventName != null) {
            List<ClientBehavior> behaviors = clientBehaviorMap.get(eventName);
            if (behaviors != null && !behaviors.isEmpty()) {
                String source = paramMap.get("javax.faces.source");
                if (component.getClientId().equals(source)) {
                    for (ClientBehavior behavior : behaviors) {
                        behavior.decode(context, component);
                    }
                }
            }
        }
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
