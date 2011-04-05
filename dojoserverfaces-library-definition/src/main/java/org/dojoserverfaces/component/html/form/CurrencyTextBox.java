/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.build.annotation.Property;

/**
 * A specialized input component for monetary values.
 */
@EditableValueHolder(dojoType = "dijit.form.CurrencyTextBox")
class CurrencyTextBox extends NumberInputBase {
    
    /**
     * The [ISO4217](http://en.wikipedia.org/wiki/ISO_4217) currency code, 
     * a three letter sequence like "USD"
     */
    @Property
    String currency;

    /**
     *  (currency only) override currency symbol. Normally, will be 
     *  looked up in localized table of supported currencies (dojo.cldr) 
     *  3-letter ISO 4217 currency code will be used if not found.
     */
    @Property(group="constraints")
    String symbol;
    
    /**
     *  where places are implied by pattern or explicit 'places' parameter, 
     *  whether to include the fractional portion.
     */
    @Property(group="constraints")
    Boolean fractional; 
}
