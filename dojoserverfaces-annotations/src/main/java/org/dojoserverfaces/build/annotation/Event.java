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

/**
 * 
 * Annotation to be applied to a field to identify it as an event handler property
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface Event {

	/**
	 * @return is this event the default event to which behaviors are attached
	 */
	boolean isDefault() default false;
	
	/**
	 * @return the event name (as opposed to the event property name). The default
	 * will be the property name sans the "on" and lowercase first letter.
	 */
	String name() default "";

	/**
	 * @return the propertyHandler class to use for handling the property value.
	 */
	Class<?> handler() default Object.class;

}
