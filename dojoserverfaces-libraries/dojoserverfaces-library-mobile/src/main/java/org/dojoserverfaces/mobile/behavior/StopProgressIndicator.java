/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.behavior;

import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Behavior;
import org.dojoserverfaces.component.behavior.BehaviorBase;

/**
 * This behavior will allow you to show a ProgressIndicator.
 */
@Behavior
public class StopProgressIndicator extends BehaviorBase {
    public StopProgressIndicator() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        return new StringBuilder(
                "dojox.mobile.ProgressIndicator.getInstance().stop();")
                .toString();
    }
}