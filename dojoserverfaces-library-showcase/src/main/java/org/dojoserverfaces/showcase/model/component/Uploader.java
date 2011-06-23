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
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.dojoserverfaces.showcase.data.model.UploadRecord;
import org.dojoserverfaces.showcase.data.model.UploadRecord.UploadFile;

@ManagedBean
@SessionScoped
public class Uploader extends WigdetBase {
    private String label = "Select some files";
    private String plugin = "html5";
    private Boolean multiple = true;
    private Boolean uploadOnSelect = true;

    private String url = new StringBuilder()
            .append(((ServletContext) FacesContext.getCurrentInstance()
                    .getExternalContext().getContext()).getContextPath())
            .append("/rest/upload").toString();

    private final Map<String, String> showcasePluginTypes = new LinkedHashMap<String, String>();
    {
        showcasePluginTypes.put("", "");
        showcasePluginTypes.put("html5", "html5");
        showcasePluginTypes.put("iframe", "iframe");
        showcasePluginTypes.put("flash", "flash");
    }

    public Map<Long, UploadFile> getUploadedFiles() {
        return UploadRecord.getUploadedFiles();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getMultiple() {
        return multiple;
    }

    public void setMultiple(Boolean multiple) {
        this.multiple = multiple;
    }

    public Boolean getUploadOnSelect() {
        return uploadOnSelect;
    }

    public void setUploadOnSelect(Boolean uploadOnSelect) {
        this.uploadOnSelect = uploadOnSelect;
    }

    public Map<String, String> getShowcasePluginTypes() {
        return showcasePluginTypes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }
}
