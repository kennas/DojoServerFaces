/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import javax.faces.component.UIComponent;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.property.ValueProperty;

/**
 * 
 * A easy-to-use date entry component that allows either typing or choosing a
 * date from a calendar.
 * 
 */
@EditableValueHolder(dojoType = "dijit.form.DateTextBox")
class DateTextBox extends ValidationTextBoxBase {

    public static class DateValue extends ValueProperty {
        public DateValue() {
            super();
        }

        public DateValue(String name) {
            super(name);
        }

        public DateValue(String name, String propertyName) {
            super(name, propertyName);
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            if (component instanceof javax.faces.component.EditableValueHolder) {
                // if editableValueHolder then the value could be from alternate
                // variables
                javax.faces.component.EditableValueHolder editableValue = (javax.faces.component.EditableValueHolder) component;
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
                    return getAsJavascriptDate(Helper.getConvertedValue(
                            component, editableValue.getLocalValue()));
                }
            }
            return getAsJavascriptDate(Helper.getConvertedValue(component,
                    ((ValueHolder) component).getValue()));
        }

        String getAsJavascriptDate(String valueAsString) {
            // will handle any legal javascript date formatted string
            // however the submitted value will be in the from yyyy-MM-dd
            StringBuffer newDate = new StringBuffer("new Date(").append(
                    Helper.makeStringVar(valueAsString.replaceAll("-", "/")))
                    .append(')');
            return newDate.toString();
        }

        @Override
        public Object decodeSubmittedValue(FacesContext context,
                Object submittedValue) throws ConverterException {
            if (null == submittedValue || ((String) submittedValue).isEmpty()) {
                return null;
            }
            /*
             * TODO The submitted value will be in the string form yyyy-MM-dd I
             * do not see us being able to make this work with out the page
             * designer having to give us the correct format Perhaps, if there
             * is no converter and we are bound to a Date object we can convert
             * it right now.
             */

            return super.decodeSubmittedValue(context, submittedValue);
        }
    }

    /**
     * The date value, in yyyy-MM-dd format, for this component.
     */
    @Property(handler = DateValue.class)
    Object value;

    /**
     * Set this textbox to display a down arrow button, to open the drop down
     * list.
     */
    @Property
    Boolean hasDownArrow;

    /**
     * Set to true to open drop down upon clicking anywhere on the textbox.
     */
    @Property
    Boolean openOnClick;

    /**
     * Flag to _HasDropDown to make drop down Calendar width == <input> width
     */
    @Property
    Boolean forceWidth;

    /**
     * override localized convention with this pattern. As a result, all users
     * will see the same behavior, regardless of locale, and your application
     * may not be globalized. See
     * http://www.unicode.org/reports/tr35/#Date_Format_Patterns
     */
    @Property(group = "constraints", name = "datePattern")
    String pattern;

    /**
     * choose from formats: long, short, medium or full (plus any custom
     * additions). Defaults to 'short'
     */
    @Property(group = "constraints")
    String formatLength;

    /**
     * (format only) use 4 digit years whenever 2 digit years are called for
     */
    @Property(group = "constraints")
    Boolean fullYear;

    /**
     * override the locale on this widget only, choosing from
     * djConfig.extraLocale
     */
    @Property(group = "constraints")
    String locale;

    /**
     * false by default. If true, parsing matches exactly by regular expression.
     * If false, more tolerant matching is used for abbreviations and some white
     * space.}
     */
    @Property(group = "constraints")
    String strict;
}