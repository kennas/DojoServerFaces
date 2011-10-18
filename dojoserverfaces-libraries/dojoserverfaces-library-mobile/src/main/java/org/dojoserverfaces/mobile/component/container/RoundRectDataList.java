/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.constants.RenderPosition;
import org.dojoserverfaces.mobile.component.DataListBase;

/**
 * RoundRectDataList is an enhanced version of RoundRectList. It can generate
 * ListItems according to the given dojo.data store.
 * 
 */
@Container(dojoType = "dojox.mobile.RoundRectDataList", requiredCss = {
        "dojox/mobile/themes/{theme}/RoundRectList.css",
        "dojox/mobile/themes/{theme}/ListItem.css" }, renderPosition = RenderPosition.EN_CODE_BEGIN)
public class RoundRectDataList extends DataListBase {

}
