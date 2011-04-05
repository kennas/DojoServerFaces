/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.layout;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;

/**
 * A container that lays out its child widgets in a table layout.
 * 
 * The TableContainer lays out child widgets in a Table layout. Each widget can
 * specify a "label" or a "title" parameter. This label is displayed either
 * above or to the left of a widget depending on whether the "orientation"
 * attribute is "horiz" or "vert", for horizontal and vertical respectively. The
 * number of columns is configured using the "cols" attribute. The width of
 * labels can be configured using the "labelWidth" parameter.
 */
@Container(dojoType = "dojox.layout.TableContainer")
class TableContainer extends ContainerBase {

    /**
     * Number of columns.
     */
    @Property
    Integer cols;

    /**
     * Defines the width of a label. If the value is a number, it is treated as
     * a pixel value. The other valid value is a percentage, e.g. "50%".
     * Defaults to 100.
     */
    @Property
    String labelWidth;

    /**
     * Indicates that labels should be displayed. Defaults to true.
     */
    @Property
    Boolean showLabels;

    /**
     * label orientation indication should be either "horiz" or "vert". Defaults
     * to "horiz"
     */
    @Property
    String orientation;

    /**
     * The cell spacing to apply to the table. Defaults to 1.
     */
    @Property
    Integer spacing;

    /**
     * A CSS class that will be applied to child elements. For example, if the
     * class is "myClass", the table will have "myClass-table" applied to it,
     * each label TD will have "myClass-labelCell" applied, and each widget TD
     * will have "myClass-valueCell" applied.
     */
    @Property
    String customClass;

}
