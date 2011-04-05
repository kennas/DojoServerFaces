/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.currencytextbox;

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
import org.dojoserverfaces.tests.values.DoubleData;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

@ManagedBean(name = "currencyTextBoxBean")
@RequestScoped
public class CurrencyTextBoxBean {
    private WidgetValues widgetValues = new CurrencyTextBoxValues();

    public static String HIDE = "Hide";
    public static String SHOW = "Show";
    private String toggleMessage;

    private DoubleData beanBoundValue;
    private DoubleData widgetInsidePanel;
    private DoubleData widgetInsidePanel2;

    private List<DoubleData> dataTableValues;
    private List<DoubleData> dataTableValuesSubmit;
    private List<DoubleData> outputDataTableValuesSubmit;
    private List<DoubleData> dataTableAjaxValues;
    private List<DoubleData> dataTableMultiCompValues;

    private DoubleData widgetReadOnly;
    private DoubleData widgetDisabled;

    private DoubleData lengthSingleValidator;
    private DoubleData widgetRequiredAttr;
    private DoubleData widgetMultipleValidators;
    private Boolean nullValue;
    private Integer widgetConverter;
    private DoubleData widgetValidatorAttr;

    private DoubleData targetAjax;
    private DoubleData targetAjaxRefresh;
    private DoubleData emptyRequiredValidator;
    private String strValueChangeListener;
    private UIInput widgetFull;
    private UIInput widgetTransient;
    private DoubleData widgetFullValue;
    private DoubleData widgetTransientValue;

    private boolean render;
    private boolean fullState;
    private boolean transientState;

    private DoubleData widgetClient;
    private DoubleData widgetValueChangeListener;
    private DoubleData widgetFacesMessage;

    @DataValidator(widgetValues = CurrencyTextBoxValues.class)
    private Double widgetBeanValidation;

    public CurrencyTextBoxBean() {
        this.beanBoundValue = new DoubleData(widgetValues.getFirst());
        this.toggleMessage = SHOW;
        this.render = false;

        widgetInsidePanel = new DoubleData(widgetValues.getFirst());
        widgetInsidePanel2 = new DoubleData(widgetValues.getFirst());

        dataTableValues = new ArrayList<DoubleData>();
        dataTableValues.add(new DoubleData(widgetValues.getFirst()));
        dataTableValues.add(new DoubleData(widgetValues.getSecond()));
        dataTableValues.add(new DoubleData(widgetValues.getThird()));
        dataTableValues.add(new DoubleData(widgetValues.getFourth()));

        dataTableValuesSubmit = new ArrayList<DoubleData>();
        dataTableValuesSubmit.add(new DoubleData(widgetValues.getFirst()));
        dataTableValuesSubmit.add(new DoubleData(widgetValues.getSecond()));

        dataTableAjaxValues = new ArrayList<DoubleData>();
        dataTableAjaxValues.add(new DoubleData(widgetValues.getFirst()));
        dataTableAjaxValues.add(new DoubleData(widgetValues.getSecond()));

        dataTableMultiCompValues = new ArrayList<DoubleData>();
        dataTableMultiCompValues.add(new DoubleData(widgetValues.getFirst()));
        dataTableMultiCompValues.add(new DoubleData(widgetValues.getSecond()));

        targetAjaxRefresh = new DoubleData(widgetValues.getFirst());
        targetAjax = new DoubleData(widgetValues.getFirst());

        transientState = false;
        fullState = false;

        widgetFullValue = new DoubleData(widgetValues.getFirst());
        widgetTransientValue = new DoubleData(widgetValues.getFirst());
        widgetClient = new DoubleData(widgetValues.getFirst());

        widgetReadOnly = new DoubleData(widgetValues.getFirst());
        widgetDisabled = new DoubleData(widgetValues.getFirst());

        lengthSingleValidator = new DoubleData(widgetValues.getFirst());
        emptyRequiredValidator = new DoubleData(widgetValues.getFirst());

        widgetRequiredAttr = new DoubleData(widgetValues.getFirst());
        widgetMultipleValidators = new DoubleData(widgetValues.getFirst());
        widgetBeanValidation = (Double) widgetValues.getFirst();
        widgetValidatorAttr = new DoubleData(widgetValues.getFirst());

        widgetConverter = new Integer(0);

        widgetValueChangeListener = new DoubleData(widgetValues.getFirst());
        widgetFacesMessage = new DoubleData(widgetValues.getFirst());
    }

    public void changeTargetAjaxRefresh() {
        this.targetAjaxRefresh = new DoubleData(widgetValues.getSecond());
    }

    public DoubleData getBeanBoundValue() {
        return this.beanBoundValue;
    }

    public List<DoubleData> getDataTableAjaxValues() {
        return dataTableAjaxValues;
    }

    public List<DoubleData> getDataTableMultiCompValues() {
        return dataTableMultiCompValues;
    }

    public List<DoubleData> getDataTableValues() {
        return dataTableValues;
    }

    public List<DoubleData> getDataTableValuesSubmit() {
        return dataTableValuesSubmit;
    }

    public DoubleData getEmptyRequiredValidator() {
        return emptyRequiredValidator;
    }

    public DoubleData getLengthSingleValidator() {
        return lengthSingleValidator;
    }

    public Boolean getNullValue() {
        return nullValue;
    }

    public List<DoubleData> getOutputDataTableValuesSubmit() {
        return outputDataTableValuesSubmit;
    }

    public Boolean getRender() {
        return render;
    }

    public String getStrValueChangeListener() {
        return strValueChangeListener;
    }

    public DoubleData getTargetAjax() {
        return targetAjax;
    }

    public DoubleData getTargetAjaxRefresh() {
        return targetAjaxRefresh;
    }

