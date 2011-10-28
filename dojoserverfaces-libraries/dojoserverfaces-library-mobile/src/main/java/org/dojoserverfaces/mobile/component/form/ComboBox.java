/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.form;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.constants.HtmlElementType;
import org.dojoserverfaces.widget.property.DojoRefProperty;

/**
 * ComboBox is a hybrid between a SELECT HTML element and an INPUT text box.
 * 
 */
@EditableValueHolder(dojoType = "dojox.mobile.ComboBox", elementType = HtmlElementType.INPUT_TEXT, requiredCss = { "dojox/mobile/themes/{theme}/ComboBox.css" })
public class ComboBox extends TextBoxBase {
    /**
     * Reference to data provider object
     */
    @Property(handler = DojoRefProperty.class)
    Object store;
    /**
     * dijit.form.DataList store made from OPTION tags and supports selected
     * attribute.
     * TO-Do
     * Do we support this property? since we do not wrap
     * dijit.form.DataList
     */
    @Property
    Object list;
}
