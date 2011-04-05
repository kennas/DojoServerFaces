/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.generator;

import java.io.UnsupportedEncodingException;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

/**
 * The GeneratorUtil class defines utility methods for class generation.
 */

public class GeneratorUtil {
    private static Elements elementUtils;
    private static SourceGeneratorManager sourceGeneratorManager;
    private static Types typeUtils;

    /**
     * Creates a GeneratorUtil object.
     */

    private GeneratorUtil() {
    }

    /**
     * Retrieves the comments for a Java model element.
     * 
     * @param element
     *            an Element object containing the Java model element for which
     *            comments are to be retrieved.
     * @return a String containing the comments for the Java model element, or
     *         null if there are none.
     */

    public static String getElementComment(Element element) {
        String comment = GeneratorUtil.elementUtils.getDocComment(element);

        if (comment != null) {
            comment = comment.trim();

            if (comment.equals("")) {
                comment = null;
            }
        }

        return comment;
    }

    /**
     * Retrieves the Java filename for a given class.
     * 
     * @param className
     *            a String containing the class name to use.
     * @return a String containing the Java filename for the given class.
     */

    public static String getJavaFilename(String className) {
        return (className.replace('.', '/').concat(".java"));
    }

    /**
     * Retrieves a source generator.
     * 
     * @param className
     *            a String containing the class name of the source generator to
     *            retrieve.
     * @return a SourceGenerator object containing the desired source generator
     *         or null if no source generator with the given class name can be
     *         found.
     */

    public static SourceGenerator getSourceGenerator(String className) {
        return GeneratorUtil.sourceGeneratorManager
                .getExistingSourceGenerator(className);
    }

    /**
     * Retrieves a Java model element from a type mirror.
     * 
     * @param type
     *            a TypeMirror object containing the type mirror to use.
     * @return an Element object containing the Java model element obtained from
     *         the given type mirror.
     */

    public static Element getTypeAsElement(TypeMirror type) {
        return GeneratorUtil.typeUtils.asElement(type);
    }

    /**
     * Retrieves a Java model element for a given class name.
     * 
     * @param name a String containing the class name to use.
     * @return a TypeElement object containing the Java model element for the
     *         given class name or null if a Java model element cannot be
     *         found.
     */
    
    public static TypeElement getTypeElement (String name) {
         return GeneratorUtil.elementUtils.getTypeElement (name);
    }
    
    /**
     * Sets the processing environment to associate with this generator
     * utilities class.
     * 
     * @param env
     *            a ProcessingEnvironment object containing the processing
     *            environment to associate with this generator utilities class.
     * @param sourceGeneratorManager
     *            a SourceGeneratorManager object containing the source
     *            generator manager to associate with this generator utilities
     *            class.
     */

    public static void setProcessingEnvironment(ProcessingEnvironment env,
            SourceGeneratorManager sourceGeneratorManager) {
        GeneratorUtil.elementUtils = env.getElementUtils();
        GeneratorUtil.sourceGeneratorManager = sourceGeneratorManager;
        GeneratorUtil.typeUtils = env.getTypeUtils();
    }

    /**
     * Determines whether or not a type element's name is equal to a given name.
     * 
     * @param element
     *            a TypeElement object containing the type element to check.
     * @param name
     *            a String containing the name to check.
     * @return a boolean containing true if the given type element has the same
     *         name as the given name, false otherwise.
     */

    public static boolean elementNameEquals(TypeElement element, String name) {
        return element.getQualifiedName().toString().equals(name);
    }

    /**
     * Creates a camelcase string from an input string and a prefix.
     * 
     * @param prefix
     *            a String containing the prefix to use.
     * @param str
     *            a String containing the input string to use.
     * @return a String containing the fixed string.
     */

    public static String makeCamelCase(String prefix, String str) {
        String result = ((prefix == null) ? "" : prefix);

        if (prefix != null) {
            result += Character.toUpperCase(str.charAt(0));
        }

        else {
            result += Character.toLowerCase(str.charAt(0));
        }

        result += str.substring(1);

        return result;
    }

    /**
     * Convert a string to be safe for xml element content (body). by replacing
     * <, > and & characters with their escape sequence. This will also make it
     * html safe and can be displayed by tools.
     * 
     * @param s
     *            String to convert
     * @return String the converted string
     */
    public static String makeXmlSafeContent(String s) {
        if (null == s) {
            return null;
        }

        try {
            // need to insure UTF-8 form of string is created
            return new String(s.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
                    .replaceAll(">", "&gt;").getBytes(), "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
