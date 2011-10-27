/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.behavior;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Behavior;
import org.dojoserverfaces.component.behavior.BehaviorBase;

/**
 * Show method of mobile opener.
 * 
 */
@Behavior
public class Open extends BehaviorBase {
    private String target;
    private String position;

    /**
     * Id of target component to act on
     */
    @Attribute(required = true)
    public String getTarget() {
        return target;
    }

    /**
     * Position of the target.Its value can be only left,right,above,below.
     */
    @Attribute(required = true)
    public String getPosition() {
        return position;
    }

    public void setPosition(String pos) {
        this.position = pos;
    }

    public void setTarget(String targetvalue) {
        this.target = targetvalue;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.faces.component.behavior.ClientBehaviorBase#getScript(javax.faces
     * .component.behavior.ClientBehaviorContext)
     */
    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        if (null != target) {
            UIComponent targetComp = behaviorContext.getComponent()
                    .findComponent(target);
            if (null != targetComp) {
                appendGetDijit(script, targetComp.getClientId());
                script.append(".show(this.domNode,");
                if ("above".equals(position)) {
                    script.append("['below','above-centered','after','before']");
                }
                else if ("below".equals(position)) {
                    script.append("['above','below-centered','before','after']");
                }
                else if ("right".equals(position)) {
                    script.append("['before','after','below-centered','above-centered']");
                }
                else if ("left".equals(position)) {
                    script.append("['after','before','above','below']");
                }
                else {
                    // wrong value
                    return "";
                }
                script.append(");");
            }
        }
        return script.toString();
    }
}
