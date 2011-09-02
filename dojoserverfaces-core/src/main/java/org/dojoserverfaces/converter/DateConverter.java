/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Coverter of java.util.Date, java.sql.Date, and java.sql.Timestamp.
 * 
 */
public class DateConverter implements Converter {
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        ValueExpression ve = component.getValueExpression("value");
        Class<?> valueType = ve.getType(context.getELContext());
        if (valueType.isAssignableFrom(java.util.Date.class)) {
            try {
                return (java.util.Date) df.parse(value);
            }
            catch (ParseException e) {
                // TO-DO handle this exception
            }
        }
        if (valueType.isAssignableFrom(java.sql.Date.class)) {
            return java.sql.Date.valueOf(value);
        }
        else if (valueType.isAssignableFrom(java.sql.Timestamp.class)) {
            try {
                Date dt = df.parse(value);
                return new java.sql.Timestamp(dt.getTime());
            }
            catch (ParseException e) {
                // TO-DO handle this exception
            }
        }
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        return new SimpleDateFormat("yyyy-MM-dd Z").format(value);
    }

}
