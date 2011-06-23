/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.dojoserverfaces.test.support.util.DojoServerFacesUtil;
import org.dojoserverfaces.test.support.widget.WidgetValues;

/**
 * The String values are submitted as Integers corresponding to the index of the
 * value defined in WidgetValues, throws ConverterException otherwise.
 * 
 * @author "jatin.varshney@in.ibm.com"
 * 
 */
@FacesConverter(value = "dojoserverfaces.ValueConverter")
public class ValueConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {

        if ((context == null) || (component == null)) {
            throw new NullPointerException();
        }

        if (value == null) {
            return null;
        }

        Integer obj = null;
        WidgetValues widgetValues = DojoServerFacesUtil.getWidgetValuesInstance(
                context, component);
        if (widgetValues != null) {
            obj = new Integer(widgetValues.getDisplayedValueIndex(value));
        }

        if ((Integer) obj == -1) {
            FacesMessage errMessage = new FacesMessage("Undefined value!");
            errMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(errMessage);
        }

        return obj;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        if ((context == null) || (component == null)) {
            throw new NullPointerException();
        }

        if (value == null) {
            return "";
        }

        String val = null;
        WidgetValues widgetValues = DojoServerFacesUtil.getWidgetValuesInstance(
                context, component);
        if (widgetValues != null) {
            if (value instanceof Integer)
                val = widgetValues.getDisplayedValue((Integer) value)
                        .toString();
            else {
                if (widgetValues.getFirst().getClass().equals(value.getClass())) {
                    int valueIndex = widgetValues.getValueIndex(value);
                    if (valueIndex != -1) {
                        val = widgetValues.getDisplayedValue(valueIndex);
                    }
                    else {
                        val = value.toString();
                    }
                }
                else
                    val = value.toString();
            }
        }
        return val;
    }
}