/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import org.dojoserverfaces.build.annotation.GeneratedComponent;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.widget.property.StringArrayProperty;

/**
 * Labels for Horizontal Slider Rule.
 */
@GeneratedComponent(displayName = "Horizontal Rule Labels", dojoType = "dijit.form.HorizontalRuleLabels")
class HorizontalRuleLabels extends HorizontalRuleBase {
    /**
     * Used in conjunction with minimum and maximum the count indicates the
     * number of numeric labels to generate.
     */
    @Property
    Integer count;

    /**
     * labelStyle: String CSS style to apply to individual text labels
     */
    @Property
    String labelStyle;

    /**
     * Array of text labels to render - evenly spaced from left-to-right or
     * bottom-to-top. Alternately, minimum and maximum can be specified, to get
     * numeric labels.
     */
    @Property(handler = StringArrayProperty.class)
    Object labels;

    /**
     * Number of generated numeric labels that should be rendered as '' on the
     * ends when labels[] are not specified. Default is 0.
     */
    @Property
    Integer numericMargin;

    /**
     * Leftmost label value for generated numeric labels when labels[] are not
     * specified. Default is 0.
     */
    @Property
    Integer minimum;

    /**
     * Rightmost label value for generated numeric labels when labels[] are not
     * specified. Default is 1.
     */
    @Property
    Integer maximum;

    /**
     * override the locale on this widget only, choosing from
     * djConfig.extraLocale
     */
    @Property(group = "constraints")
    String locale;

    /**
     * override localized convention with this pattern. As a result, all users
     * will see the same behavior, regardless of locale, and your application
     * may not be globalized. See
     * http;//www.unicode.org/reports/tr35/#Number_Format_Patterns.
     */
    @Property(group = "constraints")
    String pattern;

    /**
     * The number of decimal places.
     */
    @Property(group = "constraints")
    String places;

    /**
     * 5 rounds to nearest .5; 0 rounds to nearest whole (default). -1 means do
     * not round.
     */
    @Property(group = "constraints")
    Integer round;

    /**
     * The format type; decimal, scientific (not yet supported), percent,
     * currency. Default is decimal.
     */
    @Property(group = "constraints")
    String type;

    /**
     * An [ISO4217](http://en.wikipedia.org/wiki/ISO_4217) currency code, a
     * three letter sequence like "USD"}
     */
    @Property(group = "constraints")
    String currency;

    /**
     * Localized currency symbol
     */
    @Property(group = "constraints")
    String symbol;
}
