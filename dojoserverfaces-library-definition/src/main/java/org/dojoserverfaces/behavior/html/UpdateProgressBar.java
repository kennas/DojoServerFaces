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
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.DojoWidget;

/**
 * This behavior will allow you to set the progressBar's indeterminate,progress
 * and maximum properties.
 * 
 */
@Behavior
public class UpdateProgressBar extends BehaviorBase {
    private String target;
    private Boolean indeterminate;
    private String progress;
    private Integer maximum;

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        String clientId = getClientId(this.getTarget(),
                behaviorContext);
        if (clientId == null || "".equals(clientId)) {
            return script.toString();
        }
        appendGetDijit(script, clientId);
        boolean addComa = false;
        script.append(".update({");
        if (this.getIndeterminate() != null) {
            script.append("indeterminate:").append(this.getIndeterminate());
            addComa = true;
        }
        if (this.getProgress() != null) {
            if (addComa) {
                script.append(",");
            }
            if (PARAM_EVENT.equals(this.getProgress())) {
                script.append("progress:").append("event.value*100+'%'");
            }
            else {
                if (this.getMaximum() != null) {
                    script.append("progress:").append(
                            Helper.quote(this.getProgress()));
                }
                else {
                    script.append("progress:").append(
                            Helper.quote(Float.valueOf(this.getProgress())
                                    * 100 + "%"));
                }

            }
            addComa = true;
        }
        if (this.getMaximum() != null) {
            if (addComa) {
                script.append(",");
            }
            if (PARAM_EVENT.equals(this.getProgress())) {
                script.append("maximum:1");
            }
            else {
                script.append("maximum:").append(this.getMaximum());
            }

            addComa = true;
        }
        script.append("});");
        return script.toString();
    }

    /**
     * component id to act on.
     */
    @Attribute(required = true)
    public String getTarget() {
        return target;
    }

    /**
     * new indeterminate value
     */
    @Attribute
    public Boolean getIndeterminate() {
        return indeterminate;
    }

    public void setIndeterminate(Boolean indeterminate) {
        this.indeterminate = indeterminate;
    }

    /**
     * new progress value it should between 0 and 1 if you do not set maximum
     * value otherwise it can be a Integer value
     */
    @Attribute
    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    /**
     * new maximum value
     */
    @Attribute
    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public void setTarget(String target) {
        this.target = target;
    }
    /**
     * Get rendered client id through component id
     * 
     * @param id
     * @param behaviorContext
     * @return
     */
    private String getClientId(String id,
            ClientBehaviorContext behaviorContext) {
        if (null != id) {
            UIComponent targetComp = behaviorContext.getComponent()
                    .findComponent(id);
            if (null != targetComp && targetComp instanceof DojoWidget) {
                return targetComp.getClientId();
            }
            else {
                log("It is not a widget or valid component not found with id"
                        + id);
                return id;
            }
        }
        else {
            log("The input id is null");
            return null;
        }

    }
}
