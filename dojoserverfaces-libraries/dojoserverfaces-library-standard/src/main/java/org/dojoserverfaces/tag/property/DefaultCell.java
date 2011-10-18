/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tag.property;

import javax.faces.component.UIComponent;
import javax.faces.view.facelets.TagAttribute;
import javax.faces.view.facelets.TagConfig;

import org.dojoserverfaces.build.annotation.FaceletTag;
import org.dojoserverfaces.widget.property.ComplexProperty;

/**
 * This tag used as the grid cell definition when there is no cell defined for a
 * particular field.
 * 
 */
@FaceletTag("DataGrid DefaultCell")
public class DefaultCell extends CellBase {

    protected String PROP_DEFAULTCELL = "defaultCell";

    public DefaultCell(TagConfig config) {
        super(config);
    }

    @Override
    protected ComplexProperty getCellProperty(UIComponent component,
            TagAttribute viewTagAttribute, StringBuilder attributeUniqueName) {
        String[] viewNodes = getViewNodes(viewTagAttribute);
        ComplexProperty viewProperty = getViewProperty(component, viewNodes[0]);
        String attrName = viewProperty.getName() + PROP_DEFAULTCELL;
        ComplexProperty defaultCellProperty = (ComplexProperty) component
                .getAttributes().get(attrName);
        if (null == defaultCellProperty) {
            defaultCellProperty = new ComplexProperty(PROP_DEFAULTCELL);
            component.getAttributes().put(attrName, defaultCellProperty);
            viewProperty.add(defaultCellProperty);
        }
        attributeUniqueName.append(attrName); // save prop list name
        return defaultCellProperty;
    }
}
