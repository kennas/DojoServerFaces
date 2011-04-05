/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.library.test.data.store;

import javax.faces.model.DataModel;

public abstract class DojoDataModel extends DataModel {
    
    public abstract String getAsStore();

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object getRowData() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getRowIndex() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object getWrappedData() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isRowAvailable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setRowIndex(int arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setWrappedData(Object arg0) {
        // TODO Auto-generated method stub

    }

}
