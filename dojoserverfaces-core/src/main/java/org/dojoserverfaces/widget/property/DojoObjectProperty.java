/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.component.UIComponent;

/**
 * This property class is for properties that represent a dojo object of a
 * specific dojo type. The renderer will query properties for being this type
 * and will add dojo.requires statement for the the dojoType specified.
 * 
 */
public abstract class DojoObjectProperty extends Property implements DojoClass{
    private String dojoType;

    /**
     * @param attributeName
     *            component attribute name
     * @param propertyName
     *            widget property name
     * @param dojoType
     */
    protected DojoObjectProperty(String attributeName, String propertyName,
            String dojoType) {
        super(attributeName, propertyName);
        this.dojoType = dojoType;
    }

    /**
     * @param name
     *            component attribute and widget property name
     * @param dojoType
     */
    protected DojoObjectProperty(String name, String dojoType) {
        super(name);
        this.dojoType = dojoType;
    }

    /* (non-Javadoc)
     * @see org.dojoserverfaces.widget.property.DojoClass#getDojoType()
     */
    @Override
    public String getDojoType(UIComponent component) {
        return dojoType;
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        Object value = getAttributeValue(component);
        if (value != null) {
            StringBuilder newObjectConstructor = new StringBuilder("new ")
                    .append(dojoType).append('(').append(value).append(")");
            return newObjectConstructor.toString();
        }
        else
            return null;
    }
}
