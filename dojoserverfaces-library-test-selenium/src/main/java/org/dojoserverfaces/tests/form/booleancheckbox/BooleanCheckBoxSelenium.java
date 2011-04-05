/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.booleancheckbox;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.dojoserverfaces.SingleValuedComponentSelenium;
import junit.framework.Test;
import junit.framework.TestSuite;

public class BooleanCheckBoxSelenium extends SingleValuedComponentSelenium {

    public BooleanCheckBoxSelenium() {
        this.widgetValues = new BooleanCheckBoxValues();
        this.widgetInteraction = new BooleanCheckBoxInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                BooleanCheckBoxSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/form/booleanCheckBox/index.jsf");
        }
    }

    @Override
    protected void checkForBadValueInConverter() {
        // do nothing.
    }

    @Override
    protected void checkEmptyConditionRequiredValidator() {
        // do nothing.
    }

    @Override
    protected void checkEmptySubmittedValueNull() {
        // do nothing.
    }

    @Override
    protected void checkRequiredAttribute() {
        // do nothing.
    }

    @Override
    protected void checkWithMultipleValidatorsEmptyCondition() {
        // do nothing.
    }

    @Override
    public void testEmptySubmitConditionParamFalse() throws Exception {
        // do nothing.
    }
}