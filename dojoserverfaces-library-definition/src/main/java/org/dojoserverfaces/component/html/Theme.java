/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Component;
import org.dojoserverfaces.component.dojo.DojoTheme;

/**
 * This component defines the theme to be used by this library's components in
 * this page.
 */
@Component
public class Theme extends DojoTheme {

    /**
     * Creates a component.
     */
    public Theme() {
        super();
    }

    /**
     * The theme name.
     * 
     */
    @Attribute
    public String getName() {
        return (String) getStateHelper().eval("name", "claro");
    }

    /**
     * 
     * @param name
     *            a String containing the theme.
     */
    public void setName(String name) {
        getStateHelper().put("name", name);
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    }

    @Override
    public void encodeChildren(FacesContext context) throws IOException {
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
    }

    @Override
    public void encodeAll(FacesContext context) throws IOException {

        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("link", null);
        writer.writeAttribute("rel", "stylesheet", null);
        writer.writeAttribute("type", "text/css", null);
        StringBuilder themeUrl = new StringBuilder(getLibraryUrlPrefix(context));
        String themeName = getName();
        themeUrl.append("dijit/themes/").append(themeName).append('/')
                .append(themeName).append(".css");
        writer.writeAttribute("href", themeUrl.toString(), null);
        writer.endElement("link");
    }

    @Override
    protected Renderer getRenderer(FacesContext context) {
        return null;
    }

    @Override
    public String getRendererType() {
        return null;
    }
}
