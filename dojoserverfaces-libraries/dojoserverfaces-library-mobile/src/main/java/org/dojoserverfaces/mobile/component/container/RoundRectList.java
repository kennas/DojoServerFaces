/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.constants.RenderPosition;
import org.dojoserverfaces.mobile.component.ListBase;

/**
 * RoundRectList is a rounded rectangle list, which can be used to display a
 * group of items. Each item must be dojox.mobile.ListItem.
 */
@Container(dojoType = "dojox.mobile.RoundRectList", requiredCss = "dojox/mobile/themes/{theme}/RoundRectList.css", renderPosition = RenderPosition.EN_CODE_BEGIN)
class RoundRectList extends ListBase {

}
