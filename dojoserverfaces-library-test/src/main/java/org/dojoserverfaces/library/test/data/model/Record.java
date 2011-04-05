/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.library.test.data.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.el.ELResolver;
import javax.faces.context.FacesContext;

public class Record {
    private String htmlText = "<input />";
    private Integer hitMe = 0;
    private String text = null;
    private String name = null;
    private String descripiton = null;
    private List<String> savedTextValues = new ArrayList<String>();
    private String[] textArray = null;
    private Boolean bool = Boolean.FALSE;
    private Boolean boolOne = Boolean.TRUE;
    private Boolean boolTwo = Boolean.FALSE;
    private Integer count = new Integer("0");
    private Integer index = new Integer("0");
    private Float amount = null;
    private Float[] savedAmountValues = new Float[] { new Float(1),
            new Float(10), new Float(100), new Float(1000) };
    private Date birthDate = new Date();
    private Date birthTime = new Date();
    private Long time = new Long(3600000);
    private java.sql.Time sqlTime = new Time(time);
    private java.sql.Date sqlDate = new java.sql.Date(birthDate.getTime());
    private java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(
            birthDate.getTime());
    private List<Options> options;
    private String[] optionKeys = { "option1", "option2", "option3", "option4",
            "option5", "option6" };

    public class Options {
        public Options(String name, Boolean selected) {
            super();
            this.name = name;
            this.selected = selected;
        }

        private String name;
        private Boolean selected;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setSelected(Boolean selected) {
            this.selected = selected;
        }

        public Boolean getSelected() {
            return selected;
        }
    }

    public String doAction() {
        System.out.println("doAction - wahooo!");
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("phaseId: " + context.getCurrentPhaseId());
        ELResolver resolver = context.getApplication().getELResolver();
        System.out.println("doAction - record.count: "
                + resolver.getValue(context.getELContext(), null,
                        "store.record.count"));
        return "global";
    }

    public String doActionAndStayHere() {
        System.out.println("doAction - wahooo!");
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("phaseId: " + context.getCurrentPhaseId());
        ELResolver resolver = context.getApplication().getELResolver();
        System.out.println("doAction - record.count: "
                + resolver.getValue(context.getELContext(), null,
                        "store.record.count"));
        return null;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        if (!savedTextValues.contains(text)) {
            savedTextValues.add(text);
        }
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setSqlTime(java.sql.Time sqlTime) {
        this.sqlTime = sqlTime;
    }

    public java.sql.Time getSqlTime() {
        return sqlTime;
    }

    public void setSqlDate(java.sql.Date sqlDate) {
        this.sqlDate = sqlDate;
    }

    public java.sql.Date getSqlDate() {
        return sqlDate;
    }

    public void setSqlTimestamp(java.sql.Timestamp sqlTimestamp) {
        this.sqlTimestamp = sqlTimestamp;
    }

    public java.sql.Timestamp getSqlTimestamp() {
        return sqlTimestamp;
    }

    public void setBirthTime(Date birthTime) {
        this.birthTime = birthTime;
    }

    public Date getBirthTime() {
        return birthTime;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getAmount() {
        return amount;
    }

    public void setTextArray(String[] textArray) {
        this.textArray = textArray;
    }

    public String[] getTextArray() {
        return textArray;
    }

    public void setBoolOne(Boolean boolOne) {
        this.boolOne = boolOne;
    }

    public Boolean getBoolOne() {
        return boolOne;
    }

    public void setBoolTwo(Boolean boolTwo) {
        this.boolTwo = boolTwo;
    }

    public Boolean getBoolTwo() {
        return boolTwo;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public List<Options> getOptions() {
        if (null == options) {
            options = new ArrayList<Options>();
            for (String s : getOptionKeys()) {
                options.add(new Options(s, Boolean.FALSE));
            }
        }
        return options;
    }

    public List<String> getSelectedOptions() {
        ArrayList<String> selected = new ArrayList<String>();
        for (Options o : getOptions()) {
            if (o.getSelected().booleanValue()) {
                selected.add(o.getName());
            }
        }
        return selected;
    }

    public void setOptionKeys(String[] optionKeys) {
        this.optionKeys = optionKeys;
    }

    public String[] getOptionKeys() {
        return optionKeys;
    }

    public void setHitMe(Integer hitMe) {
        this.hitMe = hitMe;
    }

    public Integer getHitMe() {
        hitMe = new Integer(hitMe.intValue() + 1);
        return hitMe;
    }

    public List<String> getSavedTextValues() {
        return savedTextValues;
    }

    public Float[] getSavedAmountValues() {
        return savedAmountValues;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescripiton(String descripiton) {
        this.descripiton = descripiton;
    }

    public String getDescripiton() {
        return descripiton;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText;
    }

    public String getHtmlText() {
        return htmlText;
    }
}
