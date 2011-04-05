/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.multiselect;

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

import org.dojoserverfaces.tests.validator.DataValidator;
import org.dojoserverfaces.tests.validator.ValidatorUtil;
import org.dojoserverfaces.tests.values.StringArrayData;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

@ManagedBean(name = "multiSelectBean")
@RequestScoped
public class MultiSelectBean {
    private WidgetValues widgetValues = new MultiSelectValues();

    private Map<Object, Object> values = new LinkedHashMap<Object, Object>();

    public static String HIDE = "Hide";
    public static String SHOW = "Show";
    private String toggleMessage;

    private StringArrayData beanBoundValue;
    private StringArrayData widgetInsidePanel;
    private StringArrayData widgetInsidePanel2;

    private List<StringArrayData> dataTableValues;
    private List<StringArrayData> dataTableValuesSubmit;
    private List<StringArrayData> outputDataTableValuesSubmit;
    private List<StringArrayData> dataTableAjaxValues;
    private List<StringArrayData> dataTableMultiCompValues;

    private StringArrayData widgetReadOnly;
    private StringArrayData widgetDisabled;

    private StringArrayData lengthSingleValidator;
    private StringArrayData widgetRequiredAttr;
    private StringArrayData widgetMultipleValidators;
    private Boolean nullValue;
    private Integer[] widgetConverter;
    private StringArrayData widgetValidatorAttr;

    private StringArrayData targetAjax;
    private StringArrayData targetAjaxRefresh;
    private StringArrayData emptyRequiredValidator;
    private String strValueChangeListener;
    private UIInput widgetFull;
    private UIInput widgetTransient;
    private StringArrayData widgetFullValue;
    private StringArrayData widgetTransientValue;

    private boolean render;
    private boolean fullState;
    private boolean transientState;

    private StringArrayData widgetClient;
    private StringArrayData widgetValueChangeListener;
    private StringArrayData widgetFacesMessage;

    @DataValidator(widgetValues = MultiSelectValues.class)
    private String[] widgetBeanValidation;

    public MultiSelectBean() {

        this.values.put(widgetValues.getFirst(), widgetValues.getFirst());
        this.values.put(widgetValues.getSecond(), widgetValues.getSecond());
        this.values.put(widgetValues.getThird(), widgetValues.getThird());
        this.values.put(widgetValues.getFourth(), widgetValues.getFourth());

        this.beanBoundValue = new StringArrayData(widgetValues.getFirst());
        this.toggleMessage = SHOW;
        this.render = false;

        widgetInsidePanel = new StringArrayData(widgetValues.getFirst());
        widgetInsidePanel2 = new StringArrayData(widgetValues.getFirst());

        dataTableValues = new ArrayList<StringArrayData>();
        dataTableValues.add(new StringArrayData(widgetValues.getFirst()));
        dataTableValues.add(new StringArrayData(widgetValues.getSecond()));
        dataTableValues.add(new StringArrayData(widgetValues.getThird()));
        dataTableValues.add(new StringArrayData(widgetValues.getFourth()));

        dataTableValuesSubmit = new ArrayList<StringArrayData>();
        dataTableValuesSubmit.add(new StringArrayData(widgetValues.getFirst()));
        dataTableValuesSubmit
                .add(new StringArrayData(widgetValues.getSecond()));

        dataTableAjaxValues = new ArrayList<StringArrayData>();
        dataTableAjaxValues.add(new StringArrayData(widgetValues.getFirst()));
        dataTableAjaxValues.add(new StringArrayData(widgetValues.getSecond()));

        dataTableMultiCompValues = new ArrayList<StringArrayData>();
        dataTableMultiCompValues.add(new StringArrayData(widgetValues
                .getFirst()));
        dataTableMultiCompValues.add(new StringArrayData(widgetValues
                .getSecond()));

        targetAjaxRefresh = new StringArrayData(widgetValues.getFirst());
        targetAjax = new StringArrayData(widgetValues.getFirst());

        transientState = false;
        fullState = false;

        widgetFullValue = new StringArrayData(widgetValues.getFirst());
        widgetTransientValue = new StringArrayData(widgetValues.getFirst());
        widgetClient = new StringArrayData(widgetValues.getFirst());

        widgetReadOnly = new StringArrayData(widgetValues.getFirst());
        widgetDisabled = new StringArrayData(widgetValues.getFirst());

        lengthSingleValidator = new StringArrayData(widgetValues.getFirst());
        emptyRequiredValidator = new StringArrayData(widgetValues.getFirst());

        widgetRequiredAttr = new StringArrayData(widgetValues.getFirst());
        widgetMultipleValidators = new StringArrayData(widgetValues.getFirst());

        widgetBeanValidation = new String[1];
        widgetBeanValidation[0] = (String) widgetValues.getFirst();
        widgetValidatorAttr = new StringArrayData(widgetValues.getFirst());

        widgetConverter = new Integer[1];
        widgetConverter[0] = new Integer(0);

        widgetValueChangeListener = new StringArrayData(widgetValues.getFirst());
        widgetFacesMessage = new StringArrayData(widgetValues.getFirst());
    }

