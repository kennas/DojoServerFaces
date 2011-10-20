/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.behavior;

import javax.faces.component.UIViewRoot;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.context.FacesContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Behavior;
import org.dojoserverfaces.component.behavior.BehaviorBase;
import org.dojoserverfaces.component.dojo.DojoScriptBlockComponent;
import org.dojoserverfaces.component.dojo.DojoStyleComponent;

/**
 * This behavior will allow you to start a ProgressIndicator.
 */
@Behavior
public class StartProgressIndicator extends BehaviorBase {

    public StartProgressIndicator() {
        super();
        UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
        DojoStyleComponent.findStyleBlockComponent(view).addRequiredCss(
                "dojox/mobile/themes/{theme}/ProgressIndicator.css");
        if (DojoScriptBlockComponent.findInitBlockComponent(view) == null) {
            DojoScriptBlockComponent.addScriptBlockToView(view);
        }
        DojoScriptBlockComponent.findInitBlockComponent(view).addRequires(
                "dojox.mobile.ProgressIndicator");
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder(
                "var prog=dojox.mobile.ProgressIndicator.getInstance();");
        if (interval != null) {
            script.append("prog.interval=").append(interval).append(";");
        }
        if (colors != null && colors.length() > 0) {
            StringBuilder colorsArray = new StringBuilder();
            String[] splitedColors = colors.split("\\s");
            for (int i = 0; i < splitedColors.length; i++) {
                if (i > 0) {
                    colorsArray.append(",");
                }
                colorsArray.append("\"").append(splitedColors[i]).append("\"");
            }
            if (colorsArray.length() > 0) {
                script.append("prog.colors=[").append(colorsArray).append("];");
            }
        }
        if (imagePath != null) {
            // TODO: we need to invoke setImage() first to remove any existing
            // image first, otherwise the dojo will create many images, it's a
            // dojo's bug
            script.append("prog.setImage();").append("prog.setImage(\"")
                    .append(imagePath).append("\");");
        }
        if (null != target) {
            appendGetElement(script, target);
            if (behaviorContext.getComponent().findComponent(target) == null) {
                logComponentNotFound(target);
            }
        }
        else {
            script.append("dojo.body()");
        }
        script.append(".appendChild(prog.domNode);").append("prog.start();");
        return script.toString();
    }

    private String target;

    private Integer interval;

    private String colors;

    private String imagePath;

    /**
     * the time interval in milliseconds for updating the spinning indicator.
     */
    @Attribute
    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    /**
     * a path for an indicator icon image file
     */
    @Attribute
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

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
     * an array of indicator colors. e.g. "#C0C0C0 #B8B9B8 #AEAFAE #838383".
     */
    @Attribute
    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }
}