/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.convert.Converter;

@ManagedBean
@SessionScoped
public class HorizontalSlider {
    Double value;
    Boolean showButtons;
    Integer minimum = 0;
    Integer maximum = 100;
    Integer discreteValues = 11;
    Integer pageIncrement = 2;
    Boolean clickSelect;
    Integer slideDuration = 100;
    String labelStyle;

    public String getLabelStyle() {
        return labelStyle;
    }

    public void setLabelStyle(String labelStyle) {
        this.labelStyle = labelStyle;

    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getShowButtons() {

        return showButtons;

    }

    public void setShowButtons(Boolean showButtons) {
        this.showButtons = showButtons;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        if (this.minimum != minimum)
            this.value = minimum.doubleValue();
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        if (this.maximum != maximum)
            this.value = this.minimum.doubleValue();
        this.maximum = maximum;
    }

    public Integer getDiscreteValues() {
        return discreteValues;
    }

    public void setDiscreteValues(Integer discreteValues) {
        this.discreteValues = discreteValues;
    }

    public Integer getPageIncrement() {
        return pageIncrement;
    }

    public void setPageIncrement(Integer pageIncrement) {
        this.pageIncrement = pageIncrement;
    }

    public Boolean getClickSelect() {
        return clickSelect;
    }

    public void setClickSelect(Boolean clickSelect) {
        this.clickSelect = clickSelect;
    }

    public Integer getSlideDuration() {
        return slideDuration;
    }

    public void setSlideDuration(Integer slideDuration) {
        this.slideDuration = slideDuration;
    }

}
