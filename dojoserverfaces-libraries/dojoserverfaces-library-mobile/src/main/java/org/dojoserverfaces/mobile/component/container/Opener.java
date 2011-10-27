/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.constants.RenderPosition;
import org.dojoserverfaces.mobile.component.WidgetBase;

/**
 * Opener is a utility widget that behaves either as a Overlay on small screen
 * devices or as a Tooltip otherwise.
 * 
 */
@Container(dojoType = "dojox.mobile.Opener", requiredCss = "dojox/mobile/themes/{theme}/Opener.css", renderPosition = RenderPosition.EN_CODE_BEGIN)
public class Opener extends WidgetBase {

}
