/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import javax.lang.model.element.Element;

import org.dojoserverfaces.build.annotation.DojoObject;

/**
 * Class used to encapsulate information used to generate a component
 * representing a dojo object.
 */

public class DojoObjectComponent extends GeneratedComponentInfo {

    /**
     * @param element
     *            an Element object containing the Java model element to use.
     * @param dojoObject
     *            a DojoObject (annotation) object to use.
     */
    public DojoObjectComponent(Element element, DojoObject dojoObject) {
        super(dojoObject, element);
        setObjectType(dojoObject.dojoType());
        setDisplayName(dojoObject.displayName());
    }
}
