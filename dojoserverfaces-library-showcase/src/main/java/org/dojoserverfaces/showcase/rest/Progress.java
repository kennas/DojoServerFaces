/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * This rest is used for progressbar sample get data from server
 * 
 */
@Path("/progress")
public class Progress {
    private static float progress = 0;

    @GET
    @Path("/value/")
    public String getProgress() {
        if (progress > 100) {
            progress = 0;
        }
        progress = progress + 10;
        if (progress == 100.0) {
            return null;
        }
        return String.valueOf(progress / 100);
    }
}
