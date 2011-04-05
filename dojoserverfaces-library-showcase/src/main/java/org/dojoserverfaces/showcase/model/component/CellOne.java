/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CellOne extends DefaultCell {
    protected String options = "countries continent city";
    protected String fomatter = "function(inDatum){return isNaN(inDatum) ? '...' : dojo.currency.format(inDatum, this.constraint);}";
    protected String constraint = "{currency: 'EUR'}";
    protected String widgetClass;
    protected String field;
    protected String name = "ID";

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getFomatter() {
        return fomatter;
    }

    public void setFomatter(String fomatter) {
        this.fomatter = fomatter;
    }

    public String getConstraint() {
        return constraint;
    }

    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }

    public String getWidgetClass() {
        return widgetClass;
    }

    public void setWidgetClass(String widgetClass) {
        this.widgetClass = widgetClass;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
