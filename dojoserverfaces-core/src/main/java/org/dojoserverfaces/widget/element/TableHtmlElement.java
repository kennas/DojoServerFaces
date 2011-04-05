/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.element;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class TableHtmlElement extends HtmlElement {
     /*
      * @see org.dojoserverfaces.widget.element.HtmlElement#getElement(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
      */
     
     @Override
     public String getElement (FacesContext context, UIComponent component) {
          StringBuilder result = new StringBuilder ("<table id=\"");
          
          result.append (component.getClientId (context));
          result.append ("\" />");
          
          return result.toString();
     }
     
     /*
      * @see org.dojoserverfaces.widget.element.HtmlElement#getElementClose(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
      */
     
     @Override
     public String getElementClose (FacesContext context,
          UIComponent component) {
          return null;
     }
}
