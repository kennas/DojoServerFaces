/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import javax.lang.model.element.Element;

import org.dojoserverfaces.build.annotation.ValueHolder;

/**
 * Class used to encapsulate information used to generate a value holder
 * component.
 */
public class ValueHolderComponent extends GeneratedComponentInfo {
    private AttributeInfo value = new AttributeInfo("value",
            "The data for the component to show.", false, "java.lang.Object");

    public ValueHolderComponent(Element element, ValueHolder annotation) {
        this(annotation, element);
        setWidgetType(annotation.dojoType());
        setRequiredCss(annotation.requiredCss());
        setDisplayName(annotation.displayName());
        setElementType(annotation.elementType());
        setJsfNode(annotation.jsfNode());
        setRendersChildren(annotation.rendersChildren());
        setRenderPosition(annotation.renderPosition());
    }

    protected ValueHolderComponent(java.lang.annotation.Annotation annotation,
            Element element) {
        super(annotation, element);
        setIsValueHolder(true);
        // add in definitions of attributes coming from the base class
        // from ValueHolder
        addAttribute(value);
        addAttribute(new AttributeInfo(
                "converter",
                "The id or class name of a custom converter to use with this component. If a custom converter may also be specified by using the converter tag as a child tag of the component.",
                false, "java.lang.String"));

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
