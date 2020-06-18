FROM fabric8/java-alpine-openjdk11-jre:1.8.0

ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV AB_ENABLED=jmx_exporter
ENV JAVA_APP_DIR=/deployments

# Be prepared for running in OpenShift too
RUN adduser -G root --no-create-home --disabled-password 1001 \
  && chown -R 1001 /deployments \
  && chmod -R "g+rwX" /deployments \
  && chown -R 1001:root /deployments

COPY target/lib/* /deployments/lib/
COPY target/*-runner.jar /deployments/app.jar

EXPOSE 8080
USER 1001

#ENV HTTP_PROXY_HOST=localhost
#ENV HTTP_PROXY_PORT=9090
#ENV HTTP_PROXY_SCHEME=https
#ENV HTTP_CLIENT_URI=https://restcountries.eu/rest


WORKDIR /deployments
CMD [ "/deployments/run-java.sh" ]

## example to execute the container

## docker run -it --rm --name http-proxy-quarkus -p 8080:8080 -e HTTP_PROXY_HOST=localhost \
##  -e HTTP_PROXY_PORT=9090 -e HTTP_PROXY_SCHEME=https -e HTTP_CLIENT_URI=https://restcountries.eu/rest \
##  clamer/http-proxy-quarkus