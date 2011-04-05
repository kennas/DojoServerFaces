/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.util;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class Helper {
    private Helper() {
    }

    /*
     * Helper methods
     */

    /**
     * @param value
     *            java string to convert to javascript string declaration.
     * @return value as a javascript string declaration. That is a string, with
     *         any special chars escaped (e.g. double quote and return chars)
     *         and surrounded with double quotes.
     */
    public static String makeStringVar(String value) {
        if (null == value) {
            return null;
        }
        StringBuffer s = new StringBuffer("\"");
        // TODO: is there is more escaping that would need to be done
        value = value.replace("\\", "\\\\");
        value = value.replace("\"", "\\\"");
        value = value.replace("\t", "\\t");
        value = value.replace("\r", "\\r");
        value = value.replace("\n", "\\n");
        s.append(value).append('"');
        return s.toString();
    }

    /**
     * @param component
     * @return a Converter object either explicitly attached to the component or
     *         implied by the class type of the value bound to the component's
     *         value or null.
     */
    public static Converter getConverter(UIComponent component) {
        if (!(component instanceof ValueHolder)) {
            return null;
        }
        Converter converter = ((ValueHolder) component).getConverter();
        if (null == converter) {
            FacesContext context = FacesContext.getCurrentInstance();
            ValueExpression ve = component.getValueExpression("value");
            if (null != ve) {
                Class<?> valueType = ve.getType(context.getELContext());
                if (null != valueType) {
                    converter = context.getApplication().createConverter(
                            valueType);
                }
            }
        }
        return converter;
    }

    /**
     * @param component
     * @param value
     * @return the string representation of value using, if available, any
     *         converter associated with the component.
     */
    public static String getConvertedValue(UIComponent component, Object value) {
        if (null != value) {
            Converter converter = ((ValueHolder) component).getConverter();
            if ((null == converter) && !(value instanceof String)) {
                converter = FacesContext.getCurrentInstance().getApplication()
                        .createConverter(value.getClass());
            }
            if (null != converter) {
                return converter.getAsString(FacesContext.getCurrentInstance(),
                        component, value);
            }
            return value.toString();
        }
        return null;
    }

    /**
     * @param component
     * @param name
     * @return the value of the requested attribute
     */
    public static Object getAttributeValue(UIComponent component, String name) {
        // TODO: use an efficient method on a DojoWidget component as opposed
        // the the generic UIComponent method.
        // ** However,there appears to be a problem for props like dataGrid 
        // structure where attrs are added to the attribute map.
        return component.getAttributes().get(name);
    }

    /**
     * Quote a string with ""
     */
    public static String quote(String s) {
        return new StringBuilder("\"").append(s).append("\"").toString();
    }

    /**
     * check if a string is null or ""
     */
    public static boolean isEmpty(String s) {
        return (s == null || s.length() == 0);
    }

}
