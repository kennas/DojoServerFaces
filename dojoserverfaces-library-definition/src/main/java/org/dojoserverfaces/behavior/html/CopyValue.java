/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
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
 * This behavior will allow you to copy a value from a source, then set it to a
 * component
 */
@Behavior
public class CopyValue extends BehaviorBase {

    private static final String VALUE_ATTR = "value";
    
    public CopyValue() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        if (null != source && null != destination) {
            UIComponent destComp = behaviorContext.getComponent()
                    .findComponent(destination);
            if (destComp == null) {
                logComponentNotFound(destination);
                return script.toString();
            }

            // TODO: should we check that destComp is a EditableValueHolder
            // firstly?

            StringBuilder value = null;
            if (PARAM_EVENT.equals(source)) {
                value = new StringBuilder("event.value");
            } else {
                UIComponent sourceComp = behaviorContext.getComponent();
                if (!PARAM_THIS.equals(source)) {
                    sourceComp = sourceComp.findComponent(source);
                }
               if (sourceComp != null) {
                    String sourceId = Helper.quote(sourceComp.getClientId());
                    value = new StringBuilder();
                    if (sourceComp instanceof DojoWidget) {
                        // TODO: get value from DojoWidget
                        value.append("dijit.byId(").append(sourceId)
                                .append(").get(").append(Helper.quote(VALUE_ATTR))
                                .append(")");
                    } else {
                        // TODO: should we check if it is a ValueHolder?
                        value.append("dojo.attr(")
                                .append(sourceId).append(",")
                                .append(Helper.quote(VALUE_ATTR)).append(")");
                    }
                }
            }
            appendSetElementAttr(script, destComp, VALUE_ATTR, value.toString());
            script.append(";");
        }
        return script.toString();
    }

    private String source = "@this";

    private String destination;

    /**
     * a source could be "@this", "@event", or a component id
     */
    @Attribute
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    /**
     * component id
     */
    @Attribute(required = true)
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}