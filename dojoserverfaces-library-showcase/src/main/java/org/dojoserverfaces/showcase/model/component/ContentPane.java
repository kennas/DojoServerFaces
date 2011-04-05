/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

@ManagedBean
@SessionScoped
public class ContentPane extends WigdetBase {
    private String defaultHref = new StringBuilder("/")
            .append(((ServletContext) FacesContext.getCurrentInstance()
                    .getExternalContext().getContext()).getContextPath())
            .append("/sampleContent.faces").toString();

    private String href = defaultHref;
    private String tooltip = "A Content Pane";

    private String loadingMessage = "<span class='dijitContentPaneLoading'>Loading, please wait...</span>";
    private String errorMessage = "<span class='dijitContentPaneError'>Sorry, an error occurred</span>";

    private Boolean extractContent = false;
    private Boolean refreshOnShow = true;
    private Boolean doLayout = true;

    private final Map<String, String> showcaseHrefs = new LinkedHashMap<String, String>();
    {
        showcaseHrefs.put(defaultHref, "Sample Content");
        showcaseHrefs.put("http://www.baidu.com", "Baidu");
    }

    private static final String[] COLORS = { "red", "orange", "green", "blue",
            "indigo", "purple" };

    private int currentFontColorIdx;

    public String getFontColor() {
        currentFontColorIdx = getNextColorIndex(currentFontColorIdx);
        
        try {
            Thread.sleep(1000); // Increase the process time to ensure the loadingMessage be displayed.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return COLORS[currentFontColorIdx];
    }

    private int getNextColorIndex(int except) {
        int idx = (int) (Math.random() * COLORS.length);
        while (idx == except) {
            idx = (int) (Math.random() * COLORS.length);
        }
        return idx;
    }

    public String title(String href) {
        return showcaseHrefs.get(href);
    }

    public String getLoadingMessage() {
        return loadingMessage;
    }

    public void setLoadingMessage(String loadingMessage) {
        this.loadingMessage = loadingMessage;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public Collection<String> getShowcaseHrefs() {
        return showcaseHrefs.keySet();
    }

    public Boolean getExtractContent() {
        return extractContent;
    }

    public void setExtractContent(Boolean extractContent) {
        this.extractContent = extractContent;
    }

    public Boolean getRefreshOnShow() {
        return refreshOnShow;
    }

    public void setRefreshOnShow(Boolean refreshOnShow) {
        this.refreshOnShow = refreshOnShow;
    }

    public Boolean getDoLayout() {
        return doLayout;
    }

    public void setDoLayout(Boolean doLayout) {
        this.doLayout = doLayout;
    }
}
