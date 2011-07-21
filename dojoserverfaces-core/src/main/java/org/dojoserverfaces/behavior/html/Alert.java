/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html;

import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Behavior;
import org.dojoserverfaces.component.behavior.BehaviorBase;
import org.dojoserverfaces.util.Helper;

/**
 * This behavior will allow you to use the browser alert dialog.
 */
@Behavior
public class Alert extends BehaviorBase {

    public Alert() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        if (null != message) {
            script.append("alert(").append(Helper.makeStringVar(message))
                    .append(");");
        }
        else {
            log("message is required");
        }
        return script.toString();
    }

    private String message;

    /**
     * Message text.
     */
    @Attribute(required = true)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}