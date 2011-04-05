/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.dojo;

import java.io.IOException;
import java.util.HashSet;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.dojoserverfaces.component.DojoResource;

/**
 * This component will be used to collect and then emit CSS import statements
 * required by dojo components.
 * 
 */
public class DojoStyleComponent extends DojoResource {

    private static final String STYLE_BLOCK_ID = "dojoserverfaces_style";
    private static final String STYLE_TARGET = "head";

    /*
     * This component is transient, the following local vars are only used to
     * build and render the style block
     */
    private HashSet<String> requiredCssAdded = new HashSet<String>();
    private StringBuilder styleBlock = new StringBuilder();

    /**
     * @param view
     * @return the Style block component, if it exists, from the view
     */
    public static DojoStyleComponent findStyleBlockComponent(UIViewRoot view) {
        DojoStyleComponent sb = (DojoStyleComponent) findResourceComponent(
                view, STYLE_BLOCK_ID, STYLE_TARGET);
        if (null == sb) {
            sb = new DojoStyleComponent();
            view.addComponentResource(FacesContext.getCurrentInstance(),
                    sb, STYLE_TARGET);
        }
        return sb;
    }

    /**
     * Add css file to list of css files to import.
     * 
     * @param requiredCss
     *            path of required css file
     */
    public void addRequiredCss(String requiredCss) {
        if (!requiredCssAdded.contains(requiredCss)) {
            styleBlock
                    .append("@import \"")
                    .append(getLibraryUrlPrefix(getFacesContext()))
                    .append(requiredCss)
                    .append("\";\r\n");
            requiredCssAdded.add(requiredCss);
        }
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
        String themeName = DojoTheme.findThemeComponent(context.getViewRoot()).getName();
        String requiredCss = styleBlock.toString().replace("{theme}", themeName);
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("style", null);
        writer.writeAttribute("type", "text/css", null);
        writer.write(requiredCss);
        writer.endElement("style");
    }

    @Override
    public String getId() {
        return STYLE_BLOCK_ID;
    }

}
