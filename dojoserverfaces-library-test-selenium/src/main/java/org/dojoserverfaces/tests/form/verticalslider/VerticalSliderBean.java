/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.verticalslider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import org.dojoserverfaces.tests.values.StringData;
import org.dojoserverfaces.tests.widget.values.WidgetValues;
import org.dojoserverfaces.tests.validator.DataValidator;
import org.dojoserverfaces.tests.validator.ValidatorUtil;

@ManagedBean(name = "verticalSliderBean")
@RequestScoped
public class VerticalSliderBean {
    private WidgetValues widgetValues = new VerticalSliderValues();

    private Map<Object, Object> values = new LinkedHashMap<Object, Object>();

    public static String HIDE = "Hide";
    public static String SHOW = "Show";
    private String toggleMessage;

    private StringData beanBoundValue;
    private StringData widgetInsidePanel;
    private StringData widgetInsidePanel2;

    private List<StringData> dataTableValues;
    private List<StringData> dataTableValuesSubmit;
    private List<StringData> outputDataTableValuesSubmit;
    private List<StringData> dataTableAjaxValues;
    private List<StringData> dataTableMultiCompValues;

    private StringData widgetReadOnly;
    private StringData widgetDisabled;

    private StringData lengthSingleValidator;
    private StringData widgetRequiredAttr;
    private StringData widgetMultipleValidators;
    private Boolean nullValue;
    private Integer widgetConverter;
    private StringData widgetValidatorAttr;

    private StringData targetAjax;
    private StringData targetAjaxRefresh;
    private StringData emptyRequiredValidator;
    private String strValueChangeListener;
    private UIInput widgetFull;
    private UIInput widgetTransient;
    private StringData widgetFullValue;
    private StringData widgetTransientValue;

    private boolean render;
    private boolean fullState;
    private boolean transientState;

    private StringData widgetClient;
    private StringData widgetValueChangeListener;
    private StringData widgetFacesMessage;

    @DataValidator(widgetValues = VerticalSliderValues.class)
    private String widgetBeanValidation;

    public VerticalSliderBean() {

        this.values.put(widgetValues.getFirst(), widgetValues.getFirst());
        this.values.put(widgetValues.getSecond(), widgetValues.getSecond());
        this.values.put(widgetValues.getThird(), widgetValues.getThird());
        this.values.put(widgetValues.getFourth(), widgetValues.getFourth());

        this.beanBoundValue = new StringData(widgetValues.getFirst());
        this.toggleMessage = SHOW;
        this.render = false;

        widgetInsidePanel = new StringData(widgetValues.getFirst());
        widgetInsidePanel2 = new StringData(widgetValues.getFirst());

        dataTableValues = new ArrayList<StringData>();
        dataTableValues.add(new StringData(widgetValues.getFirst()));
        dataTableValues.add(new StringData(widgetValues.getSecond()));
        dataTableValues.add(new StringData(widgetValues.getThird()));
        dataTableValues.add(new StringData(widgetValues.getFourth()));

        dataTableValuesSubmit = new ArrayList<StringData>();
        dataTableValuesSubmit.add(new StringData(widgetValues.getFirst()));
        dataTableValuesSubmit.add(new StringData(widgetValues.getSecond()));

        dataTableAjaxValues = new ArrayList<StringData>();
        dataTableAjaxValues.add(new StringData(widgetValues.getFirst()));
        dataTableAjaxValues.add(new StringData(widgetValues.getSecond()));

        dataTableMultiCompValues = new ArrayList<StringData>();
        dataTableMultiCompValues.add(new StringData(widgetValues.getFirst()));
        dataTableMultiCompValues.add(new StringData(widgetValues.getSecond()));

        targetAjaxRefresh = new StringData(widgetValues.getFirst());
        targetAjax = new StringData(widgetValues.getFirst());

        transientState = false;
        fullState = false;

        widgetFullValue = new StringData(widgetValues.getFirst());
        widgetTransientValue = new StringData(widgetValues.getFirst());
        widgetClient = new StringData(widgetValues.getFirst());

        widgetReadOnly = new StringData(widgetValues.getFirst());
        widgetDisabled = new StringData(widgetValues.getFirst());

        lengthSingleValidator = new StringData(widgetValues.getFirst());
        emptyRequiredValidator = new StringData(widgetValues.getFirst());

        widgetRequiredAttr = new StringData(widgetValues.getFirst());
        widgetMultipleValidators = new StringData(widgetValues.getFirst());
        widgetBeanValidation = (String) widgetValues.getFirst();
        widgetValidatorAttr = new StringData(widgetValues.getFirst());

        widgetConverter = new Integer(0);

        widgetValueChangeListener = new StringData(widgetValues.getFirst());
        widgetFacesMessage = new StringData(widgetValues.getFirst());
    }

