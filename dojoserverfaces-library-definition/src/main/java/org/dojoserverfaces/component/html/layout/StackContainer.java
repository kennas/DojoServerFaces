/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.layout;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;

/**
 * A container for widgets (ContentPanes, for example) That displays only one
 * Widget at a time. Publishes topics [widgetId]-addChild,
 * [widgetId]-removeChild, and [widgetId]-selectChild Can be base class for
 * container, Wizard, Show, etc
 * 
 */
@Container(dojoType = "dijit.layout.StackContainer")
class StackContainer extends ContainerBase {

    /**
     * Save selected component in a cookie.
     */
    @Property
    Boolean persist;
    
    /**
     * If true, change the size of my currently displayed child to match my size.
     */
    @Property
    Boolean doLayout;

}
