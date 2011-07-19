/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import org.dojoserverfaces.build.annotation.GeneratedComponent;
import org.dojoserverfaces.build.annotation.Property;

/**
 * Hash marks for Vertical Slider
 */
@GeneratedComponent(displayName = "Vertical Rule", dojoType = "dijit.form.VerticalRule")
class VerticalRule extends HorizontalRule {
    /**
     * The container indicates whether this rule goes above or below the slider.
     * Legal values are either "leftDecoration" or "rightDecoration". Default is
     * "rightDecoration".
     * Note: On an RTL system, "leftDecoration" and "rightDecoration would swap 
     * positions.
     */
    @Property
    String container;
}
