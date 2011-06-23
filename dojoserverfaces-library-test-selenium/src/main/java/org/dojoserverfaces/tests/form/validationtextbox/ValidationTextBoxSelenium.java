/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.validationtextbox;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import org.dojoserverfaces.tests.widget.values.VariableName;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ValidationTextBoxSelenium extends SeleniumTestCase {

    protected WidgetValues widgetValues;
    
    public ValidationTextBoxSelenium() {
        this.widgetValues = new ValidationTextBoxValues();
        this.widgetInteraction = new ValidationTextBoxInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                ValidationTextBoxSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/form/validationtextbox/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The attribute 'regExp' could was not set as expected",
                "\\d{5}",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('regExp')"));
        System.out
                .println("RegExp is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('regExp')"));
        verifyEquals(
                "The attribute 'required' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('required')"));
        System.out
                .println("Required is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('required')"));
        verifyEquals(
                "The attribute 'promptMessage' could was not set as expected",
                "Regular Expression: \\d{5}",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('promptMessage')"));
        System.out
                .println("PromptMessage is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('promptMessage')"));
        verifyEquals(
                "The attribute 'missingMessage' could was not set as expected",
                "This value is required.",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('missingMessage')"));
        System.out
                .println("MissingMessage is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('missingMessage')"));
        verifyEquals(
                "The attribute 'invalidMessage' could was not set as expected",
                "The value entered is not valid.",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('invalidMessage')"));
        System.out
                .println("InvalidMessage is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('invalidMessage')"));
        verifyEquals(
                "The attribute 'tooltipPosition' could was not set as expected",
                "above",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tooltipPosition')"));
        System.out
                .println("TooltipPosition is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tooltipPosition')"));
    }

    public void testAjaxRefresh() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "Initial value of the component for facesMessageRegistration did not match.",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:ajaxRefresh:widgetAjaxCall"));

        widgetInteraction.setDisplayedValue("form:ajaxRefresh:widgetAjaxCall",
                VariableName.SECOND);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals("Custom validation message was not shown.",
                "You entered an invalid text.", selenium
                        .getText("form:ajaxRefresh:errMsgTextBoxFacesMessage"));
        verifyEquals(
                "The value should still be persisted, in case of required attribute, but it was not",
                widgetValues.getSeleniumValues(VariableName.SECOND),
                widgetInteraction
                        .getDisplayedValue("form:ajaxRefresh:widgetAjaxCall"));

        // set correct value now, and check for removal of validation error.
        widgetInteraction.setDisplayedValue("form:ajaxRefresh:widgetAjaxCall",
                VariableName.FIRST);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyFalse(
                "Error message should not be shown for the correct value",
                selenium
                        .isTextPresent("form:ajaxRefresh:errMsgTextBoxFacesMessage"));
        verifyEquals("The entered value should be persisted.", widgetValues
                .getSeleniumValues(VariableName.FIRST), widgetInteraction
                .getDisplayedValue("form:ajaxRefresh:widgetAjaxCall"));
    }
}