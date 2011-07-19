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
 * This behavior will allow you to publish a dojo event.
 */
@Behavior
public class Broadcast extends BehaviorBase {

    public Broadcast() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        if (null != topic) {
            // TODO: support additional params?
            script.append("dojo.publish(").append(Helper.quote(topic));
        }

        // TODO: just a test, consider to implement this.
        if (null != data) {
            if (PARAM_EVENT.equals(data)) {
                data = "event";
            }
            script.append(",[").append(data).append("]");
        }

        script.append(");");
        return script.toString();
    }

    private String topic;

    private String data;

    /**
     * this is the published event name
     */
    @Attribute
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * this is additional data published with the event
     */
    @Attribute
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}