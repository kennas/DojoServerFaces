/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tag.property;

import javax.faces.component.UIComponent;

import org.dojoserverfaces.widget.property.DojoClass;
import org.dojoserverfaces.widget.property.Property;

public class CellWidgetProperty extends Property implements DojoClass {
    private String dojoType = null;

    public CellWidgetProperty(String attributeName, String propertyName,
            String dojoType) {
        super(attributeName, propertyName);
        this.dojoType = dojoType;
    }

    public CellWidgetProperty(String name, String dojoType) {
        this(name, name, dojoType);
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        Object value = getAttributeValue(component);
        if (null != value) {
            return value.toString();
        }
        return null;
    }

    @Override
    public String getDojoType(UIComponent component) {
        return dojoType;
    }
}
