/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

import org.dojoserverfaces.util.Helper;

public class NumberValue extends ValueProperty {

    public NumberValue() {
        super();
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        if (component instanceof EditableValueHolder) {
            // if editableValueHolder then the value could be from alternate
            // variables
            EditableValueHolder editableValue = (EditableValueHolder) component;
            Object submittedValue = editableValue.getSubmittedValue();
            if (null != submittedValue) {
                // if there is a submitted value we'll not try to make a date
                if (submittedValue instanceof String) {
                    // just return current "submitted" value
                    return Helper.makeStringVar((String) submittedValue);
                }
                else {
                    // TODO consider handling this as an err?
                    return Helper.makeStringVar(submittedValue.toString());
                }
            }
            else if (editableValue.isLocalValueSet()) {
                return getAsJavascriptNumber(Helper.getConvertedValue(
                        component, editableValue.getLocalValue()));
            }
        }
        return getAsJavascriptNumber(Helper.getConvertedValue(component,
                ((ValueHolder) component).getValue()));
    }

    private String getAsJavascriptNumber(String valueAsString) {
        return valueAsString;
    }

    @Override
    public Object decodeSubmittedValue(FacesContext context,
            Object submittedValue) throws ConverterException {
        // TODO validation of string
        if (null == submittedValue || ((String) submittedValue).isEmpty()) {
            return null;
        }
        return submittedValue;
    }

}