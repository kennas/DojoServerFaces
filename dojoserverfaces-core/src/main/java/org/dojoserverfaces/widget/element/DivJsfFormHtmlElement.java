/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.element;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 * Creates a div element tag along with a hidden input file by the name
 * <id>_input. This is useful for the form widget to know it was submitted.
 */
public class DivJsfFormHtmlElement extends HtmlElement {
    public DivJsfFormHtmlElement() {
    }

    @Override
    public String getElement(FacesContext context, UIComponent component) {
        StringBuilder elementMarkup = new StringBuilder("<div id=\"").append(
                component.getClientId(context)).append("\">");
        if (!"get".equals(component.getAttributes().get("method"))) {
            elementMarkup.append("<input type='hidden' name=\"")
                    .append(component.getClientId(context))
                    .append("Submitted\"/>");
        }
        return elementMarkup.toString();
    }

    @Override
    public String getElementClose(FacesContext context, UIComponent component) {
        if (!"get".equals(component.getAttributes().get("method"))) {
            // add view state to form
            try {
                // TODO this is a bit of a hack because we do not (or should
                // not know when this method will be called. This writeState
                // method will write the state using the current responseWriter
                // in its current state
                context.getApplication().getViewHandler().writeState(context);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "</div>";
    }
}
