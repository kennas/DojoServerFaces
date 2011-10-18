/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.widget.interactions;

import org.dojoserverfaces.test.support.widget.WidgetValues;

public abstract class AbstractMultiValuedWidgetInteraction extends
        AbstractWidgetInteraction {

    public AbstractMultiValuedWidgetInteraction(WidgetValues widgetValues) {
        super(widgetValues);
    }

    public AbstractMultiValuedWidgetInteraction() {
        super();
    }

    @Override
    public boolean isMultiValued() {
        return true;
    }
}