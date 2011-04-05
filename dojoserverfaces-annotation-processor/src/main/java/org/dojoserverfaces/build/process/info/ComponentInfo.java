/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import javax.lang.model.element.Element;

import org.dojoserverfaces.build.annotation.Component;

/**
 * Class used to encapsulate information about a faces component.
 */

public class ComponentInfo extends FacesArtifactBase implements InfoHolder {

    /**
     * Creates a ComponentInfo object.
     * 
     * @param element
     *            an Element object containing the Java model element to use.
     * @param
     */
    protected ComponentInfo(Element element, String displayName) {
        super(element, displayName, "dojoserverfaces.component.");
        addAttribute(new AttributeInfo(
                "rendered",
                "Flag indicating whether or not this component should be rendered (during Render Response Phase), or processed on any subsequent form submit. The default value for this property is true.",
                false, "java.lang.Boolean"));
    }

    /**
     * Creates a ComponentInfo object.
     * 
     * @param element
     *            an Element object containing the Java model element to use.
     * @param component
     *            a object containing the annotation to use.
     */
    public ComponentInfo(Element element, Component component) {
        this(element, component.value());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.dojoserverfaces.build.process.model.FacesArtifact#getArtifactType()
     */
    @Override
    public FacesArtifact.Type getArtifactType() {
        return FacesArtifact.Type.COMPONENT;
    }
}
