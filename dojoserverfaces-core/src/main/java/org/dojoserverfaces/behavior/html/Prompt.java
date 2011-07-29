/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html;

import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Behavior;
import org.dojoserverfaces.util.Helper;

/**
 * This behavior will allow you to use a browser prompt dialog.
 */
@Behavior
public class Prompt extends Confirm {

    public Prompt() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        if (null != getMessage()
                && (!Helper.isEmpty(getBroadcastOk()) || !Helper
                        .isEmpty(getBroadcastCancel()))) {
            if (getStop()) {
                script.append("dojo.stopEvent(").append(ARGUMENT_EVENT)
                        .append(");");
            }

            script.append("(function(){").append("var _ret=prompt(")
                    .append(Helper.makeStringVar(getMessage())).append(");");

            if (!Helper.isEmpty(getBroadcastOk())) {
                script.append("if(_ret !== null){dojo.publish(")
                        .append(Helper.quote(getBroadcastOk()))
                        .append(",[_ret]);}");
                if (!Helper.isEmpty(getBroadcastCancel())) {
                    script.append("else{dojo.publish(")
                            .append(Helper.quote(getBroadcastCancel()))
                            .append(",[_ret]);}");
                }
            }
            else {
                script.append("if(_ret === null){dojo.publish(")
                        .append(Helper.quote(getBroadcastCancel()))
                        .append(",[_ret]);}");
            }
            script.append("})();");
        }
        else {
            log("message is required");
        }
        return script.toString();
    }
}