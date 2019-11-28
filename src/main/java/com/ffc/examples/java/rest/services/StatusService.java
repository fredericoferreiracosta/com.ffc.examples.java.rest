package com.ffc.examples.java.rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * REST endpoint for statuses.
 */
@Path("/status")
public class StatusService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getStatus() {
        return new Date().toString() + " - Running";
    }
}
