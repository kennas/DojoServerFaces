/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.component.UIComponent;

/**
 * Property handler for properties accepting an array of element id strings. The
 * id specified can be a component id, which will be converted to the client id,
 * or an element id. This handler will accept a value of type String[] or a
 * String value where a space separates individual String values.
 * 
 */
public class ElementIdArrayProperty extends Property {

    public ElementIdArrayProperty(String name) {
        super(name);
    }

    public ElementIdArrayProperty(String name, String propertyName) {
        super(name, propertyName);
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        Object value = getAttributeValue(component);
        if (null != value) {
            String[] targets;
            if (value instanceof String[]) {
                targets = (String[]) value;
            }
            else if (value instanceof String) {
                if (((String) value).isEmpty()) {
                    return null;
                }
                targets = ((String) value).split("\\s");
            }
            else {
                log(component, "invalid value type");
                return null;
            }
            StringBuilder propertyValue = new StringBuilder("[");
            boolean addComma = false;
            for (String id : targets) {
                UIComponent target = component.findComponent(id);
                if (null != target) {
                    id = target.getClientId();
                }
                propertyValue.append((String) (addComma ? ",\"" : "\""))
                        .append(id).append('"');
                addComma = true;
            }
            propertyValue.append(']');
            return propertyValue.toString();
        }
        return null;
    }
}
