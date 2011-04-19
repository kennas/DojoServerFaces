/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.util.Collection;

import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.event.ListenerFor;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Component;
import org.dojoserverfaces.component.dojo.DojoScriptBlockComponent;
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.DojoType;
import org.dojoserverfaces.widget.DojoWidget;
import org.dojoserverfaces.widget.PostBackHandler;
import org.dojoserverfaces.widget.element.HtmlElement;
import org.dojoserverfaces.widget.property.Property;

/**
 * A dataStore used java collection as its source
 * 
 */

@Component
@ListenerFor(systemEventClass = javax.faces.event.PostAddToViewEvent.class)
public class JsfDataModelReadStore extends UIComponentBase implements
        DojoWidget {
    private static final String REQUIRED_MODULE = "dojo.data.ItemFileReadStore";
    private static final String JSF_DOJO_COMPONENT_FAMILY = "jsfdojo.component";
    private static final String HEAD = "head";
    private static final org.dojoserverfaces.widget.DojoType widgetType = new org.dojoserverfaces.widget.SimpleObjectType(
            "dojo.data.ItemFileReadStore");
    private static final org.dojoserverfaces.widget.element.HtmlElement element = org.dojoserverfaces.widget.element.ElementRendererFactory
            .getRenderer(org.dojoserverfaces.constants.HtmlElementType.DIV);

    @Override
    public String getFamily() {
        return JSF_DOJO_COMPONENT_FAMILY;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.faces.component.UIComponent#processEvent(javax.faces.event.
     * ComponentSystemEvent)
     */
    @Override
    public void processEvent(javax.faces.event.ComponentSystemEvent event)
            throws javax.faces.event.AbortProcessingException {
        javax.faces.context.FacesContext context = javax.faces.context.FacesContext
                .getCurrentInstance();
        javax.faces.component.UIViewRoot view = context.getViewRoot();

        // rendered or not we are going to added these resources
        // this is because a subsequent ajax update may render the component

        // a ComponentResource is only added once(per jsf spec)
        // add in the dojo library resource
        // org.dojoserverfaces.component.dojo.DojoLibraryComponent.addLibraryReferenceToView(view);

        // Make sure there is a script block on the view to which we'll add some
        // script
        org.dojoserverfaces.component.dojo.DojoScriptBlockComponent
                .addScriptBlockToView(view);

        /*
         * Move the dojo object component to the head. This takes it out of any
         * parent rendering sequence as it does not render any html markup. It
         * will also insure it is created before the widgets that may reference
         * it.
         */
        view.addComponentResource(getFacesContext(), this, HEAD);

    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        DojoScriptBlockComponent scriptBlock = DojoScriptBlockComponent
                .findInitBlockComponent(context.getViewRoot());
        scriptBlock.addRequires(REQUIRED_MODULE);
        scriptBlock.addCreateGlobalSpaceScript();
        String script = getScript();
        if (script != null && script.length() > 0) {
            scriptBlock.addPreWidgetCreateScript(script);
        }

    }

    /*
     * Forming the rendered js code
     */
    private String getScript() {

        StringBuilder sb = new StringBuilder(
                DojoScriptBlockComponent.getGlobalReference(this));
        sb.append("= new ").append(REQUIRED_MODULE).append("({data:");
        StringBuilder items = new StringBuilder();
        boolean addComa = false;
        String[] properties = null;
        String identifier = this.getIdentification();
        StringBuilder propertyWithId = new StringBuilder();
        boolean addObjComa = false;
        if (this.getProperties() != null) {
            if (!this.getProperties().contains(identifier)) {
                propertyWithId.append(identifier).append(" ")
                        .append(this.getProperties());
            }
            else {
                propertyWithId.append(this.getProperties());
            }
            properties = propertyWithId.toString().split("\\s");
        }

        Object value = this.getData();
        if (value instanceof Collection) {
            for (Object obj : (Collection<?>) value) {
                if (properties == null) {
                    properties = this.getAllProperties(obj);
                }
                if (addObjComa) {
                    items.append(",");
                }
                items.append("{");
                addComa = false;
                for (String propertyName : properties) {
                    if (addComa) {
                        items.append(",");
                    }
                    items.append(propertyName)
                            .append(":")
                            .append(Helper.quote(this.getPropertyValue(obj,
                                    propertyName).toString()));
                    addComa = true;
                }
                items.append("}");
                addObjComa = true;
            }
        }
        sb.append("{identifier:");
        sb.append(Helper.quote(identifier)).append(",label:")
                .append(Helper.quote(identifier)).append(",items:[");
        sb.append(items.toString()).append("]}");
        sb.append("});");
        return sb.toString();

    }

    /**
     * The properties of an object in the java collection. They are divided by
     * space
     */
    @Attribute
    public String getProperties() {
        return (String) getStateHelper().eval("properties");
    }

    /**
     * 
     * @param properties
     */
    public void setProperties(String properties) {
        getStateHelper().put("properties", properties);
    }

    /**
     * Data Source usually a java collection
     */
    @Attribute(required = true)
    public Object getData() {
        return getStateHelper().eval("data");
    }

    /**
     * 
     * @param data
     */
    public void setData(Object data) {
        getStateHelper().put("data", data);
    }

    /**
     * Identifier of an object in collection
     */
    @Attribute(required = true)
    public String getIdentification() {
        return (String) getStateHelper().eval("identification");
    }

    /**
     * 
     * @param identification
     */
    public void setIdentification(String identification) {
        getStateHelper().put("identification", identification);
    }

    @Override
    public HtmlElement getElement() {
        return element;
    }

    @Override
    public String getJsfNode() {
        return null;
    }

    @Override
    public Collection<Property> getPropertyHandlers() {
        return null;
    }

    @Override
    public DojoType getWidgetType() {
        return widgetType;
    }

    @Override
    public PostBackHandler getPostBackHandler() {
        return null;
    }

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    private Object getPropertyValue(Object bean, String propertyName) {

        PropertyDescriptor[] properties;
        try {
            properties = Introspector.getBeanInfo(bean.getClass())
                    .getPropertyDescriptors();

            for (PropertyDescriptor prop : properties) {
                String name = prop.getName();
                if (!"class".equals(name)) {
                    if (propertyName.equals(name)) {
                        return prop.getReadMethod().invoke(bean);
                    }
                }
            }
        }
        catch (Throwable ex) {
            // TODO: handle.
            return null;
        }
        return null;
    }

    private String[] getAllProperties(Object bean) {
        String[] value;
        boolean addcoma = false;
        StringBuilder propString = new StringBuilder();
        PropertyDescriptor[] properties;
        try {
            properties = Introspector.getBeanInfo(bean.getClass())
                    .getPropertyDescriptors();

            for (PropertyDescriptor prop : properties) {
                String name = prop.getName();
                if (!"class".equals(name)) {
                    if (addcoma) {
                        propString.append(",");
                    }
                    propString.append(name);
                    addcoma = true;
                }
            }
            value = propString.toString().split(",");
        }
        catch (Throwable ex) {
            // TODO: handle.
            return null;
        }
        return value;

    }
}
