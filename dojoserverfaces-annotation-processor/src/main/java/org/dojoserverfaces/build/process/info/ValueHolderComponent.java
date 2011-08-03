package org.dojoserverfaces.build.process.info;

import javax.lang.model.element.Element;

import org.dojoserverfaces.build.annotation.ValueHolder;
/**
 * Class used to encapsulate information used to generate a value holder
 * component.
 */
public class ValueHolderComponent extends GeneratedComponentInfo {
    private AttributeInfo value = new AttributeInfo("value",
            "The data for the component to show.", false,
            "java.lang.Object");

    public ValueHolderComponent(Element element, ValueHolder annotation) {
        this(annotation, element);
        setWidgetType(annotation.dojoType());
        setRequiredCss(annotation.requiredCss());
        setDisplayName(annotation.displayName());
        setElementType(annotation.elementType());
        setJsfNode(annotation.jsfNode());
        setRendersChildren(annotation.rendersChildren());
    }

    protected ValueHolderComponent(java.lang.annotation.Annotation annotation,
            Element element) {
        super(annotation, element);
        setIsValueHolder(true);
        // add in definitions of attributes coming from the base class
        // from ValueHolder
        addAttribute(value);
        addAttribute(new AttributeInfo("converterMessage",
                "Message to be used when reporting conversion failed.", false,
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