    public void changeTargetAjaxRefresh() {
        this.targetAjaxRefresh = new StringArrayData(widgetValues.getSecond());
    }

    public StringArrayData getBeanBoundValue() {
        return this.beanBoundValue;
    }

    public List<StringArrayData> getDataTableAjaxValues() {
        return dataTableAjaxValues;
    }

    public List<StringArrayData> getDataTableMultiCompValues() {
        return dataTableMultiCompValues;
    }

    public List<StringArrayData> getDataTableValues() {
        return dataTableValues;
    }

    public List<StringArrayData> getDataTableValuesSubmit() {
        return dataTableValuesSubmit;
    }

    public StringArrayData getEmptyRequiredValidator() {
        return emptyRequiredValidator;
    }

    public StringArrayData getLengthSingleValidator() {
        return lengthSingleValidator;
    }

    public Boolean getNullValue() {
        return nullValue;
    }

    public List<StringArrayData> getOutputDataTableValuesSubmit() {
        return outputDataTableValuesSubmit;
    }

    public Boolean getRender() {
        return render;
    }

    public String getStrValueChangeListener() {
        return strValueChangeListener;
    }

    public StringArrayData getTargetAjax() {
        return targetAjax;
    }

    public StringArrayData getTargetAjaxRefresh() {
        return targetAjaxRefresh;
    }

    public String getToggleMessage() {
        return toggleMessage;
    }

    public boolean getTransientSet() {
        return widgetTransient.isTransient();
    }

    public String[] getWidgetBeanValidation() {
        return widgetBeanValidation;
    }

    public StringArrayData getWidgetClient() {
        return widgetClient;
    }

    public Integer[] getWidgetConverter() {
        return widgetConverter;
    }

    public StringArrayData getWidgetDisabled() {
        return widgetDisabled;
    }

    public StringArrayData getWidgetFacesMessage() {
        return widgetFacesMessage;
    }

    public UIInput getWidgetFull() {
        return widgetFull;
    }

    public StringArrayData getWidgetFullValue() {
        return widgetFullValue;
    }

    public StringArrayData getWidgetInsidePanel() {
        return widgetInsidePanel;
    }

    public StringArrayData getWidgetInsidePanel2() {
        return widgetInsidePanel2;
    }

    public StringArrayData getWidgetMultipleValidators() {
        return widgetMultipleValidators;
    }

    public StringArrayData getWidgetReadOnly() {
        return widgetReadOnly;
    }

    public StringArrayData getWidgetRequiredAttr() {
        return widgetRequiredAttr;
    }

    public UIInput getWidgetTransient() {
        return widgetTransient;
    }

    public StringArrayData getWidgetTransientValue() {
        return widgetTransientValue;
    }

    public StringArrayData getWidgetValidatorAttr() {
        return widgetValidatorAttr;
    }

