/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.component.UIComponent;

/**
 * Interface to allow a Property to add additional widget initialization after
 * the widget is created.
 */
public interface PostCreateScript {

    /**
     * @param component
     *            the component being rendered
     * @param widgetVar
     *            the name of the
     * @return initialization script (keep compressed)
     */
    String getPostCreateInitialization(UIComponent component, String widgetVar);

}
