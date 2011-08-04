package org.dojoserverfaces.build.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.dojoserverfaces.constants.HtmlElementType;
import org.dojoserverfaces.constants.RendersChildren;
/**
 * Annotation to be applied to a class that defines a dojo widget to be wrapped
 * into a jsf component/renderer
 * 
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@GeneratedComponent(baseClassName = "javax.faces.component.UIOutput")
public @interface ValueHolder {
    /**
     * @return element enum from HtmlElementType
     */
    public HtmlElementType elementType() default HtmlElementType.SPAN;

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
}
