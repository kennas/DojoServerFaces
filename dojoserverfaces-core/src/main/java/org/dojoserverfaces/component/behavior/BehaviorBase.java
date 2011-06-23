/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.behavior;

import javax.faces.application.ProjectStage;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehaviorBase;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.context.FacesContext;
import javax.faces.render.ClientBehaviorRenderer;

import org.dojoserverfaces.widget.DojoWidget;

public abstract class BehaviorBase extends ClientBehaviorBase {

    protected static final String PARAM_THIS = "@this";
    protected static final String PARAM_FORM = "@form";
    protected static final String PARAM_ALL = "@all";
    protected static final String PARAM_NONE = "@none";
    protected static final String PARAM_EVENT = "@event";

    /**
     * This is the variable name of the javascript event object in the callback
     * handler
     */
    protected static final String ARGUMENT_EVENT = "event";

    public BehaviorBase() {
        super();
    }

    @Override
    protected ClientBehaviorRenderer getRenderer(FacesContext context) {
        // TODO Auto-generated method stub
        return super.getRenderer(context);
    }

    @Override
    public String getRendererType() {
        // TODO Auto-generated method stub
        return super.getRendererType();
    }

    @Override
    public boolean isTransient() {
        // TODO Auto-generated method stub
        return super.isTransient();
    }

    @Override
    public void restoreState(FacesContext context, Object state) {
        // TODO Auto-generated method stub
        super.restoreState(context, state);
    }

    @Override
    public Object saveState(FacesContext context) {
        // TODO Auto-generated method stub
        return super.saveState(context);
    }

    @Override
    public void setTransient(boolean transientFlag) {
        // TODO Auto-generated method stub
        super.setTransient(transientFlag);
    }

    protected UIComponent findComponent(ClientBehaviorContext behaviorContext,
            String id) {
        if (PARAM_THIS.equals(id)) {
            return behaviorContext.getComponent();
        }
        else {
            if (id.startsWith("@")) {
                id = id.substring(1);
            }
            return behaviorContext.getComponent().findComponent(id);
        }
    }

    /**
     * @param script
     *            buffer to which to append addition script
     * @param component
     * @return the script (StringBuilder)
     */
    protected StringBuilder appendGetDijit(StringBuilder script, String id) {
        script.append("dijit.byId('").append(id).append("')");
        return script;
    }

    /**
     * @param script
     *            buffer to which to append addition script
     * @param component
     * @return the script (StringBuilder)
     */
    protected StringBuilder appendGetElement(StringBuilder script, String id) {
        script.append("dojo.byId('").append(id).append("')");
        return script;
    }

    /**
     * @param script
     *            buffer to which to append addition script
     * @param component
     * @return the script (StringBuilder)
     */
    protected StringBuilder appendGetElement(StringBuilder script,
            UIComponent component) {
        if (component instanceof DojoWidget) {
            appendGetDijit(script, component.getClientId());
        }
        else {
            appendGetElement(script, component.getClientId());
        }
        return script;
    }

    /**
     * @param script
     *            script string to be added on
     * @param id
     *            element id
     * @param attrName
     *            name of attribute to set
     * @param value
     *            setting for string values should be quoted
     * @return the script (StringBuilder)
     */
    protected StringBuilder appendSetElementAttr(StringBuilder script,
            String id, String attrName, String value) {
        script.append("dojo.attr('").append(id).append("','").append(attrName)
                .append("',").append(value).append(")");
        return script;
    }

    /**
     * @param script
     *            script string to be added on
     * @param id
     *            element id
     * @param attrName
     *            name of attribute to set
     * @param value
     *            setting for string values should be quoted
     * @return the script (StringBuilder)
     */
    protected StringBuilder appendSetDijitAttr(StringBuilder script, String id,
            String attrName, String value) {
        script.append("dijit.byId('").append(id).append("').set('")
                .append(attrName).append("',").append(value).append(')');
        return script;
    }

    /**
     * @param script
     *            script string to be added on
     * @param component
     * @param attrName
     *            name of attribute to set
     * @param value
     *            setting for string values should be quoted
     * @return the script (StringBuilder)
     */
    protected StringBuilder appendSetElementAttr(StringBuilder script,
            UIComponent component, String attrName, String value) {
        if (component instanceof DojoWidget) {
            appendSetDijitAttr(script, component.getClientId(), attrName, value);
        }
        else {
            appendSetElementAttr(script, component.getClientId(), attrName,
                    value);
        }
        return script;
    }

    /**
     * @param script
     *            script string to be added on
     * @param id
     *            element id
     * @param attrName
     *            name of attribute to set
     * @param value
     *            setting for string values should be quoted
     * @return the script (StringBuilder)
     */
    protected StringBuilder appendGetElementAttr(StringBuilder script,
            String id, String attrName) {
        script.append("dojo.attr('").append(id).append("','").append(attrName)
                .append("')");
        return script;
    }

    /**
     * @param script
     *            script string to be added on
     * @param id
     *            element id
     * @param attrName
     *            name of attribute to set
     * @param value
     *            setting for string values should be quoted
     * @return the script (StringBuilder)
     */
    protected StringBuilder appendGetDijitAttr(StringBuilder script, String id,
            String attrName) {
        script.append("dijit.byId('").append(id).append("').get('")
                .append(attrName).append("')");
        return script;
    }

    /**
     * @param script
     *            script string to be added on
     * @param component
     * @param attrName
     *            name of attribute to set
     * @param value
     *            setting for string values should be quoted
     * @return the script (StringBuilder)
     */
    protected StringBuilder appendGetElementAttr(StringBuilder script,
            UIComponent component, String attrName) {
        if (component instanceof DojoWidget) {
            appendGetDijitAttr(script, component.getClientId(), attrName);
        }
        else {
            appendGetElementAttr(script, component.getClientId(), attrName);
        }
        return script;
    }

    /**
     * Log a message if the project stage is Development
     * 
     * @param msg
     */
    protected void log(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.isProjectStage(ProjectStage.Development)) {
            context.getExternalContext()
                    .log(getClass().getName() + " - " + msg);
        }
    }

   /**
     * Get rendered clientid through component id
     * 
     * @param id
     * @param behaviorContext
     * @return
     */
    protected String getRenderedClientIdById(String id,
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
                return "";
            }
        }
        else {
            log("The input id is null");
            return null;
        }

    }

    /**
     * Log a component not found message
     * 
     * @param id
     */
    protected void logComponentNotFound(String id) {
        log("valid component not found with id " + id);
    }
}
