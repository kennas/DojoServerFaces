/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface Property {

	/**
	 * @return indication that the property should be an exposed tag attribute
	 */
	boolean exposed() default true;

	public String group () default "";
	
	/**
	 * @return the widget property name, if empty the default to field name
	 */
	String name() default "";

	/**
	 * @return the propertyHandler class to use for handling the property value
	 */
	Class<?> handler() default Object.class;
	
	public boolean required () default false;
}
