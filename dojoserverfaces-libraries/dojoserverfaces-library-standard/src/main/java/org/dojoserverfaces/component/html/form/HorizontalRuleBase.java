/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;

/**
 * Base attributes for "Ruler" marks for Sliders
 */
class HorizontalRuleBase extends WidgetBase {
    /**
     * The container indicates whether this rule goes above or below the slider.
     * Legal values are either "topDecoration" or "bottomDecoration". Default is
     * bottomDecoration.
     */
    @Property
    String container;

}
