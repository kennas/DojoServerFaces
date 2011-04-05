/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.data;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.util.Iterator;

import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

/**
 * Data store component that can access a bean data store.
 */

public class BeanDataStoreComponent extends DojoDataStoreComponent {
    /**
     * Creates a BeanDataStoreComponent object.
     */

    public BeanDataStoreComponent() {
        super("dojo.data.ItemFileReadStore");
    }

    /*
     * @see
     * org.dojoserverfaces.component.data.DojoDataStoreComponent#encodeEnd(javax.faces
     * .context.FacesContext)
     */

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        Object obj;

        // TODO: I have no idea why Faces wouldn't call the getters and
        // setters for the bean attribute, so I'm resorting to this...

        obj = getStateHelper().eval("bean");

        if (obj instanceof DataModel<?>) {
            DataModel<?> dataModel = (DataModel<?>) obj;
            StringBuilder items = new StringBuilder("[");

            // Iterate over the items and add them to the item list.

            for (Iterator<?> i = dataModel.iterator(); i.hasNext();) {
                Object bean = i.next();
                PropertyDescriptor properties[];

                // TODO: not great to have to do this, so think of
                // something a little better performance-wise.

                try {
                    properties = Introspector.getBeanInfo(bean.getClass())
                            .getPropertyDescriptors();
                }

                catch (Throwable e) {
                    // TODO: handle.

                    e.printStackTrace();

                    return;
                }

                items.append('{');

                for (int j = 0; j < properties.length; ++j) {
                    String name = properties[j].getName();

                    if (!name.equals("class")) {
                        items.append(properties[j].getName());
                        items.append(':');

                        try {
                            // TODO: need to escape these, but not with
                            // the helper method. Revisit in the future.
                            // TODO: we're also assuming strings for
                            // everything...

                            items.append('"');
                            items.append(properties[j].getReadMethod()
                                    .invoke(bean).toString());
                            items.append('"');
                        }

                        catch (Throwable ex) {
                            // TODO: handle.

                            ex.printStackTrace();

                            return;
                        }

                        if (j < (properties.length - 1)) {
                            items.append(',');
                        }
                    }
                }

                items.append('}');

                if (i.hasNext()) {
                    items.append(',');
                }
            }

            items.append(']');

            addConstructorArgument("data", "{items:" + items.toString() + "}");

            super.encodeEnd(context);
        }
    }

    /*
     * @see
     * org.dojoserverfaces.component.data.DojoDataStoreComponent#shouldEscapeArgument
     * (java.lang.String)
     */

    @Override
    protected boolean shouldEscapeArgument(String name) {
        if (name.equals("data")) {
            return false;
        }

        return true;
    }
}
