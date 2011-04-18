/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Behavior;
import org.dojoserverfaces.component.behavior.BehaviorBase;
import org.dojoserverfaces.component.dojo.DojoScriptBlockComponent;
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.DojoWidget;

/**
 * This behavior allows you to save the data of a DataStore and broadcast
 * different topic for different saving result
 * 
 */
@Behavior
public class StoreSave extends BehaviorBase {

    private String target;
    private String broadcastOnComplete;
    private String broadcastOnError;

    /**
     * Id of target DataStore component to act on
     */
    @Attribute(required = true)
    public String getTarget() {
        return target;
    }

    /**
     * Topic to broadcast when the save has error. This can used in conjunction
     * with the listener component.
     */
    @Attribute
    public String getBroadcastOnError() {
        return broadcastOnError;
    }

    public void setBroadcastOnError(String broadcastOnError) {
        this.broadcastOnError = broadcastOnError;
    }

    /**
     * Topic to broadcast when the save has completed successfully. This can
     * used in conjunction with the listener component.
     */
    @Attribute
    public String getBroadcastOnComplete() {
        return broadcastOnComplete;
    }

    public void setBroadcastOnComplete(String broadcastOnComplete) {
        this.broadcastOnComplete = broadcastOnComplete;
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
        boolean addComa = false;
        if (null != target) {
            UIComponent targetComp = behaviorContext.getComponent()
                    .findComponent(target);
            script.append(DojoScriptBlockComponent
                    .getGlobalReference((DojoWidget) targetComp));
            script.append(".save(");
            if (broadcastOnComplete != null) {
                script.append("{onComplete:function (){")
                        .append("dojo.publish(")
                        .append(Helper.quote(broadcastOnComplete))
                        .append(");}");
                addComa = true;
            }
            if (broadcastOnError != null) {
                if (addComa) {
                    script.append(",");
                }
                else {
                    script.append("{");
                }
                script.append("onError:function (){dojo.publish(")
                        .append(Helper.quote(broadcastOnError)).append(");}}");

            }
            else {
                if (addComa) {
                    script.append("}");
                }

            }
            script.append(");");
        }
        return script.toString();
    }
}
