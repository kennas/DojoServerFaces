/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.dojo;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PreRenderViewEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

import org.dojoserverfaces.component.DojoResource;

/**
 * The ThemeComponent class defines a JSF component used to theme DojoServerFaces
 * applications.
 */

public class DojoTheme extends DojoResource implements SystemEventListener {

    protected final static String RESOURCE_TARGET = "head";
    private static final String SYTLE_CLASS_ATTRIBUTE = "styleClass";
    private static final String BODY_RENDERER_NAME = "javax.faces.Body";
    private static final String CONTEXT_PARAM_DOJO_THEME = CONTEXT_PARAM_PREFIX
            + ".theme";
    private static final String THEME_LINK = CONTEXT_PARAM_DOJO_THEME + ".link";
    private static final String RESOURCE_ID = "dojoserverfaces_theme";

    private String themeName = null;

    public DojoTheme() {
        this(true);
    }
    /*
     * This constructor is for MobileTheme not let the DojoTheme subscribe any events listeners
     */
    public DojoTheme(String noEvent) {
        super.setId(DojoTheme.RESOURCE_ID);
    }
    DojoTheme(boolean moveIfNecessary) {
        super();
        if (moveIfNecessary) {
            // Register a system event listener so we can move the component
            getFacesContext().getViewRoot().subscribeToViewEvent(
                    javax.faces.event.PostAddToViewEvent.class, this);
        }
        // Register a system event listener so we can modify the body tag
        getFacesContext().getViewRoot().subscribeToViewEvent(
                javax.faces.event.PreRenderViewEvent.class, this);
        super.setId(DojoTheme.RESOURCE_ID);
    }

    /*
     * @see
     * javax.faces.event.SystemEventListener#isListenerForSource(java.lang.Object
     * )
     */
    @Override
    public boolean isListenerForSource(Object source) {
        // we are only interested in ourself
        if ((source instanceof DojoTheme) || (source instanceof UIViewRoot)) {
            return true;
        }
        return false;
    }

    /*
     * @see
     * javax.faces.event.SystemEventListener#processEvent(javax.faces.event.
     * SystemEvent)
     */
    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {
        if (event instanceof PreRenderViewEvent) {
            // find the body component and set the styleClass
            for (UIComponent component : ((UIViewRoot) event.getSource())
                    .getChildren()) {
                if (BODY_RENDERER_NAME.equals(component.getRendererType())) {
                    String styleClass = (String) component.getAttributes().get(
                            SYTLE_CLASS_ATTRIBUTE);
                    if (null != styleClass) {
                        styleClass = new StringBuilder(getName()).append(' ')
                                .append(styleClass).toString();
                    }
                    else {
                        styleClass = getName();
                    }
                    component.getAttributes().put(SYTLE_CLASS_ATTRIBUTE,
                            styleClass);
                }
            }
        }
        else {
            // make sure we are in the resource area
            final UIViewRoot viewRoot = getFacesContext().getViewRoot();
            // unsubscribe from the PostAddToViewEvent as moving the component
            // may cause a re-firing of the same event
            viewRoot.unsubscribeFromViewEvent(
                    javax.faces.event.PostAddToViewEvent.class, this);
            // move myself to the correct resource block
            viewRoot.addComponentResource(getFacesContext(), this,
                    RESOURCE_TARGET);
        }
    }

    /**
     * @return a String containing the theme name.
     */
    public String getName() {
        if (null == themeName) {
            FacesContext context = FacesContext.getCurrentInstance();
            themeName = (String) context.getAttributes().get(
                    CONTEXT_PARAM_DOJO_THEME);
            if (null == themeName) {
                themeName = context.getExternalContext().getInitParameter(
                        CONTEXT_PARAM_DOJO_THEME);
                if (null == themeName || themeName.isEmpty()) {
                    themeName = "claro";
                }
                context.getAttributes()
                        .put(CONTEXT_PARAM_DOJO_THEME, themeName);
            }
        }
        return themeName;
    }

    @Override
    public void encodeAll(FacesContext context) throws IOException {
        String linkTag = (String) context.getAttributes().get(THEME_LINK);
        if (null == linkTag) {
            String themeName = getName();
            StringBuilder themeCssLink = new StringBuilder(
                    "<link rel=\"stylesheet\"  type=\"text/css\" href=\"");
            themeCssLink.append(getLibraryUrlPrefix(context))
                    .append("dijit/themes/").append(themeName).append('/')
                    .append(themeName).append(".css");
            themeCssLink.append("\" />");
            linkTag = themeCssLink.toString();
            context.getAttributes().put(THEME_LINK, linkTag);
        }
        context.getResponseWriter().write(linkTag);
    }

    @Override
    public void setId(String id) {
        // Seems like the facelet processor wants to give me an id
        // we've set it already so ignore this.
    }

    /**
     * @param view
     * @return the Style block component, if it exists, from the view
     */
    public static DojoTheme findThemeComponent(UIViewRoot view) {
        DojoTheme theme = (DojoTheme) findResourceComponent(
                view, RESOURCE_ID, RESOURCE_TARGET);
        return theme;
    }

}
