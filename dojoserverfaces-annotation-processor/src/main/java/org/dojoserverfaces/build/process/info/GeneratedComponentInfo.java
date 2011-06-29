/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import java.util.Collection;
import java.util.TreeSet;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;

import org.dojoserverfaces.build.annotation.GeneratedComponent;
import org.dojoserverfaces.build.process.AnnotationProcessor;
import org.dojoserverfaces.build.process.generator.GeneratorUtil;
import org.dojoserverfaces.constants.HtmlElementType;

/**
 * The GeneratedComponentInfo class defines a class used to encapsulate
 * information to be used for generating the component source code.
 */

public class GeneratedComponentInfo extends ComponentInfo {

    private String baseClassName;
    private String dojoType;
    private Boolean isWidget = true;
    private String[] requiredCss = null;
    private HtmlElementType elementType;
    private String interfaceNames[];
    private Boolean valueEditor = Boolean.FALSE;
    private Boolean isActionSource = Boolean.FALSE;
    private String jsfNode;

    /**
     * indication that the component will handle postbacks
     */
    private Boolean handlesPostBack = Boolean.FALSE;
    private String postBackHandler = null;

    protected GeneratedComponentInfo(java.lang.annotation.Annotation annotaion,
            Element element) {
        this(element, annotaion.annotationType().getAnnotation(
                GeneratedComponent.class));
    }

    public GeneratedComponentInfo(Element element,
            GeneratedComponent generatedComponent) {
        super(element, generatedComponent.displayName());

        // Construct the component class name since resource generators will
        // need access to it.

        String componentClassName = ((TypeElement) element).getSimpleName()
                .toString() + "Component";
        String componentPackageName = System
                .getProperty(AnnotationProcessor.PROPERTY_PACKAGE_COMPONENT);
        if (null == componentPackageName || componentPackageName.isEmpty()) {
            // default to generating class in to same package as annotated file
            componentPackageName = ((TypeElement) element).getQualifiedName()
                    .toString();
            componentPackageName = componentPackageName.substring(0,
                    componentPackageName.lastIndexOf('.'));
        }

        setClassName(new StringBuilder(componentPackageName).append('.')
                .append(componentClassName).toString());

        if (generatedComponent != null) {
            this.baseClassName = generatedComponent.baseClassName().trim();
            this.dojoType = generatedComponent.dojoType().trim();
            this.elementType = generatedComponent.elementType();
            this.jsfNode = generatedComponent.jsfNode().trim();
            this.interfaceNames = generatedComponent.interfaceNames();

            if (this.baseClassName.equals("")
                    || this.baseClassName.equals("java.lang.Object")) {
                this.baseClassName = null;
            }

            if (this.dojoType.trim().equals("")) {
                this.dojoType = null;
            }

            if (this.jsfNode.equals("")) {
                this.jsfNode = null;
            }

            // Bit of a hack to be done because annotation processing cannot
            // handle class loading at compile-time...
            String handler = null;
            try {
                handler = generatedComponent.postBackHandler().getName();
            }
            catch (MirroredTypeException e) {
                try {
                    handler = GeneratorUtil.getTypeAsElement(e.getTypeMirror())
                            .toString();
                }
                catch (Throwable ex) {
                    System.out.println("exception 2: ");
                }
            }
            this.postBackHandler = (handler.equals("java.lang.Object")) ? null
                    : handler;
        }
        addAttribute(new AttributeInfo("id", "The tag id.", false,
                "java.lang.String"));
    }

    /**
     * Retrieves the base class name associated with this generic component.
     * 
     * @return a String containing the base class name associated with this
     *         generic component.
     */

    public String getBaseClassName() {
        return this.baseClassName;
    }

    /**
     * Retrieves the default event associated with this component.
     * 
     * @return an EventInfo object containing the default event associated with
     *         this component, or null if no default event exists.
     */

