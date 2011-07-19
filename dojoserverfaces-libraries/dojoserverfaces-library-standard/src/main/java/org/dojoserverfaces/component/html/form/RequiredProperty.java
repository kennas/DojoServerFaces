/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;

import org.dojoserverfaces.widget.property.BooleanProperty;

public class RequiredProperty extends BooleanProperty {

	public RequiredProperty(String name, String propertyName) {
		super(name, propertyName);
	}

	@Override
	public Object getAttributeValue(UIComponent component) {
		return (component instanceof UIInput) ? ((UIInput) component)
				.isRequired() : super.getAttributeValue(component);
	}

}