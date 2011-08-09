/*******************************************************************************
 *   Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *   Available via Academic Free License >= 2.1 OR the modified BSD license.
 *   see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.store.tree;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.widget.property.DataStoreRefProperty;
import org.dojoserverfaces.widget.property.PropertyCollectionProperty;

/**
 * Defines base properties for tree models.
 */

public abstract class TreeModelBase {
     /**
      * One or more attribute names (attributes in the dojo.data item) that
      * specify that item's children.
      */
     
     @Property(handler=PropertyCollectionProperty.class)
     Object childrenAttrs;
     
     /**
      * Setting this to true will cause the model to defer calling loadItem on
      * nodes until they are expanded. This allows for lazy loading where only
      * one loadItem (and generally one network call, consequently) per
      * expansion (rather than one for each child). This relies on partial
      * loading of the children items; each children item of a fully loaded
      * item should contain the label and info about having children.
      */
     
     @Property
     Boolean deferItemLoadingUntilExpand;
     
     /**
      * If specified, get label for tree node from this attribute, rather than
      * by calling store.getLabel().
      */
     
     @Property
     String labelAttr;
     
     /**
      * Name of attribute in the Object passed to newItem() that specifies the
      * id. If newItemIdAttr is set then it's used when newItem() is called to
      * see if an item with the same id already exists, and if so just links to
      * the old item (so that the old item ends up with two parents). Setting
      * this to null or "" will make every drop create a new item.
      */
     
     @Property
     String newItemIdAttr;
     
     /**
      * Event issued whenever an item has changed, so that Tree can update the
      * label, icon, etc. Note that changes to an item's children or parent(s)
      * will trigger an onChildrenChange() so you can ignore those changes here.
      */
     
     @Event
     String onChange;
     
     /**
      * Event issue in response to notifications about new, updated, or deleted
      * items.
      */
     
     @Event
     String onChildrenChange;
     
     /**
      * Event issued when an item has been deleted.
      */
     
     @Event
     String onDelete;
     
     /**
      * Event issued in response to delete notifications from underlying store.
      */
     
     @Event
     String onDeleteItem;
     
     /**
      *  Event issued when new items appear in the store, either from a drop
      *  operation or some other way. Updates the tree view (if necessary).
      */
     
     @Event
     String onNewItem;
     
     /**
      * Event issued in response to changes in the data store.
      */
     
     @Event
     String onSetItem;
     
     /**
      * Specifies datastore query to return the root item for the tree. Must
      * only return a single item. Alternately can just pass in pointer to root
      * item.
      */
     
     @Property
     String query;
     
     /**
      * The data store to use.
      */
     
     @Property(handler=DataStoreRefProperty.class)
     Object store;
}
