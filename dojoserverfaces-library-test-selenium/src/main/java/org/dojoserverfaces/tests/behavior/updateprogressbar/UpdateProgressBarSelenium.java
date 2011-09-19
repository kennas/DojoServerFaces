package org.dojoserverfaces.tests.behavior.updateprogressbar;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;

public class UpdateProgressBarSelenium extends SeleniumTestCase {
 
    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                UpdateProgressBarSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/behavior/updateprogressbar/updateprogressbar.jsf");
        }
    }
    
    public void testUpdateProgressBar() throws Exception {
        waitForDojoReady();
        String valueBeforeClick = selenium.getEval("window.dijit.byId('form:initialValues:progressbar').get('maximum')");
        selenium.click("form:initialValues:fetchData");
        String valueAfterClick = selenium.getEval("window.dijit.byId('form:initialValues:progressbar').get('maximum')");
        if (!(valueBeforeClick.equals(valueAfterClick)))
            System.out.println("******Testcase Passed.******");
        else
            System.out.println("******Testcase Failed.******");
    }
}
