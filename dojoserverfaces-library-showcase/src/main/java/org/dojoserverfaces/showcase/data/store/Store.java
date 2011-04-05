/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.data.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.dojoserverfaces.showcase.data.model.Record;

@ManagedBean
@SessionScoped
public class Store {
    private Record record = new Record();
    private Map<String, String> states;
    private Set<String> ss;

    {
        states = new HashMap<String, String>();
        states.put("Alabama", "AL");
        states.put("Alaska", "AK");
        states.put("American Samoa", "AS");
        states.put("Arizona", "AZ");
        states.put("Arkansas", "AR");
        states.put("Armed Forces Europe", "AE");
        states.put("Armed Forces Pacific", "AP");
        states.put("Armed Forces the Americas", "AA");
        states.put("California", "CA");
        states.put("Colorado", "CO");
        states.put("Connecticut", "CI");
        states.put("Delaware", "DE");
        states.put("District of Columbia", "DC");
        states.put("Federated States of Micronesia", "FM");
        states.put("Florida", "FL");
        states.put("Georgia", "GA");
        states.put("Guam", "GU");
        states.put("Hawaii", "HI");
        states.put("Idaho", "ID");
        states.put("Illinois", "IL");
        states.put("Indiana", "IN");
        states.put("Iowa", "IA");
        states.put("Kansas", "KS");
        states.put("Kentucky", "KY");
        states.put("Louisiana", "LA");
        states.put("Maine", "ME");
        states.put("Marshall Islands", "MH");
        states.put("Maryland", "MD");
        states.put("Massachusetts", "MA");
        states.put("Michigan", "MI");
        states.put("Minnesota", "MN");
        states.put("Mississippi", "MS");
        states.put("Missouri", "MO");
        states.put("Montana", "MT");
        states.put("Nebraska", "NE");
        states.put("Nevada", "NV");
        states.put("New Hampshire", "NH");
        states.put("New Jersey", "NJ");
        states.put("New Mexico", "NM");
        states.put("New York", "NY");
        states.put("North Carolina", "NC");
        states.put("North Dakota", "ND");
        states.put("Northern Mariana Islands", "MP");
        states.put("Ohio", "OH");
        states.put("Oklahoma", "OK");
        states.put("Oregon", "OR");
        states.put("Pennsylvania", "PA");
        states.put("Puerto Rico", "PR");
        states.put("Rhode Island", "RI");
        states.put("South Carolina", "SC");
        states.put("South Dakota", "SD");
        states.put("Tennessee", "TN");
        states.put("Texas", "TX");
        states.put("Utah", "UT");
        states.put("Vermont", "VT");
        states.put("Virgin Islands, U.S.", "VI");
        states.put("Virginia", "VA");
        states.put("Washington", "WA");
        states.put("West Virginia", "WV");
        states.put("Wisconsin", "WI");
        states.put("Wyoming", "WY");
        ss = states.keySet();
    }

    private static final String EMPTY_STRING = "";

    public String getStateName(String stateCode) {
        for (Entry<String, String> entry : states.entrySet()) {
            if (entry.getValue().equals(stateCode)) {
                return entry.getKey();
            }
        }
        return EMPTY_STRING;
    }

    public String getStateNames(String[] stateCodes) {
        if (stateCodes == null || stateCodes.length == 0)
            return EMPTY_STRING;

        List<String> result = new ArrayList<String>();
        for (String sc : stateCodes) {
            result.add(getStateName(sc));
        }
        return result.toString();
    }

    public Map<String, String> getStates() {
        return states;
    }

    public Set getSs() {
        return ss;
    }

    public Record getRecord() {
        return record;
    }
}
