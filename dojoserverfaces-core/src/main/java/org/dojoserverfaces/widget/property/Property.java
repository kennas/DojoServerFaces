/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.application.ProjectStage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.dojoserverfaces.util.Helper;

/**
 * Class to handle the rendering of widget property values.
 * 
 */
public abstract class Property {

    private String name = null;
    private String propertyName = null;

    protected Property(String name) {
        this.name = name;
        this.propertyName = name;
    }

    protected Property(String name, String propertyName) {
        this.name = name;
        this.propertyName = propertyName;
    }

    /**
     * @return the name of the component attribute containing the value for the
     *         property.
     */
    public String getName() {
        return name;
    }

    /**
     * @return the name of the widget property.
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * @param component
     * @return a String representing the property value
     */
    public String getAsPropertyValue(UIComponent component) {
        Object value = getAttributeValue(component);
        if (null != value) {
            return value.toString();
        }
        return null;
    }

    /**
     * @param component
     * @return a String representing the property as a JSON value (e.g
     *         name:value)
     */
    public String getAsJsonPropertySetting(UIComponent component) {
        String value = getAsPropertyValue(component);
        if (null != value) {
            return buildJsonPropertySetting(getPropertyName(), value);
        }
        return null;
    }

    /**
     * @param component
     * @return the value of the attribute from the component
     */
    public Object getAttributeValue(UIComponent component) {
        return Helper.getAttributeValue(component, name);
    }

    public boolean isSet(UIComponent component) {
        // we have avoided actually evaluating the expression
        if (null != component.getValueExpression(name)) {
            return true;
        }
        // value could be a literal
        return (null != Helper.getAttributeValue(component, name));
    }

    /**
     * @param name
     * @param value
     * @return json property setting
     */
    protected String buildJsonPropertySetting(String name, String value) {
        // quote property name
        StringBuffer jp = new StringBuffer("\"").append(name).append("\"");
        jp.append(':').append(value);
        return jp.toString();
    }

    /**
     * Log a message for the indicated component. The component id and property
     * name will automatically be added in to the logged message.
     * 
     * @param component
     *            the component being processed
     * @param message
     *            the message to log
     */
    protected void log(UIComponent component, String message) {
        if (FacesContext.getCurrentInstance().isProjectStage(
                ProjectStage.Development)) {
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .log(component.getClass().getName() + message + " "
                            + "(id=" + component.getId() + ") " + getName()
                            + "=" + getAttributeValue(component));
        }
    }
}
