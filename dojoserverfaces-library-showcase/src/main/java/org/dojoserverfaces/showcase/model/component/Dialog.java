/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Dialog extends WigdetBase {
    private String title = "A Dialog";

    private Boolean open = false;
    private Integer duration = 300;
    private Boolean refocus = true;
    private Boolean autofocus = true;
    private Boolean draggable = true;
    private String ariaDescribedBy = "intro";

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getRefocus() {
        return refocus;
    }

    public void setRefocus(Boolean refocus) {
        this.refocus = refocus;
    }

    public Boolean getAutofocus() {
        return autofocus;
    }

    public void setAutofocus(Boolean autofocus) {
        this.autofocus = autofocus;
    }

    public Boolean getDraggable() {
        return draggable;
    }

    public void setDraggable(Boolean draggable) {
        this.draggable = draggable;
    }

    public String getAriaDescribedBy() {
        return ariaDescribedBy;
    }

    public void setAriaDescribedBy(String ariaDescribedBy) {
        this.ariaDescribedBy = ariaDescribedBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
