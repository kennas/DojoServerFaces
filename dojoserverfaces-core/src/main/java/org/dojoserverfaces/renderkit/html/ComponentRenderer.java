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
        Collection<Property> properties = dojoWidget.getPropertyHandlers();
        Collection<Property> postCreateProperties = null;

        DojoType dojoType = dojoWidget.getWidgetType();

        DojoScriptBlockComponent initScriptBlock = DojoScriptBlockComponent
                .findInitBlockComponent(facesContext.getViewRoot());
        initScriptBlock.addRequires(dojoWidget.getWidgetType().geTypeName());

        // let's first see if any property actually requires a dojo class
        addPropertyRequires(initScriptBlock, component, properties.iterator());

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
                if (null == postCreateProperties) {
                    postCreateProperties = new ArrayList<Property>();
                }
                postCreateProperties.add(property);
            }
        }

        if (dojoType.isDijit()) {
            // constructor takes element id as second arg
            widgetInitialization.append("},\"")
                    .append(component.getClientId(facesContext)).append("\")");
        }
        else {
            widgetInitialization.append("})");
        }
        if (dojoType.isDijit()) {
            if (null == postCreateProperties) {
                widgetInitialization.append(".startup();");
            }
            else {
                // note the scoping of the var by enclosing in {}
                StringBuilder widgetCreation = new StringBuilder("var ")
                        .append(component.getId()).append("=")
                        .append(widgetInitialization.toString()).append(';');
                widgetInitialization = widgetCreation;
                for (Property property : postCreateProperties) {
                    widgetInitialization.append(((PostCreateScript) property)
                            .getPostCreateInitialization(component,
                                    component.getId()));
                }
                widgetInitialization.append(component.getId()).append(
                        ".startup();");
            }
            initScriptBlock.addWidgetCreateScript(widgetInitialization
                    .toString());
        }
        else {
            // then it must be an object that will be a widget property
            // so make it a field of the giant addOnLoad function being
            // generated
            String field = component.getId();
            StringBuilder widgetCreation = new StringBuilder(
                    DojoScriptBlockComponent
                            .getGlobalReference((DojoWidget) component))
                    .append("=").append(widgetInitialization.toString())
                    .append(';');
            widgetInitialization = widgetCreation;
            if (null != postCreateProperties) {
                for (Property property : postCreateProperties) {
                    widgetInitialization.append(((PostCreateScript) property)
                            .getPostCreateInitialization(component, field));
                }
            }
            initScriptBlock.addCreateGlobalSpaceScript();
            initScriptBlock.addPreWidgetCreateScript(widgetInitialization
                    .toString());
        }
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