    public void changeTargetAjaxRefresh() {
        this.targetAjaxRefresh = new StringData(widgetValues.getSecond());
    }

    public StringData getBeanBoundValue() {
        return this.beanBoundValue;
    }

    public List<StringData> getDataTableAjaxValues() {
        return dataTableAjaxValues;
    }

    public List<StringData> getDataTableMultiCompValues() {
        return dataTableMultiCompValues;
    }

    public List<StringData> getDataTableValues() {
        return dataTableValues;
    }

    public List<StringData> getDataTableValuesSubmit() {
        return dataTableValuesSubmit;
    }

    public StringData getEmptyRequiredValidator() {
        return emptyRequiredValidator;
    }

    public StringData getLengthSingleValidator() {
        return lengthSingleValidator;
    }

    public Boolean getNullValue() {
        return nullValue;
    }

    public List<StringData> getOutputDataTableValuesSubmit() {
        return outputDataTableValuesSubmit;
    }

    public Boolean getRender() {
        return render;
    }

    public String getStrValueChangeListener() {
        return strValueChangeListener;
    }

    public StringData getTargetAjax() {
        return targetAjax;
    }

    public StringData getTargetAjaxRefresh() {
        return targetAjaxRefresh;
    }

    public String getToggleMessage() {
        return toggleMessage;
    }

    public boolean getTransientSet() {
        return widgetTransient.isTransient();
    }

    public String getWidgetBeanValidation() {
        return widgetBeanValidation;
    }

    public StringData getWidgetClient() {
        return widgetClient;
    }

    public Integer getWidgetConverter() {
        return widgetConverter;
    }

    public StringData getWidgetDisabled() {
        return widgetDisabled;
    }

    public StringData getWidgetFacesMessage() {
        return widgetFacesMessage;
    }

    public UIInput getWidgetFull() {
        return widgetFull;
    }

    public StringData getWidgetFullValue() {
        return widgetFullValue;
    }

    public StringData getWidgetInsidePanel() {
        return widgetInsidePanel;
    }

    public StringData getWidgetInsidePanel2() {
        return widgetInsidePanel2;
    }

    public StringData getWidgetMultipleValidators() {
        return widgetMultipleValidators;
    }

    public StringData getWidgetReadOnly() {
        return widgetReadOnly;
    }

    public StringData getWidgetRequiredAttr() {
        return widgetRequiredAttr;
    }

    public UIInput getWidgetTransient() {
        return widgetTransient;
    }

    public StringData getWidgetTransientValue() {
        return widgetTransientValue;
    }

    public StringData getWidgetValidatorAttr() {
        return widgetValidatorAttr;
    }

