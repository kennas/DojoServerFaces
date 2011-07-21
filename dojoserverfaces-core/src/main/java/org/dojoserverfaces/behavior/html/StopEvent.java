/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html;

import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Behavior;
import org.dojoserverfaces.component.behavior.BehaviorBase;

/**
 * This behavior will allow you to stop the continued default processing of an
 * event.
 * 
 * NOTE: This is not an immediate stop. If this behavior is among other
 * behaviors it does not affect those behaviors (regardless of position, first,
 * last middle)
 */
@Behavior
public class StopEvent extends BehaviorBase {
    public StopEvent() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        script.append("dojo.stopEvent(").append(ARGUMENT_EVENT).append(");");
        return script.toString();
    }
}