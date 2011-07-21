/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.layout;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;

/**
 * Holds a set of panes where every pane's title is visible, but only one 
 * pane's content is visible at a time, and switching between panes is 
 * visualized by sliding the other panes up/down.
 *
 */
@Container(dojoType = "dijit.layout.AccordionContainer")
class AccordionContainer extends StackContainer {
    
    // TODO - buttonWidget support? name of class not an instance so facet may not help
    
    /**
     * Amount of time (in ms) it takes to slide panes
     */
    @Property
    Integer duration;

}
