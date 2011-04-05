/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import org.dojoserverfaces.build.annotation.ActionSource;
import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Behavior;
import org.dojoserverfaces.build.annotation.Component;
import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.DojoObject;
import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.FaceletTag;
import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.GeneratedComponent;
import org.dojoserverfaces.build.annotation.MultiSelectValueHolder;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.build.annotation.SelectValueHolder;
import org.dojoserverfaces.build.process.generator.GeneratorUtil;
import org.dojoserverfaces.build.process.generator.SourceGeneratorManager;
import org.dojoserverfaces.build.process.generator.doc.DocCompositeSourceGenerator;
import org.dojoserverfaces.build.process.generator.lib.ComponentSourceGenerator;
import org.dojoserverfaces.build.process.generator.lib.FacesConfigResourceGenerator;
import org.dojoserverfaces.build.process.generator.lib.TaglibResourceGenerator;
import org.dojoserverfaces.build.process.info.ActionSourceComponent;
import org.dojoserverfaces.build.process.info.AttributeInfo;
import org.dojoserverfaces.build.process.info.BehaviorInfo;
import org.dojoserverfaces.build.process.info.ComponentInfo;
import org.dojoserverfaces.build.process.info.ContainerComponent;
import org.dojoserverfaces.build.process.info.DojoObjectComponent;
import org.dojoserverfaces.build.process.info.EventInfo;
import org.dojoserverfaces.build.process.info.FaceletTagInfo;
import org.dojoserverfaces.build.process.info.FacesArtifact;
import org.dojoserverfaces.build.process.info.GadgetComponent;
import org.dojoserverfaces.build.process.info.GeneratedComponentInfo;
import org.dojoserverfaces.build.process.info.InfoHolder;
import org.dojoserverfaces.build.process.info.InformationCollector;
import org.dojoserverfaces.build.process.info.MultiValueSelectComponent;
import org.dojoserverfaces.build.process.info.PropertyInfo;
import org.dojoserverfaces.build.process.info.ValueEditorComponent;
import org.dojoserverfaces.build.process.info.ValueSelectComponent;

/**
 * The AnnotationProcessor class defines an annotation processor used to
 * generate DojoServerFaces components.
 */

