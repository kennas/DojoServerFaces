/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.generator.lib;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

import org.dojoserverfaces.build.process.generator.ClassSourceGenerator;
import org.dojoserverfaces.build.process.info.GeneratedComponentInfo;

/**
 * The ComponentSourceGenerator class defines an implementation of the
 * SourceGenerator class that handles Dojo JSF components.
 */

public class ComponentSourceGenerator extends ClassSourceGenerator {
    private GeneratedComponentInfo componentDefinition;
    private String outputLocation;

    /**
     * Creates a ComponentSourceGenerator object.
     * 
     * @param processingEnv
     *            a ProcessingEnvironment object containing the processing
     *            environment to use.
     * @param roundEnv
     *            a RoundEnvironment object containing the round environment to
     *            use.
     * @param element
     *            a TypeElement object containing the Java model element
     *            representing the class used by this class source generator.
     * @param componentDefinitionClass
     *            a String containing the location where the generated source
     *            should be saved.
     * @throws Throwable
     *             if an error occurs while creating this source generator.
     */
    protected ComponentSourceGenerator(ProcessingEnvironment processingEnv,
            RoundEnvironment roundEnv, TypeElement element,
            String componentDefinitionClass) throws Throwable {
        super(processingEnv, roundEnv, element, componentDefinitionClass);
    }

    /**
     * Creates a ComponentSourceGenerator object.
     * 
     * @param processingEnv
     *            a ProcessingEnvironment object containing the processing
     *            environment to use.
     * @param roundEnv
     *            a RoundEnvironment object containing the round environment to
     *            use.
     * @param element
     *            a TypeElement object containing the Java model element
     *            representing the class used by this class source generator.
     * @param definition
     *            an description of what to generate
     * @throws Throwable
     *             if an error occurs while creating this source generator.
     */
    public ComponentSourceGenerator(ProcessingEnvironment processingEnv,
            RoundEnvironment roundEnv, TypeElement element,
            GeneratedComponentInfo definition) throws Throwable {
        super(processingEnv, roundEnv, element, definition.getClassName());
        setDefinition(definition);
    }

    /*
     * @see org.dojoserverfaces.internal.annotation.generator.SourceGenerator#
     * getOutputLocation()
     */
    @Override
    protected String getOutputLocation() {
        if (this.outputLocation == null) {
            return super.getOutputLocation();
        }
        return this.outputLocation;
    }

    /*
     * @see
     * org.dojoserverfaces.internal.annotation.generator.SourceGenerator#getTemplatePath
     * ()
     */
    @Override
    protected String getTemplatePath() {
        return "META-INF/template/lib/component.template";
    }

    public void setDefinition(GeneratedComponentInfo componentInfo) {
        String interfaces[];

        // This should always be a GeneratedComponentInfo...
        this.componentDefinition = (GeneratedComponentInfo) componentInfo;

        // save away for generation via template
        addContextProperty("componentInfo", componentInfo);

        // Use the correct DojoServerFaces base classes and interfaces.
        setSuperclass(this.componentDefinition.getBaseClassName());
        interfaces = this.componentDefinition.getInterfaceNames();

        for (String intf : interfaces) {
            addInterfaceName(intf);
        }

        // Also, mark that we actually want to generate source for this
        // class.

        if (componentInfo instanceof GeneratedComponentInfo) {
            setQualifiedClassName(((GeneratedComponentInfo) componentInfo)
                    .getClassName());
        }
        setShouldGenerate(true);
    }
}
