/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.timetextbox;

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
import org.dojoserverfaces.tests.values.TimeData;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

@ManagedBean(name = "timeTextBoxBean")
@RequestScoped
public class TimeTextBoxBean {
    private WidgetValues widgetValues = new TimeTextBoxValues();

    public static String HIDE = "Hide";
    public static String SHOW = "Show";
    private String toggleMessage;

    private TimeData beanBoundValue;
    private TimeData widgetInsidePanel;
    private TimeData widgetInsidePanel2;

    private List<TimeData> dataTableValues;
    private List<TimeData> dataTableValuesSubmit;
    private List<TimeData> outputDataTableValuesSubmit;
    private List<TimeData> dataTableAjaxValues;
    private List<TimeData> dataTableMultiCompValues;

    private TimeData widgetReadOnly;
    private TimeData widgetDisabled;

    private TimeData lengthSingleValidator;
    private TimeData widgetRequiredAttr;
    private TimeData widgetMultipleValidators;
    private Boolean nullValue;
    private Integer widgetConverter;
    private TimeData widgetValidatorAttr;

    private TimeData targetAjax;
    private TimeData targetAjaxRefresh;
    private TimeData emptyRequiredValidator;
    private String strValueChangeListener;
    private UIInput widgetFull;
    private UIInput widgetTransient;
    private TimeData widgetFullValue;
    private TimeData widgetTransientValue;

    private boolean render;
    private boolean fullState;
    private boolean transientState;

    private TimeData widgetClient;
    private TimeData widgetValueChangeListener;
    private TimeData widgetFacesMessage;

    @DataValidator(widgetValues = TimeTextBoxValues.class)
    private Long widgetBeanValidation;

    public TimeTextBoxBean() {
        this.beanBoundValue = new TimeData(widgetValues.getFirst());
        this.toggleMessage = SHOW;
        this.render = false;

        widgetInsidePanel = new TimeData(widgetValues.getFirst());
        widgetInsidePanel2 = new TimeData(widgetValues.getFirst());

        dataTableValues = new ArrayList<TimeData>();
        dataTableValues.add(new TimeData(widgetValues.getFirst()));
        dataTableValues.add(new TimeData(widgetValues.getSecond()));
        dataTableValues.add(new TimeData(widgetValues.getThird()));
        dataTableValues.add(new TimeData(widgetValues.getFourth()));

        dataTableValuesSubmit = new ArrayList<TimeData>();
        dataTableValuesSubmit.add(new TimeData(widgetValues.getFirst()));
        dataTableValuesSubmit.add(new TimeData(widgetValues.getSecond()));

        dataTableAjaxValues = new ArrayList<TimeData>();
        dataTableAjaxValues.add(new TimeData(widgetValues.getFirst()));
        dataTableAjaxValues.add(new TimeData(widgetValues.getSecond()));

        dataTableMultiCompValues = new ArrayList<TimeData>();
        dataTableMultiCompValues.add(new TimeData(widgetValues.getFirst()));
        dataTableMultiCompValues.add(new TimeData(widgetValues.getSecond()));

        targetAjaxRefresh = new TimeData(widgetValues.getFirst());
        targetAjax = new TimeData(widgetValues.getFirst());

        transientState = false;
        fullState = false;

        widgetFullValue = new TimeData(widgetValues.getFirst());
        widgetTransientValue = new TimeData(widgetValues.getFirst());
        widgetClient = new TimeData(widgetValues.getFirst());

        widgetReadOnly = new TimeData(widgetValues.getFirst());
        widgetDisabled = new TimeData(widgetValues.getFirst());

        lengthSingleValidator = new TimeData(widgetValues.getFirst());
        emptyRequiredValidator = new TimeData(widgetValues.getFirst());

        widgetRequiredAttr = new TimeData(widgetValues.getFirst());
        widgetMultipleValidators = new TimeData(widgetValues.getFirst());
        widgetBeanValidation = (Long) widgetValues.getFirst();
        widgetValidatorAttr = new TimeData(widgetValues.getFirst());

        widgetConverter = new Integer(0);

        widgetValueChangeListener = new TimeData(widgetValues.getFirst());
        widgetFacesMessage = new TimeData(widgetValues.getFirst());
    }

    public void changeTargetAjaxRefresh() {
        this.targetAjaxRefresh = new TimeData(widgetValues.getSecond());
    }

    public TimeData getBeanBoundValue() {
        return this.beanBoundValue;
    }

    public List<TimeData> getDataTableAjaxValues() {
        return dataTableAjaxValues;
    }

    public List<TimeData> getDataTableMultiCompValues() {
        return dataTableMultiCompValues;
    }

    public List<TimeData> getDataTableValues() {
        return dataTableValues;
    }

    public List<TimeData> getDataTableValuesSubmit() {
        return dataTableValuesSubmit;
    }

    public TimeData getEmptyRequiredValidator() {
        return emptyRequiredValidator;
    }

    public TimeData getLengthSingleValidator() {
        return lengthSingleValidator;
    }

    public Boolean getNullValue() {
        return nullValue;
    }

    public List<TimeData> getOutputDataTableValuesSubmit() {
        return outputDataTableValuesSubmit;
    }

    public Boolean getRender() {
        return render;
    }

    public String getStrValueChangeListener() {
        return strValueChangeListener;
    }

    public TimeData getTargetAjax() {
        return targetAjax;
    }

    public TimeData getTargetAjaxRefresh() {
        return targetAjaxRefresh;
    }

    public String getToggleMessage() {
        return toggleMessage;
    }

