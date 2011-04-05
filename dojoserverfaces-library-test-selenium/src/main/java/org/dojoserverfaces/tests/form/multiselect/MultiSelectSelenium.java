/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.multiselect;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.dojoserverfaces.MultiValuedComponentSelenium;
import junit.framework.Test;
import junit.framework.TestSuite;

public class MultiSelectSelenium extends MultiValuedComponentSelenium {

    public MultiSelectSelenium() {
        this.widgetValues = new MultiSelectValues();
        this.widgetInteraction = new MultiSelectInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                MultiSelectSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/form/multiSelect/index.jsf");
        }
    }

    @Override
    protected void checkEmptyConditionRequiredValidator() {
    }

    protected void checkEmptySubmittedValueNull() {
    }

    @Override
    protected void checkRequiredAttribute() {
    }

    @Override
    public void testEmptySubmitConditionParamFalse() throws Exception {
    }
}