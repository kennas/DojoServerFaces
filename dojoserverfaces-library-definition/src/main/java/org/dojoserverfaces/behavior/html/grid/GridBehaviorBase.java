/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html.grid;


import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.component.behavior.BehaviorBase;

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

  
}
