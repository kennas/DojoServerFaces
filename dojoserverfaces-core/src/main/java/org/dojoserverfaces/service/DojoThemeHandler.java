/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.service;

import javax.faces.context.FacesContext;

/**
 * An interface to handle theme related issues like theme url, required css etc
 */
public interface DojoThemeHandler {
    /**
     * @param context
     * @param themeName
     * @return a full theme url based on the given theme name
     */
    public String getThemeUrl(FacesContext context, String themeName);

    /**
     * @param context
     * @param cssPath
     * @return a full css url based on the given css path
     */
    public String getCssUrl(FacesContext context, String cssPath);

    /**
     * @param context
     * @return required css files that needed for all dojo applications
     */
    public String[] getRequiredCss(FacesContext context);
}
