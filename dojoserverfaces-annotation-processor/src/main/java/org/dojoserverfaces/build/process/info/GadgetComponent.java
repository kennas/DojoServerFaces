/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import javax.lang.model.element.Element;

import org.dojoserverfaces.build.annotation.Gadget;

/**
 * Class used to encapsulate information used to generate simple gadget (no value) component.
 */

public class GadgetComponent extends GeneratedComponentInfo {

    /**
     * Creates a GadgetComponent object.
     * 
     * @param element
     *            an Element object containing the Java model element to use.
     * @param container
     *            a Container object containing the Container annotation to use.
     */
    public GadgetComponent(Element element, Gadget annotation) {
        super(annotation, element);
        setWidgetType(annotation.dojoType());
        setRequiredCss(annotation.requiredCss());
        setDisplayName(annotation.displayName());
        setJsfNode(annotation.jsfNode());
        setRendersChildren(annotation.rendersChildren());
        setRenderPosition(annotation.renderPosition());
    }
}
