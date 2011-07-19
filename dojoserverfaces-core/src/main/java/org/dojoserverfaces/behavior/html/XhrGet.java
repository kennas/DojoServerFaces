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

/**
 * 
 * This behavior will allow you to use ajax to get the result of the given url
 * and it will broadcast topics on different conditions with the result data.e.g
 * if it get no data from sever it will publish BroadcastOnComplete topic
 * 
 */
@Behavior
public class XhrGet extends BehaviorBase {
    private String broadcastOnComplete;
    private String broadcastOnRecieve;
    private String broadcastOnError;
    private String url;

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        script.append("dojo.xhrGet({url:'").append(this.getUrl())
                .append("',handleAs:'text',load:function(data){")
                .append("if(data==''){dojo.publish('")
                .append(this.getBroadcastOnComplete())
                .append("');}else{dojo.publish('")
                .append(this.getBroadcastOnRecieve()).append("',[data]);}}");
        if (this.getBroadcastOnError() != null) {
            script.append(",error:function(error) {dojo.publish('")
                    .append(this.getBroadcastOnError()).append("');}");
        }
        script.append("});");
        return script.toString();
    }

    /**
     * This is the published event name when completing
     */
    @Attribute(required = true)
    public String getBroadcastOnComplete() {
        return broadcastOnComplete;
    }

    public void setBroadcastOnComplete(String broadcastOnComplete) {
        this.broadcastOnComplete = broadcastOnComplete;
    }

    /**
     * This is the published event name when getting data
     * 
     */
    @Attribute(required = true)
    public String getBroadcastOnRecieve() {
        return broadcastOnRecieve;
    }

    public void setBroadcastOnRecieve(String broadcastOnRecieve) {
        this.broadcastOnRecieve = broadcastOnRecieve;
    }

    /**
     * Request url. where will get result
     * 
     */
    @Attribute(required = true)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This is the published event name when error occurred
     */
    @Attribute
    public String getBroadcastOnError() {
        return broadcastOnError;
    }

    public void setBroadcastOnError(String broadcastOnError) {
        this.broadcastOnError = broadcastOnError;
    }

}
