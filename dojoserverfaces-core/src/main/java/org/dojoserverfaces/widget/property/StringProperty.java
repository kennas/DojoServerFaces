/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.component.UIComponent;

import org.dojoserverfaces.util.Helper;

/**
 * Property to render String values. This will escape special chars making the
 * value a legal javascript String.
 */
public class StringProperty extends Property {

    public StringProperty(String name) {
        super(name);
    }

    public StringProperty(String name, String propertyName) {
        super(name, propertyName);
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        Object value = getAttributeValue(component);
        if (null != value) {
            return Helper.makeStringVar(value.toString());
        }
        return null;
    }
}
