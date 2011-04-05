/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.gadget;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.widget.property.EnumPropertyBase;

/**
 * A Calendar component.
 * 
 */
@Gadget(dojoType = "dijit.Calendar")
class Calendar {

    static class DayWidthProperty extends EnumPropertyBase {
        private static String[] validValues = { "abbr", "wide", "narrow" };

        protected DayWidthProperty(String name, String propertyName) {
            super(name, propertyName, validValues);
        }
    }

    /**
     * Represent the days of the week in the calendar header. Values are abbr,
     * wide and narrow.
     */
    @Property(handler = DayWidthProperty.class)
    String dayWidth;

    /**
     * The event handler script to execute when the field value changes. This
     * may be immediate of when the field loses focus.
     */
    @Event(isDefault = true)
    String onChange;

    /**
     * Notification that a date cell was selected. It may be the same as the
     * previous value.
     */
    @Event
    String onValueSelected;
}