/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.component.UIComponent;

public interface DojoClass {

    /**
     * @return the dojoType for which this property represents.
     */
    public String getDojoType(UIComponent component);
}
