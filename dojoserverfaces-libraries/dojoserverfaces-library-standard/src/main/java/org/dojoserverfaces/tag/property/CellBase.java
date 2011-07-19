/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tag.property;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagAttribute;
import javax.faces.view.facelets.TagConfig;
import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.widget.property.AsStringProperty;
import org.dojoserverfaces.widget.property.BooleanProperty;
import org.dojoserverfaces.widget.property.ComplexProperty;
import org.dojoserverfaces.widget.property.DimensionProperty;
import org.dojoserverfaces.widget.property.StringArrayProperty;
import org.dojoserverfaces.widget.property.StringProperty;

/**
 * Base class for Cell property tags
 */
public abstract class CellBase extends StructureBase {
    private TagAttribute widthTagAttribute;
    private String PROP_WIDTH = "width";
    private TagAttribute typeTagAttribute;
    private String PROP_TYPE = "type";
    private TagAttribute editableTagAttribute;
    private String PROP_EDITABLE = "editable";
    private TagAttribute stylesTagAttribute;
    private String PROP_STYLES = "styles";
    private TagAttribute viewTagAttribute;
    private String PROP_VIEW = "view";
    private final TagAttribute fieldTagAttribute;
    private final String PROP_FIELD = "field";
    private final TagAttribute nameTagAttribute;
    private final String PROP_NAME = "name";
    private final TagAttribute optionsTagAttribute;
    private final String PROP_OPTIONS = "options";
    private final TagAttribute formatterTagAttribute;
    private final String PROP_FORMATTER = "formatter";
    private final TagAttribute constraintTagAttribute;
    private final String PROP_CONSTRAINT = "constraint";
    private final TagAttribute widgetClassTagAttribute;
    private final String PROP_WIDGETCLASS = "widgetClass";

    public CellBase(TagConfig config) {
        super(config);
        widthTagAttribute = getAttribute(PROP_WIDTH);
        typeTagAttribute = getAttribute(PROP_TYPE);
        editableTagAttribute = getAttribute(PROP_EDITABLE);
        stylesTagAttribute = getAttribute(PROP_STYLES);
        viewTagAttribute = getAttribute(PROP_VIEW);
        nameTagAttribute = getAttribute(PROP_NAME);
        fieldTagAttribute = getAttribute(PROP_FIELD);
        optionsTagAttribute = getAttribute(PROP_OPTIONS);
        formatterTagAttribute = getAttribute(PROP_FORMATTER);
        constraintTagAttribute = getAttribute(PROP_CONSTRAINT);
        widgetClassTagAttribute = getAttribute(PROP_WIDGETCLASS);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.faces.view.facelets.FaceletHandler#apply(javax.faces.view.facelets
     * .FaceletContext, javax.faces.component.UIComponent)
     */
    @Override
    public void apply(FaceletContext context, UIComponent parent)
            throws IOException {
        StringBuilder defaultCellName = new StringBuilder();

        // retrieve the default cell Property object for the indicated
        // view
        ComplexProperty cellProperty = getCellProperty(parent,
                viewTagAttribute, defaultCellName);
        // create a prefix for generating unique attributes names for a
        // property's values
        String cellAttrNamePrefix = defaultCellName.toString();
        updateCellProperty(context, parent, cellAttrNamePrefix, cellProperty);
    }

    /**
     * @param component
     * @param viewTagAttribute
     * @param attributeUniqueName
     *            returned unique name for use in adding component attributes
     * @return a Property for storing the cell properties defined by the tag.
     */
    abstract protected ComplexProperty getCellProperty(UIComponent component,
            TagAttribute viewTagAttribute, StringBuilder attributeUniqueName);

