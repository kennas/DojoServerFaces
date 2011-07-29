/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.dojo;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.faces.application.ProjectStage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.dojoserverfaces.component.DojoResource;

public final class DojoLibraryComponent extends DojoResource {

    private static final String RESOURCE_TARGET = "head";
    private static final String CONTEXT_PARAM_DOJO_LIBRARY = CONTEXT_PARAM_PREFIX
            + ".library";
    private static final String CONTEXT_PARAM_DOJO_CONFIG_ASYNC = CONTEXT_PARAM_PREFIX
            + ".async_module_loading";
    private static final String DOJO_LIBRARY = "dojo/dojo.js";

    /**
     * @param context
     *            FacesContext
     * @return the url to dojo.js
     */
    private static String getLibraryUrl(FacesContext context) {
        String dojoLibraryUrl = (String) context.getAttributes().get(
                CONTEXT_PARAM_DOJO_LIBRARY);
        if (null != dojoLibraryUrl) {
            return dojoLibraryUrl;
        }
        String dojoLibrary = context.getExternalContext().getInitParameter(
                CONTEXT_PARAM_DOJO_LIBRARY);
        if (null == dojoLibrary || dojoLibrary.isEmpty()) {
            dojoLibrary = DOJO_LIBRARY;
        }
        dojoLibraryUrl = getLibraryUrlPrefix(context) + dojoLibrary;
        // after all that work lets save this string away
        context.getAttributes().put(CONTEXT_PARAM_DOJO_LIBRARY, dojoLibraryUrl);
        context.getExternalContext().log(
                "DojoServerFaces: dojo library url: " + dojoLibraryUrl);
        return dojoLibraryUrl;
    }

    private static DojoLibraryComponent findLibraryComponent(
            List<UIComponent> compList) {
        for (UIComponent comp : compList) {
            if (comp instanceof DojoLibraryComponent) {
                return (DojoLibraryComponent) comp;
            }
        }
        return null;
    }

    public static void addLibraryReferenceToView(UIViewRoot view) {
        /*
         * instead of just creating the component and calling
         * addComponentResource which would replace the component if already
         * there lets save the creation of an unnecessary object and look for an
         * existing one.
         */
        if (null != findLibraryComponent(view.getComponentResources(
                FacesContext.getCurrentInstance(), RESOURCE_TARGET))) {
            return; // its there, we're done
        }

        view.addComponentResource(FacesContext.getCurrentInstance(),
                new DojoLibraryComponent());
        // add a default theme if not there already
        for (UIComponent comp : view.getComponentResources(
                FacesContext.getCurrentInstance(), RESOURCE_TARGET)) {
            if (comp instanceof DojoTheme) {
                return; // already a theme there, we're done
            }
        }
        DojoTheme theme = new DojoTheme(false);
        view.addComponentResource(FacesContext.getCurrentInstance(), theme);
    }

    protected DojoLibraryComponent() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.faces.component.UIComponent#encodeAll(javax.faces.context.FacesContext
     * )
     */
    @Override
    public void encodeAll(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        StringBuilder djConfig = new StringBuilder();
        boolean addComma = false;
        // get locale
        Locale viewLocale = context.getViewRoot().getLocale();
        if (null != viewLocale) {
            if (addComma) {
                djConfig.append(',');
            }
            // Dojo's locale must be specified in all lowercase with dashes
            // separating variants.
            // there must be a language
            djConfig.append("locale:\"").append(
                    viewLocale.getLanguage().toLowerCase());
            if (null != viewLocale.getCountry()) {
                djConfig.append('-').append(
                        viewLocale.getCountry().toLowerCase());
            }
            String variant = viewLocale.getVariant();
            if ((null != variant) && !variant.isEmpty()) {
                djConfig.append('-').append(
                        viewLocale.getVariant().toLowerCase());
            }
            djConfig.append('"');
            addComma = true;
        }
        if (context.isProjectStage(ProjectStage.Development)) {
            if (addComma) {
                djConfig.append(',');
            }
            djConfig.append("isDebug:true");
            addComma = true;
        }
        String async = context.getExternalContext().getInitParameter(
                CONTEXT_PARAM_DOJO_CONFIG_ASYNC);
        if (null != async) {
            if (addComma) {
                djConfig.append(",");
            }
            djConfig.append("async:").append(async);
        }
        if (djConfig.length() > 0) {
            // lets avoid "validation" errors on emitted markup
            writer.write("\n");
            writer.startElement("script", null);
            writer.writeAttribute("type", "text/javascript", null);
            djConfig.insert(0, "var djConfig={").append("};");
            writer.write(djConfig.toString());
            writer.endElement("script");
        }
        writer.startElement("script", null);
        writer.writeAttribute("type", "text/javascript", null);
        writer.writeURIAttribute("src", getLibraryUrl(context), null);
        writer.endElement("script");
    }
}
