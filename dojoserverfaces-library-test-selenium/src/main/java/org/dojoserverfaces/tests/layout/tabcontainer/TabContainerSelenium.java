/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.layout.tabcontainer;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.dojoserverfaces.LayoutComponentSelenium;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TabContainerSelenium extends LayoutComponentSelenium {

    public TabContainerSelenium() {
        this.widgetValues = new TabContainerValues();
        this.widgetInteraction = new TabContainerInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                TabContainerSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/layout/tabContainer/index.jsf");
        }
    }

    public void testSelfProperties() {
        try {
            waitForDojoReady();
            verifyEquals(
                    "The attribute 'tooltip' could was not set as expected",
                    "This is Tab Container.",
                    selenium
                            .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tooltip')"));
            System.out
                    .println("Tooltip is----->>>>"
                            + selenium
                                    .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tooltip')"));
            verifyEquals(
                    "The attribute 'nested' could was not set as expected",
                    "true",
                    selenium
                            .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('nested')"));
            System.out
                    .println("Nested is----->>>>"
                            + selenium
                                    .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('nested')"));
            verifyEquals(
                    "The attribute 'tabPosition' could was not set as expected",
                    "top",
                    selenium
                            .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tabPosition')"));
            System.out
                    .println("TabPosition is----->>>>"
                            + selenium
                                    .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tabPosition')"));
            verifyEquals(
                    "The attribute 'tabStrip' could was not set as expected",
                    "true",
                    selenium
                            .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tabStrip')"));
            System.out
                    .println("TabStrip is----->>>>"
                            + selenium
                                    .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tabStrip')"));
            verifyEquals(
                    "The attribute 'useMenu' could was not set as expected",
                    "true",
                    selenium
                            .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('useMenu')"));
            System.out
                    .println("UseMenu is----->>>>"
                            + selenium
                                    .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('useMenu')"));
            verifyEquals(
                    "The attribute 'useSlider' could was not set as expected",
                    "true",
                    selenium
                            .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('useSlider')"));
            System.out
                    .println("UseSlider is----->>>>"
                            + selenium
                                    .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('useSlider')"));
        }
        catch (Exception e) {
            System.err.println("!!!Testcase for TabContainer has failed!!!");
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void testInheritedStackContainerProperties() {
        try {
            waitForDojoReady();
            verifyEquals(
                    "The element 'persist' is not present",
                    "true",
                    selenium
                            .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('persist')"));
            System.out
                    .println("Persist is----->>>>"
                            + selenium
                                    .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('persist')"));
            verifyEquals(
                    "The element 'doLayout' is not present",
                    "true",
                    selenium
                            .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('doLayout')"));
            System.out
                    .println("DoLayout is----->>>>"
                            + selenium
                                    .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('doLayout')"));
            verifyEquals(
                    "The element 'showTitle' is not present",
                    "true",
                    selenium
                            .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('showTitle')"));
            System.out
                    .println("ShowTitle is----->>>>"
                            + selenium
                                    .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('showTitle')"));
        }
        catch (Exception e) {
            System.err.println("!!!Testcase for TabContainer has failed!!!");
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void testInheritedLayoutComponentsProperties() {
        try {
            waitForDojoReady();
            verifyEquals(
                    "The attribute 'title' could was not set as expected",
                    widgetValues.getSimpleValue(),
                    selenium
                            .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('title')"));
            System.out
                    .println("Title is----->>>>"
                            + selenium
                                    .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('title')"));
            verifyEquals(
                    "The attribute 'style' could was not set as expected",
                    "width: 400px; height: 100px;",
                    selenium
                            .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
            System.out
                    .println("Style is----->>>>"
                            + selenium
                                    .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
        }
        catch (Exception e) {
            System.err.println("!!!Testcase for TabContainer has failed!!!");
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void testAjaxRefresh() throws Exception {
        waitForDojoReady();
        String titleBeforeClick = selenium
                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('title')");
        String valueBeforeClick = selenium
                .getEval("window.document.getElementById('form:ajaxRefresh:text1').innerHTML");
        System.out
                .println("Title Before Click-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('title')"));
        System.out
                .println("Value Before Click-------->>>>>"
                        + selenium
                                .getEval("window.document.getElementById('form:ajaxRefresh:text1').innerHTML"));
        selenium.click("form:ajaxRefresh:myButton1");
        System.out.println("*********Button Got Clicked**********");
        String titleAfterClick = selenium
                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('title')");
        String valueAfterClick = selenium
                .getEval("window.document.getElementById('form:ajaxRefresh:text1').innerHTML");
        System.out
                .println("Title After Click-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('title')"));
        System.out
                .println("Value After Click-------->>>>>"
                        + selenium
                                .getEval("window.document.getElementById('form:ajaxRefresh:text1').innerHTML"));
        if ((!(titleBeforeClick.equals(titleAfterClick)))
                && (!(valueBeforeClick.equals(valueAfterClick))))
            System.out.println("******Testcase Passed.******");
        else
            System.out.println("******Testcase Failed.******");
    }
}