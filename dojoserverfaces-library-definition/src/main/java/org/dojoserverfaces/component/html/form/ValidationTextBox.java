/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.RegexValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.widget.property.StringProperty;

/**
 * 
 * A text input component with an associated regular expression pattern used to
 * validate the input.
 * 
 */
@EditableValueHolder(dojoType = "dijit.form.ValidationTextBox")
class ValidationTextBox extends ValidationTextBoxBase {

	static class RegularExpressionProperty extends StringProperty implements
			Validator {
		public RegularExpressionProperty(String name, String propertyName) {
			super(name, propertyName);
		}

		@Override
		public void validate(FacesContext context, UIComponent component,
				Object value) throws ValidatorException {
			String pattern = (String) component.getAttributes().get(this.getName());
			if (null != pattern) {
				RegexValidator validator = new RegexValidator();
				validator.setPattern(pattern);
				validator.validate(context, component, value);
			}
		}
	}

	/**
	 * Regular expression pattern used to validate the input.
	 */
	@Property(handler = RegularExpressionProperty.class)
	String regExp;

}
