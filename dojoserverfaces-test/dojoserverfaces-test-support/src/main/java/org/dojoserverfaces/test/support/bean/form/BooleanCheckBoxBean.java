/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.bean.form;

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

import org.dojoserverfaces.test.support.validator.DataValidator;
import org.dojoserverfaces.test.support.validator.ValidatorUtil;
import org.dojoserverfaces.test.support.values.BooleanData;
import org.dojoserverfaces.test.support.widget.WidgetValues;

@ManagedBean
@RequestScoped
public class BooleanCheckBoxBean {
    private WidgetValues widgetValues = new BooleanCheckBoxValues();

    public static String HIDE = "Hide";
    public static String SHOW = "Show";
    private String toggleMessage;

    private BooleanData beanBoundValue;
    private BooleanData widgetInsidePanel;
    private BooleanData widgetInsidePanel2;

    private List<BooleanData> dataTableValues;
    private List<BooleanData> dataTableValuesSubmit;
    private List<BooleanData> outputDataTableValuesSubmit;
    private List<BooleanData> dataTableAjaxValues;
    private List<BooleanData> dataTableMultiCompValues;

    private BooleanData widgetReadOnly;
    private BooleanData widgetDisabled;

    private BooleanData lengthSingleValidator;
    private BooleanData widgetRequiredAttr;
    private BooleanData widgetMultipleValidators;
    private Boolean nullValue;
    private Integer widgetConverter;
    private BooleanData widgetValidatorAttr;

    private BooleanData targetAjax;
    private BooleanData targetAjaxRefresh;
    private BooleanData emptyRequiredValidator;
    private String strValueChangeListener;
    private UIInput widgetFull;
    private UIInput widgetTransient;
    private BooleanData widgetFullValue;
    private BooleanData widgetTransientValue;

    private boolean render;
    private boolean fullState;
    private boolean transientState;

    private BooleanData widgetClient;
    private BooleanData widgetValueChangeListener;
    private BooleanData widgetFacesMessage;

    @DataValidator(widgetValues = BooleanCheckBoxValues.class)
    private Boolean widgetBeanValidation;

    public BooleanCheckBoxBean() {
        this.beanBoundValue = new BooleanData(widgetValues.getFirst());
        this.toggleMessage = SHOW;
        this.render = false;

        widgetInsidePanel = new BooleanData(widgetValues.getFirst());
        widgetInsidePanel2 = new BooleanData(widgetValues.getFirst());

        dataTableValues = new ArrayList<BooleanData>();
        dataTableValues.add(new BooleanData(widgetValues.getFirst()));
        dataTableValues.add(new BooleanData(widgetValues.getSecond()));
        dataTableValues.add(new BooleanData(widgetValues.getThird()));
        dataTableValues.add(new BooleanData(widgetValues.getFourth()));

        dataTableValuesSubmit = new ArrayList<BooleanData>();
        dataTableValuesSubmit.add(new BooleanData(widgetValues.getFirst()));
        dataTableValuesSubmit.add(new BooleanData(widgetValues.getSecond()));

        dataTableAjaxValues = new ArrayList<BooleanData>();
        dataTableAjaxValues.add(new BooleanData(widgetValues.getFirst()));
        dataTableAjaxValues.add(new BooleanData(widgetValues.getSecond()));

        dataTableMultiCompValues = new ArrayList<BooleanData>();
        dataTableMultiCompValues.add(new BooleanData(widgetValues.getFirst()));
        dataTableMultiCompValues.add(new BooleanData(widgetValues.getSecond()));

        targetAjaxRefresh = new BooleanData(widgetValues.getFirst());
        targetAjax = new BooleanData(widgetValues.getFirst());

        transientState = false;
        fullState = false;

        widgetFullValue = new BooleanData(widgetValues.getFirst());
        widgetTransientValue = new BooleanData(widgetValues.getFirst());
        widgetClient = new BooleanData(widgetValues.getFirst());

        widgetReadOnly = new BooleanData(widgetValues.getFirst());
        widgetDisabled = new BooleanData(widgetValues.getFirst());

        lengthSingleValidator = new BooleanData(widgetValues.getFirst());
        emptyRequiredValidator = new BooleanData(widgetValues.getFirst());

        widgetRequiredAttr = new BooleanData(widgetValues.getFirst());
        widgetMultipleValidators = new BooleanData(widgetValues.getFirst());
        widgetBeanValidation = (Boolean) widgetValues.getFirst();
        widgetValidatorAttr = new BooleanData(widgetValues.getFirst());

        widgetConverter = new Integer(0);

        widgetValueChangeListener = new BooleanData(widgetValues.getFirst());
        widgetFacesMessage = new BooleanData(widgetValues.getFirst());
    }

