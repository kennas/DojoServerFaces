/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.behavior.faidinout;

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

public class FadeinFadeoutSelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                FadeinFadeoutSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/behavior/fadeinout/fadeinout.jsf");
        }
    }

    public void testFadeout() throws Exception {
        waitForDojoReady();
        XPath xpath = XPathFactory.newInstance().newXPath();
        Document doc = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(
                        "http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/behavior/fadeinout/fadeinout.xhtml");
        String id = selenium
                .getEval("window.dijit.byId('form:initialValues:form1:portletA').get('id')");
        String id1 = id.substring(19);
        String target = xpath.evaluate("//behaviorFadeOut/@target", doc);
        if (!(target.equals(id1))) {
            FacesMessage message = new FacesMessage(
                    "valid component not found with id " + target);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        else {
        verifyEquals("true", selenium.isVisible("form:initialValues:form1:portletA"));
        selenium.click("form:initialValues:buttonB");
        verifyEquals("false", selenium.isVisible("form:initialValues:form1:portletA"));
        }
    }

    public void testFadein() throws Exception {
        waitForDojoReady();
        XPath xpath = XPathFactory.newInstance().newXPath();
        Document doc = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(
                        "http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/behavior/fadeinout/fadeinout.xhtml");
        String id = selenium
                .getEval("window.dijit.byId('form:initialValues:form1:portletA').get('id')");
        String id1 = id.substring(19);
        String target = xpath.evaluate("//behaviorFadeIn/@target", doc);
        if (!(target.equals(id1))) {
            FacesMessage message = new FacesMessage(
                    "valid component not found with id " + target);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        else {
        verifyEquals("false", selenium.isVisible("form:initialValues:form1:portletA"));
        selenium.click("form:initialValues:buttonA");
        verifyEquals("true", selenium.isVisible("form:initialValues:form1:portletA"));
        }
    }
}