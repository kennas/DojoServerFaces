/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.behavior.displayvisible;

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

public class DisplayVisibleSelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                DisplayVisibleSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/behavior/setdisplayvisible/setdisplayvisible.jsf");
        }
    }

    public void testDisplay() throws Exception {
        waitForDojoReady();
        XPath xpath = XPathFactory.newInstance().newXPath();
        Document doc = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(
                        "http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/behavior/setdisplayvisible/setdisplayvisible.xhtml");
        String id = selenium
                .getEval("window.dijit.byId('form:initialValues:form1:paneOne').get('id')");
        String id1 = id.substring(19);
        String target = xpath.evaluate("//behaviorSetDisplay/@target", doc);
        if (!(target.equals(id1))) {
            FacesMessage message = new FacesMessage(
                    "valid component not found with id " + target);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        else {
        // when setDisplay value set to false
        selenium.click("form:initialValues:button1");
        verifyEquals("false", selenium.isVisible("form:initialValues:form1:paneOne"));
        verifyEquals("false", selenium.isVisible("testDiv"));
        // when setDisplay value set to true
        selenium.click("form:initialValues:button2");
        verifyEquals("true", selenium.isVisible("form:initialValues:form1:paneOne"));
        verifyEquals("true", selenium.isVisible("testDiv"));
        }
    }

    public void testVisible() throws Exception {
        waitForDojoReady();
        XPath xpath = XPathFactory.newInstance().newXPath();
        Document doc = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(
                        "http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/behavior/setdisplayvisible/setdisplayvisible.xhtml");
        String id = selenium
                .getEval("window.dijit.byId('form:initialValues:form1:paneOne').get('id')");
        String id1 = id.substring(19);
        String target = xpath.evaluate("//behaviorSetVisible/@target", doc);
        if (!(target.equals(id1))) {
            FacesMessage message = new FacesMessage(
                    "valid component not found with id " + target);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        else {
        // when setVisible value set to false
        selenium.click("form:initialValues:button3");
        verifyEquals("false", selenium.isVisible("form:initialValues:form1:paneOne"));
        verifyEquals("false", selenium.isVisible("testDiv"));
        // when setVisible value set to true
        selenium.click("form:initialValues:button4");
        verifyEquals("true", selenium.isVisible("form:initialValues:form1:paneOne"));
        verifyEquals("true", selenium.isVisible("testDiv"));
        }
    }
}