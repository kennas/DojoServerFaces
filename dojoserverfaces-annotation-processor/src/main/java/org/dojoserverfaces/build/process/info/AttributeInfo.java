/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import javax.lang.model.element.Element;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.process.generator.GeneratorUtil;

/**
 * The AttributeInfo class defines a class used to encapsulate information
 * related to the @Attribute annotation.
 */

public class AttributeInfo implements InfoHolder {

    private String comment;
    private String name;
    private boolean required = false;
    private String type;

    public AttributeInfo() {
    }

    public AttributeInfo(String name, String comment, boolean required,
            String type) {
        this.name = name;
        this.comment = comment;
        this.required = required;
        this.type = type;
    }

    /**
     * Creates a AttributeInfo object.
     * 
     * @param element
     *            an Element object containing the Java model element to use.
     */
    public AttributeInfo(Element element) {
        this.name = element.getSimpleName().toString();
        if (this.name.startsWith("get")){
            this.name = Character.toLowerCase(this.name.charAt(3)) + this.name.substring(4);
        }
        this.comment = GeneratorUtil.getElementComment(element);
        this.type = element.asType().toString();
        if (this.type.startsWith("()")){
            this.type = this.type.substring(2); 
        }
    }

    /**
     * Creates a AttributeInfo object.
     * 
     * @param element
     *            an Element object containing the Java model element to use.
     * @param attribute
     *            an Attribute object containing the @Attribute annotation to use.
     */

    public AttributeInfo(Element element, Attribute attribute) {
        this(element);
        this.required = attribute.required();
    }

    /**
     * Retrieves the comment associated with this attribute.
     * 
     * @return a String containing the comment associated with this attribute.
     */

    public String getComment() {
        return this.comment;
    }

    /**
     * Retrieves the name associated with this attribute.
     * 
     * @return a String containing the name associated with this attribute.
     */

    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the type associated with this attribute.
     * 
     * @return a String containing the type associated with this attribute.
     */

    public String getType() {
        return this.type;
    }
    
    /**
     * @return the xml safe description of the attribute
     */
    public String getXmlDescription() {
        return GeneratorUtil.makeXmlSafeContent(comment);
    }

    /**
     * Retrieves the status as to whether or not this attribute is
     * required.
     * 
     * @return a boolean containing true if this attribute is required,
     *         false otherwise.
     */

    public boolean isRequired() {
        return this.required;
    }

    protected void setComment(String comment) {
        this.comment = comment;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setRequired(boolean required) {
        this.required = required;
    }

    protected void setType(String type) {
        this.type = type;
    }

}
