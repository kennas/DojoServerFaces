/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tag.property;

import java.util.ArrayList;
import javax.faces.component.UIComponent;
import javax.faces.view.facelets.TagAttribute;
import javax.faces.view.facelets.TagConfig;
import org.dojoserverfaces.build.annotation.FaceletTag;
import org.dojoserverfaces.widget.property.ComplexProperty;
import org.dojoserverfaces.widget.property.Property;
import org.dojoserverfaces.widget.property.PropertyCollectionProperty;

/**
 * Defines a cell in a view of the structure property of the parent component.
 * Cells can be grouped by using a dot notation in the view name.
 */
@FaceletTag("DataGrid Cell")
public final class Cell extends CellBase {
    private final String PROP_CELL = "cell";

    public Cell(TagConfig config) {
        super(config);
    }

    @Override
    protected ComplexProperty getCellProperty(UIComponent component,
            TagAttribute viewTagAttribute, StringBuilder attributeUniqueName) {
        // retrieve the list to hold cell Property objects for the indicated
        // view
        ArrayList<ComplexProperty> cellList = getCellList(component,
                viewTagAttribute, attributeUniqueName, "cells");
        // create a prefix for generating unique attributes names for a
        // property's values
        attributeUniqueName.append(cellList.size()).toString();

        // define the cell property (a collection of sub properties) and add it
        // to the list of cells
        ComplexProperty cellProperty = new ComplexProperty(PROP_CELL);
        cellList.add(cellProperty);
        return cellProperty;
    }

    /**
     * @param component
     * @param viewTagAttribute
     * @param cellListName
     * @param prop
     * @return the cell list associated with the indicated view (including sub
     *         view). If the view and/or cell list does not yet exist they/it
     *         will be created. If no view name is specified the default will be
     *         used.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected ArrayList<ComplexProperty> getCellList(UIComponent component,
            TagAttribute viewTagAttribute, StringBuilder propListName,
            String prop) {
        String[] viewNodes = getViewNodes(viewTagAttribute);
        ComplexProperty viewProperty = getViewProperty(component, viewNodes[0]);
        String propListAttrName = viewProperty.getName() + prop;
        ArrayList<? extends Property> propList = (ArrayList<? extends Property>) component
                .getAttributes().get(propListAttrName);
        if (null == propList) {
            propList = new ArrayList<ComplexProperty>();
            component.getAttributes().put(propListAttrName, propList);
            viewProperty.add(new PropertyCollectionProperty(propListAttrName,
                    prop));
        }
        // for each node of the view name make sure there is a prop list
        for (int i = 1; i < viewNodes.length; ++i) {
            propListAttrName = propListAttrName + viewNodes[i];
            ArrayList<ComplexProperty> subpropList = (ArrayList<ComplexProperty>) component
                    .getAttributes().get(propListAttrName);
            if (null == subpropList) {
                subpropList = new ArrayList<ComplexProperty>();
                component.getAttributes().put(propListAttrName, subpropList);
                ((ArrayList) propList).add(new PropertyCollectionProperty(
                        propListAttrName, prop));
            }
            propList = subpropList; // we return propList
        }
        propListName.append(propListAttrName); // save prop list name
        return (ArrayList<ComplexProperty>) propList;
    }
}
