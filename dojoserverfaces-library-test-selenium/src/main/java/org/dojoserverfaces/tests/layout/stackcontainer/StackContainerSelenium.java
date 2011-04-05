/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.layout.stackcontainer;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.dojoserverfaces.LayoutComponentSelenium;
import junit.framework.Test;
import junit.framework.TestSuite;

public class StackContainerSelenium extends LayoutComponentSelenium {

    public StackContainerSelenium() {
        this.widgetValues = new StackContainerValues();
        this.widgetInteraction = new StackContainerInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                StackContainerSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/layout/stackContainer/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The element 'persist' is not present",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('persist')"));
        System.out
                .println("Persist is-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('persist')"));
        verifyEquals(
                "The element 'doLayout' is not present",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('doLayout')"));
        System.out
                .println("DoLayout is-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('doLayout')"));
        verifyEquals(
                "The element 'tooltip' is not present",
                "This is Stack Container.",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tooltip')"));
        System.out
                .println("Tooltip is-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tooltip')"));
        verifyEquals(
                "The element 'showTitle' is not present",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('showTitle')"));
        System.out
                .println("ShowTitle is-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('showTitle')"));
    }

    public void testInheritedLayoutComponentsProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The attribute 'title' could was not set as expected",
                widgetValues.getSimpleValue(),
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('title')"));
        System.out
                .println("Title is-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('title')"));
        verifyEquals(
                "The attribute 'style' could was not set as expected",
                "width: 400px; height: 100px;",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
        System.out
                .println("Style is-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
    }

    public void testAjaxRefresh() throws Exception {
        waitForDojoReady();
        String valueBeforeClick = selenium
                .getEval("window.document.getElementById('form:ajaxRefresh:text1').innerHTML");
        System.out
                .println("Value Before Click-------->>>>>"
                        + selenium
                                .getEval("window.document.getElementById('form:ajaxRefresh:text1').innerHTML"));
        selenium.click("form:ajaxRefresh:myButton1");
        System.out.println("*********Button Got Clicked**********");
        String valueAfterClick = selenium
                .getEval("window.document.getElementById('form:ajaxRefresh:text1').innerHTML");
        System.out
                .println("Value After Click-------->>>>>"
                        + selenium
                                .getEval("window.document.getElementById('form:ajaxRefresh:text1').innerHTML"));
        if ((!(valueBeforeClick.equals(valueAfterClick))))
            System.out.println("******Testcase Passed.******");
        else
            System.out.println("******Testcase Failed.******");
    }
}