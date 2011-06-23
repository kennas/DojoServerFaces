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

/**
 * Annotation for widgets that perform as multi-select components.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@GeneratedComponent(baseClassName = "javax.faces.component.UISelectMany", elementType = HtmlElementType.SELECT_OPTION)
public @interface MultiSelectValueHolder {
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
     * @return flag indicating uses a dojo data store
     */
    public boolean store() default true;

    /**
     * @return the node to use with non-DojoServerFaces behaviors
     */
    public String jsfNode() default "domNode";
}