@SupportedAnnotationTypes({ "org.dojoserverfaces.build.annotation.*" })
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class AnnotationProcessor extends AbstractProcessor {

    /**
     * collection of classElements and their collection of annotations
     */
    HashMap<TypeElement, InformationCollector> annotatedClasses = new HashMap<TypeElement, InformationCollector>();

    /**
     * The property name for a component library's namespace.
     */
    public static final String PROPERTY_NAMESPACE = "dojoserverfaces.widget.lib.namespace";

    /**
     * The property name for a component library's component package.
     */
    public static final String PROPERTY_PACKAGE_COMPONENT = "dojoserverfaces.widget.lib.package.component";

    private SourceGeneratorManager manager;
    private ProcessingEnvironment processingEnv;

    private InfoHolder getInfoHolder(Element element, TypeElement annotation) {
        if (GeneratorUtil.elementNameEquals(annotation,
                Property.class.getName())) {
            return new PropertyInfo(element,
                    element.getAnnotation(Property.class));
        }
        else if (GeneratorUtil.elementNameEquals(annotation,
                Attribute.class.getName())) {
            return new AttributeInfo(element,
                    element.getAnnotation(Attribute.class));
        }
        else if (GeneratorUtil.elementNameEquals(annotation,
                Event.class.getName())) {
            return new EventInfo(element, element.getAnnotation(Event.class));
        }
        else if (GeneratorUtil.elementNameEquals(annotation,
                Behavior.class.getName())) {
            return new BehaviorInfo(element,
                    element.getAnnotation(Behavior.class));
        }
        else if (GeneratorUtil.elementNameEquals(annotation,
                Component.class.getName())) {
            return new ComponentInfo(element,
                    element.getAnnotation(Component.class));
        }
        else if (GeneratorUtil.elementNameEquals(annotation,
                FaceletTag.class.getName())) {
            return new FaceletTagInfo(element,
                    element.getAnnotation(FaceletTag.class));
        }
        else if (GeneratorUtil.elementNameEquals(annotation,
                EditableValueHolder.class.getName())) {
            return new ValueEditorComponent(element,
                    element.getAnnotation(EditableValueHolder.class));
        }
        else if (GeneratorUtil.elementNameEquals(annotation,
                ActionSource.class.getName())) {
            return new ActionSourceComponent(element,
                    element.getAnnotation(ActionSource.class));
        }
        else if (GeneratorUtil.elementNameEquals(annotation,
                MultiSelectValueHolder.class.getName())) {
            return new MultiValueSelectComponent(element,
                    element.getAnnotation(MultiSelectValueHolder.class));
        }
        else if (GeneratorUtil.elementNameEquals(annotation,
                SelectValueHolder.class.getName())) {
            return new ValueSelectComponent(element,
                    element.getAnnotation(SelectValueHolder.class));
        }
        else if (GeneratorUtil.elementNameEquals(annotation,
                Container.class.getName())) {
            return new ContainerComponent(element,
                    element.getAnnotation(Container.class));
        }
        else if (GeneratorUtil.elementNameEquals(annotation,
                Gadget.class.getName())) {
            return new GadgetComponent(element,
                    element.getAnnotation(Gadget.class));
        }
        else if (GeneratorUtil.elementNameEquals(annotation,
                DojoObject.class.getName())) {
            return new DojoObjectComponent(element,
                    element.getAnnotation(DojoObject.class));
        }
        else if (GeneratorUtil.elementNameEquals(annotation,
                GeneratedComponent.class.getName())) {
            return new GeneratedComponentInfo(element,
                    element.getAnnotation(GeneratedComponent.class));
        }
        return null;
    }

    public InformationCollector getInfoCollectorForClass(
            TypeElement classElement) {
        Element annotation;
        InformationCollector collector = null;
        List<? extends AnnotationMirror> mirrors = classElement
                .getAnnotationMirrors();

        if (mirrors.size() > 0) {
            // Use the first annotation.
            // TODO: what about multiple annotations?
            annotation = mirrors.get(0).getAnnotationType().asElement();
            collector = (InformationCollector) getInfoHolder(classElement,
                    (TypeElement) annotation);
        }
        if (null == collector) {
            // just create a generic collector information
            collector = new InformationCollector();
        }
        return collector;
    }

    /*
     * @see javax.annotation.processing.AbstractProcessor#init(javax.annotation.
     * processing.ProcessingEnvironment)
     */

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        this.manager = new SourceGeneratorManager(processingEnv);
        this.processingEnv = processingEnv;

        GeneratorUtil.setProcessingEnvironment(processingEnv, this.manager);
    }

    /**
     * Finds all the locations of a particular annotation.
     * 
     * @param annotation
     *            a TypeElement object containing the Java model element
     *            corresponding to the annotation that will be searched for.
     * @param env
     *            a RoundEnvironment object containing the round environment to
     *            use.
     * @return a Map object keyed by a TypeElement object representing the class
     *         in which the annotation was found with a List object value
     *         consisting of Element objects that represent the Java model
     *         elements where the given annotation was found.
     */

    private Map<TypeElement, List<Element>> locateAnnotations(
            TypeElement annotation, RoundEnvironment env) {

        Set<? extends Element> elements = env
                .getElementsAnnotatedWith(annotation);
        HashMap<TypeElement, List<Element>> result = new HashMap<TypeElement, List<Element>>();

        // Iterate over the annotated elements and figure out what class they
        // belong to, then store the elements in a list for each class.
        for (Iterator<? extends Element> i = elements.iterator(); i.hasNext();) {
            TypeElement classElement;
            Element element = i.next();
            List<Element> elementList = null;

            if (element instanceof TypeElement) {
                // This is a class, so we can simply use the type element.
                classElement = (TypeElement) element;
            }
            else {
                // This should be a field or method, so the enclosing type
                // is the class.
                classElement = (TypeElement) element.getEnclosingElement();
            }
            // Find the appropriate list to add the element to.
            elementList = result.get(classElement);
            if (elementList == null) {
                elementList = new LinkedList<Element>();
                result.put(classElement, elementList);
            }
            elementList.add(element);
        }
        return result;
    }

    /*
     * @see javax.annotation.processing.AbstractProcessor#process(java.util.Set,
     * javax.annotation.processing.RoundEnvironment)
     */

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv) {

        // Iterate over all the annotations and find their locations.

        for (Iterator<? extends TypeElement> i = annotations.iterator(); i
                .hasNext();) {
            TypeElement annotation = i.next();

            // get a map of class elements with a list the associated member
            // elements this particular annotation is used on
            Map<TypeElement, List<Element>> classesWithAnnotation = locateAnnotations(
                    annotation, roundEnv);

            // get just the list of class elements that use this annotation
            Set<TypeElement> classElements = classesWithAnnotation.keySet();

            // Iterate over all the classes and make sure there is an associated
            // "annotation collector" class saved away.
            for (TypeElement classElement : classElements) {
                if (!annotatedClasses.containsKey(classElement)) {
                    annotatedClasses.put(classElement,
                            getInfoCollectorForClass(classElement));
                }
            }
            // We earlier collected all the elements annotated with the
            // annotation being processed and grouped them with their 
            // associated class element.
            // Now for each group, process the annotation and apply
            // it to the annotation collector associated with the class.
            // Unless the annotation being processed is on the class
            // element itself.
            for (TypeElement classElement : classElements) {
                List<Element> elements = classesWithAnnotation
                        .get(classElement);
                for (Element element : elements) {
                    if (!element.equals(classElement)) {
                        annotatedClasses.get(classElement).addInformation(
                                getInfoHolder(element, annotation));
                    }
                }
            }
        }
        // now set up the annotated classes hierarchy.
        for (TypeElement annotatedClass : annotatedClasses.keySet()) {
            // for each classElement see if its parent is in the
            // annotated class list
            String parentName = annotatedClass.getSuperclass().toString();
            for (TypeElement classElement : annotatedClasses.keySet()) {
                if (classElement.getQualifiedName().toString()
                        .equals(parentName)) {
                    annotatedClasses.get(annotatedClass).setParent(
                            annotatedClasses.get(classElement));
                }
            }
        }

        if (roundEnv.processingOver()) {
            // Processing is finished, so create a component source generator
            // for each appropriately annotated class
            try {
                for (TypeElement annotatedClass : annotatedClasses.keySet()) {
                    InformationCollector infoCollector = annotatedClasses
                            .get(annotatedClass);
                    if (infoCollector instanceof GeneratedComponentInfo) {
                        this.manager
                                .addSourceGenerator(new ComponentSourceGenerator(
                                        processingEnv, roundEnv,
                                        annotatedClass,
                                        (GeneratedComponentInfo) infoCollector));
                    }
                }
                // TODO: allow plugin to specify location of config files ?
                FacesConfigResourceGenerator configGenerator = new FacesConfigResourceGenerator(
                        this.processingEnv, roundEnv,
                        "META-INF/faces-config.xml");
                this.manager.addSourceGenerator(configGenerator);
                TaglibResourceGenerator taglibGenerator = new TaglibResourceGenerator(
                        this.processingEnv, roundEnv,
                        "META-INF/dojoserverfaces.taglib.xml");
                this.manager.addSourceGenerator(taglibGenerator);
                DocCompositeSourceGenerator docGenerator = new DocCompositeSourceGenerator(
                        this.processingEnv, roundEnv, null);
                this.manager.addSourceGenerator(docGenerator);

                for (InformationCollector infoCollector : annotatedClasses
                        .values()) {
                    if (infoCollector instanceof FacesArtifact) {
                        configGenerator
                                .addArtifact((FacesArtifact) infoCollector);
                        taglibGenerator
                                .addArtifact((FacesArtifact) infoCollector);
                        docGenerator.addArtifact((FacesArtifact) infoCollector);
                    }
                }
                // generate the source files!
                this.manager.applyAllSourceGenerators();
            }
            catch (Throwable e) {
                // TODO: maybe report the error...
                e.printStackTrace();
            }
        }
        return true;
    }
}