    public StringArrayData getWidgetValueChangeListener() {
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

    public void setBeanBoundValue(StringArrayData value) {
        this.beanBoundValue = value;
    }

    public void setDataTableAjaxValues(List<StringArrayData> dataTableAjaxValues) {
        this.dataTableAjaxValues = dataTableAjaxValues;
    }

    public void setDataTableMultiCompValues(
            List<StringArrayData> dataTableMultiCompValues) {
        this.dataTableMultiCompValues = dataTableMultiCompValues;
    }

    public void setDataTableValues(List<StringArrayData> dataTableValues) {
        this.dataTableValues = dataTableValues;
    }

    public void setDataTableValuesSubmit(
            List<StringArrayData> dataTableValuesSubmit) {
        this.dataTableValuesSubmit = dataTableValuesSubmit;
    }

    public void setEmptyRequiredValidator(StringArrayData emptyRequiredValidator) {
        this.emptyRequiredValidator = emptyRequiredValidator;
    }

    public void setFullState(boolean fullState) {
        this.fullState = fullState;
    }

    public void setLengthSingleValidator(StringArrayData lengthSingleValidator) {
        this.lengthSingleValidator = lengthSingleValidator;
    }

    public void setNullValue(Boolean nullValue) {
        this.nullValue = nullValue;
    }

    public void setOutputDataTableValuesSubmit(
            List<StringArrayData> outputDataTableValuesSubmit) {
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

    public void setTargetAjax(StringArrayData targetAjax) {
        this.targetAjax = targetAjax;
    }

    public void setTargetAjaxRefresh(StringArrayData targetAjaxRefresh) {
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

    public void setWidgetBeanValidation(String[] widgetBeanValidation) {
        this.widgetBeanValidation = widgetBeanValidation;
    }

    public void setWidgetClient(StringArrayData widgetClient) {
        this.widgetClient = widgetClient;
    }

    public void setWidgetConverter(Integer[] widgetConverter) {
        this.widgetConverter = widgetConverter;
    }

    public void setWidgetDisabled(StringArrayData widgetDisabled) {
        this.widgetDisabled = widgetDisabled;
    }

    public void setWidgetFacesMessage(StringArrayData widgetFacesMessage) {
        this.widgetFacesMessage = widgetFacesMessage;
    }

    public void setWidgetFull(UIInput widgetFull) {
        this.widgetFull = widgetFull;
    }

    public void setWidgetFullValue(StringArrayData widgetFullValue) {
        this.widgetFullValue = widgetFullValue;
    }

    public void setWidgetInsidePanel(StringArrayData widgetInsidePanel) {
        this.widgetInsidePanel = widgetInsidePanel;
    }

    public void setWidgetInsidePanel2(StringArrayData widgetInsidePanel2) {
        this.widgetInsidePanel2 = widgetInsidePanel2;
    }

    public void setWidgetMultipleValidators(
            StringArrayData widgetMultipleValidators) {
        this.widgetMultipleValidators = widgetMultipleValidators;
    }

    public void setWidgetReadOnly(StringArrayData widgetReadOnly) {
        this.widgetReadOnly = widgetReadOnly;
    }

    public void setWidgetRequiredAttr(StringArrayData widgetRequiredAttr) {
        this.widgetRequiredAttr = widgetRequiredAttr;
    }

    public void setWidgetTransient(UIInput widgetTransient) {
        this.widgetTransient = widgetTransient;
    }

    public void setWidgetTransientValue(StringArrayData widgetTransientValue) {
        this.widgetTransientValue = widgetTransientValue;
    }

    public void setWidgetValidatorAttr(StringArrayData widgetValidatorAttr) {
        this.widgetValidatorAttr = widgetValidatorAttr;
    }

    public void setWidgetValueChangeListener(
            StringArrayData widgetValueChangeListener) {
        this.widgetValueChangeListener = widgetValueChangeListener;
    }

    public void setWidgetValues(WidgetValues widgetValues) {
        this.widgetValues = widgetValues;
    }

    public void submitDataTableValues() {
        outputDataTableValuesSubmit = new ArrayList<StringArrayData>();
        Iterator<StringArrayData> iterator = dataTableValuesSubmit.iterator();
        while (iterator.hasNext()) {
            outputDataTableValuesSubmit.add(new StringArrayData(iterator.next()
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