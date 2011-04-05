/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.numberspinner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.dojoserverfaces.tests.validator.DataValidator;
import org.dojoserverfaces.tests.validator.ValidatorUtil;
import org.dojoserverfaces.tests.values.IntegerData;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

@ManagedBean(name = "numberSpinnerBean")
@RequestScoped
public class NumberSpinnerBean {
    private WidgetValues widgetValues = new NumberSpinnerValues();

    public static String HIDE = "Hide";
    public static String SHOW = "Show";
    private String toggleMessage;

    private IntegerData beanBoundValue;
    private IntegerData widgetInsidePanel;
    private IntegerData widgetInsidePanel2;

    private List<IntegerData> dataTableValues;
    private List<IntegerData> dataTableValuesSubmit;
    private List<IntegerData> outputDataTableValuesSubmit;
    private List<IntegerData> dataTableAjaxValues;
    private List<IntegerData> dataTableMultiCompValues;

    private IntegerData widgetReadOnly;
    private IntegerData widgetDisabled;

    private IntegerData lengthSingleValidator;
    private IntegerData widgetRequiredAttr;
    private IntegerData widgetMultipleValidators;
    private Boolean nullValue;
    private Integer widgetConverter;
    private IntegerData widgetValidatorAttr;

    private IntegerData targetAjax;
    private IntegerData targetAjaxRefresh;
    private IntegerData emptyRequiredValidator;
    private String strValueChangeListener;
    private UIInput widgetFull;
    private UIInput widgetTransient;
    private IntegerData widgetFullValue;
    private IntegerData widgetTransientValue;

    private boolean render;
    private boolean fullState;
    private boolean transientState;

    private IntegerData widgetClient;
    private IntegerData widgetValueChangeListener;
    private IntegerData widgetFacesMessage;

    @DataValidator(widgetValues = NumberSpinnerValues.class)
    private Integer widgetBeanValidation;

    public NumberSpinnerBean() {
        this.beanBoundValue = new IntegerData(widgetValues.getFirst());
        this.toggleMessage = SHOW;
        this.render = false;

        widgetInsidePanel = new IntegerData(widgetValues.getFirst());
        widgetInsidePanel2 = new IntegerData(widgetValues.getFirst());

        dataTableValues = new ArrayList<IntegerData>();
        dataTableValues.add(new IntegerData(widgetValues.getFirst()));
        dataTableValues.add(new IntegerData(widgetValues.getSecond()));
        dataTableValues.add(new IntegerData(widgetValues.getThird()));
        dataTableValues.add(new IntegerData(widgetValues.getFourth()));

        dataTableValuesSubmit = new ArrayList<IntegerData>();
        dataTableValuesSubmit.add(new IntegerData(widgetValues.getFirst()));
        dataTableValuesSubmit.add(new IntegerData(widgetValues.getSecond()));

        dataTableAjaxValues = new ArrayList<IntegerData>();
        dataTableAjaxValues.add(new IntegerData(widgetValues.getFirst()));
        dataTableAjaxValues.add(new IntegerData(widgetValues.getSecond()));

        dataTableMultiCompValues = new ArrayList<IntegerData>();
        dataTableMultiCompValues.add(new IntegerData(widgetValues.getFirst()));
        dataTableMultiCompValues.add(new IntegerData(widgetValues.getSecond()));

        targetAjaxRefresh = new IntegerData(widgetValues.getFirst());
        targetAjax = new IntegerData(widgetValues.getFirst());

        transientState = false;
        fullState = false;

        widgetFullValue = new IntegerData(widgetValues.getFirst());
        widgetTransientValue = new IntegerData(widgetValues.getFirst());
        widgetClient = new IntegerData(widgetValues.getFirst());

        widgetReadOnly = new IntegerData(widgetValues.getFirst());
        widgetDisabled = new IntegerData(widgetValues.getFirst());

        lengthSingleValidator = new IntegerData(widgetValues.getFirst());
        emptyRequiredValidator = new IntegerData(widgetValues.getFirst());

        widgetRequiredAttr = new IntegerData(widgetValues.getFirst());
        widgetMultipleValidators = new IntegerData(widgetValues.getFirst());
        widgetBeanValidation = (Integer) widgetValues.getFirst();
        widgetValidatorAttr = new IntegerData(widgetValues.getFirst());

        widgetConverter = new Integer(0);

        widgetValueChangeListener = new IntegerData(widgetValues.getFirst());
        widgetFacesMessage = new IntegerData(widgetValues.getFirst());
    }

    public void changeTargetAjaxRefresh() {
        this.targetAjaxRefresh = new IntegerData(widgetValues.getSecond());
    }

