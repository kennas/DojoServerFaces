/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.component.UIComponent;

/**
 * Property handler for properties accepting an array of strings. This handler
 * will accept a value of type String[] or a String value where a space
 * separates individual String values.
 * 
 */
public class StringArrayProperty extends Property {

    public StringArrayProperty(String name) {
        super(name);
    }

    public StringArrayProperty(String name, String propertyName) {
        super(name, propertyName);
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        Object value = getAttributeValue(component);
        if (null != value) {
            String[] values;
            if (value instanceof String[]) {
                values = (String[]) value;
            }
            else if (value instanceof String) {
                if (((String) value).isEmpty()) {
                    return null;
                }
                values = ((String) value).split("\\s");
            }
            else {
                log(component, "invalid value type");
                return null;
            }
            StringBuilder propertyValue = new StringBuilder("[");
            boolean addComma = false;
            for (String s : values) {
                propertyValue.append((String) (addComma ? ",\"" : "\""))
                        .append(s).append('"');
                addComma = true;
            }
            propertyValue.append(']');
            return propertyValue.toString();
        }
        return null;
    }
}
