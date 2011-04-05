/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import javax.lang.model.element.Element;
import javax.lang.model.type.MirroredTypeException;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.process.generator.GeneratorUtil;

/**
 * Class used to encapsulate information about an componet client side event.
 */

public class EventInfo extends AttributeInfo {
    private String getterName;
    private boolean isDefault;
    private String eventName;
    private String setterName;
    private String handler;


    /**
     * Creates an EventInfo object.
     * 
     * @param element
     *            an Element object containing the Java model element to use.
     * @param event
     *            an Event object containing the @Event annotation to use.
     */

    public EventInfo(Element element, Event event) {
        super(element);
        this.isDefault = event.isDefault();
        this.eventName = event.name().trim();
        this.getterName = GeneratorUtil
                .makeCamelCase("get", getName());
        this.setterName = GeneratorUtil
                .makeCamelCase("set", getName());

        if (this.eventName.equals("")) {
            // No eventName specified, so use the field eventName as a
            // reference. If
            // it starts with "on", the eventName is the field eventName minus
            // the
            // leading "on" and with the first letter converted to
            // lowercase. Otherwise, we will use the full field eventName with
            // the first letter converted to lowercase.

            this.eventName = element.getSimpleName().toString();
        }

        if (this.eventName.toLowerCase().startsWith("on")) {
            this.eventName = GeneratorUtil.makeCamelCase(null,
                    this.eventName.substring(2));
        }
        else {
            this.eventName = GeneratorUtil.makeCamelCase(null, this.eventName);
        }
        try {
            handler = event.handler().getName();
        }
        catch (MirroredTypeException e) {
            try {
                handler = GeneratorUtil.getTypeAsElement(e.getTypeMirror())
                        .toString();
            }
            catch (Throwable ex) {
            }
        }
        // TODO I would like to use an annotation to define the default
        // event handler property
	this.handler = (handler.equals("java.lang.Object")) ? "org.dojoserverfaces.widget.property.EventHandlerProperty"
	        : handler;
    }

    /**
     * Retrieves the getter method eventName associated with this event.
     * 
     * @return a String containing the getter method eventName associated with
     *         this event.
     */

    public String getGetterName() {
        return this.getterName;
    }

    /**
     * Retrieves the eventName associated with this event.
     * 
     * @return a String containing the eventName associated with this event
     *        .
     */

    public String getEventName() {
        return this.eventName;
    }

    /**
     * Retrieves the setter method eventName associated with this event.
     * 
     * @return a String containing the setter method eventName associated with
     *         this event.
     */

    public String getSetterName() {
        return this.setterName;
    }

    /**
     * Retrieves the property handler associated with this event.
     * 
     * @return a String containing the property handler associated with this
     *         event.
     */

    public String getHandler() {
        return handler;
    }

    /**
     * Retrieves the status as to whether or not the event associated with this
     * event is the default event.
     * 
     * @return a boolean containing true if the event associated with this event
     *         is the default event, false otherwise.
     */

    public boolean isDefault() {
        return this.isDefault;
    }
}
