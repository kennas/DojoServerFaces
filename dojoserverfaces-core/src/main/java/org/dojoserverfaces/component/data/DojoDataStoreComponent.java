/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.data;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

import org.dojoserverfaces.component.dojo.DojoScriptBlockComponent;
import org.dojoserverfaces.util.Helper;

/**
 * Base class for data store components.
 */

public class DojoDataStoreComponent extends UIPanel {
    private HashMap<String, Object> constructorMap;
    private String dojoType;

    /**
     * Creates a DojoDataStoreComponent object.
     * 
     * @param dojoType
     *            a String containing the Dojo data store type that used when
     *            rendering this data store component.
     */

    protected DojoDataStoreComponent(String dojoType) {
        this.constructorMap = new HashMap<String, Object>();
        this.dojoType = dojoType;
    }

    /**
     * Retrieves a constructor argument from this data store component.
     * 
     * @param name
     *            a String containing the name of the argument to use.
     * @return an Object containing the constructor argument with the given
     *         name, or null if no constructor argument with the given name
     *         exists.
     */

    protected Object getConstructorArgument(String name) {
        return this.constructorMap.get(name);
    }

    /*
     * @see
     * javax.faces.component.UIComponentBase#getRenderer(javax.faces.context
     * .FacesContext)
     */

    @Override
    protected Renderer getRenderer(FacesContext context) {
        return null;
    }

    /**
     * Adds a constructor argument to this data store component.
     * 
     * @param name
     *            a String containing the name to use.
     * @param value
     *            an Object containing the value to use.
     */

    protected void addConstructorArgument(String name, Object value) {
        this.constructorMap.put(name, value);
    }

    /*
     * @see javax.faces.component.UIComponentBase#encodeEnd(javax.faces.context.
     * FacesContext)
     */

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        Iterator<String> names;
        StringBuilder onLoadFunction = new StringBuilder();
        DojoScriptBlockComponent scriptBlock = DojoScriptBlockComponent
                .findInitBlockComponent(context.getViewRoot());

        // Build up the onload function used to create the Dojo data store.

        onLoadFunction.append(getId());
        onLoadFunction.append(" = new ");
        onLoadFunction.append(this.dojoType);
        onLoadFunction.append("({");

        names = this.constructorMap.keySet().iterator();

        while (names.hasNext()) {
            String name = names.next();

            onLoadFunction.append(name);
            onLoadFunction.append(':');

            if (shouldEscapeArgument(name)) {
                onLoadFunction.append(Helper.makeStringVar(this.constructorMap
                        .get(name).toString()));
            }

            else {
                onLoadFunction.append(this.constructorMap.get(name).toString());
            }

            if (names.hasNext()) {
                onLoadFunction.append(',');
            }
        }

        onLoadFunction.append("});");

        // Need to add a requires statement first.

        scriptBlock.addRequires(this.dojoType);

        scriptBlock.addWidgetCreateScript(onLoadFunction.toString());
    }

    /**
     * Determines whether or not a constructor argument should be escaped as if
     * it were a string value.
     * 
     * @param name
     *            a String containing the name of the constructor argument to
     *            check.
     * @return a boolean containing true if the constructor argument with the
     *         given name should be escaped, false otherwise.
     */

    protected boolean shouldEscapeArgument(String name) {
        return true;
    }
}
