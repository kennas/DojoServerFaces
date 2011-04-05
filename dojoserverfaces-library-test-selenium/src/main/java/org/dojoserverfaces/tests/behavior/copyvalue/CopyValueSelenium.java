/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.behavior.copyvalue;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class CopyValueSelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                CopyValueSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/behavior/copyvalue/copyvalue.jsf");
        }
    }

    public void testCopyValue() throws Exception {
        waitForDojoReady();
        verifyNotEquals(selenium.getValue("form:initialValues:holder"), selenium
                .getValue("form:initialValues:text1"));
        selenium.click("form:initialValues:buttonA");
        verifyEquals(selenium.getValue("form:initialValues:holder"), selenium
                .getValue("form:initialValues:text1"));
        verifyNotEquals(selenium.getValue("form:initialValues:holder"), selenium
                .getValue("form:initialValues:text2"));
        selenium.click("form:initialValues:buttonB");
        verifyEquals(selenium.getValue("form:initialValues:holder"), selenium
                .getValue("form:initialValues:text2"));
    }
}