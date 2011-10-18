/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.dojoserverfaces.constants.HtmlElementType;
import org.dojoserverfaces.constants.RenderPosition;
import org.dojoserverfaces.constants.RendersChildren;

/**
 * Annotation used to specify a generic DojoServerFaces component.
 */

// TODO: with the way that we rely on dojoserverfaces-runtime for some of these
// classes, we really should examine whether or not to roll
// dojoserverfaces-annotations
// back into that project and just not package the compiled annotation classes
// into the runtime JAR.

// TODO: lots of problems with classpath handling by the widget plugin if we
// use class objects here, so that's something to investigate later. For now,
// we'll just use strings.

@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface GeneratedComponent {
    public String displayName() default "";

    public String baseClassName() default "javax.faces.component.UIComponentBase";

    public String dojoType() default "";

    public HtmlElementType elementType() default HtmlElementType.DIV;

    public String[] interfaceNames() default {};

    public Class<?> postBackHandler() default Object.class;

    public String jsfNode() default "";

    /**
     * 
     * @return renderChildren type
     */
    public RendersChildren rendersChildren() default RendersChildren.NO_NOT_RESPONSIBLE;

    /**
     * @return true if the widget is a Dijit Container, false otherwise.
     *         Defaults to false.
     */
    public boolean isDijitContainer() default false;

    /**
     * 
     * @return where rendering the script
     */
    public RenderPosition renderPosition() default RenderPosition.EN_CODE_END;
}
