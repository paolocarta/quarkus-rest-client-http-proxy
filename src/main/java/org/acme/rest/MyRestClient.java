package org.acme.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface MyRestClient {

    @Path("/api/v1/employee/1")
    @GET
    String testCall();
}
