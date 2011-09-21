/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.mobile.component.WidgetBase;

/**
 * FixedSplitterPane is a pane widget that is used in a
 * dojox.mobile.FixedSplitter. It is a widget, but can be regarded as a simple
 * <div> element.
 */
@Container(dojoType = "dojox.mobile.FixedSplitterPane", requiredCss = "dojox/mobile/themes/{theme}/FixedSplitterPane.css")
class FixedSplitterPane extends WidgetBase {
}
