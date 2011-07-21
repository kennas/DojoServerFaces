/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html.grid;


import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.component.behavior.BehaviorBase;
import org.dojoserverfaces.widget.DojoWidget;

/**
 * Grid related class base class it provides target attribute which points to a
 * grid id
 * 
 */
abstract class GridBehaviorBase extends BehaviorBase {
    protected GridBehaviorBase() {
        super();
    }

    private String target;

    /**
     * Id of a datagrid component to act on
     * 
     * 
     */
    @Attribute(required = true)
    public String getTarget() {
        return target;
    }

    /**
     * Setter for id of a datagrid component to act on
     * 
     * 
     */
    public void setTarget(String targetvalue) {
        this.target = targetvalue;
    }

    /**
     * Get rendered client id through component id
     * 
     * @param id
     * @param behaviorContext
     * @return
     */
    protected String getClientId(String id,
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
