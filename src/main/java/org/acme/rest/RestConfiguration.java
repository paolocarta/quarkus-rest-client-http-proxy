package org.acme.rest;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.core.UriBuilder;

import static org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder.*;

@ApplicationScoped
public class RestConfiguration {

    @ConfigProperty(name = "custom.http.proxy.host")
    String proxyHost;

    @ConfigProperty(name = "custom.http.proxy.port")
    int proxyPort;

    @ConfigProperty(name = "custom.http.proxy.scheme")
    String proxyScheme;

    @ConfigProperty(name = "custom.http.client.uri")
    String baseUri;

    @Produces
    public MyRestClientWithProxy restClientWithProxy() {

        MyRestClientWithProxy build = RestClientBuilder.newBuilder()
                .baseUri(UriBuilder.fromUri(baseUri).build())
                .property(PROPERTY_PROXY_HOST, proxyHost)
                .property(PROPERTY_PROXY_PORT, proxyPort)
                .property(PROPERTY_PROXY_SCHEME, proxyScheme)
                .build(MyRestClientWithProxy.class);

        return build;
    }

    @Produces
    public MyRestClient restClient() {

        MyRestClient build = RestClientBuilder.newBuilder()
                .baseUri(UriBuilder.fromUri("http://dummy.restapiexample.com").build())
                .build(MyRestClient.class);

        return build;
    }
}
