/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.gadget.progressbar;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import org.dojoserverfaces.tests.widget.values.VariableName;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

public class ProgressBarSelenium extends SeleniumTestCase {
    
protected WidgetValues widgetValues;
    
    public ProgressBarSelenium() {
        this.widgetValues = new ProgressBarValues();
        this.widgetInteraction = new ProgressBarInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;
    
    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                ProgressBarSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/gadget/progressbar/index.jsf");
        }
    }
    
    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The element 'indeterminate' is not present",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:progressbar').get('indeterminate')"));
        System.out
                .println("Indeterminate ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:progressbar').get('indeterminate')"));
        verifyEquals(
                "The element 'maximum' is not present",
                "1",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:progressbar').get('maximum')"));
        System.out
                .println("Maximum ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:progressbar').get('maximum')"));
        verifyEquals(
                "The element 'style' is not present",
                "width:300px;height:14px",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:progressbar').get('style')"));
        System.out
                .println("Style ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:progressbar').get('style')"));
    }
    
    public void testProgressBar() throws Exception {
        waitForDojoReady();
        String valueBeforeClick = selenium.getEval("window.dijit.byId('form:ajaxRefresh:progressbar').get('label')");
        selenium.click("form:ajaxRefresh:button");
        String valueAfterClick = selenium.getEval("window.dijit.byId('form:ajaxRefresh:progressbar').get('label')");
        if (!(valueBeforeClick.equals(valueAfterClick)))
            System.out.println("******Testcase Passed.******");
        else
            System.out.println("******Testcase Failed.******");
    }
}