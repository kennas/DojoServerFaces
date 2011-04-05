/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.element;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public abstract class HtmlElement {

    
    public static final String TYPE_CHECKBOX = "checkbox";
    public static final String TYPE_RADIO = "radio";
    public static final String TYPE_TEXT = "text";
    public static final String TYPE_TEXTAREA = "textarea";
    public static final String TYPE_DIV = "div";
    public static final String TYPE_SELECT = "select_with_store";
    public static final String TYPE_SELECT_OPTION = "select_with_option";


    protected HtmlElement() {
    }

    public abstract String getElement(FacesContext context,
            UIComponent component);

    public abstract String getElementClose(FacesContext context,
            UIComponent component);
}
