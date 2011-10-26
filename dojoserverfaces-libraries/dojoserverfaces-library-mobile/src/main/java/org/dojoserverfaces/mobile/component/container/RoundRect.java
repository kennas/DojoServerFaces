/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.constants.RenderPosition;
import org.dojoserverfaces.mobile.component.WidgetBase;

/**
 * RoundRect is a simple round rectangle container for any HTML and/or widgets.
 * You can achieve the same appearance by just applying the
 * -webkit-border-radius style to a div tag. However, if you use RoundRect, you
 * can get a round rectangle even on non-CSS3 browsers such as (older) IE.
 * 
 */
@Container(dojoType = "dojox.mobile.RoundRect", requiredCss = { "dojox/mobile/themes/{theme}/RoundRect.css" }, renderPosition = RenderPosition.EN_CODE_BEGIN)
public class RoundRect extends WidgetBase {
    /**
     * If true, adds a shadow effect to the container element.
     */
    @Property
    Boolean shadow;
}
