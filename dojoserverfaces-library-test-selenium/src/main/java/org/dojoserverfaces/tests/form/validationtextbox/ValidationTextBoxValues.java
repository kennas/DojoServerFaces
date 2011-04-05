/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.validationtextbox;

import org.dojoserverfaces.tests.widget.values.WidgetValues;

public class ValidationTextBoxValues extends WidgetValues {
    public ValidationTextBoxValues() {
        super(new String("12345"), new String("0000a"), new String("11111"),
                new String("22222"), "badValue");
    }
}