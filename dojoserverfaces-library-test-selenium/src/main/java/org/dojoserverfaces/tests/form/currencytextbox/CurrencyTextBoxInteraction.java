/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.currencytextbox;

import org.dojoserverfaces.tests.widget.interaction.AbstractSingleValuedWidgetInteraction;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

public class CurrencyTextBoxInteraction extends
        AbstractSingleValuedWidgetInteraction {
    public CurrencyTextBoxInteraction(WidgetValues widgetValues) {
        super(widgetValues);
        this.TAG_NAME = "div//div[2]//input";
    }
}