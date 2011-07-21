/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.constants.HtmlElementType;

/**
 * An component that allows one to select a value with a vertically draggable
 * handle. Labels and rule marks are provided by separate components:
 * VerticalRuleLabels and VerticalRule.
 */
@EditableValueHolder(dojoType = "dijit.form.VerticalSlider", elementType = HtmlElementType.DIV)
public class VerticalSlider extends HorizontalSlider {
}
