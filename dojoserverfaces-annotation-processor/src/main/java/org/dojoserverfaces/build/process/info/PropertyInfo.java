/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import java.util.HashMap;
import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;

import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.build.process.generator.GeneratorUtil;

/**
 * Class used to encapsulate information about a component's dojo property.
 */

public class PropertyInfo extends AttributeInfo {
    private static final HashMap<String, String> propertyHandlers = new HashMap<String, String>();

    static {
        // Initialize the map of property handlers.

        // TODO I would like to use an annotation to define the default
        // property handlers
        PropertyInfo.propertyHandlers.put("java.lang.Boolean",
                "org.dojoserverfaces.widget.property.BooleanProperty");
        PropertyInfo.propertyHandlers.put("java.lang.Integer",
                "org.dojoserverfaces.widget.property.NumberProperty");
        PropertyInfo.propertyHandlers.put("java.lang.Double",
                "org.dojoserverfaces.widget.property.NumberProperty");
        PropertyInfo.propertyHandlers.put("java.lang.String",
                "org.dojoserverfaces.widget.property.StringProperty");
    }

    private boolean exposed;
    private String getterName;
    private String group;
    private String handler;
    private boolean isValidator;
    private boolean isValue;
    private String propertyName;
    private String setterName;

    /**
     * Creates a PropertyInfo object.
     * 
     * @param element
     *            an Element object containing the Java model element to use.
     * @param property
     *            a Property object containing the @Property annotation to use.
     */

    public PropertyInfo(Element element, Property property) {
        super(element);
        setName(element.getSimpleName().toString());
        setRequired(property.required());

        String handler = null;
        TypeElement handlerType;

        this.exposed = property.exposed();

        this.group = property.group().trim();
        if (this.group.equals("")) {
            this.group = null;
        }

        this.propertyName = property.name().trim();
        if (this.propertyName.equals("")) {
            // No propertyName provided, so just use the element propertyName.
            this.propertyName = GeneratorUtil.makeCamelCase(null, getName());
        }

        this.isValue = this.propertyName.toLowerCase().equals("value");

        this.getterName = GeneratorUtil.makeCamelCase("get", getName());
        this.setterName = GeneratorUtil.makeCamelCase("set", getName());

        // Hack needed because annotation processing cannot always 
        // handle class loading at compile-time...

        try {
            handler = property.handler().getName();
        }
        catch (MirroredTypeException e) {
            try {
                handler = GeneratorUtil.getTypeAsElement(e.getTypeMirror())
                        .toString();
            }
            catch (Throwable ex) {
            }
        }

        this.handler = (handler.equals("java.lang.Object")) ? null : handler;

        // TODO: if this is a value property, pick the handler out of a
        // different map.

        if ((this.handler == null) && !this.isValue) {
            // Try to find the property handler in the map.
            this.handler = PropertyInfo.propertyHandlers.get(element.asType()
                    .toString());
            if (this.handler == null) {
                // Still null, so default to the string type.
                this.handler = PropertyInfo.propertyHandlers
                        .get("java.lang.String");
            }
        }

        // See if the property is a validator.
        handlerType = GeneratorUtil.getTypeElement(this.handler);
        if (handlerType != null) {
            List<? extends TypeMirror> interfaces = handlerType.getInterfaces();
            for (TypeMirror intf : interfaces) {
                if (intf.toString().equals("javax.faces.validator.Validator")) {
                    this.isValidator = true;
                    break;
                }
            }
        }
    }

    /**
     * Retrieves the getter method propertyName associated with this property.
     * 
     * @return a String containing the getter method propertyName associated
     *         with this property.
     */

    public String getGetterName() {
        return this.getterName;
    }

    /**
     * Retrieves the group associated with this property.
     * 
     * @return a String containing the group associated with this property.
     */

    public String getGroup() {
        return this.group;
    }

    /**
     * Retrieves the property handler associated with this property.
     * 
     * @return a String containing the property handler associated with this
     *         property.
     */

    public String getHandler() {
        return this.handler;
    }

    /*
     * @see org.dojoserverfaces.build.process.model.InfoHolder#getHolderType()
     */

    /**
     * Retrieves the propertyName associated with this property.
     * 
     * @return a String containing the propertyName associated with this
     *         property.
     */

    public String getPropertyName() {
        return this.propertyName;
    }

    /**
     * Retrieves the setter method propertyName associated with this property.
     * 
     * @return a String containing the setter method propertyName associated
     *         with this property.
     */

    public String getSetterName() {
        return this.setterName;
    }

    /**
     * Retrieves the status as to whether or not this property is
     * exposed.
     * 
     * @return a boolean containing true if this property is exposed,
     *         false otherwise.
     */

    public boolean isExposed() {
        return this.exposed;
    }

    /**
     * Retrieves the status as to whether or not this property is a
     * validator.
     * 
     * @return a boolean containing true if this property is a validator,
     *         false otherwise.
     */

    public boolean isValidator() {
        return this.isValidator;
    }

    /**
     * Retrieves the status as to whether or not this property is a
     * value.
     * 
     * @return a boolean containing true if this property is a value,
     *         false otherwise.
     */

    public boolean isValue() {
        return this.isValue;
    }

}
