/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import java.util.Map;

import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.PostBackHandler;

public class ValueProperty extends Property implements PostBackHandler {

    public ValueProperty() {
        super("value");
    }

    public ValueProperty(String name) {
        super(name);
    }

    public ValueProperty(String name, String propertyName) {
        super(name, propertyName);
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        if (component instanceof EditableValueHolder) {
            // if editableValueHolder then the value could be from alternate
            // variables
            EditableValueHolder editableValue = (EditableValueHolder) component;
            Object submittedValue = editableValue.getSubmittedValue();
            if (null != submittedValue) {
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
                return Helper.makeStringVar(Helper.getConvertedValue(component,
                        editableValue.getLocalValue()));
            }
        }
        return Helper.makeStringVar(Helper.getConvertedValue(component,
                ((ValueHolder) component).getValue()));
    }

    protected Object decodeSubmittedValue(FacesContext context,
            Object submittedValue) throws ConverterException {
        return submittedValue;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.dojoserverfaces.widget.PostBackHandler#retrievePostBackValue(javax.faces.context
     * .FacesContext, javax.faces.component.UIComponent)
     */
    @Override
    public void retrievePostBackValue(FacesContext context,
            UIComponent component) {
        Map<String, String> requestParams = context.getExternalContext()
                .getRequestParameterMap();
        Object submittedValue = requestParams.get(component.getClientId());
        if (null != submittedValue) {
            ((EditableValueHolder) component)
                    .setSubmittedValue(decodeSubmittedValue(context,
                            submittedValue));
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.dojoserverfaces.widget.PostBackHandler#convertPostBackValue(javax.faces.context
     * .FacesContext, javax.faces.component.UIComponent, java.lang.Object)
     */
    @Override
    public Object convertPostBackValue(FacesContext context,
            UIComponent component, Object submittedValue) {

        if (null != submittedValue) {
            Converter converter = Helper.getConverter(component);
            if (null != converter) {
                return converter.getAsObject(context, component,
                        (String) submittedValue);
            }
            return submittedValue;
        }
        return null;
    }
}
