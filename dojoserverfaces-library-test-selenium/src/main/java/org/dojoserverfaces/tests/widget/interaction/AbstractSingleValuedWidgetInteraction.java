/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.widget.interaction;

import org.dojoserverfaces.tests.widget.values.VariableName;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

public abstract class AbstractSingleValuedWidgetInteraction extends
        AbstractWidgetInteraction {

    public static final String XPATH_CHARACTER = "//";
    protected String TAG_NAME = "input";

    public AbstractSingleValuedWidgetInteraction(WidgetValues widgetValues) {
        super(widgetValues);
    }

    public AbstractSingleValuedWidgetInteraction() {
        super();
    }

    @Override
    public String getDisplayedValue(String element) {
        return selenium.getValue(element);
    }

    @Override
    public String getValue(String element) {
        return selenium.getEval("window.dijit.byId('" + element
                + "').attr('value')");
    }

    @Override
    public String getValueFromParentXPath(String parentXPath) {
        // TODO : Need to change this logic.
        return selenium.getValue(parentXPath + XPATH_CHARACTER + TAG_NAME);
    }

    @Override
    public String getDisplayedValueFromParentXPath(String parentXPath) {
        return this.getDisplayedValue(parentXPath + XPATH_CHARACTER + TAG_NAME);
    }

    @Override
    public boolean isElementPresentAsChild(String parentXPath) {
        return selenium.isElementPresent(parentXPath + XPATH_CHARACTER
                + TAG_NAME);
    }

    @Override
    public void setDisplayedValue(String element, VariableName... vName) {
        String id = getElementId(element);
        String value = vName != null ? widgetValues.getDisplayedValue(vName[0])
                : "";
        if (id != null)
            selenium.type(id, value);
    }

    @Override
    public void setValue(String element, VariableName... vName) {
        String id = getElementId(element);
        String value = vName != null ? widgetValues.getDisplayedValue(vName[0])
                : "";
        if (id != null)
            selenium.getEval("window.dijit.byId('" + id + "').attr('value',\""
                    + value + "\")");
    }

    @Override
    public boolean isMultiValued() {
        return false;
    }

    public void setDisplayedValueFromParentXPath(String parentXPath,
            VariableName... vName) {
        this.setDisplayedValue(parentXPath + XPATH_CHARACTER + TAG_NAME, vName);
    }

    public void setValueFromParentXPath(String parentXPath,
            VariableName... vName) {
        this.setValue(parentXPath + XPATH_CHARACTER + TAG_NAME, vName);
    }

    private String getElementId(String element) {
        String id = element;
        if (id.startsWith(XPATH_CHARACTER)) {
            // find id of element, then enter value in it.
            id = selenium.getAttribute(element + "@id");
        }
        return id;
    }
}