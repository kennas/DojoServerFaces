/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.behavior.displayvisible;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class DisplayVisibleSelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                DisplayVisibleSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/behavior/setdisplayvisible/setdisplayvisible.jsf");
        }
    }

    public void testDisplay() throws Exception {
        waitForDojoReady();
        // when setDisplay value set to false
        selenium.click("form:initialValues:button1");
        verifyEquals("false", selenium.isVisible("form:initialValues:paneOne"));
        verifyEquals("false", selenium.isVisible("testDiv"));
        // when setDisplay value set to true
        selenium.click("form:initialValues:button2");
        verifyEquals("true", selenium.isVisible("form:initialValues:paneOne"));
        verifyEquals("true", selenium.isVisible("testDiv"));
    }

    public void testVisible() throws Exception {
        waitForDojoReady();
        // when setVisible value set to false
        selenium.click("form:initialValues:button3");
        verifyEquals("false", selenium.isVisible("form:initialValues:paneOne"));
        verifyEquals("false", selenium.isVisible("testDiv"));
        // when setVisible value set to true
        selenium.click("form:initialValues:button4");
        verifyEquals("true", selenium.isVisible("form:initialValues:paneOne"));
        verifyEquals("true", selenium.isVisible("testDiv"));
    }
}