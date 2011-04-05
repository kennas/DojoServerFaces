/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ValidationTextBox extends ValidationTextBoxBase {
    private String regExp = "\\d{5}";
    private String promptMessage = "Regular Expression: " + regExp;
    private String validatorMessage = "You entered an invalid text.";
    private String requiredMessage = "This field is required";
    private Object tooltipPosition = "after";

    private Boolean required = true;

    private String regedStr;

    private final Map<String, String> showcasePositions = new LinkedHashMap<String, String>();
    {
        showcasePositions.put("before", "before");
        showcasePositions.put("after", "after");
        showcasePositions.put("above", "above");
        showcasePositions.put("below", "below");
    }

    public String getRegExp() {
        return regExp;
    }

    public void setRegExp(String regExp) {
        this.regExp = regExp;
    }

    public String getRegedStr() {
        return regedStr;
    }

    public void setRegedStr(String regedStr) {
        this.regedStr = regedStr;
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }

    public String getValidatorMessage() {
        return validatorMessage;
    }

    public void setValidatorMessage(String validatorMessage) {
        this.validatorMessage = validatorMessage;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getRequiredMessage() {
        return requiredMessage;
    }

    public void setRequiredMessage(String requiredMessage) {
        this.requiredMessage = requiredMessage;
    }

    public Object getTooltipPosition() {
        return tooltipPosition;
    }

    public void setTooltipPosition(Object tooltipPosition) {
        this.tooltipPosition = tooltipPosition;
    }

    public Map<String, String> getShowcasePositions() {
        return showcasePositions;
    }
}
