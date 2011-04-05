/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import javax.lang.model.element.Element;

import org.dojoserverfaces.build.annotation.FaceletTag;

/**
 * Class used to encapsulate information about a facelet tag.
 */

public class FaceletTagInfo extends FacesArtifactBase implements InfoHolder {

    /**
     * Creates a FaceletTagInfo object.
     * 
     * @param element
     *            an Element object containing the Java model element to use.
     * @param 
     */
    protected FaceletTagInfo(Element element, String displayName) {
        super(element, displayName, "dojoserverfaces.component.");
    }

    /**
     * Creates a FaceletTagInfo object.
     * 
     * @param element
     *            an Element object containing the Java model element to use.
     * @param component
     *            a object containing the annotation to use.
     */
    public FaceletTagInfo(Element element, FaceletTag annotation) {
        this(element, annotation.value());
    }

	/*
     * (non-Javadoc)
     * 
     * @see org.dojoserverfaces.build.process.model.FacesArtifact#getArtifactType()
     */
    @Override
    public FacesArtifact.Type getArtifactType() {
        return FacesArtifact.Type.FACELET_TAG;
    }
}
