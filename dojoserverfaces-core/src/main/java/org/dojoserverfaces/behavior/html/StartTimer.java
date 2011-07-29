/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html;

import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Behavior;
import org.dojoserverfaces.component.behavior.BehaviorBase;
import org.dojoserverfaces.util.Helper;

/**
 * 
 * This behavior will allow you to publish a dojo event in a delaying time
 * 
 */
@Behavior
public class StartTimer extends BehaviorBase {
    private Integer time;

    public StartTimer() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        if (null != this.getBroadcastOnAlarm()) {
            script.append("setTimeout(function(){dojo.publish(")
                    .append(Helper.quote(this.getBroadcastOnAlarm()))
                    .append(");},");
            script.append(this.getTime()).append(");");
        }
        return script.toString();
    }

    /**
     * 
     * The milliseconds delayed to publish topic
     */
    @Attribute(required = true)
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    private String broadcastOnAlarm;

    /**
     * This is the published event name
     */
    @Attribute(required = true)
    public String getBroadcastOnAlarm() {
        return broadcastOnAlarm;
    }

    public void setBroadcastOnAlarm(String broadcastOnAlarm) {
        this.broadcastOnAlarm = broadcastOnAlarm;
    }

}
