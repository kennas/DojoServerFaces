/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import java.util.Collection;
import java.util.TreeMap;

/**
 * Defines a class used to collect "information" related to a
 * particular class element.
 */
public class InformationCollector implements InfoHolder {
    private InformationCollector parent;
    private TreeMap<String, EventInfo> events;
    private TreeMap<String, PropertyInfo> properties;
    private TreeMap<String, AttributeInfo> attributes;

    public InformationCollector() {
        events = new TreeMap<String, EventInfo>();
        properties = new TreeMap<String, PropertyInfo>();
        attributes = new TreeMap<String, AttributeInfo>();
    }

    public InformationCollector getParent() {
        return parent;
    }

    public void setParent(InformationCollector parent) {
        this.parent = parent;
    }

    /**
     * Retrieves all the properties associated with this class.
     * 
     * @return a Collection object consisting of PropertyInfo objects that
     *         represents all the properties associated with this class.
     */

    public Collection<PropertyInfo> getProperties() {
        TreeMap<String, PropertyInfo> result = new TreeMap<String, PropertyInfo>();

        // Add in the parent properties first.

        if (this.parent != null) {
            Collection<PropertyInfo> parentProperties = this.parent
                    .getProperties();

            for (PropertyInfo property : parentProperties) {
                result.put(property.getPropertyName(), property);
            }
        }

        for (PropertyInfo property : this.properties.values()) {
            result.put(property.getPropertyName(), property);
        }

        return result.values();
    }

    /**
     * Retrieves all the events associated with this artifact.
     * 
     * @return a Collection object consisting of EventInfo objects that
     *         represents all the attributes associated with this artifact.
     */
    public Collection<EventInfo> getEvents() {
        TreeMap<String, EventInfo> result = new TreeMap<String, EventInfo>();

        // Add in the parent events first.
        if (this.parent != null) {
            Collection<EventInfo> parentEvents = this.parent.getEvents();
            for (EventInfo event : parentEvents) {
                result.put(event.getEventName(), event);
            }
        }
        for (EventInfo event : this.events.values()) {
            result.put(event.getEventName(), event);
        }
        return result.values();
    }

    /**
     * Adds an event.
     * 
     * @param name
     *            a String containing the name of the event to add.
     * @param event
     *            an EventInfo object containing the event to add.
     */

    protected void addEvent(String name, EventInfo event) {
        this.events.put(name, event);
        addAttribute(event);
    }

    /**
     * Adds a property.
     * 
     * @param name
     *            a String containing the name of the property to add.
     * @param property
     *            a PropertyInfo object containing the property to add.
     */

    protected void addProperty(String name, PropertyInfo property) {
        this.properties.put(name, property);
        if (property.isExposed()) {
            addAttribute(property);
        }
    }

    /**
     * Retrieves all the attributes associated with this artifact.
     * 
     * @return a Collection object consisting of AttributeInfo objects that
     *         represents all the attributes associated with this artifact.
     */
    public Collection<AttributeInfo> getAttributes() {
        TreeMap<String, AttributeInfo> result = new TreeMap<String, AttributeInfo>();
        // Add in the parent Attributes first.
        if (this.parent != null) {
            Collection<AttributeInfo> parentAttributes = this.parent
                    .getAttributes();
            for (AttributeInfo attribute : parentAttributes) {
                result.put(attribute.getName(), attribute);
            }
        }
        for (AttributeInfo attribute : this.attributes.values()) {
            result.put(attribute.getName(), attribute);
        }
        return result.values();
    }

    /**
     * Adds an attribute.
     * 
     * @param name
     *            a String containing the name of the attribute to add.
     * @param attribute
     *            a AttributeInfo object containing the attribute to add.
     */

    protected void addAttribute(AttributeInfo attribute) {
        this.attributes.put(attribute.getName(), attribute);
    }

    public void addInformation(InfoHolder infoHolder) {
        if (infoHolder instanceof EventInfo) {
            EventInfo eventInfo = (EventInfo) infoHolder;
            addEvent(eventInfo.getEventName(), eventInfo);
        }
        else if (infoHolder instanceof PropertyInfo) {
            PropertyInfo propertyInfo = (PropertyInfo) infoHolder;
            addProperty(propertyInfo.getPropertyName(), propertyInfo);
        }
        else if (infoHolder instanceof AttributeInfo) {
            AttributeInfo attribute = (AttributeInfo) infoHolder;
            addAttribute(attribute);
        }
    }

}
