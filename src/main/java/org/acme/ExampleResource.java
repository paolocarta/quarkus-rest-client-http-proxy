package org.acme;

import org.acme.rest.MyRestClient;
import org.acme.rest.RestConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/country")
public class ExampleResource {

    private static final Logger log = LoggerFactory.getLogger(ExampleResource.class);

    @Inject
    MyRestClient restClient;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        String result = restClient.testCall();

        log.info(result);

        return result;
    }
}
