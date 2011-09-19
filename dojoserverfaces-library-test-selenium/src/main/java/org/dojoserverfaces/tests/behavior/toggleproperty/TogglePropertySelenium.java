/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.behavior.toggleproperty;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TogglePropertySelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                TogglePropertySelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/behavior/toggleproperty/toggleproperty.jsf");
        }
    }

    public void testToggleProperty() throws Exception {
        waitForDojoReady();
        String labelBeforeClick = selenium
                .getEval("window.dijit.byId('form:initialValues:widgetAjaxCall').get('label')");
        System.out
                .println("Label Before Click-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetAjaxCall').get('label')"));
        selenium.click("form:initialValues:widgetAjaxCall");
        System.out.println("*********Button Got Clicked**********");
        String labelAfterClick = selenium
                .getEval("window.dijit.byId('form:initialValues:widgetAjaxCall').get('label')");
        System.out
                .println("Label After Click-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetAjaxCall').get('label')"));
        if ((!(labelBeforeClick.equals(labelAfterClick))))
            System.out.println("******Testcase Passed.******");
        else
            System.out.println("******Testcase Failed.******");
    }
}