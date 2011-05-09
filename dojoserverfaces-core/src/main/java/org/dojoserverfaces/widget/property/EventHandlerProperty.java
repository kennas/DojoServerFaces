/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.ActionSource2;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;

import org.dojoserverfaces.component.behavior.BehaviorBase;
import org.dojoserverfaces.widget.DojoWidget;

public class EventHandlerProperty extends Property {

    private String behaviorName = null;

    public String getBehaviorName() {
        return behaviorName;
    }

    public EventHandlerProperty(String propertyName, String behaviorName) {
        super(propertyName);
        this.behaviorName = behaviorName;
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        String value = (String) getAttributeValue(component);
        if (component instanceof ClientBehaviorHolder) {
            ClientBehaviorHolder behaviorHolder = (ClientBehaviorHolder) component;
            return buildFunction(value, behaviorHolder.getClientBehaviors()
                    .get(behaviorName),
                    ClientBehaviorContext.createClientBehaviorContext(
                            FacesContext.getCurrentInstance(), component,
                            behaviorName, null, null));
        }
        else if (null != value) {
            return buildFunction(value, null, null);
        }
        return null;
    }

    /**
     * @param script
     * @return the script with any single quote character escaped
     */
    protected static String quoteScript(String script) {
        /*
         * Since we are setting this as a js string we do not need to worry
         * about converting special chars to their html escaped equivalent (e.g.
         * &quote; ). Do we?
         */
        StringBuilder sb = new StringBuilder("'");
        sb.append(script.replace("'", "\\'")).append('\'');
        return sb.toString();
    }

    /**
     * @param script
     * @param eventBehaviors
     * @param behaviorContext
     * @return A javascript function definition for the specified event that
     *         combines the given eventScript and any "behavior" script attached
     *         to the event.
     */
    protected static String buildFunction(String eventScript,
            List<ClientBehavior> eventBehaviors,
            ClientBehaviorContext behaviorContext) {
        // how should behavior listeners be used
        // how should behavior hints be used? e.g. if SUBMIT then should it be
        // first/last?

        // treat empty script as null
        if ((null != eventScript) && eventScript.isEmpty()) {
            eventScript = null;
        }
        // Iterate over all the client behaviors to build a list of scripts
        ArrayList<String> behaviorScripts = null;
        if (null != eventBehaviors && !eventBehaviors.isEmpty()) {
            behaviorScripts = new ArrayList<String>(eventBehaviors.size());
            for (ClientBehavior behavior : eventBehaviors) {
                // ask the behavior for its script
                String script = behavior.getScript(behaviorContext);
                // if the behavior was "disabled" no script will be returned
                if (null != script) {
                    if (!(behavior instanceof BehaviorBase)) {
                        // behaviors we do not know about must be expecting the
                        // this object to be the dom element
                        UIComponent comp = behaviorContext.getComponent();
                        if (comp instanceof DojoWidget) {
                            if (comp instanceof ActionSource2) {
                                script = script.replaceAll("this",
                                        "dojo.byId(\"" + comp.getClientId()
                                                + "\")");
                            }
                            else {
                                String jsfNode = ((DojoWidget) comp)
                                        .getJsfNode();
                                if (jsfNode != null && jsfNode.length() > 0) {
                                    script = script.replaceAll("this", "this."
                                            + jsfNode);
                                }
                            }
                        }
                    }
                    behaviorScripts.add(script);
                }
            }
        }

        StringBuilder functionDeclaration = new StringBuilder(
                "function(event){");

        if ((null != eventScript && (null != behaviorScripts && !behaviorScripts
                .isEmpty()))
                || (null != behaviorScripts && behaviorScripts.size() > 1)) {
            /*
             * There are multiple behaviors attached to this event. Use the
             * dojo.every to chain the behavior scripts. Special care is taken
             * to pass along the "this" object to the scripts. Any script
             * returning false will stop the execution of the remaining scripts.
             */
            functionDeclaration.append("var o=this;dojo.every([");
            boolean needComma = false;
            if (null != eventScript) {
                functionDeclaration.append("function(event){")
                        .append(eventScript).append("}");
                needComma = true;
            }
            for (String script : behaviorScripts) {
                if (needComma) {
                    functionDeclaration.append(',');
                }
                else {
                    needComma = true;
                }
                functionDeclaration.append("function(event){").append(script)
                        .append("}");
            }
            functionDeclaration
                    .append("],function(f,i){return (f.call(o, event) !== false);});");
        }
        else if (null != eventScript) {
            // we just have the script on the component
            functionDeclaration.append(eventScript);
        }
        else if (null != behaviorScripts && !behaviorScripts.isEmpty()) {
            // we just have one behavior attached
            functionDeclaration.append(behaviorScripts.get(0));
        }
        else {
            // turns out there are no scripts to be added
            return null;
        }
        functionDeclaration.append('}');
        return functionDeclaration.toString();
    }
}
