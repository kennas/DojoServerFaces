/*******************************************************************************
 *   Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *   Available via Academic Free License >= 2.1 OR the modified BSD license.
 *   see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.gadget;

import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;
import org.dojoserverfaces.widget.property.DojoRefProperty;
import org.dojoserverfaces.widget.property.StringArrayProperty;

/**
 * This widget displays hierarchical data from a store.
 */

@Gadget(dojoType="dijit.Tree")
public class Tree extends WidgetBase {
     /**
      * Fully expand the tree on load.
      */
     
     @Property
     Boolean autoExpand;
     
     /**
      * Set to a positive value to allow drag and drop "between" nodes. If
      * during DnD mouse is over a (target) node but less than betweenThreshold
      * pixels from the bottom edge, dropping the the dragged node will make it
      * the next sibling of the target node, rather than the child. Similarly,
      * if mouse is over a target node but less that betweenThreshold pixels
      * from the top edge, dropping the dragged node will make it the target
      * node's previous sibling rather than the target node's child.
      */
     
     @Property
     Integer betweenThreshold;
     
     /**
      * Interface to read tree data, get notifications of changes to tree data,
      * and for handling drop operations (i.e drag and drop onto the tree).
      */
     
     @Property(handler=DojoRefProperty.class)
     Object model;
     
     /**
      *  If multiple characters are typed where each keystroke happens within
      *  multiCharSearchDuration of the previous keystroke, search for nodes
      *  matching all the keystrokes. For example, typing "ab" will search for
      *  entries starting with "ab" unless the delay between "a" and "b" is
      *  greater than multiCharSearchDuration.
      */
     
     @Property
     Integer multiCharSearchDuration;
     
     /**
      * If true, clicking a folder node's label will open it, rather than
      * calling onClick().
      */
     
     @Property
     Boolean openOnClick;
     
     /**
      * If true, double-clicking a folder node's label will open it, rather
      * than calling onDblClick().
      */
     
     @Property
     Boolean openOnDblClick;
     
     /**
      * A path in the tree that should be opened automatically.
      */
     
     @Property(handler=StringArrayProperty.class)
     Object path;
     
     /**
      * The root node of this tree.
      */
     
     @Property(handler=DojoRefProperty.class)
     Object rootNode;
     
     /**
      * The tree item to select.
      */
     
     @Property(handler=DojoRefProperty.class)
     Object selectedItem;
     
     /**
      * Should the root node be displayed, or hidden?
      */
     
     @Property
     Boolean showRoot;
     
     
}
