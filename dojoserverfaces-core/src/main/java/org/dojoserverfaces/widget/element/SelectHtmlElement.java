/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.element;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class SelectHtmlElement extends HtmlElement {
     public SelectHtmlElement() {
     }
     @Override
     public String getElement(FacesContext context, UIComponent component) {
         StringBuilder elementMarkup = 
             new StringBuilder("<select id=\"")
                 .append(component.getClientId(context)).append("\">");
         return elementMarkup.toString();
     }
     @Override
     public String getElementClose(FacesContext context, UIComponent component) {
         return "</select>";
     }
}
