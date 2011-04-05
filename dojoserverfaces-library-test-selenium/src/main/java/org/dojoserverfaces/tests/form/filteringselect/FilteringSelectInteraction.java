/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.filteringselect;

import org.dojoserverfaces.tests.widget.interaction.AbstractSingleValuedWidgetInteraction;
import org.dojoserverfaces.tests.widget.values.VariableName;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

public class FilteringSelectInteraction extends
        AbstractSingleValuedWidgetInteraction {
    public FilteringSelectInteraction(WidgetValues widgetValues) {
        super(widgetValues);
        this.TAG_NAME = "div//div[3]//input";
    }

    public void setDisplayedValue(String element, VariableName... vName) {
        // the selenium.type() does not work in case of the dijit combobox,
        // because it needs the options values, not the displayed values, but
        // these options values are displayed using javascript and are available
        // only on runtime, this combobox is not same a select box, using dijit
        // widget instance instead to set value which is performed by setValue
        // function.
        setValue(element, vName);
    }
}