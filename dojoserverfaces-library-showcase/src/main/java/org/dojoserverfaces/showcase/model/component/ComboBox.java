/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ComboBox {
    private Boolean disabled;
    private Boolean readOnly;
    private Boolean required;
    private Boolean selectOnClick;
    private Boolean trim;
    private Boolean autoComplete;
    private Boolean hasDownArrow = true;
    private Boolean ignoreCase;
    private Integer searchDelay = 100;
    private String highlightMatch = "first";
    private String onBlur;
    private String onChange;
    private String onFocus;
    private String onSelect;
    private String forceCase;
    private String placeHolder = "select your faviorate state";
    private String value;
    private String[] options = { "1", "3", "4", "5", "7", "9" };

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private Integer maxLength = 10;

    public Boolean getAutoComplete() {
        return autoComplete;
    }

    public void setAutoComplete(Boolean autoComplete) {
        this.autoComplete = autoComplete;
    }

    public Boolean getHasDownArrow() {
        return hasDownArrow;
    }

    public void setHasDownArrow(Boolean hasDownArrow) {
        this.hasDownArrow = hasDownArrow;
    }

    public Boolean getIgnoreCase() {
        return ignoreCase;
    }

    public void setIgnoreCase(Boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    public Integer getSearchDelay() {
        return searchDelay;
    }

    public void setSearchDelay(Integer searchDelay) {
        this.searchDelay = searchDelay;
    }

    public String getHighlightMatch() {
        return highlightMatch;
    }

    public void setHighlightMatch(String highlightMatch) {
        this.highlightMatch = highlightMatch;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
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

    public String getOnBlur() {
        return onBlur;
    }

    public void setOnBlur(String onBlur) {
        this.onBlur = onBlur;
    }

    public String getOnChange() {
        return onChange;
    }

    public void setOnChange(String onChange) {
        this.onChange = onChange;
    }

    public String getOnFocus() {
        return onFocus;
    }

    public void setOnFocus(String onFocus) {
        this.onFocus = onFocus;
    }

    public String getOnSelect() {
        return onSelect;
    }

    public void setOnSelect(String onSelect) {
        this.onSelect = onSelect;
    }

    public String getForceCase() {
        return forceCase;
    }

    public void setForceCase(String forceCase) {
        this.forceCase = forceCase;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHoder) {
        this.placeHolder = placeHoder;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

}
