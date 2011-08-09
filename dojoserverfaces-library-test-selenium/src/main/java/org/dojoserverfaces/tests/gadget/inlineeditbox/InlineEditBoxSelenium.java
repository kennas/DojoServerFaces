/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.gadget.inlineeditbox;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import org.dojoserverfaces.tests.widget.values.VariableName;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

import junit.framework.Test;
import junit.framework.TestSuite;

public class InlineEditBoxSelenium extends SeleniumTestCase {

    protected WidgetValues widgetValues;

    public InlineEditBoxSelenium() {
        this.widgetValues = new InlineEditBoxValues();
        this.widgetInteraction = new InlineEditBoxInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                InlineEditBoxSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/gadget/inlineeditbox/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The attribute 'autoSave' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('autoSave')"));
        System.out
                .println("AutoSave is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('autoSave')"));
        verifyEquals(
                "The attribute 'renderAsHtml' could was not set as expected",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('renderAsHtml')"));
        System.out
                .println("RenderAsHtml is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('renderAsHtml')"));
        verifyEquals(
                "The attribute 'editing' could was not set as expected",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('editing')"));
        System.out
                .println("Editing is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('editing')"));
        verifyEquals(
                "The attribute 'noValueIndicator' could was not set as expected",
                "edit here",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('noValueIndicator')"));
        System.out
                .println("NoValueIndicator is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('noValueIndicator')"));
        verifyEquals(
                "The attribute 'width' could was not set as expected",
                "700px",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('width')"));
        System.out
                .println("Width is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('width')"));
    }

    public void testAjaxRefresh() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The value of the component having f:ajax call did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:ajaxRefresh:description"));
        // Verify Ajax call to update bean value.
        widgetInteraction.setDisplayedValue("form:ajaxRefresh:description",
                VariableName.SECOND);
        selenium.click("form:ajaxRefresh:button");
        verifyEquals(
                "The component's value did not change even after entering new value",
                widgetValues.getSeleniumValues(VariableName.SECOND),
                widgetInteraction
                        .getDisplayedValue("form:ajaxRefresh:description"));
        waitForTextToChange(
                "The Ajax call to update bean value was not successful",
                widgetValues.getValues(VariableName.SECOND),
                "form:ajaxRefresh:result");
    }
}