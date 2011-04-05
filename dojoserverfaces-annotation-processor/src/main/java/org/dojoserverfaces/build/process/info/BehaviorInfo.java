/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import javax.lang.model.element.Element;

import org.dojoserverfaces.build.annotation.Behavior;

/**
 * The BehaviorInfo class defines a class used to encapsulate information
 * related to the @Behavior annotation.
 */

public class BehaviorInfo extends FacesArtifactBase implements InfoHolder {

    /**
     * Creates a BehaviorInfo object.
     * 
     * @param element
     *            an Element object containing the Java model element to use.
     * @param behavior
     *            a Behavior object containing the @Behavior annotation to use.
     */

    public BehaviorInfo(Element element, Behavior behavior) {
        super(element, null, "dojoserverfaces.behavior.");
        
        // all behaviors have this attribute
        addAttribute(new AttributeInfo(
                "event",
                "The name of the event to which to attach the behavior.",
                false, "java.lang.String"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dojoserverfaces.build.process.model.FacesArtifact#getArtifactType()
     */
    @Override
    public FacesArtifact.Type getArtifactType() {
        return FacesArtifact.Type.BEHAVIOR;
    }
}
