/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget;



/**
 * A class to represent a simple widget type definition. It will take a widget
 * type name and return that as the type.
 * 
 */
public class SimpleWidgetType extends DojoType {
    private String widgetType;

    /**
     * Construct a widget object with the dojo widget name.
     * 
     * @param widgetType
     */
    public SimpleWidgetType(String widgetType) {
        this.widgetType = widgetType;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.dojoserverfaces.widget.element.WidgetType#geTypeName(javax.faces.
     * component .UIComponent)
     */
    public String geTypeName() {
        return widgetType;
    }

    @Override
    public boolean isDijit() {
        return true;
    }
}
