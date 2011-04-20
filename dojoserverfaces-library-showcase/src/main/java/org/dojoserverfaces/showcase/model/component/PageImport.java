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
public class PageImport {
    private String href = new StringBuilder("/")
            .append(((ServletContext) FacesContext.getCurrentInstance()
                    .getExternalContext().getContext()).getContextPath())
            .append("/sections/pageimport/importpage.jsp").toString();
    private Boolean extractContent = true;
    private String loadingMessage = "page is loading..... ";
    private String errorMessage = "error occurs";

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getExtractContent() {
        return extractContent;
    }

    public void setExtractContent(Boolean extractContent) {
        this.extractContent = extractContent;
    }

    public String getLoadingMessage() {
        return loadingMessage;
    }

    public void setLoadingMessage(String loadingMessage) {
        this.loadingMessage = loadingMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static void main(String[] args) {
        PageImport a = new PageImport();
        System.out.println(a.getHref());

    }
}
