/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.element;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class ActionHtmlElement extends HtmlElement {
    public ActionHtmlElement() {
    }

    @Override
    public String getElement(FacesContext context, UIComponent component) {
        StringBuilder elementMarkup = null;
            elementMarkup = new StringBuilder("<button").append(" id=\"")
                    .append(component.getClientId(context)).append("\">");
        return elementMarkup.toString();
    }

    @Override
    public String getElementClose(FacesContext context, UIComponent component) {
        return "</button>";
    }
}
