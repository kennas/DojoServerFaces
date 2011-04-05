package org.dojoserverfaces.test.data.model;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

@ManagedBean(name="dataModel")
@SessionScoped
public class DataModelBean {
     private ListDataModel<KeyValuePair> data;
     
     public DataModelBean () {
          ArrayList<KeyValuePair> exampleValues =
               new ArrayList<KeyValuePair>();
          
          for (int i = 0; i < 10; ++i) {
               exampleValues.add (new KeyValuePair ("item" + i, "value" + i));
          }
          
          this.data = new ListDataModel<KeyValuePair> (exampleValues);
     }
     
     public ListDataModel<KeyValuePair> getData () {
          return this.data;
     }
}