    public String getToggleMessage() {
        return toggleMessage;
    }

    public boolean getTransientSet() {
        return widgetTransient.isTransient();
    }

    public Double getWidgetBeanValidation() {
        return widgetBeanValidation;
    }

    public DoubleData getWidgetClient() {
        return widgetClient;
    }

    public Integer getWidgetConverter() {
        return widgetConverter;
    }

    public DoubleData getWidgetDisabled() {
        return widgetDisabled;
    }

    public DoubleData getWidgetFacesMessage() {
        return widgetFacesMessage;
    }

    public UIInput getWidgetFull() {
        return widgetFull;
    }

    public DoubleData getWidgetFullValue() {
        return widgetFullValue;
    }

    public DoubleData getWidgetInsidePanel() {
        return widgetInsidePanel;
    }

    public DoubleData getWidgetInsidePanel2() {
        return widgetInsidePanel2;
    }

    public DoubleData getWidgetMultipleValidators() {
        return widgetMultipleValidators;
    }

    public DoubleData getWidgetReadOnly() {
        return widgetReadOnly;
    }

    public DoubleData getWidgetRequiredAttr() {
        return widgetRequiredAttr;
    }

    public UIInput getWidgetTransient() {
        return widgetTransient;
    }

    public DoubleData getWidgetTransientValue() {
        return widgetTransientValue;
    }

    public DoubleData getWidgetValidatorAttr() {
        return widgetValidatorAttr;
    }

    public DoubleData getWidgetValueChangeListener() {
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

    public void setBeanBoundValue(DoubleData value) {
        this.beanBoundValue = value;
    }

    public void setDataTableAjaxValues(List<DoubleData> dataTableAjaxValues) {
        this.dataTableAjaxValues = dataTableAjaxValues;
    }

    public void setDataTableMultiCompValues(
            List<DoubleData> dataTableMultiCompValues) {
        this.dataTableMultiCompValues = dataTableMultiCompValues;
    }

    public void setDataTableValues(List<DoubleData> dataTableValues) {
        this.dataTableValues = dataTableValues;
    }

    public void setDataTableValuesSubmit(List<DoubleData> dataTableValuesSubmit) {
        this.dataTableValuesSubmit = dataTableValuesSubmit;
    }

    public void setEmptyRequiredValidator(DoubleData emptyRequiredValidator) {
        this.emptyRequiredValidator = emptyRequiredValidator;
    }

    public void setFullState(boolean fullState) {
        this.fullState = fullState;
    }

    public void setLengthSingleValidator(DoubleData lengthSingleValidator) {
        this.lengthSingleValidator = lengthSingleValidator;
    }

    public void setNullValue(Boolean nullValue) {
        this.nullValue = nullValue;
    }

    public void setOutputDataTableValuesSubmit(
            List<DoubleData> outputDataTableValuesSubmit) {
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

    public void setTargetAjax(DoubleData targetAjax) {
        this.targetAjax = targetAjax;
    }

    public void setTargetAjaxRefresh(DoubleData targetAjaxRefresh) {
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

    public void setWidgetBeanValidation(Double widgetBeanValidation) {
        this.widgetBeanValidation = widgetBeanValidation;
    }

    public void setWidgetClient(DoubleData widgetClient) {
        this.widgetClient = widgetClient;
    }

    public void setWidgetConverter(Integer widgetConverter) {
        this.widgetConverter = widgetConverter;
    }

    public void setWidgetDisabled(DoubleData widgetDisabled) {
        this.widgetDisabled = widgetDisabled;
    }

    public void setWidgetFacesMessage(DoubleData widgetFacesMessage) {
        this.widgetFacesMessage = widgetFacesMessage;
    }

    public void setWidgetFull(UIInput widgetFull) {
        this.widgetFull = widgetFull;
    }

    public void setWidgetFullValue(DoubleData widgetFullValue) {
        this.widgetFullValue = widgetFullValue;
    }

    public void setWidgetInsidePanel(DoubleData widgetInsidePanel) {
        this.widgetInsidePanel = widgetInsidePanel;
    }

    public void setWidgetInsidePanel2(DoubleData widgetInsidePanel2) {
        this.widgetInsidePanel2 = widgetInsidePanel2;
    }

    public void setWidgetMultipleValidators(DoubleData widgetMultipleValidators) {
        this.widgetMultipleValidators = widgetMultipleValidators;
    }

    public void setWidgetReadOnly(DoubleData widgetReadOnly) {
        this.widgetReadOnly = widgetReadOnly;
    }

    public void setWidgetRequiredAttr(DoubleData widgetRequiredAttr) {
        this.widgetRequiredAttr = widgetRequiredAttr;
    }

    public void setWidgetTransient(UIInput widgetTransient) {
        this.widgetTransient = widgetTransient;
    }

    public void setWidgetTransientValue(DoubleData widgetTransientValue) {
        this.widgetTransientValue = widgetTransientValue;
    }

    public void setWidgetValidatorAttr(DoubleData widgetValidatorAttr) {
        this.widgetValidatorAttr = widgetValidatorAttr;
    }

    public void setWidgetValueChangeListener(
            DoubleData widgetValueChangeListener) {
        this.widgetValueChangeListener = widgetValueChangeListener;
    }

    public void setWidgetValues(WidgetValues widgetValues) {
        this.widgetValues = widgetValues;
    }

    public void submitDataTableValues() {
        outputDataTableValuesSubmit = new ArrayList<DoubleData>();
        Iterator<DoubleData> iterator = dataTableValuesSubmit.iterator();
        while (iterator.hasNext()) {
            outputDataTableValuesSubmit.add(new DoubleData(iterator.next()
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