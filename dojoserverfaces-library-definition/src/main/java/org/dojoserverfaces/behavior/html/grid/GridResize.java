/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html.grid;

import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;

/**
 * 
 * This behavior will allow you to resize a datagrid, changing its height and
 * width.
 * 
 */

public class GridResize extends GridBehaviorBase {
    public GridResize() {
        super();
    }

    /**
     * 
     * @see javax.faces.component.behavior.ClientBehaviorBase#getScript(javax.faces.component.behavior.ClientBehaviorContext)
     */
    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        appendSetDijitAttr(script, getClientId(getTarget(), behaviorContext),
                "autoHeight", "false");
        script.append(";");
        appendSetDijitAttr(script, getClientId(getTarget(), behaviorContext),
                "autoWidth", "false");
        script.append(";");
        script.append("dojo.contentBox(");
        appendGetDijit(script, getClientId(getTarget(), behaviorContext));
        script.append(".domNode,{w:");
        script.append(width);
        script.append(",h:").append(height).append("});");
        appendGetDijit(script, getClientId(getTarget(), behaviorContext));
        script.append(".update();");
        return script.toString();
    }

    private String width;
    private String height;

    /**
     * New width for the datagrid.
     */
    @Attribute(required = true)
    public String getWidth() {
        return width;
    }

    /**
     * Setter for Width.
     * 
     * 
     */
    public void setWidth(String widthValue) {
        this.width = widthValue;
    }

    /**
     * New height for the datagrid.
     * 
     * 
     */
    @Attribute(required = true)
    public String getHeight() {
        return height;
    }

    /**
     * Setter for height of a datagrid.
     * 
     * 
     */
    public void setHeight(String heightValue) {
        this.height = heightValue;
    }

}
