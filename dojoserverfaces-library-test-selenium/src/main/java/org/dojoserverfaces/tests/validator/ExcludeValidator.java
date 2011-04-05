/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.dojoserverfaces.tests.util.DojoServerFacesUtil;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

@FacesValidator(value = "dojoserverfaces.ExcludeValidator")
public class ExcludeValidator implements Validator {

    private StringBuilder message = new StringBuilder("");

    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        if (value == null)
            return;

        String excludeIndex = (String) component.getAttributes().get(
                "dojoserverfaces.ExcludeValidator.index");
        int index = -1;
        if (excludeIndex != null) {
            try {
                index = Integer.parseInt(excludeIndex);
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
                return;
            }
        }

        if (index != -1) {
            WidgetValues widgetValues = DojoServerFacesUtil.getWidgetValuesInstance(
                    context, component);
            Object valueAtIndex = widgetValues.getValue(index);

            if (ValidatorUtil.validateObjectContainsValue(value, valueAtIndex))
                message.append("The values should not contain this value");
        }

        if (!("".equals(this.message.toString()))) {
            FacesMessage errMessage = new FacesMessage(message.toString());
            errMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(errMessage);
        }
    }
}