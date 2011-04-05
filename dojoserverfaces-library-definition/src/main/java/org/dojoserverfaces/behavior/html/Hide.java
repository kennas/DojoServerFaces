/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html;

import org.dojoserverfaces.build.annotation.Behavior;

/**
 * This behavior will allow you the hide a particular component. The component
 * must support the client side hide operation.
 */
@Behavior
public class Hide extends SimpleMethodBase {

    public Hide() {
        super("hide");
    }

}