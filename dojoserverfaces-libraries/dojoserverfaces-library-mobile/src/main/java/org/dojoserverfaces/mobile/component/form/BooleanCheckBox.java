/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.form;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.constants.HtmlElementType;
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.property.ValueProperty;

/**
 * An input component for setting boolean values using a checkbox.
 * 
 */
@EditableValueHolder(dojoType = "dojox.mobile.CheckBox", elementType = HtmlElementType.INPUT_CHECKBOX, requiredCss = { "dojox/mobile/themes/{theme}/CheckBox.css" })
public class BooleanCheckBox extends InputBase {
    public static class CheckedValue extends ValueProperty {
        public CheckedValue() {
            super("checked");
        }

        /**
         * @param name
         * @param propertyName
         */
        public CheckedValue(String name, String propertyName) {
            // generated code assumes a two argument constructor
            // is available. Ignoring the arguments as this is
            // special value prop.
            this();
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            javax.faces.component.EditableValueHolder editableValue = (javax.faces.component.EditableValueHolder) component;
            Object attrValue = editableValue.getSubmittedValue();
            if (null == attrValue) {
                if (editableValue.isLocalValueSet()) {
                    attrValue = Helper.getConvertedValue(component,
                            editableValue.getLocalValue());
                }
                else {
                    attrValue = Helper.getConvertedValue(component,
                            editableValue.getValue());
                }
            }
            if ("true".equals(attrValue)) {
                return "true";
            }
            else {
                // this "checked" attribute should only be written if the
                // components value is true
                return null;
            }
        }

        @Override
        public void retrievePostBackValue(FacesContext context,
                UIComponent component) {
            Map<String, String> requestParams = context.getExternalContext()
                    .getRequestParameterMap();
            String value = (String) requestParams.get(component.getClientId());
            ;
            if (null == value) {
                ((javax.faces.component.EditableValueHolder) component)
                        .setSubmittedValue("false");
            }
            else {
                ((javax.faces.component.EditableValueHolder) component)
                        .setSubmittedValue("true");
            }
        }
    }

    /**
     * The value for this component.
     */

    @Property(handler = CheckedValue.class)
    Object value;
}
