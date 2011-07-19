/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import javax.faces.component.UIComponent;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.validator.DoubleRangeValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.property.NumberProperty;
import org.dojoserverfaces.widget.property.ValueProperty;

/**
 * Base class for number input fields
 */
class NumberInputBase extends ValidationTextBoxBase {

    static class NumberValue extends ValueProperty {

        public NumberValue() {
            super();
        }

        public NumberValue(String string, String string2) {
            this();
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            if (component instanceof javax.faces.component.EditableValueHolder) {
                // if editableValueHolder then the value could be from alternate
                // variables
                javax.faces.component.EditableValueHolder editableValue = 
                    (javax.faces.component.EditableValueHolder) component;
                Object submittedValue = editableValue.getSubmittedValue();
                if (null != submittedValue) {
                    // if there is a submitted value we'll not try to make a
                    // date
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

        String getAsJavascriptNumber(String valueAsString) {
            return valueAsString;
        }
    }

    static class MinConstraintProperty extends NumberProperty implements
            Validator {
        public MinConstraintProperty(String name, String propertyName) {
            super(name, propertyName);
        }

        @Override
        public void validate(FacesContext context, UIComponent component,
                Object value) throws ValidatorException {
            Number min = (Number) component.getAttributes().get(this.getName());
            if (null != min) {
                DoubleRangeValidator validator = new DoubleRangeValidator();
                validator.setMinimum(min.doubleValue());
                validator.validate(context, component, value);
            }
        }
    }

    static class MaxConstraintProperty extends NumberProperty implements
            Validator {
        public MaxConstraintProperty(String name, String propertyName) {
            super(name, propertyName);
        }

        @Override
        public void validate(FacesContext context, UIComponent component,
                Object value) throws ValidatorException {
            Number max = (Number) component.getAttributes().get(this.getName());
            if (null != max) {
                DoubleRangeValidator validator = new DoubleRangeValidator();
                validator.setMaximum(max.doubleValue());
                validator.validate(context, component, value);
            }
        }
    }

    /**
     * The value, a number, for this component.
     */
    @Property(handler = NumberValue.class)
    Number value;

    /**
     * The message to display if the value is not within the defined constraints
     */
    @Property
    String rangeMessage;

    /**
     * override the locale on this widget only, choosing from
     * djConfig.extraLocale
     */
    @Property(group = "constraints")
    String locale;

    /**
     * override localized convention with this pattern. As a result, all users
     * will see the same behavior, regardless of locale, and your application
     * may not be globalized. See
     * http;//www.unicode.org/reports/tr35/#Number_Format_Patterns.
     */
    @Property(group = "constraints")
    String pattern;

    /**
     * number of decimal places to accept.
     */
    @Property(group = "constraints")
    String places;

    /**
     * strict parsing, false by default. When strict mode is false, certain
     * allowances are made to be more tolerant of user input, such as 'am'
     * instead of 'a.m.', some white space may be optional, etc.
     */
    @Property(group = "constraints")
    String strict;

    /**
     * choose a format type based on the locale from the following; decimal,
     * scientific (not yet supported), percent, currency. decimal by default.
     */
    @Property(group = "constraints")
    String type;

    /**
     * Minimum signed value. Default is -Infinity
     */
    @Property(group = "constraints", handler = MinConstraintProperty.class)
    Double min;

    /**
     * Maximum signed value. Default is +Infinity
     */
    @Property(group = "constraints", handler = MaxConstraintProperty.class)
    Double max;
}
