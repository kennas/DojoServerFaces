/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html;

import org.dojoserverfaces.build.annotation.Behavior;

/**
 * This behavior will allow you to make an element gain focus.
 */
@Behavior
public class Focus extends SimpleMethodBase {

    public Focus() {
        super("focus", true);
    }
}