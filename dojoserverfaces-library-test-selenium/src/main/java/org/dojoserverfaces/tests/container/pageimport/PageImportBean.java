/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.container.pageimport;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.dojoserverfaces.tests.values.StringData;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

@ManagedBean(name = "pageImportBean")
@RequestScoped
public class PageImportBean {
    private WidgetValues widgetValues = new PageImportValues();

    private StringData beanBoundValue;

    public Date getCurrentTime() {
        return (new Date());
    }

    public PageImportBean() {
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