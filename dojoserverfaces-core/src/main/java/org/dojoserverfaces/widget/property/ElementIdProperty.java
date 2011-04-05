/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.component.UIComponent;

import org.dojoserverfaces.util.Helper;

/**
 * Property handler for properties expecting an id of an html element.
 * The id specified can be a component id, which will be converted to the
 * client id, or an actual element id.
 */
public class ElementIdProperty extends Property {

    public ElementIdProperty(String name) {
        super(name);
    }

    public ElementIdProperty(String name, String propertyName) {
        super(name, propertyName);
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        Object value = getAttributeValue(component);
        if ((null != value) && (!((String) value).isEmpty())) {
            UIComponent target = component.findComponent((String) value);
            if (null != target){
                return Helper.makeStringVar(target.getClientId());                
            }
            // allowed to use non component element id
            return Helper.makeStringVar(value.toString());
        }
        return null;
    }
}
