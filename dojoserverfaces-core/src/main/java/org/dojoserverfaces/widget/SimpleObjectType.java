/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget;



/**
 * A class to represent a dojo object type definition. It will take a dojo
 * type name and return that as the type.
 * 
 */
public class SimpleObjectType extends DojoType {
    private String dojoType;

    /**
     * Construct with the dojo widget name.
     * 
     * @param widgetType
     */
    public SimpleObjectType(String widgetType) {
        this.dojoType = widgetType;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.dojoserverfaces.widget.element.WidgetType#geTypeName(javax.faces.component
     * .UIComponent)
     */
    public String geTypeName() {
        return dojoType;
    }

    @Override
    public boolean isDijit() {
        return false;
    }

    @Override
    public boolean isMobileWidget() {
        return false;
    }
}
