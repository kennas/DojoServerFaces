/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html;

import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Behavior;
import org.dojoserverfaces.util.Helper;

/**
 * This behavior will allow you to use the browser confirm dialog.
 */
@Behavior
public class Confirm extends Alert {
    public Confirm() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        if (null != getMessage()) {
            if (!stop && isEmpty(broadcastOk) && isEmpty(broadcastCancel)) {
                script.append("return confirm(")
                        .append(Helper.makeStringVar(getMessage()))
                        .append(");");
            }
            else {
                if (isEmpty(broadcastOk)) {
                    script.append("if(!confirm(")
                            .append(Helper.makeStringVar(getMessage()))
                            .append(")){");
                }
                else {
                    script.append("if(confirm(")
                            .append(Helper.makeStringVar(getMessage()))
                            .append(")){dojo.publish(")
                            .append(Helper.quote(broadcastOk)).append(");}");
                    if (stop || !isEmpty(broadcastCancel)) {
                        script.append("else{");
                    }
                }

                if (stop) {
                    script.append("dojo.stopEvent(").append(ARGUMENT_EVENT)
                            .append(");");
                }

                if (!isEmpty(broadcastCancel)) {
                    script.append("dojo.publish(")
                            .append(Helper.quote(broadcastCancel)).append(");");
                }

                if (stop || !isEmpty(broadcastCancel)) {
                    script.append("}");
                }
            }
        }
        else {
            log("message is required");
        }
        return script.toString();
    }

    private static boolean isEmpty(String s) {
        return (s == null || s.isEmpty());
    }

    private Boolean stop = true;

    private String broadcastOk;

    private String broadcastCancel;

    /**
     * Indicates to stop the event from bubbling up when "Cancel" is selected. The
     * default is <code>true</code>.
     */
    @Attribute
    public Boolean getStop() {
        return stop;
    }

    public void setStop(Boolean stop) {
        this.stop = stop;
    }

    /**
     * Topic text to broadcast when "OK" is selected. If null no broadcast
     * will occur
     */
    @Attribute
    public String getBroadcastOk() {
        return broadcastOk;
    }

    public void setBroadcastOk(String broadcastOk) {
        this.broadcastOk = broadcastOk;
    }

    /**
     * Topic text to broadcast when "Cancel=" is selected. If null no
     * broadcast will occur
     */
    @Attribute
    public String getBroadcastCancel() {
        return broadcastCancel;
    }

    public void setBroadcastCancel(String broadcastCancel) {
        this.broadcastCancel = broadcastCancel;
    }
}