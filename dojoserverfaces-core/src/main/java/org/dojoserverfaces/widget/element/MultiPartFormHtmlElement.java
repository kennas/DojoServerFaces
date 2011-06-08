/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.element;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 * Creates a form element tag and set its enctype to multipart/form-data along
 * with a div. This is mainly for the component that need to be nested in a
 * multiPart form.
 */
public class MultiPartFormHtmlElement extends HtmlElement {
    public MultiPartFormHtmlElement() {
    }

    @Override
    public String getElement(FacesContext context, UIComponent component) {
        StringBuilder elementMarkup = new StringBuilder(
                "<form method=\"post\" enctype=\"multipart/form-data\"><input type=\"file\" id=\"")
                .append(component.getClientId(context)).append("\"/>");
        return elementMarkup.toString();
    }

    @Override
    public String getElementClose(FacesContext context, UIComponent component) {
        return "</form>";
    }
}
