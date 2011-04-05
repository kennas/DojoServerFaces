/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.datetextbox;

import java.util.ArrayList;
import java.util.Date;
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
import org.dojoserverfaces.tests.values.DateData;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

@ManagedBean(name = "dateTextBoxBean")
@RequestScoped
public class DateTextBoxBean {
    private WidgetValues widgetValues = new DateTextBoxValues();

    public static String HIDE = "Hide";
    public static String SHOW = "Show";
    private String toggleMessage;

    private DateData beanBoundValue;
    private DateData widgetInsidePanel;
    private DateData widgetInsidePanel2;

    private List<DateData> dataTableValues;
    private List<DateData> dataTableValuesSubmit;
    private List<DateData> outputDataTableValuesSubmit;
    private List<DateData> dataTableAjaxValues;
    private List<DateData> dataTableMultiCompValues;

    private DateData widgetReadOnly;
    private DateData widgetDisabled;

    private DateData lengthSingleValidator;
    private DateData widgetRequiredAttr;
    private DateData widgetMultipleValidators;
    private Boolean nullValue;
    private Integer widgetConverter;
    private DateData widgetValidatorAttr;

    private DateData targetAjax;
    private DateData targetAjaxRefresh;
    private DateData emptyRequiredValidator;
    private String strValueChangeListener;
    private UIInput widgetFull;
    private UIInput widgetTransient;
    private DateData widgetFullValue;
    private DateData widgetTransientValue;

    private boolean render;
    private boolean fullState;
    private boolean transientState;

    private DateData widgetClient;
    private DateData widgetValueChangeListener;
    private DateData widgetFacesMessage;

    @DataValidator(widgetValues = DateTextBoxValues.class)
    private Date widgetBeanValidation;

    public DateTextBoxBean() {
        this.beanBoundValue = new DateData(widgetValues.getFirst());
        this.toggleMessage = SHOW;
        this.render = false;

        widgetInsidePanel = new DateData(widgetValues.getFirst());
        widgetInsidePanel2 = new DateData(widgetValues.getFirst());

        dataTableValues = new ArrayList<DateData>();
        dataTableValues.add(new DateData(widgetValues.getFirst()));
        dataTableValues.add(new DateData(widgetValues.getSecond()));
        dataTableValues.add(new DateData(widgetValues.getThird()));
        dataTableValues.add(new DateData(widgetValues.getFourth()));

        dataTableValuesSubmit = new ArrayList<DateData>();
        dataTableValuesSubmit.add(new DateData(widgetValues.getFirst()));
        dataTableValuesSubmit.add(new DateData(widgetValues.getSecond()));

        dataTableAjaxValues = new ArrayList<DateData>();
        dataTableAjaxValues.add(new DateData(widgetValues.getFirst()));
        dataTableAjaxValues.add(new DateData(widgetValues.getSecond()));

        dataTableMultiCompValues = new ArrayList<DateData>();
        dataTableMultiCompValues.add(new DateData(widgetValues.getFirst()));
        dataTableMultiCompValues.add(new DateData(widgetValues.getSecond()));

        targetAjaxRefresh = new DateData(widgetValues.getFirst());
        targetAjax = new DateData(widgetValues.getFirst());

        transientState = false;
        fullState = false;

        widgetFullValue = new DateData(widgetValues.getFirst());
        widgetTransientValue = new DateData(widgetValues.getFirst());
        widgetClient = new DateData(widgetValues.getFirst());

        widgetReadOnly = new DateData(widgetValues.getFirst());
        widgetDisabled = new DateData(widgetValues.getFirst());

        lengthSingleValidator = new DateData(widgetValues.getFirst());
        emptyRequiredValidator = new DateData(widgetValues.getFirst());

        widgetRequiredAttr = new DateData(widgetValues.getFirst());
        widgetMultipleValidators = new DateData(widgetValues.getFirst());
        widgetBeanValidation = (Date) widgetValues.getFirst();
        widgetValidatorAttr = new DateData(widgetValues.getFirst());

        widgetConverter = new Integer(0);

        widgetValueChangeListener = new DateData(widgetValues.getFirst());
        widgetFacesMessage = new DateData(widgetValues.getFirst());
    }

    public void changeTargetAjaxRefresh() {
        this.targetAjaxRefresh = new DateData(widgetValues.getSecond());
    }

    public DateData getBeanBoundValue() {
        return this.beanBoundValue;
    }

    public List<DateData> getDataTableAjaxValues() {
        return dataTableAjaxValues;
    }

    public List<DateData> getDataTableMultiCompValues() {
        return dataTableMultiCompValues;
    }

    public List<DateData> getDataTableValues() {
        return dataTableValues;
    }

    public List<DateData> getDataTableValuesSubmit() {
        return dataTableValuesSubmit;
    }

    public DateData getEmptyRequiredValidator() {
        return emptyRequiredValidator;
    }

    public DateData getLengthSingleValidator() {
        return lengthSingleValidator;
    }

    public Boolean getNullValue() {
        return nullValue;
    }

    public List<DateData> getOutputDataTableValuesSubmit() {
        return outputDataTableValuesSubmit;
    }

    public Boolean getRender() {
        return render;
    }

    public String getStrValueChangeListener() {
        return strValueChangeListener;
    }

    public DateData getTargetAjax() {
        return targetAjax;
    }

    public DateData getTargetAjaxRefresh() {
        return targetAjaxRefresh;
    }

