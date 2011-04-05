/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import org.dojoserverfaces.build.annotation.GeneratedComponent;
import org.dojoserverfaces.build.annotation.Property;

/**
 * Hash marks for Horizontal Slider
 */
@GeneratedComponent(displayName = "Horizontal Rule", dojoType = "dijit.form.HorizontalRule")
class HorizontalRule extends HorizontalRuleBase {
    /**
     * Number of hash marks to generate. Default is 3.
     */
    @Property
    Integer count;

    /**
     * CSS style to apply to individual hash marks
     */
    @Property
    String ruleStyle;
}
