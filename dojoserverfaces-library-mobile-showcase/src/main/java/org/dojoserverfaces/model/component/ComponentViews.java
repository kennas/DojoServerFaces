/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.model.component;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;

@ManagedBean
@ViewScoped
public class ComponentViews implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String COMP_VIEW_PANE_ID = "compViewPane";
    private String loadViewId;

    public void setLoadViewId(String loadViewId) {
        this.loadViewId = loadViewId;
    }

    public String getLoadViewId() {
        return loadViewId;
    }

    public boolean shouldRender(String viewId) {
        PartialViewContext pvContext = FacesContext.getCurrentInstance()
                .getPartialViewContext();
        if (!(pvContext.isAjaxRequest() && pvContext.isPartialRequest())) {
            return false;
        }
        return !pvContext.getRenderIds().contains(COMP_VIEW_PANE_ID)
                || (viewId != null && viewId.equals(loadViewId));
    }
}
