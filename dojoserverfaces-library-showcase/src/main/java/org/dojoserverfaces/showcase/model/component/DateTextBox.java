/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DateTextBox extends ValidationTextBoxBase {
    private String pattern = "MM/dd/yyyy";
    private String formatLength = "short";

    private Date date = new Date();

    private Boolean hasDownArrow = true;
    private Boolean openOnClick = false;
    private Boolean forceWidth = true;
    private Boolean fullYear = false;
    private Boolean required = true;

    private final List<String> showcasePatterns = new ArrayList<String>();
    {
        showcasePatterns.add("");
        showcasePatterns.add("MM/dd/yyyy");
        showcasePatterns.add("yyyy-MM-dd");
        showcasePatterns.add("yyyy/MM/dd");
    }

    private final Map<String, String> showcaseFormatLengths = new LinkedHashMap<String, String>();
    {
        showcaseFormatLengths.put("full", "full");
        showcaseFormatLengths.put("long", "long");
        showcaseFormatLengths.put("medium", "medium");
        showcaseFormatLengths.put("short", "short");
    }

    public String getFormatLength() {
        return formatLength;
    }

    public void setFormatLength(String formatLength) {
        this.formatLength = formatLength;
    }

    public Boolean getHasDownArrow() {
        return hasDownArrow;
    }

    public void setHasDownArrow(Boolean hasDownArrow) {
        this.hasDownArrow = hasDownArrow;
    }

    public Boolean getOpenOnClick() {
        return openOnClick;
    }

    public void setOpenOnClick(Boolean openOnClick) {
        this.openOnClick = openOnClick;
    }

    public Boolean getForceWidth() {
        return forceWidth;
    }

    public void setForceWidth(Boolean forceWidth) {
        this.forceWidth = forceWidth;
    }

    public Boolean getFullYear() {
        return fullYear;
    }

    public void setFullYear(Boolean fullYear) {
        this.fullYear = fullYear;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Map<String, String> getShowcaseFormatLengths() {
        return showcaseFormatLengths;
    }

    public List<String> getShowcasePatterns() {
        return showcasePatterns;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFormattedDate() {
        String patternLocal = pattern;
        if (patternLocal == null || patternLocal.isEmpty()) {
            patternLocal = "yyyy-MM-dd";
        }
        final DateFormat DF = new SimpleDateFormat(patternLocal);
        return DF.format(date);
    }
}
