/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.build.annotation.Property;

/**
 * An input component which restricts input to numeric input and offers down and
 * up arrow buttons to "spin" the number up and down
 * 
 */
@EditableValueHolder(dojoType = "dijit.form.NumberSpinner")
class NumberSpinner extends NumberInputBase {

    /**
     * Adjust the value by this amount when spinning using the arrow
     * keys/buttons
     */
    @Property
    Number smallDelta;
    /**
     * Adjust the value by this amount when spinning using the PgUp/Dn keys
     */
    @Property
    Number largeDelta;
}