    public void changeTargetAjaxRefresh() {
        this.targetAjaxRefresh = new BooleanData(widgetValues.getSecond());
    }

    public BooleanData getBeanBoundValue() {
        return this.beanBoundValue;
    }

    public List<BooleanData> getDataTableAjaxValues() {
        return dataTableAjaxValues;
    }

    public List<BooleanData> getDataTableMultiCompValues() {
        return dataTableMultiCompValues;
    }

    public List<BooleanData> getDataTableValues() {
        return dataTableValues;
    }

    public List<BooleanData> getDataTableValuesSubmit() {
        return dataTableValuesSubmit;
    }

    public BooleanData getEmptyRequiredValidator() {
        return emptyRequiredValidator;
    }

    public BooleanData getLengthSingleValidator() {
        return lengthSingleValidator;
    }

    public Boolean getNullValue() {
        return nullValue;
    }

    public List<BooleanData> getOutputDataTableValuesSubmit() {
        return outputDataTableValuesSubmit;
    }

    public Boolean getRender() {
        return render;
    }

    public String getStrValueChangeListener() {
        return strValueChangeListener;
    }

    public BooleanData getTargetAjax() {
        return targetAjax;
    }

    public BooleanData getTargetAjaxRefresh() {
        return targetAjaxRefresh;
    }

    public String getToggleMessage() {
        return toggleMessage;
    }

    public boolean getTransientSet() {
        return widgetTransient.isTransient();
    }

    public Boolean getWidgetBeanValidation() {
        return widgetBeanValidation;
    }

    public BooleanData getWidgetClient() {
        return widgetClient;
    }

    public Integer getWidgetConverter() {
        return widgetConverter;
    }

    public BooleanData getWidgetDisabled() {
        return widgetDisabled;
    }

    public BooleanData getWidgetFacesMessage() {
        return widgetFacesMessage;
    }

    public UIInput getWidgetFull() {
        return widgetFull;
    }

    public BooleanData getWidgetFullValue() {
        return widgetFullValue;
    }

    public BooleanData getWidgetInsidePanel() {
        return widgetInsidePanel;
    }

    public BooleanData getWidgetInsidePanel2() {
        return widgetInsidePanel2;
    }

    public BooleanData getWidgetMultipleValidators() {
        return widgetMultipleValidators;
    }

    public BooleanData getWidgetReadOnly() {
        return widgetReadOnly;
    }

    public BooleanData getWidgetRequiredAttr() {
        return widgetRequiredAttr;
    }

    public UIInput getWidgetTransient() {
        return widgetTransient;
    }

    public BooleanData getWidgetTransientValue() {
        return widgetTransientValue;
    }

    public BooleanData getWidgetValidatorAttr() {
        return widgetValidatorAttr;
    }

