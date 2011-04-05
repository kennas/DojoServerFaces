/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.gadget.toolbar;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.dojoserverfaces.tests.values.StringData;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

@ManagedBean(name = "toolbarBean")
@RequestScoped
public class ToolbarBean {
    private WidgetValues widgetValues = new ToolbarValues();

    private StringData beanBoundValue;

    public Date getCurrentTime() {
        return (new Date());
    }

    public ToolbarBean() {
        this.beanBoundValue = new StringData(widgetValues.getFirst());
    }

    public StringData getBeanBoundValue() {
        return this.beanBoundValue;
    }

    public WidgetValues getWidgetValues() {
        return widgetValues;
    }

    public void setBeanBoundValue(StringData value) {
        this.beanBoundValue = value;
    }

    public void setWidgetValues(WidgetValues widgetValues) {
        this.widgetValues = widgetValues;
    }
}