/*******************************************************************************
 *   Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *   Available via Academic Free License >= 2.1 OR the modified BSD license.
 *   see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.integration.widget.form.booleanradiobutton;

import org.dojoserverfaces.test.support.selenium.DojoServerFacesSeleniumTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BooleanRadioButtonTestCase extends DojoServerFacesSeleniumTestCase {
     @Before
     public void setUp() throws Exception {
          setUpTestCase ("test.main.contextRoot");
     }

     @Test
     public void testUntitled() throws Exception {
          driver.get("form/booleanRadioButton/index.jsf");
          //selenium.click("form:ajaxRefresh:widgetAjaxCall");
          //verifyEquals("false", selenium.getText("form:ajaxRefresh:outputAjaxCall"));
     }

     @After
     public void tearDown() throws Exception {
    	 driver.quit();
 		String verificationErrorString = verificationErrors.toString();
 		if (!"".equals(verificationErrorString)) {
 			fail(verificationErrorString);
 		}
     }
}
