package org.acme;

import org.acme.rest.MyRestClient;
import org.acme.rest.MyRestClientWithProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ExampleResource {

    private static final Logger log = LoggerFactory.getLogger(ExampleResource.class);

    @Inject
    MyRestClientWithProxy restClientWithProxy;

    @Inject
    MyRestClient restClient;

    @GET
    @Path("country")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        String result = restClientWithProxy.testCall();

        log.info(result);

        return result;
    }

    @GET
    @Path("user")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello2() {

        String result = restClient.testCall();

        log.info(result);

        return result;
    }
}
