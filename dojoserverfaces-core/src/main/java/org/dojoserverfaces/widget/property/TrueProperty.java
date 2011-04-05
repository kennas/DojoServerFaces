/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.component.UIComponent;

/**
 * Hardcoded true boolean property
 *
 */
public class TrueProperty extends BooleanProperty {

	public TrueProperty(String name, String propertyName) {
		super(name, propertyName);
	}

	@Override
	public Object getAttributeValue(UIComponent component) {
		return Boolean.TRUE;
	}

}
