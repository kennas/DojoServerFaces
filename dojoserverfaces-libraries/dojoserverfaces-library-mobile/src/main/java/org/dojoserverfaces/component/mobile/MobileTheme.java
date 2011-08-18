/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.mobile;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

import org.dojoserverfaces.component.dojo.DojoStyleComponent;
import org.dojoserverfaces.component.dojo.DojoTheme;

/**
 * This component will load css style according to the device thought
 * client-Agent.
 * 
 */
public class MobileTheme extends DojoTheme implements SystemEventListener {
    protected final static String RESOURCE_TARGET = "head";
    protected final static String USER_AGENT = "User-Agent";
    private String themeName = null;

    private class ThemeValue {
        private String themeName;
        private Set<String> themeCss;

        public ThemeValue(String name, Set<String> css) {
            this.themeName = name;
            this.themeCss = css;
        }

        public ThemeValue(String name) {
            this.themeName = name;
            this.themeCss = null;
        }

        public String getThemeName() {
            return themeName;
        }

        public Set<String> getThemeCss() {
            return themeCss;
        }
    }

    private Map<String, ThemeValue> themeMap = new HashMap<String, ThemeValue>();

    public MobileTheme() {
        super("noEvents");
        initThemeMap();
        // Register a system event listener
        getFacesContext().getViewRoot().subscribeToViewEvent(
                javax.faces.event.PreRenderViewEvent.class, this);
    }

    private void initThemeMap() {
        if (themeMap.isEmpty()) {
            ThemeValue theme = new ThemeValue("iphone");
            themeMap.put("iPhone", theme);
            themeMap.put("iPod", theme);
            Set<String> css = new HashSet<String>();
            css.add("dojox/mobile/themes/iphone/ipad.css");
            theme = new ThemeValue("iphone", css);
            themeMap.put("iPad", theme);
            theme = new ThemeValue("android");
            themeMap.put("Android", theme);
            theme = new ThemeValue("blackberry");
            themeMap.put("BlackBerry", theme);
            theme = new ThemeValue("custom");
            themeMap.put("Custom", theme);
        }
    }

    /**
     * @return a String containing the theme name.
     */
    @Override
    public String getName() {
        return themeName;
    }

    /*
     * @see
     * javax.faces.event.SystemEventListener#isListenerForSource(java.lang.Object
     * )
     */
    @Override
    public boolean isListenerForSource(Object source) {
        // we are only interested in ourself
        if ((source instanceof MobileTheme) || (source instanceof UIViewRoot)) {
            return true;
        }
        return false;
    }

    @Override
    public void encodeAll(FacesContext context) throws IOException {
    }

    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {
        final UIViewRoot viewRoot = getFacesContext().getViewRoot();
        DojoStyleComponent styleBlock = DojoStyleComponent
                .findStyleBlockComponent(viewRoot);
        styleBlock.addRequiredCss("dojox/mobile/themes/{theme}/common.css");
        String userAgent = getFacesContext().getExternalContext()
                .getRequestHeaderMap().get(USER_AGENT);
        themeName = "iphone";
        for (String theme : themeMap.keySet()) {
            if (userAgent.contains(theme)) {
                themeName = themeMap.get(theme).getThemeName();
                if (null != themeMap.get(theme).getThemeCss()) {
                    for (String css : themeMap.get(theme).getThemeCss()) {
                        styleBlock.addRequiredCss(css);
                    }
                }
                break;
            }
        }
    }

}
