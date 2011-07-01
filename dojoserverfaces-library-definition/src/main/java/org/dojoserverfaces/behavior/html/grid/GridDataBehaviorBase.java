/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html.grid;

import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;

/**
 * This is a behavior base class for grid behaviors with fields and data
 * attributes.
 */
abstract class GridDataBehaviorBase extends SimpleGridOperationBase {

    protected GridDataBehaviorBase(String operationTarget, String methodName) {
        super(operationTarget, methodName);

    }

    protected GridDataBehaviorBase(String methodName) {
        super(methodName);

    }

    private String data;
    private String fields;

    /**
     * A space separated list of fields in the targeted datagrid.
     */
    @Attribute(required = true)
    public String getFields() {
        return fields;
    }

    /**
     * Setter for fields of the datagrid's cell to act on divided by space. e.g.
     * the row item is stored like "{ id: 'CN',name:'China',
     * type:'country',Money:'50',Mark:true}" then set fields attribute of the
     * behavior to "id name type Money Mark"
     */
    public void setFields(String fieldsValue) {
        this.fields = fieldsValue;
    }

    /**
     * A space separated list of input components from which values will be
     * retieved.
     * 
     */
    @Attribute(required = true)
    public String getData() {
        return data;
    }

    /**
     * Setter for ids of input components to act on divided by space.
     */
    public void setData(String dataValue) {
        this.data = dataValue;
    }

    /**
     * 
     * @param sb
     * @param fields
     *            the label of the value
     * @param sourceIds
     *            the components' ids of the source
     * @return
     */
    private StringBuilder getDataMap(ClientBehaviorContext behaviorContext,
            StringBuilder sb, String fields, String sourceIds) {
        sb.append("{");
        String[] splitedFields = fields.split("\\s");
        String[] widgetIds = sourceIds.split("\\s");
        for (int i = 0; i < splitedFields.length; i++) {
            if (i > 0) {
                sb.append(",");
            }

            sb.append(splitedFields[i]).append(":");

            appendGetDijitAttr(sb, getClientId(widgetIds[i], behaviorContext),
                    "value");
        }
        sb.append("}");
        return sb;
    }

    @Override
    protected void appendParameterString(ClientBehaviorContext behaviorContext,
            StringBuilder sb) {
        getDataMap(behaviorContext, sb, fields, data);
    }
}
