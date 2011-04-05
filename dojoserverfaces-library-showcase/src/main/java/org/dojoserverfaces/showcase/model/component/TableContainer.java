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
public class TableContainer extends WigdetBase {
    private Integer cols = 1;
    private String labelWidth = "200";
    private Boolean showLabels = true;
    private String orientation = "horiz";
    private Integer spacing = 1;
    private String customClass = "labelsAndValues";

    private final Map<String, String> orientations = new LinkedHashMap();
    {
        orientations.put("horiz", "horiz");
        orientations.put("vert", "vert");
    }

    private final Map<String, String> customClasses = new LinkedHashMap();
    {
        customClasses.put("", "");
        customClasses.put("justLabels", "justLabels");
        customClasses.put("labelsAndValues", "labelsAndValues");
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    public String getLabelWidth() {
        return labelWidth;
    }

    public void setLabelWidth(String labelWidth) {
        this.labelWidth = labelWidth;
    }

    public Boolean getShowLabels() {
        return showLabels;
    }

    public void setShowLabels(Boolean showLabels) {
        this.showLabels = showLabels;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public Integer getSpacing() {
        return spacing;
    }

    public void setSpacing(Integer spacing) {
        this.spacing = spacing;
    }

    public String getCustomClass() {
        return customClass;
    }

    public void setCustomClass(String customClass) {
        this.customClass = customClass;
    }

    public Map<String, String> getCustomClasses() {
        return customClasses;
    }

    public Map<String, String> getOrientations() {
        return orientations;
    }
}
