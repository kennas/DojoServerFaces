/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NumberSpinner extends NumberInputBase {
    private String type = "decimal";
    private Double min = 0D;
    private Double max = 100D;
    private String places = "0";
    private String pattern = "###";

    private Boolean selectOnClick = true;
    private Boolean trim = true;
    private Boolean required = true;

    private String placeHolder = "Age: (" + min + ", " + max + ")";
    private String rangeMessage = "Out of range";

    private Double smallDelta = 10D;
    private Double largeDelta = 50D;

    private Integer age = 18;

    private final Map<String, String> showcaseTypes = new HashMap<String, String>();
    {
        showcaseTypes.put("decimal", "decimal");
        // showcaseTypes.put("percent", "percent");
        // showcaseTypes.put("currency", "currency");
    }

    private final Collection<String> showcasePatterns = new ArrayList<String>();
    {
        showcasePatterns.add("###");
        showcasePatterns.add("000");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

    public Double getSmallDelta() {
        return smallDelta;
    }

    public void setSmallDelta(Double smallDelta) {
        this.smallDelta = smallDelta;
    }

    public Double getLargeDelta() {
        return largeDelta;
    }

    public void setLargeDelta(Double largeDelta) {
        this.largeDelta = largeDelta;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRangeMessage() {
        return rangeMessage;
    }

    public void setRangeMessage(String rangeMessage) {
        this.rangeMessage = rangeMessage;
    }

    public Boolean getSelectOnClick() {
        return selectOnClick;
    }

    public void setSelectOnClick(Boolean selectOnClick) {
        this.selectOnClick = selectOnClick;
    }

    public Boolean getTrim() {
        return trim;
    }

    public void setTrim(Boolean trim) {
        this.trim = trim;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Map<String, String> getShowcaseTypes() {
        return showcaseTypes;
    }

    public Collection<String> getShowcasePatterns() {
        return showcasePatterns;
    }
}
