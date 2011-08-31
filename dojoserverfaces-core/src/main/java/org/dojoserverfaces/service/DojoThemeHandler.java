package org.dojoserverfaces.service;

import javax.faces.context.FacesContext;

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
