/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.datetextbox;

import java.util.Date;

import org.dojoserverfaces.tests.widget.values.VariableName;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

public class DateTextBoxValues extends WidgetValues {
	public DateTextBoxValues() {
		super(new Date(1263945600000L), new Date(1264032000000L), new Date(
				1264118400000L), new Date(1264204800000L), "BAD", "2010-01-20",
				"2010-01-21", "2010-01-22", "2010-01-23");
	}

	@Override
	public String getValues(VariableName... args) {
		return super.getDisplayedValues(args);
	}
}
