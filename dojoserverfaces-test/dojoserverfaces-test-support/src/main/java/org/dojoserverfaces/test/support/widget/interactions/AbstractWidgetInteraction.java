/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.widget.interactions;

import org.dojoserverfaces.test.support.widget.VariableName;
import org.dojoserverfaces.test.support.widget.WidgetValues;

import com.thoughtworks.selenium.Selenium;

public abstract class AbstractWidgetInteraction implements WidgetInteraction {
    protected Selenium selenium;

    protected WidgetValues widgetValues;

    public AbstractWidgetInteraction(WidgetValues widgetValues) {
        this.widgetValues = widgetValues;
    }

    public AbstractWidgetInteraction() {
        this(new WidgetValues());
    }

    @Override
    public Selenium getSelenium() {
        return selenium;
    }

    @Override
    public void setSelenium(Selenium selenium) {
        this.selenium = selenium;
    }

    @Override
    public WidgetValues getWidgetValues() {
        return widgetValues;
    }

    @Override
    public void setWidgetValues(WidgetValues widgetValues) {
        this.widgetValues = widgetValues;
    }

    @Override
    public void setEmpty(String element) {
        this.setDisplayedValue(element, (VariableName[]) null);
    }
}