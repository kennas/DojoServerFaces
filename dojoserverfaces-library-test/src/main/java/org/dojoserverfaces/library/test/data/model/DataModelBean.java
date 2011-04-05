/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.library.test.data.model;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "dataModel")
@SessionScoped
public class DataModelBean {
    private ListDataModel<KeyValuePair> data;
    private String value;

    public String getValue() {
        StringBuilder content = new StringBuilder(
                "{identifier: 'id',label: 'name',  items: [");
        Map<?, ?> request = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();
        String topicValue = (String) request.get("id");
        if ("cn".equals(topicValue)) {
            content.append("{ id: 'CN', name:'China', type:'country',Money:'50',Mark:true}");

        }
        if ("all".equals(topicValue)) {
            content.append("{ id: 'CN', name:'China', type:'country',Money:'50',Mark:true},");
            content.append("{ id: 'IN', name:'India', type:'country',Money:'20',Mark:false },");
            content.append("{ id: 'RU', name:'Russia', type:'country',Money:'40',Mark:true },");
            content.append("{ id: 'MN', name:'Mongolia', type:'country',Money:'10',Mark:false }");
        }
        content.append("]}");
        this.value = content.toString();
        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }

    public DataModelBean() {
        ArrayList<KeyValuePair> exampleValues = new ArrayList<KeyValuePair>();

        for (int i = 0; i < 10; ++i) {
            exampleValues.add(new KeyValuePair("item" + i, "value" + i));
        }

        this.data = new ListDataModel<KeyValuePair>(exampleValues);
    }

    public ListDataModel<KeyValuePair> getData() {
        return this.data;
    }
}
