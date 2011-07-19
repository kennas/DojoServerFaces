/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tag.property;

import java.util.LinkedHashMap;

import javax.faces.component.UIComponent;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagAttribute;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagHandler;

import org.dojoserverfaces.build.annotation.FaceletTag;
import org.dojoserverfaces.widget.property.ComplexProperty;

/**
 * Base class for tags setting "view" properties for a structure.
 */
@FaceletTag("DataGrid View")
public abstract class StructureBase extends TagHandler implements
        javax.faces.view.facelets.AttributeHandler {

    /*
     * The "structure" property is an collection of "view" properties. A "view"
     * is a compound property one of which is the property "cells". This is a
     * collection of cell instances or an array of "cell" instances. A "cell" is
     * a collection of more properties. Two things need to be dealt with 1)
     * defining and collecting Property instances and 2) saving away property
     * values. Sub views are support by using dot notation in the view names.
     */

    // name of component attribute for the structure property
    protected static final String PROP_STRUCTURE = "structure";
    // name used for a view Property instance (not and actually widget property)
    protected static final String PROP_VIEW = "view";

    // delete this according to changes of getCellList
    // property name of the the view's collection of cells
    // protected static final String PROP_CELLS = "cells";
    public StructureBase(TagConfig config) {
        super(config);
    }

    /**
     * @param component
     * @param viewName
     * @return the named view Property object from the component. If the view
     *         does not exist one will be created and added as a component
     *         attribute. If the view name is null a default name will be
     *         created.
     */
    protected ComplexProperty getViewProperty(UIComponent component,
            String viewName) {

        if (null == viewName) {
            viewName = "default";
        }

        ComplexProperty viewProperty = null;
        @SuppressWarnings("unchecked")
        // get the existing structure definition
        LinkedHashMap<String, ComplexProperty> structure = (LinkedHashMap<String, ComplexProperty>) component
                .getAttributes().get(PROP_STRUCTURE);
        /*
         * we are using an ordered map to maintain the order the views are
         * defined with the ability to easily find an existing view.
         */
        if (null == structure) {
            structure = new LinkedHashMap<String, ComplexProperty>();
            component.getAttributes().put(PROP_STRUCTURE, structure);
        }

        viewProperty = structure.get(viewName);
        if (null == viewProperty) {
            viewProperty = new ComplexProperty(viewName, PROP_VIEW);
            structure.put(viewName, viewProperty);
        }
        return viewProperty;
    }

    /**
     * @param component
     * @param viewTagAttribute
     *            containing the name if set
     * @return the named view Property object from the component. If the view
     *         does not exist one will be created and added as a component
     *         attribute. If the view name is null a default name will be
     *         created.
     */
    protected ComplexProperty getViewProperty(UIComponent component,
            TagAttribute viewTagAttribute) {
        return getViewProperty(component, getViewNodes(viewTagAttribute)[0]);
    }

    /**
     * Store the tag's attributes value (literal or expression) in the
     * components attribute map.
     * 
     * @param context
     * @param component
     * @param attrName
     * @param value
     */
    protected void setComponentAttribute(FaceletContext context,
            UIComponent component, String attrName, TagAttribute value) {
        if (value.isLiteral()) {
            component.getAttributes().put(attrName, value.getValue());
        }
        else {
            component.setValueExpression(attrName,
                    value.getValueExpression(context, Object.class));
        }

    }

    /**
     * @param viewTagAttribute
     * @return an array of view node names parsed from a view name using dot
     *         notation.
     */
    protected String[] getViewNodes(TagAttribute viewTagAttribute) {
        String viewName = null;
        if (null != viewTagAttribute) {
            if (viewTagAttribute.isLiteral()) {
                viewName = viewTagAttribute.getValue();
            }
        }
        if (null == viewName) {
            return new String[] { "_" };
        }
        viewName = viewName.trim();
        return viewName.split("\\.");
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.faces.view.facelets.AttributeHandler#getAttributeName(javax
     * .faces .view.facelets.FaceletContext)
     */
    public String getAttributeName(FaceletContext ctx) {
        return PROP_STRUCTURE;
    }
}
