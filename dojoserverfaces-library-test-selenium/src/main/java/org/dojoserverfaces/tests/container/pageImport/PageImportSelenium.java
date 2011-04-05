/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.container.pageImport;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.dojoserverfaces.LayoutComponentSelenium;
import junit.framework.Test;
import junit.framework.TestSuite;

public class PageImportSelenium extends LayoutComponentSelenium {

    public PageImportSelenium() {
        this.widgetValues = new PageImportValues();
        this.widgetInteraction = new PageImportInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                PageImportSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/container/pageImport/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The attribute 'adjustPaths' could was not set as expected",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('adjustPaths')"));
        System.out
                .println("AdjustPaths is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('adjustPaths')"));
        verifyEquals(
                "The element 'tooltip' is not present",
                "This is Page Import.",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tooltip')"));
        System.out
                .println("Tooltip ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tooltip')"));
        verifyEquals(
                "The attribute 'cleanContent' could was not set as expected",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('cleanContent')"));
        System.out
                .println("CleanContent is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('cleanContent')"));
        verifyEquals(
                "The attribute 'scriptHasHooks' could was not set as expected",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('scriptHasHooks')"));
        System.out
                .println("ScriptHasHooks is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('scriptHasHooks')"));
        verifyEquals(
                "The attribute 'renderStyles' could was not set as expected",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('renderStyles')"));
        System.out
                .println("RenderStyles is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('renderStyles')"));
        verifyEquals(
                "The attribute 'executeScripts' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('executeScripts')"));
        System.out
                .println("ExecuteScripts is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('executeScripts')"));
        verifyEquals(
                "The attribute 'doLayout' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('doLayout')"));
        System.out
                .println("DoLayout is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('doLayout')"));
        verifyEquals(
                "The attribute 'errorMessage' could was not set as expected",
                "PageImport couldn't be loaded.",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('errorMessage')"));
        System.out
                .println("ErrorMessage is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('errorMessage')"));
        verifyEquals(
                "The attribute 'loadingMessage' could was not set as expected",
                "PageImport is Loading.",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('loadingMessage')"));
        System.out
                .println("LoadingMessage is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('loadingMessage')"));
        verifyEquals(
                "The attribute 'extractContent' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('extractContent')"));
        System.out
                .println("ExtractContent is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('extractContent')"));
        verifyEquals(
                "The attribute 'preLoad' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('preLoad')"));
        System.out
                .println("PreLoad is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('preLoad')"));
        verifyEquals(
                "The attribute 'preventCache' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('preventCache')"));
        System.out
                .println("PreventCache is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('preventCache')"));
        verifyEquals(
                "The attribute 'refreshOnShow' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('refreshOnShow')"));
        System.out
                .println("RefreshOnShow is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('refreshOnShow')"));
    }

    public void testInheritedLayoutComponentsProperties() {
        waitForDojoReady();
        verifyEquals(
                "The attribute 'style' could was not set as expected",
                "border: 2px solid black;",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
        System.out
                .println("Style is----->>>>"
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
        if (!(valueBeforeClick.equals(valueAfterClick)))
            System.out.println("******Testcase Passed.******");
        else
            System.out.println("******Testcase Failed.******");
    }
}