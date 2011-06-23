/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.behavior.disabledreadonly;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import org.w3c.dom.Document;

import junit.framework.Test;
import junit.framework.TestSuite;

public class DisabledReadOnlySelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                DisabledReadOnlySelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/behavior/setdisabledreadonly/setdisabledreadonly.jsf");
        }
    }

    public void testReadOnly() throws Exception {
        waitForDojoReady();
        XPath xpath = XPathFactory.newInstance().newXPath();
        Document doc = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(
                        "http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/behavior/setdisabledreadonly/setdisabledreadonly.xhtml");
        String id = selenium
                .getEval("window.dijit.byId('form:initialValues:form1:textB').get('id')");
        String id1 = id.substring(19);
        String target = xpath.evaluate("//behaviorSetReadonly/@target", doc);
        if (!(target.equals(id1))) {
            FacesMessage message = new FacesMessage(
                    "valid component not found with id " + target);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        else {
        selenium.click("form:initialValues:textBoxReadOnly");
        verifyEquals(
                "The attribute 'readOnly' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:form1:textB').get('readOnly')"));
        selenium.click("form:initialValues:textBoxWritable");
        verifyEquals(
                "The attribute 'readOnly' could was not set as expected",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:form1:textB').get('readOnly')"));
        }
    }

    public void testDisabled() throws Exception {
        waitForDojoReady();
        XPath xpath = XPathFactory.newInstance().newXPath();
        Document doc = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(
                        "http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/behavior/setdisabledreadonly/setdisabledreadonly.xhtml");
        String id = selenium
                .getEval("window.dijit.byId('form:initialValues:form1:buttonA').get('id')");
        String id1 = id.substring(19);
        String target = xpath.evaluate("//behaviorSetDisabled/@target", doc);
        if (!(target.equals(id1))) {
            FacesMessage message = new FacesMessage(
                    "valid component not found with id " + target);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        else {
        selenium.click("form:initialValues:textBoxDisable");
        verifyEquals(
                "The attribute 'disabled' for textbox could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:form1:textB').get('disabled')"));
        selenium.click("form:initialValues:textBoxEnable");
        verifyEquals(
                "The attribute 'disabled' for textbox could was not set as expected",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:form1:textB').get('disabled')"));
        selenium.click("form:initialValues:buttonDisable");
        verifyEquals(
                "The attribute 'disabled' for button could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:form1:buttonA').get('disabled')"));
        selenium.click("form:initialValues:buttonEnable");
        verifyEquals(
                "The attribute 'disabled' for button could was not set as expected",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:form1:buttonA').get('disabled')"));
        }
    }
}