/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget;

import java.util.Collection;

import javax.faces.component.behavior.ClientBehaviorHolder;

import org.dojoserverfaces.widget.element.HtmlElement;
import org.dojoserverfaces.widget.property.Property;

public interface DojoWidget extends ClientBehaviorHolder {
    /**
     * @return the HtmlElement class used to render the html element to which
     *         the dojo widget will be attached.
     */
    public HtmlElement getElement();
    
    /**
     * @return the node to use with non-DojoServerFaces behaviors
     */
    public String getJsfNode();

    /**
     * @return the collection of Property handlers that are used to generate the
     *         widget property values.
     */
    public Collection<Property> getPropertyHandlers();

    /**
     * @return the dojo widget type to be created
     */
    public DojoType getWidgetType();

    /**
     * @return the handler to be used for "decode" on submit
     */
    public PostBackHandler getPostBackHandler();

    /**
     * @param name
     * @return the value of the named attribute for this component
     */
    public Object getAttribute(String name);
}
