/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import javax.lang.model.element.Element;

import org.dojoserverfaces.build.annotation.SelectValueHolder;
import org.dojoserverfaces.constants.HtmlElementType;

/**
 * Class used to encapsulate information used to generate a value select
 * component.
 */

public class ValueSelectComponent extends ValueEditorComponent {
    private boolean store;

    /**
     * Creates a ValueSelectComponent object.
     * 
     * @param element
     *            an Element object containing the Java model element to use.
     * @param annotation
     *            a SelectValueHolder object containing the
     * @SelectValueHolder annotation to use.
     */

    public ValueSelectComponent(Element element, SelectValueHolder annotation) {

        super(annotation, element);
        setWidgetType(annotation.dojoType());
        setRequiredCss(annotation.requiredCss());
        setDisplayName(annotation.displayName());

        this.store = annotation.store();
        if (!this.store) {
            // use element type that uses option child tags
            super.setElementType(HtmlElementType.SELECT_OPTION);
        }
    }
}
