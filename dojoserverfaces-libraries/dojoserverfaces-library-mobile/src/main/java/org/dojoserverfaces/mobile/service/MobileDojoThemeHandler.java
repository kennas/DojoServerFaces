/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.dojoserverfaces.component.DojoResource;
import org.dojoserverfaces.service.DojoThemeHandler;

/**
 * MobileTheme handler. it will load the theme according to the client-Agent.
 * 
 */
public class MobileDojoThemeHandler extends DojoResource implements
        DojoThemeHandler {
    private static final String USER_AGENT = "User-Agent";
    private static final Map<String, String> THEME_MAP = new HashMap<String, String>();
    static {
        THEME_MAP.put("iphone", "iphone");
        THEME_MAP.put("ipod", "iphone");
        THEME_MAP.put("ipad", "iphone");
        THEME_MAP.put("android", "android");
        THEME_MAP.put("blackberry", "blackberry");
        THEME_MAP.put("custom", "custom");
    }

    private String defaultThemeName = "iphone";

    @Override
    public String getThemeUrl(FacesContext context, String themeName) {
        // We do not use the themeName param in mobileCase
        return new StringBuilder(getLibraryUrlPrefix(context))
                .append("dojox/mobile/themes/").append(getThemeName())
                .append("/common.css").toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.dojoserverfaces.service.DojoThemeHandler#getCssUrl(javax.faces.context
     * .FacesContext, java.lang.String). For mobile widget it will apply the
     * theme according to the Client-Agent
     */
    @Override
    public String getCssUrl(FacesContext context, String cssPath) {
        return new StringBuilder(getLibraryUrlPrefix(context)).append(
                cssPath.replace("{theme}", getThemeName())).toString();
    }

    private String getThemeName() {
        String userAgent = getUserAgent();
        for (String key : THEME_MAP.keySet()) {
            if (userAgent.contains(key)) {
                return THEME_MAP.get(key);
            }
        }
        return defaultThemeName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.dojoserverfaces.service.DojoThemeHandler#getRequiredCss(javax.faces
     * .context.FacesContext)
     */
    @Override
    public String[] getRequiredCss(FacesContext context) {
        List<String> requiredCss = new ArrayList<String>();
        if (getUserAgent().contains("ipad")) {
            requiredCss.add("dojox/mobile/themes/iphone/ipad.css");
        }
        return requiredCss.toArray(new String[requiredCss.size()]);
    }

    private String getUserAgent() {
        return FacesContext.getCurrentInstance().getExternalContext()
                .getRequestHeaderMap().get(USER_AGENT).toLowerCase();
    }

}
