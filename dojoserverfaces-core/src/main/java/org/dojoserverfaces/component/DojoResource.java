/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.dojoserverfaces.servlet.resource.ResourceServlet;

/**
 * Base class for components that render dojo resources. This is for transient
 * components.
 * 
 */
public class DojoResource extends UIComponentBase {
    protected static final String CONTEXT_PARAM_PREFIX = "dojoserverfaces.dojo";
    private static final String CONTEXT_PARAM_DOJO_LOCATION = CONTEXT_PARAM_PREFIX
            + ".location";

    /**
     * @param id
     *            component to find
     * @param target
     *            resource area to search ("head", "body")
     * @return the indicated resource component
     */
    protected static DojoResource findResourceComponent(UIViewRoot view,
            String id, String target) {
        List<UIComponent> compList = view.getComponentResources(
                FacesContext.getCurrentInstance(), target);
        for (UIComponent comp : compList) {
            if (id.equals(comp.getId())) {
                return (DojoResource) comp;
            }
        }
        return null;
    }

    /**
     * @param context
     *            FacesContext
     * @return the url to dojo.js
     */
    protected static String getLibraryUrlPrefix(FacesContext context) {
        String dojoLibraryUrl = (String) context.getAttributes().get(
                CONTEXT_PARAM_DOJO_LOCATION);
        if (null != dojoLibraryUrl) {
            return dojoLibraryUrl;
        }

        // TODO - I believe part of the mobile work in shrinking the js file
        // size
        // was to be able to separate browser dependent code (e.g. IE specific
        // code). We could check agent type here and emit the appropriate
        // library

        // check for context param setting
        dojoLibraryUrl = context.getExternalContext().getInitParameter(
                CONTEXT_PARAM_DOJO_LOCATION);
        if (null == dojoLibraryUrl || dojoLibraryUrl.isEmpty()) {
            dojoLibraryUrl = ResourceServlet.getDojoResourcePath(context, "/");
        }
        else {
            // check for url needing fixing
            if (dojoLibraryUrl.startsWith("//")) {
                // resource is from app deployed along side user app
                dojoLibraryUrl = dojoLibraryUrl.substring(1);
            }
            else {
                if (dojoLibraryUrl.startsWith("/")
                        || !dojoLibraryUrl.contains("://")) {
                    // need to fix up
                    String appUrl = context.getExternalContext()
                            .getRequestContextPath();
                    if (!dojoLibraryUrl.startsWith("/")) {
                        appUrl = appUrl + '/';
                    }
                    dojoLibraryUrl = appUrl + dojoLibraryUrl;
                }
            }
            if (!dojoLibraryUrl.endsWith("/")) {
                dojoLibraryUrl += '/';
            }
        }
        // after all that work lets save this string away
        context.getAttributes()
                .put(CONTEXT_PARAM_DOJO_LOCATION, dojoLibraryUrl);
        return dojoLibraryUrl;
    }

    /**
     * @param id
     */
    protected DojoResource() {
        setTransient(true); // this component has no state to save
    }

    @Override
    public String getFamily() {
        return "dojoserverfaces.resource";
    }

    @Override
    public String getRendererType() {
        return null;
    }

}