    public EventInfo getDefaultEvent() {
        Collection<EventInfo> events = getEvents();

        for (EventInfo event : events) {
            if (event.isDefault()) {
                return event;
            }
        }
        return null;
    }

    /**
     * Retrieves the Dojo type associated with this generic component.
     * 
     * @return a String containing the Dojo type associated with this generic
     *         component.
     */

    public String getDojoType() {
        return this.dojoType;
    }

    public String getJsfNode() {
        return this.jsfNode;
    }

    public Boolean getIsWidget() {
        return isWidget;
    }

    public String[] getRequiredCss() {
        return requiredCss;
    }

    protected void setWidgetType(String dojoType) {
        this.dojoType = dojoType;
        this.isWidget = Boolean.TRUE;
    }

    protected void setJsfNode(String jsfNode) {
        this.jsfNode = jsfNode;
    }

    protected void setObjectType(String dojoType) {
        this.dojoType = dojoType;
        this.isWidget = Boolean.FALSE;
    }

    protected void setRequiredCss(String[] requiredCss) {
        this.requiredCss = requiredCss;
    }

    /**
     * Retrieves the family associated with this generic component.
     * 
     * @return a String containing the family associated with this generic
     *         component.
     */

    public String getFamily() {
        return "dojoserverfaces.component.default";
    }

    /**
     * Retrieves the HTML element class name associated with this generic
     * component.
     * 
     * @return a String object containing the HTML element class name associated
     *         with this generic component.
     */
    public String getElementType() {
        return new StringBuilder(this.elementType.getClass().getName())
                .append('.').append(elementType.name()).toString();
    }

    /**
     * Retrieves the names of the interfaces associated with this generic
     * component.
     * 
     * @return an array of Strings containing the names of the interfaces
     *         associated with this generic component.
     */
    public String[] getInterfaceNames() {
        return this.interfaceNames;
    }

    /**
     * Retrieves the names of all properties associated with this generic
     * component.
     * 
     * @return a Collection object consisting of Strings that represents the
     *         names of all the properties associated with this generic
     *         component.
     */
    public Collection<String> getPropertyNames() {
        TreeSet<String> result = new TreeSet<String>();
        for (PropertyInfo property : getProperties()) {
            result.add(property.getPropertyName());
        }
        return result;
    }

    /**
     * Retrieves the value property associated with this component.
     * 
     * @return a PropertyInfo object containing the value property associated
     *         with this component, or null if no value property exists.
     */
    public PropertyInfo getValueProperty() {
        Collection<PropertyInfo> properties = getProperties();

        for (PropertyInfo property : properties) {
            if (property.isValue()) {
                return property;
            }
        }
        return null;
    }

    /**
     * @return indication that the component is a value editor
     */
    public Boolean getIsValueEditor() {
        return valueEditor;
    }

    /**
     * @param isValueEditor
     *            indication that the component is a value editor and it also
     *            handles post back
     */
    public void setIsValueEditor(Boolean isValueEditor) {
        this.valueEditor = isValueEditor;
        this.handlesPostBack = isValueEditor;
    }

    public Boolean getIsActionSource() {
        return isActionSource;
    }

    public void setIsActionSource(Boolean isActionSource) {
        this.isActionSource = isActionSource;
        this.handlesPostBack = isActionSource;
    }

    /**
     * @return indication that the component handles post back
     */
    public Boolean getHandlesPostBack() {
        return handlesPostBack;
    }

    /**
     * @param handlesPostBack
     *            indication that the component handles post back
     */
    public void setHandlesPostBack(Boolean handlesPostBack) {
        this.handlesPostBack = handlesPostBack;
    }

    public void setElementType(HtmlElementType type) {
        this.elementType = type;
    }

    /**
     * @param postBackHandler
     *            the postBackHandler to set
     */
    public void setPostBackHandler(String postBackHandler) {
        this.postBackHandler = postBackHandler;
    }

    /**
     * @return the postBackHandler
     */
    public String getPostBackHandler() {
        return postBackHandler;
    }

}
