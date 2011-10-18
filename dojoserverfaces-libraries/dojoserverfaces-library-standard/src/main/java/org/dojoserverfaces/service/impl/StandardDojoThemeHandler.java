/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.service.impl;

import javax.faces.context.FacesContext;

import org.dojoserverfaces.component.DojoResource;
import org.dojoserverfaces.service.DojoThemeHandler;

/**
 * Theme handler for DojoServiceFaces Standard Library
 */
public class StandardDojoThemeHandler extends DojoResource implements
        DojoThemeHandler {
    @Override
    public String getThemeUrl(FacesContext context, String themeName) {
        return new StringBuilder(getLibraryUrlPrefix(context))
                .append("dijit/themes/").append(themeName).append("/")
                .append(themeName).append(".css").toString();
    }

    @Override
    public String getCssUrl(FacesContext context, String cssPath) {
        return new StringBuilder(getLibraryUrlPrefix(context)).append(cssPath)
                .toString();
    }

    @Override
    public String[] getRequiredCss(FacesContext context) {
        return null;
    }
}
