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
public class GridContainerLite {
    private Boolean autoRefresh = true;
    private String dragHandleClass;
    private Integer nbZones = 2;
    private Boolean doLayout = true;
    private Boolean isAutoOrganized = true;
    private String colWidths = "25,25,25,25";

    public Boolean getAutoRefresh() {
        return autoRefresh;
    }

    public void setAutoRefresh(Boolean autoRefresh) {
        this.autoRefresh = autoRefresh;
    }

    public String getDragHandleClass() {
        return dragHandleClass;
    }

    public void setDragHandleClass(String dragHandleClass) {
        this.dragHandleClass = dragHandleClass;
    }

    public Integer getNbZones() {
        return nbZones;
    }

    public void setNbZones(Integer nbZones) {
        this.nbZones = nbZones;
    }

    public Boolean getDoLayout() {
        return doLayout;
    }

    public void setDoLayout(Boolean doLayout) {
        this.doLayout = doLayout;
    }

    public Boolean getIsAutoOrganized() {
        return isAutoOrganized;
    }

    public void setIsAutoOrganized(Boolean isAutoOrganized) {
        this.isAutoOrganized = isAutoOrganized;
    }

    public String getColWidths() {
        return colWidths;
    }

    public void setColWidths(String colWidths) {
        this.colWidths = colWidths;
    }
}
