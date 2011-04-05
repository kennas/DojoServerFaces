/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 * An interface to apply to a class that is to handle a POST from the client.
 * For example a ValueHolder for Form component would need to handle a postback.
 */
public interface PostBackHandler {
    /**
     * Method to handle the postback in order to retrieve the submitted value
     * for this component. This method needs to update the component.
     * 
     * @param context
     *            current context of the postback
     * @param component
     *            the component being processed
     */
    public void retrievePostBackValue(FacesContext context,
            UIComponent component);

    /**
     * @param context
     *            current context of the postback
     * @param component
     *            the component being processed containing a submitted value
     * @param value
     *            the submitted value to be convered to the appropriate object
     * @return
     */
    public Object convertPostBackValue(FacesContext context,
            UIComponent component, Object value);
}
