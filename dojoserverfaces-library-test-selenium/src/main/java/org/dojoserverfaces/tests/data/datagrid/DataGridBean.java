/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.data.datagrid;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.dojoserverfaces.tests.values.StringData;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

@ManagedBean
@RequestScoped
public class DataGridBean {
    private WidgetValues widgetValues = new DataGridValues();
    private Object store = "st";
    private Boolean selectable;
    private String rowSelector;
    private String selectionMode;
    private String loadingMessage;
    private String errorMessage;
    private String headerMenuId = "vehicle";
    private String query;
    private Object autoHeight;
    private Object rowsPerPage;
    private Boolean singleClickEdit;
    private StringData beanBoundValue;

    public DataGridBean() {
        this.beanBoundValue = new StringData(widgetValues.getFirst());
    }

    public Object getStore() {
        return store;
    }

    public void setStore(Object store) {
        this.store = store;
    }

    public Boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }

    public String getRowSelector() {
        return rowSelector;
    }

    public void setRowSelector(String rowSelector) {
        this.rowSelector = rowSelector;
    }

    public String getSelectionMode() {
        return selectionMode;
    }

    public void setSelectionMode(String selectionMode) {
        this.selectionMode = selectionMode;
    }

    public String getLoadingMessage() {
        return loadingMessage;
    }

    public void setLoadingMessage(String loadingMessage) {
        this.loadingMessage = loadingMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getHeaderMenuId() {
        return headerMenuId;
    }

    public void setHeaderMenuId(String headerMenuId) {
        this.headerMenuId = headerMenuId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Object getAutoHeight() {
        return autoHeight;
    }

    public void setAutoHeight(Object autoHeight) {
        this.autoHeight = autoHeight;
    }

    public Object getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(Object rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public Boolean getSingleClickEdit() {
        return singleClickEdit;
    }

    public void setSingleClickEdit(Boolean singleClickEdit) {
        this.singleClickEdit = singleClickEdit;
    }

    public Date getCurrentTime() {
        return (new Date());
    }

    public StringData getBeanBoundValue() {
        return this.beanBoundValue;
    }

    public WidgetValues getWidgetValues() {
        return widgetValues;
    }

    public void setBeanBoundValue(StringData value) {
        this.beanBoundValue = value;
    }

    public void setWidgetValues(WidgetValues widgetValues) {
        this.widgetValues = widgetValues;
    }
}