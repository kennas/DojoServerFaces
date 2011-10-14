/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import javax.lang.model.element.Element;

import org.dojoserverfaces.build.annotation.MultiSelectValueHolder;
import org.dojoserverfaces.constants.HtmlElementType;

/**
 * Class used to encapsulate information used to generate a multiple value select
 * component.
 */

public class MultiValueSelectComponent extends ValueEditorComponent {
    private boolean store;

    /**
     * Creates a ValueSelectComponent object.
     * 
     * @param element
     *            an Element object containing the Java model element to use.
     * @param annotation
     *            a MultiSelectValueHolder object containing the @MultiSelectValueHolder
     *            annotation to use.
     */

    public MultiValueSelectComponent(Element element,
            MultiSelectValueHolder annotation) {
        super(annotation, element);
        setWidgetType(annotation.dojoType());
        setRequiredCss(annotation.requiredCss());
        setDisplayName(annotation.displayName());
        setJsfNode(annotation.jsfNode());
        setRendersChildren(annotation.rendersChildren());
        setRenderPosition(annotation.renderPosition());
        this.store = annotation.store();
        if (!this.store) {
            // use element type that uses option child tags
            super.setElementType(HtmlElementType.SELECT_OPTION);
        }
    }
}
