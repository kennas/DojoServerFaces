/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.select;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.dojoserverfaces.SingleValuedComponentSelenium;
import org.dojoserverfaces.tests.widget.values.VariableName;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SelectSelenium extends SingleValuedComponentSelenium {

    public SelectSelenium() {
        this.widgetValues = new SelectValues();
        this.widgetInteraction = new SelectInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                SelectSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/form/select/index.jsf");
        }
    }

    protected void checkEmptyConditionRequiredValidator() {

    }

    protected void checkEmptySubmittedValueNull() {

    }

    protected void checkRequiredAttribute() {

    }

    protected void checkWithMultipleValidatorsEmptyCondition() {

    }

    protected void checkForBadValueInConverter() {

    }

    public void testEmptySubmitConditionParamFalse() throws Exception {

    }

    @Override
    protected void checkForReadOnly() throws Exception {
        // Verify ReadOnly
        verifyEquals(
                "The Initial value of the readonly component was not correct.",
                widgetValues.getDisplayedValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:readonlyDisabled:widgetReadOnly"));
        verifyFalse("The component could not be set readonly", selenium
                .isEditable("form:readonlyDisabled:widgetReadOnly"));
    }
}