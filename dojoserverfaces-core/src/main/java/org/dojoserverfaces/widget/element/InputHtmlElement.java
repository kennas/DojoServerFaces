/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.element;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class InputHtmlElement extends HtmlElement {
    private String type = null;

    public InputHtmlElement(String type) {
        this.type = type;
    }

    public InputHtmlElement() {
        this(TYPE_TEXT);
    }

    public static final String TYPE_BUTTON = "button";
    public static final String TYPE_CHECKBOX = "checkbox";
    public static final String TYPE_FILE = "file";
    public static final String TYPE_HIDDEN = "hidden";
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_PASSWORD = "password";
    public static final String TYPE_RADIO = "radio";
    public static final String TYPE_RESET = "reset";
    public static final String TYPE_SUBMIT = "submit";
    public static final String TYPE_TEXT = "text";
    public static final String TYPE_TEXTAREA = "textarea";

    public String getElement(FacesContext context, UIComponent component) {
        StringBuilder elementMarkup = null;
        if (TYPE_TEXTAREA.equals(type)) {
            elementMarkup = new StringBuilder("<textarea id=\"");
            elementMarkup.append(component.getClientId(context)).append("\">");
        }
        else {
            // add the name property to the htmlMarkup for some browser do not
            // allow set the name property after the <input> creating
            elementMarkup = new StringBuilder("<input type=\"");
            elementMarkup.append(type).append("\" id=\"")
                    .append(component.getClientId(context))
                    .append("\" name=\"")
                    .append(component.getClientId(context)).append("\"/>");
        }
        return elementMarkup.toString();
    }

    public String getElementClose(FacesContext context, UIComponent component) {
        if (TYPE_TEXTAREA.equals(type)) {
            return "</textarea>";
        }
        return null;
    }
}
