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
    private String failedTopic;
    private String successTopic;

    /**
     * Id of target DataStore component to act on
     */
    @Attribute(required = true)
    public String getTarget() {
        return target;
    }

    /**
     * Topic of DataStore when saving data failed
     */
    @Attribute(required = true)
    public String getFailedTopic() {
        return failedTopic;
    }

    public void setFailedTopic(String failedTopic) {
        this.failedTopic = failedTopic;
    }

    /**
     * Topic of DataStore when saving data success
     */
    @Attribute(required = true)
    public String getSuccessTopic() {
        return successTopic;
    }

    public void setSuccessTopic(String successTopic) {
        this.successTopic = successTopic;
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
            script.append(DojoScriptBlockComponent
                    .getGlobalReference((DojoWidget) targetComp));
            script.append(".save({onComplete:function (){")
                    .append("dojo.publish(").append(Helper.quote(successTopic))
                    .append(");},onError:function (){").append("dojo.publish(")
                    .append(Helper.quote(failedTopic)).append(");}});");
        }
        return script.toString();
    }

}
