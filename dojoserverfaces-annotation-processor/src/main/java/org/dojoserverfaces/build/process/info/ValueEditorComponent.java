/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import javax.lang.model.element.Element;

import org.dojoserverfaces.build.annotation.EditableValueHolder;

/**
 * Class used to encapsulate information used to generate a value editor
 * component.
 */

public class ValueEditorComponent extends GeneratedComponentInfo {
    private AttributeInfo value = new AttributeInfo("value",
            "The data for the component to manipulate.", false,
            "java.lang.Object");

    /**
     * Creates an ValueEditorComponent object.
     * 
     * @param element
     *            an Element object containing the Java model element to use.
     * @param annotation
     *            an EditableValueHolder object containing the
     * @EditableValueHolder annotation to use.
     */

    public ValueEditorComponent(Element element, EditableValueHolder annotation) {
        this(annotation, element);
        setWidgetType(annotation.dojoType());
        setRequiredCss(annotation.requiredCss());
        setDisplayName(annotation.displayName());
        setElementType(annotation.elementType());
        setJsfNode(annotation.jsfNode());
    }

    protected ValueEditorComponent(java.lang.annotation.Annotation annotation,
            Element element) {
        super(annotation, element);
        setIsValueEditor(true);
        // add in definitions of attributes coming from the base class
        // from EditableValueHolder
        addAttribute(value);
        addAttribute(new AttributeInfo(
                "immediate",
                "Indicates the value should validated during the apply request value phase.",
                false, "java.lang.Boolean"));
        addAttribute(new AttributeInfo(
                "required",
                "Indicates a value is required to be submitted for this component.",
                false, "java.lang.Boolean"));

        // from UIInput
        addAttribute(new AttributeInfo("requiredMessage",
                "Message to be used when reporting no value was submitted.",
                false, "java.lang.String"));
        addAttribute(new AttributeInfo("converterMessage",
                "Message to be used when reporting conversion failed.", false,
                "java.lang.String"));
        addAttribute(new AttributeInfo("validatorMessage",
                "Message to be used when reporting validation failed.", false,
                "java.lang.String"));
    }

    @Override
    protected void addProperty(String name, PropertyInfo property) {
        if (property.isValue()) {
            // override the default comment we gave the value attribute
            value.setComment(property.getComment());
        }
        super.addProperty(name, property);
    }
}
