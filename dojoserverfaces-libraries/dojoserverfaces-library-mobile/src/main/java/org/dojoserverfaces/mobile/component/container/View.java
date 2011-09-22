/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.mobile.component.WidgetBase;

/**
 * View acts as a container for any HTML and/or widgets. An entire HTML page can
 * have multiple View widgets and the user can navigate through the views back
 * and forth without page transitions.
 * 
 */
@Container(dojoType = "dojox.mobile.View", requiredCss = "dojox/mobile/themes/{theme}/ScrollableView.css")
public class View extends WidgetBase {
    /**
     * If true, the view is displayed at startup time. Defaults to false.
     */
    @Property
    Boolean selected;

    /**
     * If true, the scroll position is kept when transition occurs between
     * views. Defaults to true.
     */
    @Property
    Boolean keepScrollPos;

}
