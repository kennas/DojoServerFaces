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
 * A component allowing for easy input of time values. It allows for either
 * typing or choosing a time from a time-picker . The time-picker is
 * configurable. The value must allow for conversion between a string that
 * represents the time as a number of milliseconds.
 * 
 */
@EditableValueHolder(dojoType = "dijit.form.TimeTextBox")
class TimeTextBox extends ValidationTextBoxBase {

    public static class TimeValue extends ValueProperty {
        public TimeValue() {
            super();
        }

        public TimeValue(String name) {
            super(name);
        }

        public TimeValue(String name, String propertyName) {
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
            // expect a string representing the time in milliseconds
            // we need to create an ISO formatted time string
            // and make sure the value is not adjusted for
            // server or client time zone
            long timeInMillis = Long.parseLong(valueAsString);
            
            String hour = Long.toString(timeInMillis/(3600000));
            String minute =  Long.toString(((timeInMillis % (3600000)) / 60000)); 
            String seconds = Long.toString(((timeInMillis % (3600000)) % 60000) / 1000);
            long millis = ((timeInMillis % (3600000)) % 60000) % 1000;

            StringBuilder timeValue = 
                new StringBuilder("dojo.date.stamp.fromISOString(\"T");
            if (hour.length()<2) timeValue.append('0');
            timeValue.append(hour).append(':');
            if (minute.length()<2) timeValue.append('0');
            timeValue.append(minute).append(':');
            if (seconds.length()<2) timeValue.append('0');
            timeValue.append(seconds);
            
            if (millis > 0) {
                timeValue.append('.');
                String fraction = Long.toString(millis);
                if (fraction.length() < 3) timeValue.append((fraction.length() < 2) ? "00" : "0");
                timeValue.append(fraction);
            }
            timeValue.append("\", new Date())");
            return timeValue.toString();
        }

        @Override
        public Object decodeSubmittedValue(FacesContext context,
                Object submittedValue) throws ConverterException {
            // TODO validation of string
            if (null == submittedValue || ((String) submittedValue).isEmpty()) {
                return null;
            }
            /*
             * incoming string should be in the format "Thh:mm:ss" we need to
             * turn this into a number of millisecs string
             * 
             * lets see if we can re-use standard faces messages for errors e.g.
             * "javax.faces.converter.DateTimeConverter.TIME"
             */

            int hour = Integer.parseInt(((String) submittedValue).substring(1,
                    3));
            int minute = Integer.parseInt(((String) submittedValue).substring(
                    4, 6));
            int second = Integer.parseInt(((String) submittedValue)
                    .substring(7));
            long time = (hour * 60 * 60) + (minute * 60) + second;
            return Long.toString(time * 1000);
        }
    }

    /**
     * Pattern used for formating the time display
     */
    @Property(group = "constraints", name = "timePattern")
    String pattern;

    /**
     * override strings for am in times
     */
    @Property(group = "constraints")
    String am;

    /**
     * override strings for pm in times
     */
    @Property(group = "constraints")
    String pm;

    /**
     * override the locale on this widget only, choosing from
     * djConfig.extraLocale
     */
    @Property(group = "constraints")
    String locale;

    /**
     * Amount of time to increment by for each click (ISO time format e.g. 15
     * minutes is "T00:15:00")
     */
    @Property(group = "constraints")
    String clickableIncrement;

    /**
     * Amount of time to increment the visible markers (ISO time format e.g. 15
     * minutes is "T00:15:00")
     */
    @Property(group = "constraints")
    String visibleIncrement;

    /**
     * Amount of time to show in the time picker (ISO time format e.g. 15
     * minutes is "T00:15:00")
     */
    @Property(group = "constraints")
    String visibleRange;

    // TODO - range constraints?
    
    /**
     * A time, in milliseconds, to be used as is (i.e no adjustment for time zone.
     */
    @Property(handler = TimeValue.class)
    Object value;
}
