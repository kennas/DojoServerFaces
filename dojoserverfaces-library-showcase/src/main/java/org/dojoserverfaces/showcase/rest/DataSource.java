/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.rest;


import org.apache.wink.json4j.JSONArray;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;

/**
 * This defines concrete method of the url mapping method
 */
public class DataSource {
    static final Integer HTTP_SUCCESS = 200;
    static final Integer HTTP_FAILED = 400;
    private static JSONArray countries= new JSONArray();

    public JSONArray getCountries() {

        if (countries.size()>0) {
            return countries;
        }

        try {
            JSONObject country = new JSONObject();
            country.put("name", "China");
            country.put("id", "cn");
            country.put("type", "country");
            countries.add(country);

            country = new JSONObject();
            country.put("name", "Africa");
            country.put("id", "AF");
            country.put("type", "continent");
            countries.add(country);

            country = new JSONObject();
            country.put("name", "Peking");
            country.put("id", "Peking");
            country.put("type", "city");
            countries.add(country);

        }
        catch (JSONException ex) {
            return countries;
        }
        return countries;
    }

  

    static String unQuote(String value) {
        return value.substring(1, value.length() - 1);
    }

    /**
     * add a new Item
     */
    Integer addCountry(String countryJson) {
        String[] items = unQuote(countryJson).split(",");
        String[] element;
        JSONObject country = new JSONObject();
        try {
            for (String item : items) {
                element = item.split(":");
                country.put(unQuote(element[0]), unQuote(element[1]));
            }
            /*
             * you can set the insert "pos". but you have refresh the whole page
             * then the new item will appear the positions you inserted
             * e.g.ja.add(0,jobj);
             */
            countries.add(country);
        }
        catch (JSONException e) {
            return HTTP_FAILED;
        }
        return HTTP_SUCCESS;
    }

    /**
     * update the store
     * 
     */
    Integer updateCountry(String countryCode, String countryJson) {
        String[] items = unQuote(countryJson).split(",");
        String[] element;
        JSONObject newCountry = new JSONObject();
        try {
            for (String item : items) {
                element = item.split(":");
                newCountry.put(unQuote(element[0]), unQuote(element[1]));
            }
            for (int i = 0; i < countries.size(); i++) {
                JSONObject country = (JSONObject) countries.get(i);
                if (country.get("id").equals(countryCode)) {
                    countries.set(i, newCountry);
                    break;
                }
            }

            return HTTP_SUCCESS;
        }
        catch (JSONException ex) {
            return HTTP_FAILED;
        }

    }

    /**
     * judge whether the country exist
     * 
     */
    boolean isExist(String countrycode) {
        try {
            for (Object country : countries) {
                if (((JSONObject) country).get("id").equals(countrycode)) {
                    return true;
                }
            }
        }
        catch (JSONException ex) {
            return false;
        }
        return false;
    }

    /**
     * delete an Item
     */
    Integer removeCountry(String countryCode) {
        try {
            for (Object country : countries) {
                if (((JSONObject) country).get("id").equals(countryCode)) {
                    countries.remove(country);
                    return HTTP_SUCCESS;
                }
            }
            return HTTP_FAILED;
        }
        catch (JSONException ex) {
            return HTTP_FAILED;
        }
    }
}
