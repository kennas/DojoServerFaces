/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

/**
 * Class representing an HTML dimension (e.g. 1.5em, 10px).
 */
public class DimensionProperty extends StringProperty {

    public DimensionProperty(String name, String propertyName) {
        super(name, propertyName);
    }

    public DimensionProperty(String name) {
        this(name, name);
    }

    // TODO if STAGE = DEVELOPMENT then validate property as
    // a legal dimension (e.g. 1.5em, 300px,...)
}
