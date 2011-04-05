/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Behavior;
import org.dojoserverfaces.component.behavior.BehaviorBase;
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.DojoWidget;

/**
 * This behavior will allow you to fade in an element
 */
@Behavior
public class FadeIn extends BehaviorBase {

    public FadeIn() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        if (null != target && duration != null) {
            String[] tokens = (null != target) ? target.split("\\s") : null;
            for (String token : tokens) {
                String targetId = token;
                UIComponent target = behaviorContext.getComponent()
                        .findComponent(token);

                script.append("dojo.fadeIn({node:");

                // if target could not be found, assume it is a plain DOM
                // node
                if (target == null) {
                    logComponentNotFound(targetId);
                    script.append(Helper.quote(targetId));
                } else {
                    targetId = Helper.quote(target.getClientId());
                    if (target instanceof DojoWidget) {
                        script.append("dijit.byId(").append(targetId)
                                .append(").domNode");
                    } else {
                        script.append(targetId);
                    }
                }

                if (duration != null) {
                    script.append(",duration:").append(duration);
                }

                if (!Helper.isEmpty(broadcastOnEnd)) {
                    script.append(",onEnd:function(){dojo.publish(")
                            .append(Helper.quote(broadcastOnEnd)).append(");}");
                }
                script.append("}).play();");
            }
        }
        return script.toString();
    }

    private String target;

    private Integer duration;

    private String broadcastOnEnd;

    /**
     * component id or DOM element id of element
     */
    @Attribute
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * duration of fadeIn
     */
    @Attribute
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * broadcast a topic after faded in.
     */
    @Attribute
    public String getBroadcastOnEnd() {
        return broadcastOnEnd;
    }

    public void setBroadcastOnEnd(String broadcastOnEnd) {
        this.broadcastOnEnd = broadcastOnEnd;
    }
}