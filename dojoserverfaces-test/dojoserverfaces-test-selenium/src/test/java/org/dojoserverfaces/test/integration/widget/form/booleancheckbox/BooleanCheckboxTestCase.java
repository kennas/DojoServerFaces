/*******************************************************************************
 *   Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *   Available via Academic Free License >= 2.1 OR the modified BSD license.
 *   see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.integration.widget.form.booleancheckbox;

import org.dojoserverfaces.test.support.selenium.DojoServerFacesSeleniumTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class BooleanCheckboxTestCase extends DojoServerFacesSeleniumTestCase {
     
	
	@Before
     public void setUp() throws Exception {
          setUpTestCase ("test.main.contextRoot");
     }

     @Test
     public void testUntitled() throws Exception {
          driver.get("form/booleanCheckBox/index.jsf");
          //driver.findElement(By.name("form:ajaxRefresh:widgetAjaxCall")).click();
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