    public IntegerData getBeanBoundValue() {
        return this.beanBoundValue;
    }

    public List<IntegerData> getDataTableAjaxValues() {
        return dataTableAjaxValues;
    }

    public List<IntegerData> getDataTableMultiCompValues() {
        return dataTableMultiCompValues;
    }

    public List<IntegerData> getDataTableValues() {
        return dataTableValues;
    }

    public List<IntegerData> getDataTableValuesSubmit() {
        return dataTableValuesSubmit;
    }

    public IntegerData getEmptyRequiredValidator() {
        return emptyRequiredValidator;
    }

    public IntegerData getLengthSingleValidator() {
        return lengthSingleValidator;
    }

    public Boolean getNullValue() {
        return nullValue;
    }

    public List<IntegerData> getOutputDataTableValuesSubmit() {
        return outputDataTableValuesSubmit;
    }

    public Boolean getRender() {
        return render;
    }

    public String getStrValueChangeListener() {
        return strValueChangeListener;
    }

    public IntegerData getTargetAjax() {
        return targetAjax;
    }

    public IntegerData getTargetAjaxRefresh() {
        return targetAjaxRefresh;
    }

    public String getToggleMessage() {
        return toggleMessage;
    }

    public boolean getTransientSet() {
        return widgetTransient.isTransient();
    }

    public Integer getWidgetBeanValidation() {
        return widgetBeanValidation;
    }

    public IntegerData getWidgetClient() {
        return widgetClient;
    }

    public Integer getWidgetConverter() {
        return widgetConverter;
    }

    public IntegerData getWidgetDisabled() {
        return widgetDisabled;
    }

    public IntegerData getWidgetFacesMessage() {
        return widgetFacesMessage;
    }

    public UIInput getWidgetFull() {
        return widgetFull;
    }

    public IntegerData getWidgetFullValue() {
        return widgetFullValue;
    }

    public IntegerData getWidgetInsidePanel() {
        return widgetInsidePanel;
    }

    public IntegerData getWidgetInsidePanel2() {
        return widgetInsidePanel2;
    }

    public IntegerData getWidgetMultipleValidators() {
        return widgetMultipleValidators;
    }

    public IntegerData getWidgetReadOnly() {
        return widgetReadOnly;
    }

    public IntegerData getWidgetRequiredAttr() {
        return widgetRequiredAttr;
    }

    public UIInput getWidgetTransient() {
        return widgetTransient;
    }

    public IntegerData getWidgetTransientValue() {
        return widgetTransientValue;
    }

    public IntegerData getWidgetValidatorAttr() {
        return widgetValidatorAttr;
    }

    public IntegerData getWidgetValueChangeListener() {
        return widgetValueChangeListener;
    }

    public WidgetValues getWidgetValues() {
        return widgetValues;
    }

    public boolean isFullState() {
        return fullState;
    }

    public boolean isNullValue() {
        return emptyRequiredValidator == null;
    }

    public boolean isTransientState() {
        return transientState;
    }

    public void preRenderViewHandler(ComponentSystemEvent e) {
        widgetTransient.setRequired(true);
        widgetFull.setRequired(true);
    }

    public void processAction(ActionEvent event)
            throws AbortProcessingException {
        System.out.println("Inside Process Action");
    }

    public void setBeanBoundValue(IntegerData value) {
        this.beanBoundValue = value;
    }

    public void setDataTableAjaxValues(List<IntegerData> dataTableAjaxValues) {
        this.dataTableAjaxValues = dataTableAjaxValues;
    }

    public void setDataTableMultiCompValues(
            List<IntegerData> dataTableMultiCompValues) {
        this.dataTableMultiCompValues = dataTableMultiCompValues;
    }

    public void setDataTableValues(List<IntegerData> dataTableValues) {
        this.dataTableValues = dataTableValues;
    }

    public void setDataTableValuesSubmit(List<IntegerData> dataTableValuesSubmit) {
        this.dataTableValuesSubmit = dataTableValuesSubmit;
    }

    public void setEmptyRequiredValidator(IntegerData emptyRequiredValidator) {
        this.emptyRequiredValidator = emptyRequiredValidator;
    }

    public void setFullState(boolean fullState) {
        this.fullState = fullState;
    }

    public void setLengthSingleValidator(IntegerData lengthSingleValidator) {
        this.lengthSingleValidator = lengthSingleValidator;
    }

    public void setNullValue(Boolean nullValue) {
        this.nullValue = nullValue;
    }

    public void setOutputDataTableValuesSubmit(
            List<IntegerData> outputDataTableValuesSubmit) {
        this.outputDataTableValuesSubmit = outputDataTableValuesSubmit;
    }

