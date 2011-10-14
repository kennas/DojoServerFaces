/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.constants.RenderPosition;

/**
 * SwapView is a container widget that represents entire mobile device screen,
 * and can be swiped horizontally. (In dojo-1.6, it was called 'FlippableView'.)
 * SwapView is a subclass of dojox.mobile.View. SwapView allows the user to
 * swipe the screen left or right to move between the views. When SwapView is
 * swiped, it finds an adjacent SwapView to open it.
 */
@Container(dojoType = "dojox.mobile.SwapView", renderPosition = RenderPosition.EN_CODE_BEGIN)
class SwapView extends View {
}
