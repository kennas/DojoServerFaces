/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

@ManagedBean
@SessionScoped
public class ProgressBar {
    private Boolean indeterminate = false;
    private String label = null;
    private String progress = "0%";
    private Integer maximum = 1;
    private Integer places;
    private String url = new StringBuilder()
            .append(((ServletContext) FacesContext.getCurrentInstance()
                    .getExternalContext().getContext()).getContextPath())
            .append("/rest/progress/value").toString();;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getProgress() {

        return progress;
    }

    public void setProgress(String progress) {

        this.progress = progress;
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

}