    public StringData getWidgetValueChangeListener() {
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

    public void setBeanBoundValue(StringData value) {
        this.beanBoundValue = value;
    }

    public void setDataTableAjaxValues(List<StringData> dataTableAjaxValues) {
        this.dataTableAjaxValues = dataTableAjaxValues;
    }

    public void setDataTableMultiCompValues(
            List<StringData> dataTableMultiCompValues) {
        this.dataTableMultiCompValues = dataTableMultiCompValues;
    }

    public void setDataTableValues(List<StringData> dataTableValues) {
        this.dataTableValues = dataTableValues;
    }

    public void setDataTableValuesSubmit(List<StringData> dataTableValuesSubmit) {
        this.dataTableValuesSubmit = dataTableValuesSubmit;
    }

    public void setEmptyRequiredValidator(StringData emptyRequiredValidator) {
        this.emptyRequiredValidator = emptyRequiredValidator;
    }

    public void setFullState(boolean fullState) {
        this.fullState = fullState;
    }

    public void setLengthSingleValidator(StringData lengthSingleValidator) {
        this.lengthSingleValidator = lengthSingleValidator;
    }

    public void setNullValue(Boolean nullValue) {
        this.nullValue = nullValue;
    }

    public void setOutputDataTableValuesSubmit(
            List<StringData> outputDataTableValuesSubmit) {
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

    public void setTargetAjax(StringData targetAjax) {
        this.targetAjax = targetAjax;
    }

    public void setTargetAjaxRefresh(StringData targetAjaxRefresh) {
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

    public void setWidgetBeanValidation(String widgetBeanValidation) {
        this.widgetBeanValidation = widgetBeanValidation;
    }

    public void setWidgetClient(StringData widgetClient) {
        this.widgetClient = widgetClient;
    }

    public void setWidgetConverter(Integer widgetConverter) {
        this.widgetConverter = widgetConverter;
    }

    public void setWidgetDisabled(StringData widgetDisabled) {
        this.widgetDisabled = widgetDisabled;
    }

    public void setWidgetFacesMessage(StringData widgetFacesMessage) {
        this.widgetFacesMessage = widgetFacesMessage;
    }

    public void setWidgetFull(UIInput widgetFull) {
        this.widgetFull = widgetFull;
    }

    public void setWidgetFullValue(StringData widgetFullValue) {
        this.widgetFullValue = widgetFullValue;
    }

    public void setWidgetInsidePanel(StringData widgetInsidePanel) {
        this.widgetInsidePanel = widgetInsidePanel;
    }

    public void setWidgetInsidePanel2(StringData widgetInsidePanel2) {
        this.widgetInsidePanel2 = widgetInsidePanel2;
    }

    public void setWidgetMultipleValidators(StringData widgetMultipleValidators) {
        this.widgetMultipleValidators = widgetMultipleValidators;
    }

    public void setWidgetReadOnly(StringData widgetReadOnly) {
        this.widgetReadOnly = widgetReadOnly;
    }

    public void setWidgetRequiredAttr(StringData widgetRequiredAttr) {
        this.widgetRequiredAttr = widgetRequiredAttr;
    }

    public void setWidgetTransient(UIInput widgetTransient) {
        this.widgetTransient = widgetTransient;
    }

    public void setWidgetTransientValue(StringData widgetTransientValue) {
        this.widgetTransientValue = widgetTransientValue;
    }

    public void setWidgetValidatorAttr(StringData widgetValidatorAttr) {
        this.widgetValidatorAttr = widgetValidatorAttr;
    }

    public void setWidgetValueChangeListener(
            StringData widgetValueChangeListener) {
        this.widgetValueChangeListener = widgetValueChangeListener;
    }

    public void setWidgetValues(WidgetValues widgetValues) {
        this.widgetValues = widgetValues;
    }

    public void submitDataTableValues() {
        outputDataTableValuesSubmit = new ArrayList<StringData>();
        Iterator<StringData> iterator = dataTableValuesSubmit.iterator();
        while (iterator.hasNext()) {
            outputDataTableValuesSubmit.add(new StringData(iterator.next()
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

    public Map<Object, Object> getValues() {
        return values;
    }

    public void setValues(Map<Object, Object> values) {
        this.values = values;
    }
}