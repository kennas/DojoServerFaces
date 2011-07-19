/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tag.property;

import java.io.IOException;

import javax.el.ELException;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.FaceletException;
import javax.faces.view.facelets.TagAttribute;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagException;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.FaceletTag;
import org.dojoserverfaces.widget.property.BooleanProperty;
import org.dojoserverfaces.widget.property.ComplexProperty;

/**
 * Defines, for a view on the parent component, whether it should allow
 * scrolling or not.
 */
@FaceletTag("DataGrid View")
public final class View extends StructureBase {

    private final TagAttribute nameTagAttribute;
    private final String PROP_NAME = "name";
    private final TagAttribute noScrollTagAttribute;
    private final String PROP_NOSCROLL = "noscroll";

    public View(TagConfig config) {
        super(config);
        nameTagAttribute = getAttribute(PROP_NAME);
        noScrollTagAttribute = getAttribute(PROP_NOSCROLL);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.faces.view.facelets.FaceletHandler#apply(javax.faces.view.facelets
     * .FaceletContext, javax.faces.component.UIComponent)
     */
    public void apply(FaceletContext context, UIComponent parent)
            throws IOException, FacesException, FaceletException, ELException {

        if (parent == null) {
            throw new TagException(this.tag, "Must be child of component");
        }

        ComplexProperty viewProperty = getViewProperty(parent, nameTagAttribute);
        String attrName;
        if (null != noScrollTagAttribute) {
            attrName = viewProperty.getName() + PROP_NOSCROLL;
            viewProperty.add(new BooleanProperty(attrName, PROP_NOSCROLL));
            setComponentAttribute(context, parent, attrName,
                    noScrollTagAttribute);
        }
    }

    /**
     * Name of a view used for grouping cells together as "view". Use a dot
     * notation for grouping cells (e.g. "1.1")
     */
    @Attribute
    protected String getName(TagAttribute attr) {
        if (attr.isLiteral()) {
            return attr.getValue().toString();
        }
        else {
            return null;
        }
    }

    /**
     * Indicates if the "view" should allow for scrolling. Default is false.
     */
    @Attribute
    protected Boolean getNoscroll(TagAttribute attr) {
        if (attr.isLiteral()) {
            return new Boolean(attr.getValue().toString());
        }
        else {
            return null;
        }
    }
}