    public String setPartialStateSaving() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
        session.setAttribute("javax.faces.PARTIAL_STATE_SAVING", "false");
        return "index.xhtml";
    }

    public void setRender(Boolean render) {
        this.render = render;
    }

    public void setStrValueChangeListener(String strValueChangeListener) {
        this.strValueChangeListener = strValueChangeListener;
    }

    public void setTargetAjax(IntegerData targetAjax) {
        this.targetAjax = targetAjax;
    }

    public void setTargetAjaxRefresh(IntegerData targetAjaxRefresh) {
        this.targetAjaxRefresh = targetAjaxRefresh;
    }

    public void setTransientState(boolean transientState) {
        this.transientState = transientState;
    }

    public String setValidationSession() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
        session.setAttribute(
                "javax.faces.INTERPRET_EMPTY_STRING_SUBMITTED_VALUES_AS_NULL",
                "false");
        session.setAttribute("javax.faces.VALIDATE_EMPTY_FIELDS", "false");
        return "index.xhtml";
    }

    public void setWidgetBeanValidation(Integer widgetBeanValidation) {
        this.widgetBeanValidation = widgetBeanValidation;
    }

    public void setWidgetClient(IntegerData widgetClient) {
        this.widgetClient = widgetClient;
    }

    public void setWidgetConverter(Integer widgetConverter) {
        this.widgetConverter = widgetConverter;
    }

    public void setWidgetDisabled(IntegerData widgetDisabled) {
        this.widgetDisabled = widgetDisabled;
    }

    public void setWidgetFacesMessage(IntegerData widgetFacesMessage) {
        this.widgetFacesMessage = widgetFacesMessage;
    }

    public void setWidgetFull(UIInput widgetFull) {
        this.widgetFull = widgetFull;
    }

    public void setWidgetFullValue(IntegerData widgetFullValue) {
        this.widgetFullValue = widgetFullValue;
    }

    public void setWidgetInsidePanel(IntegerData widgetInsidePanel) {
        this.widgetInsidePanel = widgetInsidePanel;
    }

    public void setWidgetInsidePanel2(IntegerData widgetInsidePanel2) {
        this.widgetInsidePanel2 = widgetInsidePanel2;
    }

    public void setWidgetMultipleValidators(IntegerData widgetMultipleValidators) {
        this.widgetMultipleValidators = widgetMultipleValidators;
    }

    public void setWidgetReadOnly(IntegerData widgetReadOnly) {
        this.widgetReadOnly = widgetReadOnly;
    }

    public void setWidgetRequiredAttr(IntegerData widgetRequiredAttr) {
        this.widgetRequiredAttr = widgetRequiredAttr;
    }

    public void setWidgetTransient(UIInput widgetTransient) {
        this.widgetTransient = widgetTransient;
    }

    public void setWidgetTransientValue(IntegerData widgetTransientValue) {
        this.widgetTransientValue = widgetTransientValue;
    }

    public void setWidgetValidatorAttr(IntegerData widgetValidatorAttr) {
        this.widgetValidatorAttr = widgetValidatorAttr;
    }

    public void setWidgetValueChangeListener(
            IntegerData widgetValueChangeListener) {
        this.widgetValueChangeListener = widgetValueChangeListener;
    }

    public void setWidgetValues(WidgetValues widgetValues) {
        this.widgetValues = widgetValues;
    }

    public void submitDataTableValues() {
        outputDataTableValuesSubmit = new ArrayList<IntegerData>();
        Iterator<IntegerData> iterator = dataTableValuesSubmit.iterator();
        while (iterator.hasNext()) {
            outputDataTableValuesSubmit.add(new IntegerData(iterator.next()
                    .getData()));
        }
    }

    public void testFullState() {
        fullState = widgetFull.isRequired();
    }

    public void testTransientState() {
        transientState = !widgetTransient.isRequired();
    }

    public void togglePanel() {
        if (!this.render) {
            this.render = true;
            this.toggleMessage = HIDE;
        }
        else {
            // The hide will not work if the ManagedBean is request scoped.
            this.render = false;
            this.toggleMessage = SHOW;
        }
    }

    public void validateWidgetValidatorAttr(FacesContext context,
            UIComponent component, Object value) throws ValidatorException {

        if (ValidatorUtil.validateObjectHasOnlyValue(value, this.widgetValues
                .getFirst()))
            return;

        FacesMessage message = new FacesMessage("Value must have 'a'");
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        throw new ValidatorException(message);
    }

    public void valueChangeMethod(ValueChangeEvent evt) {
        setStrValueChangeListener(new String("valueChangeListener invoked"));
    }
}