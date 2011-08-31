/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.mobile;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Property;

abstract class InputBase extends WidgetBase {

    /**
     * The event handler script to execute when the field loses focus.
     */
    @Event
    String onBlur;

    /**
     * The event handler script to execute when the field gains focus.
     */
    @Event
    String onFocus;

    /**
     * The event handler script to execute when the field value changes. This
     * may be immediate of when the field loses focus.
     */
    @Event(isDefault = true)
    String onChange;

    /**
     * Whether or not this component is disabled.
     */
    @Property
    Boolean disabled;

    /**
     * Whether or not this component is read-only.
     */
    @Property
    Boolean readOnly;

    /**
     * The tab index for this component.
     */
    @Property
    Integer tabIndex;

    /**
     * Alternate title text
     */
    @Property
    String alt;
    // TODO - is this necessary when there is already a title attribute?
}
