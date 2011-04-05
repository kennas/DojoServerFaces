/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import org.dojoserverfaces.build.process.generator.GeneratorUtil;

/**
 * Class used to encapsulate information about a Faces artifact (e.g. component, behavior)
 */
public abstract class FacesArtifactBase extends InformationCollector implements
        FacesArtifact, Comparable<FacesArtifactBase> {
    private String uniqueId;

    private String className;
    private String description;
    private String displayName;
    private String tagName;

    /**
     * Creates a BehaviorInfo object.
     * 
     * @param element
     *            an Element object containing the Java model element to use.
     * @param id
     *            a Behavior object containing the @Behavior annotation to use.
     */

    public FacesArtifactBase(Element element, String displayName, String idPrefix) {
        setDisplayName(displayName);
        tagName = GeneratorUtil.makeCamelCase(null, element.getSimpleName().toString());
        uniqueId = new StringBuilder(idPrefix).append(tagName).toString();
        description = GeneratorUtil.getElementComment(element);
        className = ((TypeElement) element).getQualifiedName().toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dojoserverfaces.build.process.model.FacesArtifact#getUniqueId()
     */
    @Override
    public String getUniqueId() {
        return uniqueId;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.dojoserverfaces.build.process.model.FacesArtifact#getClassName()
     */
    @Override
    public String getClassName() {
        return className;
    }

    protected void setClassName(String className) {
        this.className = className;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dojoserverfaces.build.process.model.FacesArtifact#getDescription()
     */
    @Override
    public String getDescription() {
        return description;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dojoserverfaces.build.process.model.FacesArtifact#getXmlDescription()
     */
    @Override
    public String getXmlDescription() {
        return GeneratorUtil.makeXmlSafeContent(description);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dojoserverfaces.build.process.model.FacesArtifact#getDisplayName()
     */
    @Override
    public String getDisplayName() {
        // TODO if displayName is null perhaps we can break up tagName into words
        return (null != displayName) ? displayName : tagName;
    }

    protected void setDisplayName(String displayName) {
        if (null != displayName) {
            displayName = displayName.trim();
            if (displayName.isEmpty()){
                displayName = null;
            }
        }
        this.displayName = displayName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dojoserverfaces.build.process.model.FacesArtifact#getTagName()
     */
    @Override
    public String getTagName() {
        return tagName;
    }

	@Override
	public Type getArtifactType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(FacesArtifactBase artifact) {
		return this.tagName.compareTo(artifact.tagName);
	}
}
