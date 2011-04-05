/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.locale;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;

public class LocaleSelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                LocaleSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/config/locale/index.jsf");
        }
    }

    public void testLocale() throws Exception {
        waitForDojoReady();
        selenium
                .getEval("window.document.getElementById('form:initialValues:outputBox').innerHTML");
        System.out
                .println("Value Before Click-------->>>>>"
                        + selenium
                                .getEval("window.document.getElementById('form:initialValues:outputBox').innerHTML"));
        selenium.select("form:initialValues:widgetSimple", "label=French");
        selenium.click("form:submitBtn");
        selenium
                .getEval("window.document.getElementById('form:initialValues:outputBox').innerHTML");
        System.out
                .println("Value After Click-------->>>>>"
                        + selenium
                                .getEval("window.document.getElementById('form:initialValues:outputBox').innerHTML"));
    }
}