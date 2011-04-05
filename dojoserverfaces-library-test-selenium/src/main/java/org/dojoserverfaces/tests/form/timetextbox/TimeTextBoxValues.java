/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.timetextbox;

import org.dojoserverfaces.tests.widget.values.WidgetValues;

public class TimeTextBoxValues extends WidgetValues {
    public TimeTextBoxValues() {
        super(new Long(10800000), new Long(14400000), new Long(18000000),
                new Long(21600000), "BAD", "8:30 AM", "9:30 AM", "10:30 AM",
                "11:30 AM");
    }
}