    public BooleanData getWidgetValueChangeListener() {
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

    public void setBeanBoundValue(BooleanData value) {
        this.beanBoundValue = value;
    }

    public void setDataTableAjaxValues(List<BooleanData> dataTableAjaxValues) {
        this.dataTableAjaxValues = dataTableAjaxValues;
    }

    public void setDataTableMultiCompValues(
            List<BooleanData> dataTableMultiCompValues) {
        this.dataTableMultiCompValues = dataTableMultiCompValues;
    }

    public void setDataTableValues(List<BooleanData> dataTableValues) {
        this.dataTableValues = dataTableValues;
    }

    public void setDataTableValuesSubmit(List<BooleanData> dataTableValuesSubmit) {
        this.dataTableValuesSubmit = dataTableValuesSubmit;
    }

    public void setEmptyRequiredValidator(BooleanData emptyRequiredValidator) {
        this.emptyRequiredValidator = emptyRequiredValidator;
    }

    public void setFullState(boolean fullState) {
        this.fullState = fullState;
    }

    public void setLengthSingleValidator(BooleanData lengthSingleValidator) {
        this.lengthSingleValidator = lengthSingleValidator;
    }

    public void setNullValue(Boolean nullValue) {
        this.nullValue = nullValue;
    }

    public void setOutputDataTableValuesSubmit(
            List<BooleanData> outputDataTableValuesSubmit) {
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

    public void setTargetAjax(BooleanData targetAjax) {
        this.targetAjax = targetAjax;
    }

    public void setTargetAjaxRefresh(BooleanData targetAjaxRefresh) {
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

    public void setWidgetBeanValidation(Boolean widgetBeanValidation) {
        this.widgetBeanValidation = widgetBeanValidation;
    }

    public void setWidgetClient(BooleanData widgetClient) {
        this.widgetClient = widgetClient;
    }

    public void setWidgetConverter(Integer widgetConverter) {
        this.widgetConverter = widgetConverter;
    }

    public void setWidgetDisabled(BooleanData widgetDisabled) {
        this.widgetDisabled = widgetDisabled;
    }

    public void setWidgetFacesMessage(BooleanData widgetFacesMessage) {
        this.widgetFacesMessage = widgetFacesMessage;
    }

    public void setWidgetFull(UIInput widgetFull) {
        this.widgetFull = widgetFull;
    }

    public void setWidgetFullValue(BooleanData widgetFullValue) {
        this.widgetFullValue = widgetFullValue;
    }

    public void setWidgetInsidePanel(BooleanData widgetInsidePanel) {
        this.widgetInsidePanel = widgetInsidePanel;
    }

    public void setWidgetInsidePanel2(BooleanData widgetInsidePanel2) {
        this.widgetInsidePanel2 = widgetInsidePanel2;
    }

    public void setWidgetMultipleValidators(BooleanData widgetMultipleValidators) {
        this.widgetMultipleValidators = widgetMultipleValidators;
    }

    public void setWidgetReadOnly(BooleanData widgetReadOnly) {
        this.widgetReadOnly = widgetReadOnly;
    }

    public void setWidgetRequiredAttr(BooleanData widgetRequiredAttr) {
        this.widgetRequiredAttr = widgetRequiredAttr;
    }

    public void setWidgetTransient(UIInput widgetTransient) {
        this.widgetTransient = widgetTransient;
    }

    public void setWidgetTransientValue(BooleanData widgetTransientValue) {
        this.widgetTransientValue = widgetTransientValue;
    }

    public void setWidgetValidatorAttr(BooleanData widgetValidatorAttr) {
        this.widgetValidatorAttr = widgetValidatorAttr;
    }

    public void setWidgetValueChangeListener(
            BooleanData widgetValueChangeListener) {
        this.widgetValueChangeListener = widgetValueChangeListener;
    }

    public void setWidgetValues(WidgetValues widgetValues) {
        this.widgetValues = widgetValues;
    }

    public void submitDataTableValues() {
        outputDataTableValuesSubmit = new ArrayList<BooleanData>();
        Iterator<BooleanData> iterator = dataTableValuesSubmit.iterator();
        while (iterator.hasNext()) {
            outputDataTableValuesSubmit.add(new BooleanData(iterator.next()
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
    
    private class BooleanCheckBoxValues extends WidgetValues {

         public BooleanCheckBoxValues() {
             super(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, "BAD",
                     "true", "false", "true", "false", "on", "off", "on", "off");
         }
     }
}