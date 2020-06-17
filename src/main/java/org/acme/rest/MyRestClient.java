package org.acme.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface MyRestClient {

    @Path("/v2/name/italy")
    @GET
    String testCall();
}