    public boolean getTransientSet() {
        return widgetTransient.isTransient();
    }

    public Long getWidgetBeanValidation() {
        return widgetBeanValidation;
    }

    public TimeData getWidgetClient() {
        return widgetClient;
    }

    public Integer getWidgetConverter() {
        return widgetConverter;
    }

    public TimeData getWidgetDisabled() {
        return widgetDisabled;
    }

    public TimeData getWidgetFacesMessage() {
        return widgetFacesMessage;
    }

    public UIInput getWidgetFull() {
        return widgetFull;
    }

    public TimeData getWidgetFullValue() {
        return widgetFullValue;
    }

    public TimeData getWidgetInsidePanel() {
        return widgetInsidePanel;
    }

    public TimeData getWidgetInsidePanel2() {
        return widgetInsidePanel2;
    }

    public TimeData getWidgetMultipleValidators() {
        return widgetMultipleValidators;
    }

    public TimeData getWidgetReadOnly() {
        return widgetReadOnly;
    }

    public TimeData getWidgetRequiredAttr() {
        return widgetRequiredAttr;
    }

    public UIInput getWidgetTransient() {
        return widgetTransient;
    }

    public TimeData getWidgetTransientValue() {
        return widgetTransientValue;
    }

    public TimeData getWidgetValidatorAttr() {
        return widgetValidatorAttr;
    }

    public TimeData getWidgetValueChangeListener() {
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

    public void setBeanBoundValue(TimeData value) {
        this.beanBoundValue = value;
    }

    public void setDataTableAjaxValues(List<TimeData> dataTableAjaxValues) {
        this.dataTableAjaxValues = dataTableAjaxValues;
    }

    public void setDataTableMultiCompValues(
            List<TimeData> dataTableMultiCompValues) {
        this.dataTableMultiCompValues = dataTableMultiCompValues;
    }

    public void setDataTableValues(List<TimeData> dataTableValues) {
        this.dataTableValues = dataTableValues;
    }

    public void setDataTableValuesSubmit(List<TimeData> dataTableValuesSubmit) {
        this.dataTableValuesSubmit = dataTableValuesSubmit;
    }

    public void setEmptyRequiredValidator(TimeData emptyRequiredValidator) {
        this.emptyRequiredValidator = emptyRequiredValidator;
    }

    public void setFullState(boolean fullState) {
        this.fullState = fullState;
    }

    public void setLengthSingleValidator(TimeData lengthSingleValidator) {
        this.lengthSingleValidator = lengthSingleValidator;
    }

    public void setNullValue(Boolean nullValue) {
        this.nullValue = nullValue;
    }

    public void setOutputDataTableValuesSubmit(
            List<TimeData> outputDataTableValuesSubmit) {
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

    public void setTargetAjax(TimeData targetAjax) {
        this.targetAjax = targetAjax;
    }

    public void setTargetAjaxRefresh(TimeData targetAjaxRefresh) {
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

    public void setWidgetBeanValidation(Long widgetBeanValidation) {
        this.widgetBeanValidation = widgetBeanValidation;
    }

    public void setWidgetClient(TimeData widgetClient) {
        this.widgetClient = widgetClient;
    }

    public void setWidgetConverter(Integer widgetConverter) {
        this.widgetConverter = widgetConverter;
    }

    public void setWidgetDisabled(TimeData widgetDisabled) {
        this.widgetDisabled = widgetDisabled;
    }

    public void setWidgetFacesMessage(TimeData widgetFacesMessage) {
        this.widgetFacesMessage = widgetFacesMessage;
    }

    public void setWidgetFull(UIInput widgetFull) {
        this.widgetFull = widgetFull;
    }

    public void setWidgetFullValue(TimeData widgetFullValue) {
        this.widgetFullValue = widgetFullValue;
    }

    public void setWidgetInsidePanel(TimeData widgetInsidePanel) {
        this.widgetInsidePanel = widgetInsidePanel;
    }

    public void setWidgetInsidePanel2(TimeData widgetInsidePanel2) {
        this.widgetInsidePanel2 = widgetInsidePanel2;
    }

    public void setWidgetMultipleValidators(TimeData widgetMultipleValidators) {
        this.widgetMultipleValidators = widgetMultipleValidators;
    }

    public void setWidgetReadOnly(TimeData widgetReadOnly) {
        this.widgetReadOnly = widgetReadOnly;
    }

    public void setWidgetRequiredAttr(TimeData widgetRequiredAttr) {
        this.widgetRequiredAttr = widgetRequiredAttr;
    }

    public void setWidgetTransient(UIInput widgetTransient) {
        this.widgetTransient = widgetTransient;
    }

    public void setWidgetTransientValue(TimeData widgetTransientValue) {
        this.widgetTransientValue = widgetTransientValue;
    }

    public void setWidgetValidatorAttr(TimeData widgetValidatorAttr) {
        this.widgetValidatorAttr = widgetValidatorAttr;
    }

    public void setWidgetValueChangeListener(TimeData widgetValueChangeListener) {
        this.widgetValueChangeListener = widgetValueChangeListener;
    }

    public void setWidgetValues(WidgetValues widgetValues) {
        this.widgetValues = widgetValues;
    }

    public void submitDataTableValues() {
        outputDataTableValuesSubmit = new ArrayList<TimeData>();
        Iterator<TimeData> iterator = dataTableValuesSubmit.iterator();
        while (iterator.hasNext()) {
            outputDataTableValuesSubmit.add(new TimeData(iterator.next()
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