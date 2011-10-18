/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.form;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.constants.HtmlElementType;

/**
 * A simple multi-line text input area.
 * 
 */
@EditableValueHolder(dojoType = "dojox.mobile.TextArea", elementType = HtmlElementType.INPUT_TEXTAREA, requiredCss = { "dojox/mobile/themes/{theme}/TextArea.css" })
class TextArea extends TextAreaBase {

    /**
     * The height of the text area.
     */
    @Property
    Integer rows;
}
