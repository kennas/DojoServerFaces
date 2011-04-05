/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.selenium.dojoserverfaces;

import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import org.dojoserverfaces.tests.widget.values.VariableName;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

/**
 * This class works a base class for SingleValuedComponents like TextBox,
 * TimeTextBox.. etc. and provides test functions for them. Individual
 * components may override few test functions to add or remove some
 * functionality.
 * 
 * The test-cases are based on displaying the value of a managed-bean through
 * some component like h:outputText on the same page. So that we are able to
 * check the state of the managed bean.
 * 
 * @author "jatin.varshney@in.ibm.com"
 * 
 */

public abstract class SingleValuedComponentSelenium extends SeleniumTestCase {

    protected WidgetValues widgetValues;

    /**
     * Test if the initial values of components bound to managed bean are
     * reflected properly in the output.
     * 
     * @throws Exception
     */
    public void testInitialValues() throws Exception {
        waitForDojoReady();
        // Verify initial values- bound to managed bean, EL, properties file
        verifyEquals("The simple value through the attribute did not match",
                widgetValues.getSimpleValue(), widgetInteraction
                        .getDisplayedValue("form:initialValues:widgetSimple"));
        verifyEquals(
                "The value bound to the managed bean did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:initialValues:widgetBeanBoundValue"));
        verifyEquals(
                "The value bound to the managed bean with immediate evaluation did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:initialValues:widgetBeanBoundValueImmediate"));
        verifyFalse(
                "The component with attribute rendered='false' was shown",
                selenium
                        .isElementPresent("form:initialValues:widgetRenderedFalse"));
    }

    /**
     * Test if the component is rendered properly inside a container.
     * 
     * @throws Exception
     */
    public void testInsideContainer() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The value of the component inside panel did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:insideContainer:widgetInsidePanel"));
        verifyFalse(
                "The component having attribute rendered='false' of its parent was rendered",
                selenium
                        .isElementPresent("form:insideContainer:widgetInsidePanelRenderedFalse"));
    }

    /**
     * Test if the component is rendered and functions properly inside a
     * repeatable container, like <h:dataTable/>.
     * 
     * @throws Exception
     */
    public void testInsideRepeatable() throws Exception {
        waitForDojoReady();
        // Verify textboxes are rendered inside data table
        String dataTableId = "//table[@id='form:insideRepeatable:dataTable1']";
        verifyTrue("DataTable should be present", selenium
                .isElementPresent("form:insideRepeatable:dataTable1"));
        Number rowCount = selenium.getXpathCount(dataTableId + "//tr");
        verifyEquals("DataTable should have 4 rows", 4, rowCount.intValue());
        verifyTrue("Each row must have a widget", widgetInteraction
                .isElementPresentAsChild(dataTableId + "//tbody//tr[1]//td"));
        // Verify values inside these textboxes
        verifyEquals(
                "The contents of the first component inside datatable did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction.getDisplayedValueFromParentXPath(dataTableId
                        + "//tbody//tr[1]//td"));
        verifyEquals(
                "The contents of the second component inside datatable did not match",
                widgetValues.getSeleniumValues(VariableName.SECOND),
                widgetInteraction.getDisplayedValueFromParentXPath(dataTableId
                        + "//tbody//tr[2]//td"));
        verifyEquals(
                "The contents of the third component inside datatable did not match",
                widgetValues.getSeleniumValues(VariableName.THIRD),
                widgetInteraction.getDisplayedValueFromParentXPath(dataTableId
                        + "//tbody//tr[3]//td"));
        verifyEquals(
                "The contents of the fourth component inside datatable did not match",
                widgetValues.getSeleniumValues(VariableName.FOURTH),
                widgetInteraction.getDisplayedValueFromParentXPath(dataTableId
                        + "//tbody//tr[4]//td"));

        // Verify textboxes are not rendered inside data table [rendered=false]
        verifyFalse("DataTable should not be rendered", selenium
                .isElementPresent("form:dataTable2"));

        // test value submission of components inside dataTable
        dataTableId = "//table[@id='form:insideRepeatable:dataTableValuesSubmit']";
        widgetInteraction.setDisplayedValueFromParentXPath(dataTableId
                + "//tbody//tr[1]//td", VariableName.THIRD);
        widgetInteraction.setDisplayedValueFromParentXPath(dataTableId
                + "//tbody//tr[2]//td", VariableName.FOURTH);
        clickAndwaitForPageLoad("form:insideRepeatable:submitTableValuesBtn");
        verifyEquals(
                "The values of the components inside dataTable could not be submitted",
                widgetValues.getValues(VariableName.THIRD, VariableName.FOURTH),
                selenium
                        .getText("form:insideRepeatable:panelGroupDataTableValuesSubmit"));

        // test value submission of components inside dataTable using f:ajax
        dataTableId = "//table[@id='form:insideRepeatable:dataTableAjax']";
        widgetInteraction.setDisplayedValueFromParentXPath(dataTableId
                + "//tbody//tr[1]//td", VariableName.THIRD);
        selenium.click("getFocusBtn");
        waitForTextToChange(
                "The value of the component inside dataTable could not be submitted using f:ajax",
                widgetValues.getValues(VariableName.THIRD, VariableName.SECOND),
                "form:insideRepeatable:panelGroupAjax");

        widgetInteraction.setDisplayedValueFromParentXPath(dataTableId
                + "//tbody//tr[2]//td", VariableName.FOURTH);
        selenium.click("getFocusBtn");
        waitForTextToChange(
                "The value of the component inside dataTable could not be submitted using f:ajax",
                widgetValues.getValues(VariableName.FIRST, VariableName.FOURTH),
                "form:insideRepeatable:panelGroupAjax");

        // test value submission of components inside dataTable using f:ajax,
        // table has other components also
        dataTableId = "//table[@id='form:insideRepeatable:dataTableMultiComp']";
        widgetInteraction.setDisplayedValueFromParentXPath(dataTableId
                + "//tbody//tr[1]//td", VariableName.THIRD);
        selenium.click("getFocusBtn");
        waitForTextToChange(
                "The value of the component inside dataTable could not be submitted using f:ajax, (table has other components)",
                widgetValues.getValues(VariableName.THIRD, VariableName.SECOND),
                "form:insideRepeatable:panelGroupMultiAjax");

        widgetInteraction.setDisplayedValueFromParentXPath(dataTableId
                + "//tbody//tr[2]//td", VariableName.FOURTH);
        selenium.click("getFocusBtn");
        waitForTextToChange(
                "The value of the components inside dataTable could not be submitted using f:ajax (table has other components)",
                widgetValues.getValues(VariableName.FIRST, VariableName.FOURTH),
                "form:insideRepeatable:panelGroupMultiAjax");

    }

    /**
     * Test if f:ajax request can be invoked properly on the component.
     * 
     * @throws Exception
     */
    public void testAjaxRefresh() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The value of the component having f:ajax call did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:ajaxRefresh:widgetAjaxCall"));
        // Verify Ajax call to update bean value.
        widgetInteraction.setDisplayedValue("form:ajaxRefresh:widgetAjaxCall",
                VariableName.SECOND);
        selenium.click("getFocusBtn");
        verifyEquals(
                "The component's value did not change even after entering new value",
                widgetValues.getSeleniumValues(VariableName.SECOND),
                widgetInteraction
                        .getDisplayedValue("form:ajaxRefresh:widgetAjaxCall"));
        waitForTextToChange(
                "The Ajax call to update bean value was not successful",
                widgetValues.getValues(VariableName.SECOND),
                "form:ajaxRefresh:outputAjaxCall");
    }

    /**
     * Test if the component refreshes its value properly, when its a target of
     * ajax refresh of another component on the page.
     * 
     * @throws Exception
     */
    public void testTargetAjaxRefresh() throws Exception {
        waitForDojoReady();
        // Verify Target of Ajax refresh when previously not rendered
        verifyFalse(
                "Component with rendered attribute set to false(also target of ajax refresh) should not be rendered",
                selenium
                        .isElementPresent("form:targetAjaxRefresh:widgetTargetAjax"));
        selenium.click("form:targetAjaxRefresh:toggleButton");
        waitForExistence("The component could not be redered",
                "form:targetAjaxRefresh:widgetTargetAjax");
        verifyEquals(
                "The component was either not rendered or did not have correct value",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:targetAjaxRefresh:widgetTargetAjax"));

        verifyEquals(
                "The value of the component,(target of ajax refresh) did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:targetAjaxRefresh:widgetTargetAjaxRefresh"));
        // Verify Target of Ajax refresh to change value
        selenium
                .click("form:targetAjaxRefresh:btnChangeTargetAjaxRefreshValue");
        waitForValueToChange(
                "The Ajax refresh could not update the components value",
                widgetValues.getSeleniumValues(VariableName.SECOND),
                "form:targetAjaxRefresh:widgetTargetAjaxRefresh");
    }

    /**
     * Test if the state of the component is saved properly, for non-transient
     * component.
     * 
     * @throws Exception
     */
    public void testStateSaving() throws Exception {
        waitForDojoReady();
        // State saving for transient component
        verifyEquals("The value of the transient component did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:stateSaving:widgetTransient"));
        widgetInteraction.setDisplayedValue("form:stateSaving:widgetTransient",
                VariableName.SECOND);
        clickAndwaitForPageLoad("form:stateSaving:testTransientStateBtn");
        verifyEquals("Transient component's state should not be saved.",
                "true", selenium
                        .getText("form:stateSaving:outputTransientState"));

        // State saving for non-transient component.
        verifyEquals("The value of the component did not match", widgetValues
                .getSeleniumValues(VariableName.FIRST), widgetInteraction
                .getDisplayedValue("form:stateSaving:widgetFull"));
        widgetInteraction.setDisplayedValue("form:stateSaving:widgetFull",
                VariableName.SECOND);
        clickAndwaitForPageLoad("form:stateSaving:testFullStateBtn");
        verifyEquals("The component's state was not saved", "true", selenium
                .getText("form:stateSaving:outputFullState"));
    }

    /**
     * Test is the component works properly if it has both client side event
     * handler and f:ajax handler for a particular event.
     * 
     * @throws Exception
     */
    public void testClientEvents() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The value of the component having both client side and f:ajax handlers did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:clientEvents:widgetClient"));
        // Verify Client side events
        widgetInteraction.setDisplayedValue("form:clientEvents:widgetClient",
                VariableName.SECOND);
        selenium.click("getFocusBtn");
        waitForTextToChange("The Client side javascript handler did not work",
                widgetValues.getValues(VariableName.SECOND),
                "form:clientEvents:outputClient");
        waitForTextToChange("The f:ajax action was not successful",
                widgetValues.getValues(VariableName.SECOND),
                "form:clientEvents:outputClient2");
    }

    /***************** TEST EDITABLE VALUE HOLDER *********************************/

    /**
     * Test if the components can be set readonly and disabled.
     */
    public void testReadOnlyDisabled() throws Exception {
        waitForDojoReady();
        checkForReadOnly();
        checkForDisabled();
    }

    /**
     * Test if the component is readonly.
     * 
     * @throws Exception
     */
    protected void checkForReadOnly() throws Exception {
        // Verify ReadOnly
        verifyEquals(
                "The Initial value of the readonly component was not correct.",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:readonlyDisabled:widgetReadOnly"));
        verifyFalse("The component could not be set readonly", selenium
                .isEditable("form:readonlyDisabled:widgetReadOnly"));
    }

    /**
     * Test if the component is disabled.
     * 
     * @throws Exception
     */
    protected void checkForDisabled() throws Exception {
        // Disabled Element should not emit/receive events
        verifyEquals("Initial value of disabled component was not correct",
                widgetValues.getSeleniumValues(VariableName.FIRST), selenium
                        .getValue("form:readonlyDisabled:widgetDisabled"));
        selenium.click("form:readonlyDisabled:widgetDisabled");
        verifyEquals("Disabled component should not receive user events",
                "Should not change on client event", selenium
                        .getText("form:readonlyDisabled:outputDisabled"));
    }

    /**
     * Test if the value of the component is converted properly, upon form
     * submission.
     * 
     * @throws Exception
     */
    public void testConverters() throws Exception {
        waitForDojoReady();
        // Verify converters
        verifyEquals(
                "Initial value of the component having converter did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:converter:widgetConverter"));
        verifyEquals(
                "Initial bean bound value of the component having converter did not match",
                "0", selenium.getText("form:converter:outputConverter"));

        checkForBadValueInConverter();

        widgetInteraction.setDisplayedValue("form:converter:widgetConverter",
                VariableName.SECOND);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals("The value did not converted properly", "1", selenium
                .getText("form:converter:outputConverter"));
        verifyFalse(
                "The error message should not be shown for the correct value",
                selenium.isTextPresent("form:converter:errMsgTextBoxConverter"));
    }

    /**
     * Check if we enter bad value (a value which is not meant to be entered) in
     * the input component , the component throws error.
     */
    protected void checkForBadValueInConverter() {
        widgetInteraction.setDisplayedValue("form:converter:widgetConverter",
                VariableName.BAD);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals("Converter error was not shown for bad value",
                "Undefined value!", selenium
                        .getText("form:converter:errMsgTextBoxConverter"));
        verifyEquals(
                "The bean bound value changed, though it was expected not to be changed.",
                "0", selenium.getText("form:converter:outputConverter"));
    }

    /**
     * Test different kinds of validation works properly on the component.
     * 
     * @throws Exception
     */
    public void testValidators() throws Exception {
        waitForDojoReady();
        checkEmptyConditionRequiredValidator();
        checkWithSingleValidator();
        checkEmptySubmittedValueNull();
        checkRequiredAttribute();
        checkWithMultipleValidators();
        checkWithValidatorAttribute();
        checkWithJSR303BeanValidation();
    }

    /**
     * Test for required validator.
     */
    protected void checkEmptyConditionRequiredValidator() {
        // Test Empty condition (required validator)
        verifyEquals(
                "Initial value of the component having required validator did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:validators:widgetEmptyRequiredValidator"));
        widgetInteraction
                .setEmpty("form:validators:widgetEmptyRequiredValidator");
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals(
                "Validation error was not shown for the empty value",
                "form:validators:widgetEmptyRequiredValidator: Validation Error: Value is required.",
                selenium
                        .getText("form:validators:errMsgTextBoxEmptyRequiredValidator"));
        verifyEquals(
                "The value should still be persisted, in case of required validator, but it was not",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:validators:widgetEmptyRequiredValidator"));
        clickAndwaitForPageLoad("form:submitBtn");
        verifyFalse(
                "The error message should not be shown for the non empty value",
                selenium
                        .isTextPresent("form:validators:errMsgTextBoxEmptyRequiredValidator"));
    }

    /**
     * Test if the component which has validator included using <f:validator/>
     * works properly.
     */
    protected void checkWithSingleValidator() {
        // With Single Validator (Also test empty submit condition)
        verifyEquals(
                "Initial value of the component having custom validator did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:validators:widgetSingleValidator"));
        widgetInteraction.setDisplayedValue(
                "form:validators:widgetSingleValidator", VariableName.SECOND);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals(
                "Error message was not shown for the wrong value",
                "The values should not contain this value",
                selenium
                        .getText("form:validators:errMsgTextBoxSingleValidator"));
    }

    /**
     * Test if the empty values are submitted as null. (depends on the current
     * values of the init-parameter in web.xml)
     */
    protected void checkEmptySubmittedValueNull() {
        // Empty value should be submitted as null
        widgetInteraction.setEmpty("form:validators:widgetSingleValidator");
        clickAndwaitForPageLoad("form:submitBtn");
        verifyFalse(selenium
                .isTextPresent("form:validators:errMsgTextBoxSingleValidator"));
        verifyEquals("Empty value was not submitted as null", "true", selenium
                .getText("form:validators:outputSingleValidator"));
        verifyEquals("The value was not empty", "", widgetInteraction
                .getDisplayedValue("form:validators:widgetSingleValidator"));
    }

    /**
     * Test if the required attribute works properly in the component.
     */
    protected void checkRequiredAttribute() {
        // With required attribute
        verifyEquals(
                "The initial value of the component having the required attribute did not match.",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:validators:widgetRequiredAttr"));
        widgetInteraction.setEmpty("form:validators:widgetRequiredAttr");
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals(
                "Validation error for the empty value was not shown.",
                "form:validators:widgetRequiredAttr: Validation Error: Value is required.",
                selenium.getText("form:validators:errMsgTextBoxRequiredAttr"));
        verifyEquals(
                "The value should still be persisted, in case of required attribute",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:validators:widgetRequiredAttr"));
        clickAndwaitForPageLoad("form:submitBtn");
        verifyFalse(selenium
                .isTextPresent("form:validators:errMsgTextBoxRequiredAttr"));
    }

    /**
     * Test if the component works properly when multiple validators are added
     * to it.
     */
    protected void checkWithMultipleValidators() {
        // With Multiple Validators
        verifyEquals(
                "Initial value of the component having multiple validators did not match.",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:validators:widgetMultipleValidators"));
        widgetInteraction
                .setDisplayedValue("form:validators:widgetMultipleValidators",
                        VariableName.SECOND);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals(
                "Validation error for the wrong value was not shown.",
                "The values should not contain this value",
                selenium
                        .getText("form:validators:errMsgTextBoxMultipleValidators"));
        verifyEquals("The entered value was not pesisted", widgetValues
                .getSeleniumValues(VariableName.SECOND), widgetInteraction
                .getDisplayedValue("form:validators:widgetMultipleValidators"));
        widgetInteraction.setDisplayedValue(
                "form:validators:widgetMultipleValidators", VariableName.FIRST);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyFalse(
                "Error message should not be shown for the correct value",
                selenium
                        .isTextPresent("form:validators:errMsgTextBoxMultipleValidators"));

        checkWithMultipleValidatorsEmptyCondition();

    }

    /**
     * Test for the empty submit condition, when a component has multiple
     * validators.
     */
    protected void checkWithMultipleValidatorsEmptyCondition() {
        widgetInteraction.setEmpty("form:validators:widgetMultipleValidators");
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals(
                "Validation error was not shown for the required attribute, in case of multiple validators",
                "form:validators:widgetMultipleValidators: Validation Error: Value is required.",
                selenium
                        .getText("form:validators:errMsgTextBoxMultipleValidators"));
        verifyEquals(
                "The value should still be persisted, in case of required attribute, but it was not",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:validators:widgetMultipleValidators"));
        clickAndwaitForPageLoad("form:submitBtn");
        verifyFalse(
                "Error message should not be shown for the correct value",
                selenium
                        .isTextPresent("form:validators:errMsgTextBoxMultipleValidators"));
    }

    /**
     * Test if the validator attribute works properly.
     */
    protected void checkWithValidatorAttribute() {
        // With validator attribute
        verifyEquals(
                "Initial value of the component having validator attribute did not match.",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:validators:widgetValidatorAttr"));
        widgetInteraction.setDisplayedValue(
                "form:validators:widgetValidatorAttr", VariableName.SECOND);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals(
                "Validation error was not shown for the wrong value in case of validator attribute",
                "Value must have 'a'", selenium
                        .getText("form:validators:errMsgTextBoxValidatorAttr"));
        widgetInteraction.setDisplayedValue(
                "form:validators:widgetValidatorAttr", VariableName.FIRST);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals(
                "The entered value should persisted, in case of validator attribute",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:validators:widgetValidatorAttr"));
        verifyFalse(
                "Error message should not be shown for the correct value",
                selenium
                        .isTextPresent("form:validators:errMsgTextBoxValidatorAttr"));
    }

    /**
     * Test if the JSR303 bean validator is added properly to the component.
     */
    protected void checkWithJSR303BeanValidation() {
        // With JSR303 Bean Validation
        verifyEquals(
                "Initial value of the component having JSR303 bean validation did not match.",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:validators:widgetBeanValidation"));
        widgetInteraction.setDisplayedValue(
                "form:validators:widgetBeanValidation", VariableName.SECOND);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals(
                "The Validation error was not shown for JSR303 bean validation.",
                "The entered value is not valid", selenium
                        .getText("form:validators:errMsgTextBoxBeanValidation"));
        widgetInteraction.setDisplayedValue(
                "form:validators:widgetBeanValidation", VariableName.FIRST);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals(
                "The entered value should persisted, in case of JSR303 bean validation",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:validators:widgetBeanValidation"));
        verifyFalse(
                "Error message should not be shown for the correct value",
                selenium
                        .isTextPresent("form:validators:errMsgTextBoxBeanValidation"));
    }

    /**
     * Test if the value change listener registered with the component is
     * invoked, after we change its value and submit the form.
     * 
     * @throws Exception
     */
    public void testValueChangeListener() throws Exception {
        waitForDojoReady();
        // With valueChangeListener
        verifyEquals(
                "Initial value of the component for valueChangeLitener did not match.",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:valueChangeListener:widgetValueChangeListener"));
        widgetInteraction.setDisplayedValue(
                "form:valueChangeListener:widgetValueChangeListener",
                VariableName.SECOND);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals(
                "Value of the component could not be updated",
                widgetValues.getSeleniumValues(VariableName.SECOND),
                widgetInteraction
                        .getDisplayedValue("form:valueChangeListener:widgetValueChangeListener"));
        verifyEquals(
                "The valueChangeListerner could not be invoked",
                "valueChangeListener invoked",
                selenium
                        .getText("form:valueChangeListener:outputValueChangeListener"));
    }

    /**
     * Test if the custom faces message has been registered properly, and is
     * invoked on validation failure.
     * 
     * @throws Exception
     */
    public void testFacesMessageRegistration() throws Exception {
        waitForDojoReady();
        // Faces message registered correctly
        verifyEquals(
                "Initial value of the component for facesMessageRegistration did not match.",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:facesMessageRegistration:widgetFacesMessage"));

        widgetInteraction.setDisplayedValue(
                "form:facesMessageRegistration:widgetFacesMessage",
                VariableName.SECOND);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals(
                "Custom validation message was not shown.",
                "This value should not be entered!",
                selenium
                        .getText("form:facesMessageRegistration:errMsgTextBoxFacesMessage"));
        verifyEquals(
                "The value should still be persisted, in case of required attribute, but it was not",
                widgetValues.getSeleniumValues(VariableName.SECOND),
                widgetInteraction
                        .getDisplayedValue("form:facesMessageRegistration:widgetFacesMessage"));

        // set correct value now, and check for removal of validation error.
        widgetInteraction.setDisplayedValue(
                "form:facesMessageRegistration:widgetFacesMessage",
                VariableName.FIRST);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyFalse(
                "Error message should not be shown for the correct value",
                selenium
                        .isTextPresent("form:facesMessageRegistration:errMsgTextBoxFacesMessage"));
        verifyEquals(
                "The entered value should be persisted.",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:facesMessageRegistration:widgetFacesMessage"));
    }

    /**
     * Test Empty submit conditions with setting both validation param false
     */
    public void testEmptySubmitConditionParamFalse() throws Exception {
        waitForDojoReady();
        clickAndwaitForPageLoad("form:setSessionBtn");

        // Test Empty condition (required validator)
        widgetInteraction
                .setEmpty("form:validators:widgetEmptyRequiredValidator");
        clickAndwaitForPageLoad("form:submitBtn");
        verifyFalse(selenium
                .isTextPresent("form:validators:errMsgTextBoxEmptyRequiredValidator"));
        verifyEquals(
                "Empty submitted value should not be null (requiredValidator)",
                "false",
                selenium
                        .getText("form:validators:outputEmptyRequiredValidator"));

        // With Single Validator (Also test empty submit condition)
        widgetInteraction.setEmpty("form:validators:widgetSingleValidator");
        clickAndwaitForPageLoad("form:submitBtn");
        verifyFalse(selenium
                .isTextPresent("form:validators:errMsgTextBoxSingleValidator"));
        verifyEquals(
                "Empty submitted value should not be null (Single validator)",
                "false", selenium
                        .getText("form:validators:outputSingleValidator"));

        // required attribute should not get affected
        widgetInteraction.setEmpty("form:validators:widgetRequiredAttr");
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals(
                "Empty submitted value should still give error in case of required attribute",
                "form:validators:widgetRequiredAttr: Validation Error: Value is required.",
                selenium.getText("form:validators:errMsgTextBoxRequiredAttr"));
    }

    /**
     * User submitted values should be displayed in the component when
     * validation error occurs on this component. User submitted values should
     * be displayed in the component when other component on the form has error.
     * 
     * @throws Exception
     */
    public void testUserSubmittedValuesOnError() throws Exception {
        waitForDojoReady();
        // With validator attribute
        verifyEquals(
                "Initial value of the component having validator attribute did not match.",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:validators:widgetValidatorAttr"));
        widgetInteraction.setDisplayedValue(
                "form:validators:widgetValidatorAttr", VariableName.SECOND);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals(
                "Validation error was not shown for the wrong value in case of validator attribute",
                "Value must have 'a'", selenium
                        .getText("form:validators:errMsgTextBoxValidatorAttr"));
        verifyEquals("The Submitted value did not match.", widgetValues
                .getSeleniumValues(VariableName.SECOND), widgetInteraction
                .getDisplayedValue("form:validators:widgetValidatorAttr"));

        // Now component with validator attribute has error. Enter wrong value
        // in component having JSR303 bean validation.
        verifyEquals(
                "Initial value of the component having JSR303 bean validation did not match.",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:validators:widgetBeanValidation"));
        widgetInteraction.setDisplayedValue(
                "form:validators:widgetBeanValidation", VariableName.SECOND);
        clickAndwaitForPageLoad("form:submitBtn");
        verifyEquals(
                "The Validation error was not shown for JSR303 bean validation.",
                "The entered value is not valid", selenium
                        .getText("form:validators:errMsgTextBoxBeanValidation"));
        verifyEquals("The sumitted value did not match", widgetValues
                .getSeleniumValues(VariableName.SECOND), widgetInteraction
                .getDisplayedValue("form:validators:widgetBeanValidation"));

    }

    /**
     * If the present test-class belongs to a TestSuite, the server would be
     * stopped after this, and for the next test-class in the TestSuite it would
     * be restarted again, so this function would show much more time than other
     * test functions, even though this test function is not guaranteed to run
     * as the last test-case, still in most cases it will be the last. Hence
     * adding it.
     */
    public void testNothing() {
        //
    }
}