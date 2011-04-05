/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.selenium.dojoserverfaces;

import org.dojoserverfaces.tests.form.booleancheckbox.BooleanCheckBoxSelenium;
import org.dojoserverfaces.tests.form.combobox.ComboBoxSelenium;
import org.dojoserverfaces.tests.form.currencytextbox.CurrencyTextBoxSelenium;
import org.dojoserverfaces.tests.form.dynamictextarea.DynamicTextAreaSelenium;
import org.dojoserverfaces.tests.form.filteringselect.FilteringSelectSelenium;
import org.dojoserverfaces.tests.form.numberspinner.NumberSpinnerSelenium;
import org.dojoserverfaces.tests.form.numbertextbox.NumberTextBoxSelenium;
import org.dojoserverfaces.tests.form.select.SelectSelenium;
import org.dojoserverfaces.tests.form.textBox.TextBoxSelenium;
import org.dojoserverfaces.tests.form.textarea.TextAreaSelenium;
import org.dojoserverfaces.tests.selenium.SeleniumTestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A Complete test suite class for all the JWL components. To run this class as
 * a JUnit Test case , it would require that the selenium server is already
 * running on the machine. If we require that the selenium server should start
 * automatically before every test class and stop after its completion, we just
 * need to extend the {@link SeleniumTestSuite} class
 * 
 * @author "jatin.varshney@in.ibm.com"
 * 
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( { TextBoxSelenium.class, NumberTextBoxSelenium.class,
        NumberSpinnerSelenium.class, CurrencyTextBoxSelenium.class,
        BooleanCheckBoxSelenium.class, TextAreaSelenium.class,
        DynamicTextAreaSelenium.class, ComboBoxSelenium.class,
        FilteringSelectSelenium.class, SelectSelenium.class })
public class DojoServerFacesTestSuite {

}