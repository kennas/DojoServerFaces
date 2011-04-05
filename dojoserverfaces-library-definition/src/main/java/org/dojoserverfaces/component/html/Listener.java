/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.ProjectStage;
import javax.faces.component.UIComponentBase;
import javax.faces.component.UIViewRoot;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ComponentSystemEventListener;
import javax.faces.event.PostAddToViewEvent;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Component;
import org.dojoserverfaces.component.dojo.DojoScriptBlockComponent;
import org.dojoserverfaces.util.Helper;

/**
 * This component subscribes specified topics then executes related behaviors.
 */
@Component
public class Listener extends UIComponentBase implements ClientBehaviorHolder,
        ComponentSystemEventListener {
    private static final String DEFAULT_EVENT_NAME = "onRecieved";
    private static final String JS_ARG_NAME_VALUE = "value";
    private static final String JSF_DOJO_COMPONENT_FAMILY = "jsfdojo.component";
    private static final String HEAD = "head";

    private static Collection<String> eventNames = new LinkedList<String>();
    static {
        eventNames.add(DEFAULT_EVENT_NAME);
    }

    /**
     * Creates a component.
     */
    public Listener() {
        setTransient(true);
        getFacesContext().getViewRoot().subscribeToEvent(
                PostAddToViewEvent.class, this);
    }

    @Override
    public void processEvent(ComponentSystemEvent event)
            throws AbortProcessingException {
        UIViewRoot viewRoot = getFacesContext().getViewRoot();
        /*
         * Move the listener to the head. This takes it out of any parent
         * rendering sequence as it does not render any html markup. We'll also
         * assume the dojo lib and init script block are added by other
         * components that my broadcast.
         */
        viewRoot.addComponentResource(getFacesContext(), this, HEAD);
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        DojoScriptBlockComponent scriptBlock = DojoScriptBlockComponent
                .findInitBlockComponent(context.getViewRoot());

        String subscriptionScripts = getSubscriptionScripts(context);
        if (subscriptionScripts != null && subscriptionScripts.length() > 0) {
            scriptBlock.addPreWidgetCreateScript(subscriptionScripts);
        }
    }

    private String getSubscriptionScripts(FacesContext context) {
        ClientBehaviorContext behaviorContext = ClientBehaviorContext
                .createClientBehaviorContext(context, this,
                        getDefaultEventName(), null, null);

        String eventScript = (String) this.getAttributes().get(
                getDefaultEventName());
        String handlerScript = buildHandlerScript(eventScript, this
                .getClientBehaviors().get(getDefaultEventName()),
                behaviorContext);

        if (handlerScript == null || handlerScript.isEmpty()) {
            return null;
        }
        else {
            return new StringBuilder("dojo.subscribe(")
                    .append(Helper.quote(getTopic())).append(", ")
                    .append(handlerScript).append(");").toString();
        }
    }

    private String buildHandlerScript(String eventScript,
            Collection<ClientBehavior> behaviors, ClientBehaviorContext context) {
        List<String> behaviorScripts = Collections.<String> emptyList();
        if (behaviors != null && !behaviors.isEmpty()) {
            behaviorScripts = new ArrayList<String>();
            for (ClientBehavior behavior : behaviors) {
                String script = behavior.getScript(context);
                // if the behavior was "disabled" no script will be returned
                if (script != null) {
                    behaviorScripts.add(script);
                }
            }
        }

        int numOfBehaviors = (behaviorScripts.size() + (eventScript == null
                || eventScript.length() == 0 ? 0 : 1));

        if (numOfBehaviors == 0) {
            if (FacesContext.getCurrentInstance().isProjectStage(
                    ProjectStage.Development)) {
                FacesContext
                        .getCurrentInstance()
                        .getExternalContext()
                        .log(getClass().getName() + " - No behaviors attached.");
            }
            return null;
        }

        StringBuilder handler = new StringBuilder("function(")
                .append(JS_ARG_NAME_VALUE)
                .append("){var event={};event.value=")
                .append(JS_ARG_NAME_VALUE).append(";");

        if (numOfBehaviors <= 1) {
            // Only one behavior attached
            if (eventScript != null) {
                handler.append(eventScript);
            }
            else if (!behaviorScripts.isEmpty()) {
                // size of behaviorScripts must be 1
                handler.append(behaviorScripts.get(0));
            }
        }
        else {
            /*
             * There are multiple behaviors attached to this event. Use the
             * dojo.every to chain the behavior scripts. Special care is taken
             * to pass along the "this" object to the scripts. Any script
             * returning false will stop the execution of the remaining scripts.
             */
            handler.append("var o=this;dojo.every([");
            boolean needComma = false;
            if (eventScript != null) {
                handler.append("function(event){").append(eventScript)
                        .append("}");
                needComma = true;
            }

            for (String script : behaviorScripts) {
                if (needComma) {
                    handler.append(',');
                }
                else {
                    needComma = true;
                }
                handler.append("function(event){").append(script).append("}");
            }
            handler.append("],function(f,i){return (f.call(o, event) !== false);});");
        }

        handler.append("}");
        return handler.toString();
    }

    @Override
    public String getFamily() {
        return JSF_DOJO_COMPONENT_FAMILY;
    }

    @Override
    public String getDefaultEventName() {
        return DEFAULT_EVENT_NAME;
    }

    public Collection<String> getEventNames() {
        return eventNames;
    }

    /**
     * The topic to subscribe.
     */
    @Attribute
    public String getTopic() {
        return (String) getStateHelper().eval("topic");
    }

    /**
     * 
     * @param topic
     *            the topic to subscribe
     */
    public void setTopic(String topic) {
        getStateHelper().put("topic", topic);
    }
}
