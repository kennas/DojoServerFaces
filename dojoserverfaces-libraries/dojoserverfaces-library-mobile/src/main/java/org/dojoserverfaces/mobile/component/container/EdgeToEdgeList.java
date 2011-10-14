/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.constants.RenderPosition;

/**
 * EdgeToEdgeList is an edge-to-edge layout list, which displays all items in
 * equally sized rows. Each item must be dojox.mobile.ListItem.
 */
@Container(dojoType = "dojox.mobile.EdgeToEdgeList", requiredCss = "dojox/mobile/themes/{theme}/EdgeToEdgeList.css", renderPosition = RenderPosition.EN_CODE_BEGIN)
class EdgeToEdgeList extends RoundRectList {
}
