/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html;

import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Behavior;
import org.dojoserverfaces.component.behavior.BehaviorBase;

/**
 * This behavior will allow you the "Submit" a form.
 */
@Behavior
public class Submit extends BehaviorBase {

    public Submit() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();

        UIComponent form = null;
        if (target != null && target.length() > 0) {
            form = behaviorContext.getComponent().findComponent(target);
        } else {
            form = behaviorContext.getComponent();
            while (form != null && !(form instanceof UIForm)) {
                form = form.getParent();
            }
        }

        if (form != null) {
            appendGetElement(script, form).append(".submit();");
        } else {
            log("DojoServerFaces: submit behavior needs form.");
        }

        return script.toString();
    }

    private String target = null;

    /**
     * Id of form component to "submit". If not defined then the parent form of
     * the component will be used.
     */
    @Attribute
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

}