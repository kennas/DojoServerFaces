/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.gadget.progressbar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.dojoserverfaces.tests.values.StringData;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

@ManagedBean(name = "progressBarBean")
@SessionScoped
public class ProgressBarBean {
    private Boolean indeterminate = false;
    private String label;
    private StringData beanBoundValue;
    private Integer maximum = 1;
    private Integer progress = 1;
    private Integer places;
    private WidgetValues widgetValues = new ProgressBarValues();
    
    public ProgressBarBean() {
        this.beanBoundValue = new StringData(widgetValues.getFirst());
    }
    
    public Boolean getIndeterminate() {
        return indeterminate;
    }
    public void setIndeterminate(Boolean indeterminate) {
        this.indeterminate = indeterminate;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public StringData getBeanBoundValue() {
        return this.beanBoundValue;
    }
    public void setBeanBoundValue(StringData value) {
        this.beanBoundValue = value;
    }
    public Integer getMaximum() {
        return maximum;
    }
    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }
    public Integer getPlaces() {
        return places;
    }
    public void setPlaces(Integer places) {
        this.places = places;
    }

    public WidgetValues getWidgetValues() {
        return widgetValues;
    }

    public void setWidgetValues(WidgetValues widgetValues) {
        this.widgetValues = widgetValues;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }
}