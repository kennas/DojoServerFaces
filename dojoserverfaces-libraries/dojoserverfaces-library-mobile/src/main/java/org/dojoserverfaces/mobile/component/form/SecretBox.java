/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.form;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.constants.HtmlElementType;

/**
 * This component act as <input type=password/>
 * 
 */
@EditableValueHolder(dojoType = "dojox.mobile.TextBox", requiredCss = { "dojox/mobile/themes/{theme}/TextBox.css" }, elementType = HtmlElementType.INPUT_PASSWORD)
public class SecretBox extends TextBoxBase {

}
