/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.data;

import javax.faces.component.UIComponent;

import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.DojoWidget;
import org.dojoserverfaces.widget.property.DijitProperty;
import org.dojoserverfaces.widget.property.DojoRefProperty;
import org.dojoserverfaces.widget.property.PostCreateScript;
import org.dojoserverfaces.widget.property.PropertyCollectionProperty;

/**
 * Grids are familiar in the client/server development world. Basically a grid
 * is a kind of mini spreadsheet, commonly used to display details on
 * master-detail forms. From HTML terms, a grid is a "super-table" with its own
 * scrollable viewport.
 */
@Gadget(dojoType = "dojox.grid.DataGrid", requiredCss = {
        "dojox/grid/resources/Grid.css", "dojox/grid/resources/{theme}Grid.css" })
public class DataGrid extends WidgetBase {
    public static class HeaderMenuHandler extends
            org.dojoserverfaces.widget.property.Property implements
            PostCreateScript {

        public HeaderMenuHandler(String attributeName, String propertyName) {
            super(attributeName, propertyName);
        }

        public HeaderMenuHandler(String name) {
            super(name);
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {

            return null;
        }

        @Override
        public String getPostCreateInitialization(UIComponent component,
                String widgetVar) {
            Object value = getAttributeValue(component);
            if (value != null) {
                UIComponent targetComponent = component.findComponent(value
                        .toString());
                if (targetComponent == null
                        || (!(targetComponent instanceof DojoWidget))) {
                    log(component, "Invalid id");
                    return null;
                }
                StringBuilder dijitMenu = new StringBuilder("dijit.byId(")
                        .append(Helper.quote(targetComponent.getClientId()))
                        .append(")");
                return new StringBuilder(widgetVar).append(".setHeaderMenu(")
                        .append(dijitMenu.toString()).append(");").toString();
            }
            return null;

        }

        @Override
        public Boolean isStartupPostponed() {
            return Boolean.FALSE;
        }

    }

    /**
     * data store
     */
    @Property(handler = DojoRefProperty.class)
    Object store;

    /**
     * Set to true if you want to be able to select the text within the grid.
     */
    @Property
    Boolean selectable;
    /**
     * a row selector of that width to this grid.
     */
    @Property
    String rowSelector;
    /**
     * Set the selection mode of grid's Selection. Value must be 'single',
     * 'multiple', or 'extended'. Default is 'extended'.
     */
    @Property
    String selectionMode;

    /**
     * Message that shows while the grid is loading
     */
    @Property
    String loadingMessage;

    /**
     * Message that shows when the grid encounters an error loading
     */
    @Property
    String errorMessage;

    /**
     * Id of component to use as the context menu on the header.
     */
    @Property(name = "headerMenu", handler = HeaderMenuHandler.class)
    String headerMenuId;

    /**
     * structurer usage
     */
    @Property(handler = PropertyCollectionProperty.class)
    Object structure;
    /**
     * query usage
     */
    @Property
    String query;
    /**
     * if autoHeight is true, grid height is automatically set to fit the data.
     * If it is an integer, the height will be automatically set to fit the data
     * if there are fewer than that many rows - and the height will be set to
     * show that many rows if there are more
     */
    @Property
    Object autoHeight;
    /**
     * Number of rows to render at a time
     */
    @Property
    Object rowsPerPage;
    /**
     * A boolean value that defines whether a single or double click is needed
     * to enter cell editing mode.
     */
    @Property
    Boolean singleClickEdit;

}