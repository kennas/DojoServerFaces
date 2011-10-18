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
 * Annotation for defining ActionSource components
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@GeneratedComponent(baseClassName = "javax.faces.component.UICommand", elementType = HtmlElementType.ACTION)
public @interface ActionSource {
    /**
     * @return display name for component
     */
    public String displayName() default "";

    /**
     * @return dojoType String
     */
    public String dojoType();

    /**
     * @return String[] of require css files. Use {theme} for where to
     *         substitute selected theme name at runtime
     */
    public String[] requiredCss() default {};

    /**
     * @return the node to use with non-DojoServerFaces behaviors
     */
    public String jsfNode() default "domNode";

    /**
     * 
     * @return renderChildren type
     */
    public RendersChildren rendersChildren() default RendersChildren.NO_NOT_RESPONSIBLE;
    /**
     * 
     * @return where rendering the script
     */
    public RenderPosition renderPosition() default RenderPosition.EN_CODE_END;
}
