/*******************************************************************************
 *   Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *   Available via Academic Free License >= 2.1 OR the modified BSD license.
 *   see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.store.tree;

import org.dojoserverfaces.build.annotation.DojoObject;
import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Property;

/**
 * A tree model that adapts data stores for use with trees but can have
 * multiple top-level items.
 */

@DojoObject(dojoType="dijit.tree.ForestStoreModel")
public class ForestStoreModel extends TreeModelBase {
     /**
      * Event issued when an item is added to root of tree; user must override
      * this method to modify the item so that it matches the query for top
      * level items.
      */
     
     @Event
     String onAddToRoot;
     
     /**
      * Event issued when an item is removed from root of tree; user must
      * override this method to modify the item so it doesn't match the query
      * for top level items.
      */
     
     @Event
     String onLeaveRoot;
     
     /**
      * Event issued when a new item is added to the root of the tree.
      */
     
     @Event
     String onNewRootItem;
     
     /**
      * ID of fabricated root item.
      */
     
     @Property
     String rootId;
     
     /**
      * Label of fabricated root item.
      */
     
     @Property
     String rootLabel;
}
