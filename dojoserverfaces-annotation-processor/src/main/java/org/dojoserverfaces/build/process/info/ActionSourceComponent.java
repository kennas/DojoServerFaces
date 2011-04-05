/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import javax.lang.model.element.Element;

import org.dojoserverfaces.build.annotation.ActionSource;

/**
 * Class used to encapsulate information used to generate an ActionSource
 * component.
 */

public class ActionSourceComponent extends GeneratedComponentInfo {

    /**
     * Creates an ActionSourceComponent object.
     * 
     * @param element
     *            an Element object containing the Java model element to use.
     * @param annotation
     *            an ActionSource object containing the
     * @ActionSource annotation to use.
     */

    public ActionSourceComponent(Element element, ActionSource annotation) {
        this(annotation, element);
        setWidgetType(annotation.dojoType());
        setRequiredCss(annotation.requiredCss());
        setDisplayName(annotation.displayName());
        setJsfNode(annotation.jsfNode());
    }

    protected ActionSourceComponent(java.lang.annotation.Annotation annotation,
            Element element) {
        super(annotation, element);
        setIsActionSource(true);
        // add in definitions of attributes coming from the base class
        // and ActionSource
        addAttribute(new AttributeInfo(
                "action",
                "Specifies the application action to invoke when this component is selected. If an "
                        + "expression it must evaluate to a method that takes no parameters, and returns an "
                        + "Object representing the outcome to be used for navigation. If a literal string it "
                        + "is used directly by the navigation processing.",
                false, "javax.el.MethodExpression"));
        addAttribute(new AttributeInfo(
                "actionListener",
                "An expression that evaluates to a public method that takes an ActionEvent "
                        + "parameter and has a return type of void, or to a public method that takes "
                        + "no arguments and has a return type of void.", false,
                "javax.el.MethodExpression"));
        addAttribute(new AttributeInfo(
                "immediate",
                "Indicates the action event should be processed during the apply request value phase.",
                false, "java.lang.Boolean"));
    }
}
