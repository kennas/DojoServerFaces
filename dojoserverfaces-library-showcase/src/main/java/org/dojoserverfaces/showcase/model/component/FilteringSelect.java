/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FilteringSelect extends SelectStoreBase {
    private Boolean autoComplete = true;
    private String highlightMatch = "all";
    private Boolean ignoreCase = true;

    private String state;

    private final Map<String, String> highlightMatchs = new HashMap();
    {
        highlightMatchs.put("", "");
        highlightMatchs.put("first", "first");
        highlightMatchs.put("none", "none");
        highlightMatchs.put("all", "all");
    }

    public Boolean getAutoComplete() {
        return autoComplete;
    }

    public void setAutoComplete(Boolean autoComplete) {
        this.autoComplete = autoComplete;
    }

    public String getHighlightMatch() {
        return highlightMatch;
    }

    public void setHighlightMatch(String highlightMatch) {
        this.highlightMatch = highlightMatch;
    }

    public Boolean getIgnoreCase() {
        return ignoreCase;
    }

    public void setIgnoreCase(Boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    public Map<String, String> getHighlightMatchs() {
        return highlightMatchs;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
