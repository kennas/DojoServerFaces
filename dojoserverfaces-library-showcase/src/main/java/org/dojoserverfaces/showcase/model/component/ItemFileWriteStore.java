/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

@ManagedBean
public class ItemFileWriteStore {
    private String url = ((ServletContext) FacesContext.getCurrentInstance()
            .getExternalContext().getContext()).getContextPath()
            + "/data/countries.json";
    private String data;
    /*
     * This property is the same as url just used for showing grid behaviors
     */
    private String behaviorUrl = ((ServletContext) FacesContext
            .getCurrentInstance().getExternalContext().getContext())
            .getContextPath() + "/data/test.json";;

    public String getBehaviorUrl() {
        return behaviorUrl;
    }

    public void setBehaviorUrl(String behaviorUrl) {
        this.behaviorUrl = behaviorUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
