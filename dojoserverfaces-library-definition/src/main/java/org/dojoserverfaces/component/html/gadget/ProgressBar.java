/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.gadget;

import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;

/**
 * 
 * A ProgressBar gives dynamic feedback on the progress of a long-running
 * operation. The progress can be updated by JavaScript function calls. This
 * method works best for long-running JavaScript operations, or a series of
 * JavaScript XHR calls to the server.
 * 
 */
@Gadget(dojoType = "dijit.ProgressBar")
class ProgressBar extends WidgetBase {

    /**
     * Max sample number
     */
    @Property
    Integer maximum;
    /**
     * If false: show progress value (number or percentage). If true: show that
     * a process is underway but that the amount completed is unknown.
     * Deprecated. Use "value" instead.
     */
    @Property
    Boolean indeterminate;
    /**
     * (Percentage or Number) Number or percentage indicating amount of task
     * completed. With "%": percentage value, 0% <= progress <= 100%, or without
     * "%": absolute value, 0 <= progress <= maximum. Infinity means that the
     * progress bar is indeterminate.
     */
    @Property
    String progress;
    /**
     * The label to display for a given widget
     */
    @Property
    String label;
    /**
     * Number of places to show in values; 0 by default. it should not be larger than 20
     */
    @Property
    Integer places;

}