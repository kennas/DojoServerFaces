/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.dojoserverfaces.test.support.widget.WidgetValues;

/**
 * The annotation interface for defining a validator to be used with JWL test
 * cases.
 * 
 * @author "jatin.varshney@in.ibm.com"
 * 
 */
@Documented
@Constraint(validatedBy = FirstValueValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DataValidator {
    String message() default "The entered value is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public abstract Class<? extends WidgetValues> widgetValues();
}