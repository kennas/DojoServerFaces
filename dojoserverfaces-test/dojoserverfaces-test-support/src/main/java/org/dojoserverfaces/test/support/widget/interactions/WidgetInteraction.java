/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.widget.interactions;

import org.dojoserverfaces.test.support.widget.VariableName;
import org.dojoserverfaces.test.support.widget.WidgetValues;

import com.thoughtworks.selenium.Selenium;

/**
 * Interface for interacting with a single-valued or multi-valued widgets
 * 
 * @author "jatin.varshney@in.ibm.com"
 * 
 */
public interface WidgetInteraction {
    /**
     * @return the Selenium instance for the current test case, it should be
     *         called only after corresponding setSelenium has been called.
     */
    public Selenium getSelenium();

    /**
     * @return the WidgetValues instance corresponding to this WidgetInteraction
     *         class
     */
    public WidgetValues getWidgetValues();

    /**
     * Sets the WidgetValues instance
     * 
     * @param widgetValues
     */
    public void setWidgetValues(WidgetValues widgetValues);

    /**
     * Sets the Selenium instance of the current test case.
     * 
     * @param selenium
     */
    public void setSelenium(Selenium selenium);

    /**
     * Sets all the field values as empty
     * 
     * @param element
     */
    public void setEmpty(String element);

    /**
     * Given the parentXPath, it finds if an element is present as its children
     * in the DOM, element is generally determined by the corresponding html tag
     * or set of html tags hierarchy associated with it.
     * 
     * @param parentXPath
     * @return
     */
    public boolean isElementPresentAsChild(String parentXPath);

    /**
     * returns the value of the element
     * 
     * @param element
     *            - node id like form:textBox
     * @return
     */
    public String getValue(String element);

    /**
     * Given a VariableName vName, it sets the value of the node with id element
     * (if not already set) with value specified by widgetValues instance of
     * this class corresponding to vName
     * 
     * @param element
     * @param vName
     */
    public void setValue(String element, VariableName... vName);

    /**
     * Returns the value displayed in the element when application is running on
     * browser. In case of multiValued widget returns the Space separated values
     * of all the fields of the widget
     * 
     * @param element
     *            - node id like form:textBox
     * @return
     */
    public String getDisplayedValue(String element);

    /**
     * Given a VariableName vName, it sets the displyed value of the node with
     * id element (if not already set) with value specified by widgetValues
     * instance of this class corresponding to vName
     * 
     * @param element
     * @param vName
     */
    public void setDisplayedValue(String element, VariableName... vName);

    /**
     * Given the parentXPath, returns the value of first instance of the widget
     * inside the parent
     * 
     * @param parentXPath
     * @return
     */
    public String getValueFromParentXPath(String parentXPath);

    /**
     * @return returns is the widget is multivalued
     */
    public boolean isMultiValued();

    /**
     * Given the parentXPath, it sets the value of the component with value
     * specified by widgetValues instance of this class corresponding to vName
     * 
     * @param parentXPath
     */
    public void setValueFromParentXPath(String parentXPath,
            VariableName... vName);

    /**
     * Given the parentXPath, returns the displayed value of first instance of
     * the widget inside the parent
     * 
     * @param parentXPath
     * @return
     */
    public String getDisplayedValueFromParentXPath(String parentXPath);

    /**
     * Given the parentXPath, it sets the displayed value of the component with
     * value specified by widgetValues instance of this class corresponding to
     * vName
     * 
     * @param parentXPath
     */
    public void setDisplayedValueFromParentXPath(String parentXPath,
            VariableName... vName);

}