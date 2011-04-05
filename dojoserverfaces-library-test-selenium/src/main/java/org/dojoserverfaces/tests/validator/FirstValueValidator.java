/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.dojoserverfaces.tests.widget.values.WidgetValues;

public class FirstValueValidator implements
        ConstraintValidator<DataValidator, Object> {

    WidgetValues widgetValues;

    @Override
    public void initialize(DataValidator constraintAnnotation) {
        try {
            this.widgetValues = constraintAnnotation.widgetValues()
                    .newInstance();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return ValidatorUtil.validateObjectHasOnlyValue(value,
                this.widgetValues.getFirst());
    }
}