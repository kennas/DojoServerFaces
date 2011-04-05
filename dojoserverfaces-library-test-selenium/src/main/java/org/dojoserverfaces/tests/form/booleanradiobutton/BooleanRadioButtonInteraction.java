/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.booleanradiobutton;

import org.dojoserverfaces.tests.widget.interaction.AbstractSingleValuedWidgetInteraction;
import org.dojoserverfaces.tests.widget.values.VariableName;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

public class BooleanRadioButtonInteraction extends
        AbstractSingleValuedWidgetInteraction {
    public BooleanRadioButtonInteraction(WidgetValues widgetValues) {
        super(widgetValues);
    }

    public void setDisplayedValue(String element, VariableName... vName) {
        if (vName == null || vName[0] == VariableName.BAD) {// set empty value
            this.setValue(element, vName);
        }
        else {
            String value = widgetValues.getSeleniumValue(vName[0]);
            if (!value.equals(selenium.getValue(element))) {
                selenium.click(element);
            }
        }
    }
}