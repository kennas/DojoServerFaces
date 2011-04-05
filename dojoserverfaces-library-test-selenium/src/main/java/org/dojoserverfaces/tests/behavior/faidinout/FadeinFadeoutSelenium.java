/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.behavior.faidinout;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class FadeinFadeoutSelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                FadeinFadeoutSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/behavior/fadeinout/fadeinout.jsf");
        }
    }

    public void testFadeout() throws Exception {
        waitForDojoReady();
        verifyEquals("true", selenium.isVisible("form:initialValues:portletA"));
        selenium.click("form:initialValues:buttonB");
        verifyEquals("false", selenium.isVisible("form:initialValues:portletA"));
    }

    public void testFadein() throws Exception {
        waitForDojoReady();
        verifyEquals("false", selenium.isVisible("form:initialValues:portletA"));
        selenium.click("form:initialValues:buttonA");
        verifyEquals("true", selenium.isVisible("form:initialValues:portletA"));
    }
}