/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("/datastore")
public class DataStore {
    private static DataSource ds = new DataSource();

    /**
     * This is used for getting all the data
     * 
     */
    @GET
    @Path("/countries/")
    public String getCountriesJson() {
        return ds.getCountries().toString();
    }

    @POST
    @Path("/countries/")
    public String addCountry(String countryJson) {
        return ds.addCountry(countryJson).toString();
    }

    /**
     * This is used for updating a item by countrycode or adding a new item.
     * 
     */
    @PUT
    @Path("/countries/{countrycode}")
    public String postCountriesJson(
            @PathParam("countrycode") String countryCode, String countryJson) {

        if (ds.isExist(countryCode)) {
            return ds.updateCountry(countryCode, countryJson).toString();
        }
        else {
            return ds.addCountry(countryJson).toString();
        }
    }

    /**
     * This is used for deleting item by countrycode
     * 
     */
    @DELETE
    @Path("/countries/{countrycode}")
    public String RemoveItemById(@PathParam("countrycode") String countryCode) {
        return ds.removeCountry(countryCode).toString();
    }

}