    public String getToggleMessage() {
        return toggleMessage;
    }

    public boolean getTransientSet() {
        return widgetTransient.isTransient();
    }

    public Date getWidgetBeanValidation() {
        return widgetBeanValidation;
    }

    public DateData getWidgetClient() {
        return widgetClient;
    }

    public Integer getWidgetConverter() {
        return widgetConverter;
    }

    public DateData getWidgetDisabled() {
        return widgetDisabled;
    }

    public DateData getWidgetFacesMessage() {
        return widgetFacesMessage;
    }

    public UIInput getWidgetFull() {
        return widgetFull;
    }

    public DateData getWidgetFullValue() {
        return widgetFullValue;
    }

    public DateData getWidgetInsidePanel() {
        return widgetInsidePanel;
    }

    public DateData getWidgetInsidePanel2() {
        return widgetInsidePanel2;
    }

    public DateData getWidgetMultipleValidators() {
        return widgetMultipleValidators;
    }

    public DateData getWidgetReadOnly() {
        return widgetReadOnly;
    }

    public DateData getWidgetRequiredAttr() {
        return widgetRequiredAttr;
    }

    public UIInput getWidgetTransient() {
        return widgetTransient;
    }

    public DateData getWidgetTransientValue() {
        return widgetTransientValue;
    }

    public DateData getWidgetValidatorAttr() {
        return widgetValidatorAttr;
    }

    public DateData getWidgetValueChangeListener() {
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

    public void setBeanBoundValue(DateData value) {
        this.beanBoundValue = value;
    }

    public void setDataTableAjaxValues(List<DateData> dataTableAjaxValues) {
        this.dataTableAjaxValues = dataTableAjaxValues;
    }

    public void setDataTableMultiCompValues(
            List<DateData> dataTableMultiCompValues) {
        this.dataTableMultiCompValues = dataTableMultiCompValues;
    }

    public void setDataTableValues(List<DateData> dataTableValues) {
        this.dataTableValues = dataTableValues;
    }

    public void setDataTableValuesSubmit(List<DateData> dataTableValuesSubmit) {
        this.dataTableValuesSubmit = dataTableValuesSubmit;
    }

    public void setEmptyRequiredValidator(DateData emptyRequiredValidator) {
        this.emptyRequiredValidator = emptyRequiredValidator;
    }

    public void setFullState(boolean fullState) {
        this.fullState = fullState;
    }

    public void setLengthSingleValidator(DateData lengthSingleValidator) {
        this.lengthSingleValidator = lengthSingleValidator;
    }

    public void setNullValue(Boolean nullValue) {
        this.nullValue = nullValue;
    }

    public void setOutputDataTableValuesSubmit(
            List<DateData> outputDataTableValuesSubmit) {
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

    public void setTargetAjax(DateData targetAjax) {
        this.targetAjax = targetAjax;
    }

    public void setTargetAjaxRefresh(DateData targetAjaxRefresh) {
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

    public void setWidgetBeanValidation(Date widgetBeanValidation) {
        this.widgetBeanValidation = widgetBeanValidation;
    }

    public void setWidgetClient(DateData widgetClient) {
        this.widgetClient = widgetClient;
    }

    public void setWidgetConverter(Integer widgetConverter) {
        this.widgetConverter = widgetConverter;
    }

    public void setWidgetDisabled(DateData widgetDisabled) {
        this.widgetDisabled = widgetDisabled;
    }

    public void setWidgetFacesMessage(DateData widgetFacesMessage) {
        this.widgetFacesMessage = widgetFacesMessage;
    }

    public void setWidgetFull(UIInput widgetFull) {
        this.widgetFull = widgetFull;
    }

    public void setWidgetFullValue(DateData widgetFullValue) {
        this.widgetFullValue = widgetFullValue;
    }

    public void setWidgetInsidePanel(DateData widgetInsidePanel) {
        this.widgetInsidePanel = widgetInsidePanel;
    }

    public void setWidgetInsidePanel2(DateData widgetInsidePanel2) {
        this.widgetInsidePanel2 = widgetInsidePanel2;
    }

    public void setWidgetMultipleValidators(DateData widgetMultipleValidators) {
        this.widgetMultipleValidators = widgetMultipleValidators;
    }

    public void setWidgetReadOnly(DateData widgetReadOnly) {
        this.widgetReadOnly = widgetReadOnly;
    }

    public void setWidgetRequiredAttr(DateData widgetRequiredAttr) {
        this.widgetRequiredAttr = widgetRequiredAttr;
    }

    public void setWidgetTransient(UIInput widgetTransient) {
        this.widgetTransient = widgetTransient;
    }

    public void setWidgetTransientValue(DateData widgetTransientValue) {
        this.widgetTransientValue = widgetTransientValue;
    }

    public void setWidgetValidatorAttr(DateData widgetValidatorAttr) {
        this.widgetValidatorAttr = widgetValidatorAttr;
    }

    public void setWidgetValueChangeListener(DateData widgetValueChangeListener) {
        this.widgetValueChangeListener = widgetValueChangeListener;
    }

    public void setWidgetValues(WidgetValues widgetValues) {
        this.widgetValues = widgetValues;
    }

    public void submitDataTableValues() {
        outputDataTableValuesSubmit = new ArrayList<DateData>();
        Iterator<DateData> iterator = dataTableValuesSubmit.iterator();
        while (iterator.hasNext()) {
            outputDataTableValuesSubmit.add(new DateData(iterator.next()
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