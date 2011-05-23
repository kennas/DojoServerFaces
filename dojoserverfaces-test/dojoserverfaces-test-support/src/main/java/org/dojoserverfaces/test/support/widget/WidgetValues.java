/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.widget;

/**
 * Represents the widget values that are finally shown on the components in the
 * running facelet. These values can be used by bean to set data for a
 * component, can be used by selenium test cases to get and set values on a
 * component or can be used by particular widget-interaction class to return
 * selenium test case a meaningful value. It acts like a glue between bean,
 * facelet and selenium test case.
 * 
 * Subclasses can override these values, depending upon their requirement like
 * "a" can be replaced by "new Long(12345678)", these values can then be
 * converted into meaningful objects by bean
 * 
 * @author "jatin.varshney@in.ibm.com"
 * 
 */
public class WidgetValues {

    // The variable names are used to be first, second, third and fourth

    protected Object first = "a";
    protected Object second = "b";
    protected Object third = "c";
    protected Object fourth = "d";

    protected String badValue = "e";

    protected String displayFirst = "a";
    protected String displaySecond = "b";
    protected String displayThird = "c";
    protected String displayFourth = "d";

    protected String seleniumFirst = "a";
    protected String seleniumSecond = "b";
    protected String seleniumThird = "c";
    protected String seleniumFourth = "d";

    // The variables if used in a collection should be used in the following
    // order, so as to make test generation easy.
    protected Object[] values = { first, second, third, fourth };
    protected String[] displyedValues = { displayFirst, displaySecond,
            displayThird, displayFourth };
    protected String[] seleniumValues = { seleniumFirst, seleniumSecond,
            seleniumThird, seleniumFourth };

    public WidgetValues() {
    }

    public WidgetValues(Object first, Object second, Object third,
            Object fourth, String badValue, String firstDisp,
            String secondDisp, String thirdDisp, String fourthDisp,
            String seleniumFirstDisp, String seleniumSecondDisp,
            String seleniumThirdDisp, String seleniumFourthDisp) {
        this.values[0] = this.first = first;
        this.values[1] = this.second = second;
        this.values[2] = this.third = third;
        this.values[3] = this.fourth = fourth;

        this.badValue = badValue;

        this.displyedValues[0] = firstDisp;
        this.displyedValues[1] = secondDisp;
        this.displyedValues[2] = thirdDisp;
        this.displyedValues[3] = fourthDisp;

        this.seleniumValues[0] = seleniumFirstDisp;
        this.seleniumValues[1] = seleniumSecondDisp;
        this.seleniumValues[2] = seleniumThirdDisp;
        this.seleniumValues[3] = seleniumFourthDisp;
    }

    public WidgetValues(Object first, Object second, Object third,
            Object fourth, String badValue, String firstDisp,
            String secondDisp, String thirdDisp, String fourthDisp) {
        this(first, second, third, fourth, badValue, firstDisp, secondDisp,
                thirdDisp, fourthDisp, firstDisp, secondDisp, thirdDisp,
                fourthDisp);
    }

    public WidgetValues(Object first, Object second, Object third,
            Object fourth, String badValue) {
        this(first, second, third, fourth, badValue, (String) first,
                (String) second, (String) third, (String) fourth);
    }

    public Object getFirst() {
        return first;
    }

    public Object getSecond() {
        return second;
    }

    public Object getThird() {
        return third;
    }

    public Object getFourth() {
        return fourth;
    }

    public String getBadValue() {
        return badValue;
    }

    public Object getValue(int i) {
        return values[i];
    }

    public Object getValue(VariableName vName) {
        return getValueFromArray(values, vName);
    }

    /**
     * Return space separated values from the variable names passed in the args
     * 
     * @param args
     * @return
     */
    public String getValues(VariableName... args) {
        return getAllValuesFromArray(values, args);
    }

    /**
     * Returns the index of an item value in the values array
     * 
     * @param itemValue
     * @return
     */
    public int getValueIndex(Object itemValue) {
        return getValueIndexFromArray(values, itemValue);
    }

    /**
     * @return a simple value, that can be used directly by a facelet, not bound
     *         to the bean
     */
    public Object getSimpleValue() {
        return first;
    }

    public String getDisplayedValue(int i) {
        return displyedValues[i];
    }

    public String getDisplayedValue(VariableName vName) {
        return getValueFromArray(displyedValues, vName).toString();
    }

    /**
     * Return space separated values from the variable names passed in the args
     * 
     * @param args
     * @return
     */
    public String getDisplayedValues(VariableName... args) {
        return getAllValuesFromArray(displyedValues, args);
    }

    /**
     * Returns the index of an item value in the displayedValues array
     * 
     * @param itemValue
     * @return
     */
    public int getDisplayedValueIndex(String itemValue) {
        return getValueIndexFromArray(displyedValues, itemValue);
    }

    public Object[] getValuesArray() {
        return this.values;
    }

    public String getSeleniumValue(int i) {
        return seleniumValues[i];
    }

    public String getSeleniumValue(VariableName vName) {
        return getValueFromArray(seleniumValues, vName).toString();
    }

    /**
     * Return space separated values from the variable names passed in the args
     * 
     * @param args
     * @return
     */
    public String getSeleniumValues(VariableName... args) {
        return getAllValuesFromArray(seleniumValues, args);
    }

    /**
     * Returns the index of an item value in the displayedValues array
     * 
     * @param itemValue
     * @return
     */
    public int getSeleniumValueIndex(String itemValue) {
        return getValueIndexFromArray(seleniumValues, itemValue);
    }

    private Object getValueFromArray(Object[] arr, VariableName vName) {
        if (VariableName.BAD == vName)
            return this.badValue;
        return arr[vName.getValue()];
    }

    private String getAllValuesFromArray(Object[] arr, VariableName... args) {
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < args.length; i++) {
            s.append(getValueFromArray(arr, args[i]).toString());
            s.append(" ");
        }
        return s.toString().trim();
    }

    private int getValueIndexFromArray(Object[] arr, Object itemValue) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(itemValue))
                return i;
        }
        return -1;
    }
}