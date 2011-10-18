/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.gadget;

import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.mobile.component.WidgetBase;

/**
 * PageIndicator displays a series of gray and white dots to indicate which page
 * is currently being viewed. It can typically be used with
 * dojox.mobile.SwapView. The PageIndicator widget uses the dojo's pub/sub event
 * system to communicate with the other widgets. It subscribes to the
 * "/dojox/mobile/viewChanged" message, and refreshes the indicator status.
 */
@Gadget(dojoType = "dojox.mobile.PageIndicator", requiredCss = { "dojox/mobile/themes/{theme}/PageIndicator.css" })
public class PageIndicator extends WidgetBase {
    /**
     * An ID of a DOM node to be searched. Siblings of the reference node will
     * be searched for views. If not specified, this.domNode will be the
     * reference node. Defaults to "";
     */
    @Property
    String refId;
}
