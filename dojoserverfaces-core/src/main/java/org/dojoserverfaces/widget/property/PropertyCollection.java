/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.component.UIComponent;

public interface PropertyCollection {

    public Iterator<Property> iterator(UIComponent component);
    
    class MapIterator implements Iterator<Property>{
        private Iterator<Entry<Object, Property>> setIterator;
        public MapIterator(Map<Object, Property> properties) {
            super();
            setIterator = properties.entrySet().iterator();
        }

        @Override
        public boolean hasNext() {
            return setIterator.hasNext();
        }

        @Override
        public Property next() {
            return setIterator.next().getValue();
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
    class ArrayIterator implements Iterator<Property>{
        private Property[] properties;
        private int current = 0;

        public ArrayIterator(Property[] properties) {
            super();
            this.properties = properties;
        }

        @Override
        public boolean hasNext() {
            return current < properties.length;
        }

        @Override
        public Property next() {
            return properties[current++];
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    class EmptyIterator implements Iterator<Property>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Property next() {
            return null;
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
        
    }

}