    /**
     * @param context
     *            FacesContext
     * @param component
     *            Parent component
     * @param cellAttrNamePrefix
     *            prefix to use for uniquely naming component attributes
     * @param cellProperty
     *            property to update
     */
    protected void updateCellProperty(FaceletContext context,
            UIComponent component, String cellAttrNamePrefix,
            ComplexProperty cellProperty) {
        // for each cell sub property add a property to the cell definition and
        // store the value as a component attribute
        String attrName;
        if (null != widthTagAttribute) {
            attrName = cellAttrNamePrefix + PROP_WIDTH;
            cellProperty.add(new DimensionProperty(attrName, PROP_WIDTH));
            setComponentAttribute(context, component, attrName,
                    widthTagAttribute);
        }
        if (null != editableTagAttribute) {
            attrName = cellAttrNamePrefix + PROP_EDITABLE;
            cellProperty.add(new BooleanProperty(attrName, PROP_EDITABLE));
            setComponentAttribute(context, component, attrName,
                    editableTagAttribute);
        }
        if (null != stylesTagAttribute) {
            attrName = cellAttrNamePrefix + PROP_STYLES;
            cellProperty.add(new StringProperty(attrName, PROP_STYLES));
            setComponentAttribute(context, component, attrName,
                    stylesTagAttribute);
        }
        if (null != typeTagAttribute) {
            attrName = cellAttrNamePrefix + PROP_TYPE;
            cellProperty.add(new CellTypeProperty(attrName, PROP_TYPE));
            setComponentAttribute(context, component, attrName,
                    typeTagAttribute);
        }

        if (null != optionsTagAttribute) {

            attrName = cellAttrNamePrefix + PROP_OPTIONS;
            cellProperty.add(new StringArrayProperty(attrName, PROP_OPTIONS));
            setComponentAttribute(context, component, attrName,
                    optionsTagAttribute);
        }
        if (null != formatterTagAttribute) {
            attrName = cellAttrNamePrefix + PROP_FORMATTER;
            cellProperty.add(new AsStringProperty(attrName, PROP_FORMATTER));
            setComponentAttribute(context, component, attrName,
                    formatterTagAttribute);
        }
        if (null != constraintTagAttribute) {
            attrName = cellAttrNamePrefix + PROP_CONSTRAINT;
            cellProperty.add(new AsStringProperty(attrName, PROP_CONSTRAINT));
            setComponentAttribute(context, component, attrName,
                    constraintTagAttribute);
        }
        if (null != widgetClassTagAttribute) {

            attrName = cellAttrNamePrefix + PROP_WIDGETCLASS;
            cellProperty.add(new AsStringProperty(attrName, PROP_WIDGETCLASS));
            setComponentAttribute(context, component, attrName,
                    widgetClassTagAttribute);
        }
        if (null != fieldTagAttribute) {
            attrName = cellAttrNamePrefix + PROP_FIELD;
            cellProperty.add(new StringProperty(attrName, PROP_FIELD));
            setComponentAttribute(context, component, attrName,
                    fieldTagAttribute);
        }
        if (null != nameTagAttribute) {
            attrName = cellAttrNamePrefix + PROP_NAME;
            cellProperty.add(new StringProperty(attrName, PROP_NAME));
            setComponentAttribute(context, component, attrName,
                    nameTagAttribute);
        }
    }

    /**
     * Width of cell (HTML width)
     */
    @Attribute
    protected String getWidth(TagAttribute attr) {
        if (attr.isLiteral()) {
            return attr.getValue().toString();
        } else {
            return null;
        }
    }

    /**
     * Indicates if cell can be edited. Default is false.
     */
    @Attribute
    protected Boolean getEditable(TagAttribute attr) {
        if (attr.isLiteral()) {
            return new Boolean(attr.getValue().toString());
        } else {
            return null;
        }
    }

    /**
     * Indicates cell type
     */
    @Attribute
    protected String getType(TagAttribute attr) {
        if (attr.isLiteral()) {
            return attr.getValue().toString();
        } else {
            return null;
        }
    }

    /**
     * Indicates cell style
     */
    @Attribute
    protected String getStyles(TagAttribute attr) {
        if (attr.isLiteral()) {
            return attr.getValue().toString();
        } else {
            return null;
        }
    }

    /**
     * Name of a view used for grouping cells together as "view". Use a dot
     * notation for grouping cells (e.g. "1.1")
     */
    @Attribute
    protected String getView(TagAttribute attr) {
        if (attr.isLiteral()) {
            return attr.getValue().toString();
        } else {
            return null;
        }
    }

    /**
     * Name of field in the data collection to render in the cell.
     */
    @Attribute
    protected String getField(TagAttribute attr) {
        if (attr.isLiteral()) {
            return attr.getValue().toString();
        } else {
            return null;
        }
    }

    /**
     * Label for cell used in a column header.
     */
    @Attribute
    protected String getName(TagAttribute attr) {
        if (attr.isLiteral()) {
            return attr.getValue().toString();
        } else {
            return null;
        }
    }

    /**
     * Space separated list of options for use with Select cell type
     */
    @Attribute
    protected String getOptions(TagAttribute attr) {
        // TODO improve javadoc
        if (attr.isLiteral()) {
            return attr.getValue().toString();
        } else {
            return null;
        }
    }

    /**
     * Widget class for use in cell
     */
    @Attribute
    protected String getWidgetClass(TagAttribute attr) {
        if (attr.isLiteral()) {
            return attr.getValue().toString();
        } else {
            return null;
        }
    }

    /**
     * Formatter for cell content
     */
    @Attribute
    protected String getFormatter(TagAttribute attr) {
        if (attr.isLiteral()) {
            return attr.getValue().toString();
        } else {
            return null;
        }
    }

    /**
     * constraint for use with Formatter
     */
    @Attribute
    protected String getConstraint(TagAttribute attr) {
        if (attr.isLiteral()) {
            return attr.getValue().toString();
        } else {
            return null;
        }
    }

}
