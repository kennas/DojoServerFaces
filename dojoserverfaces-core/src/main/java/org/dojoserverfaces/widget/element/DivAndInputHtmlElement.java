/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.element;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 * Creates a div element tag along with a hiddenn input file by the name
 * <id>_input. This is useful for the form widget to know it was submitted.
 */
public class DivAndInputHtmlElement extends HtmlElement {
	public DivAndInputHtmlElement() {
	}

	@Override
	public String getElement(FacesContext context, UIComponent component) {
		return new StringBuilder("<div id=\"")
				.append(component.getClientId(context))
				.append("\">").toString();
	}

	@Override
	public String getElementClose(FacesContext context, UIComponent component) {
		return new StringBuilder("</div><textarea style='display: none' id=\"")
				.append(component.getClientId(context))
				.append("\" name=\"")
				.append(component.getClientId(context)).append("_value\"></textarea>").toString();
	}
}
