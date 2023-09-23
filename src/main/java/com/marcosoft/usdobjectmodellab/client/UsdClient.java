package com.marcosoft.usdobjectmodellab.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Component
public class UsdClient {

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public HttpRequest buildUsdRequest(String method, String usdObject, String requestBody, String objAttributes){
        final String ACCEPT = "Accept";
        final String CONTENT_TYPE = "Content-Type";
        final String APPLICATION_JSON = "application/json";
        final String XACCESS_KEY = "X-AccessKey";
        final String USD_ENDPOINT = "http://usd.des.sicredi.net:8050/caisd-rest";
        final String ACCESS_KEY = "74644530";

        URI usdEndPoint = URI.create(USD_ENDPOINT + usdObject);
        HttpRequest usdRequest;

        if ("GET".equals(method)) {
            usdRequest = HttpRequest.newBuilder()
                    .uri(usdEndPoint)
                    .method(method, HttpRequest.BodyPublishers.ofString(requestBody))
                    .setHeader(ACCEPT, APPLICATION_JSON)
                    .setHeader("X-Obj-Attrs", objAttributes)
                    .setHeader(XACCESS_KEY, ACCESS_KEY)
                    .build();
        }else{
            usdRequest = HttpRequest.newBuilder()
                    .uri(usdEndPoint)
                    .method(method, HttpRequest.BodyPublishers.ofString(requestBody))
                    .setHeader(CONTENT_TYPE, APPLICATION_JSON)
                    .setHeader(ACCEPT, APPLICATION_JSON)
                    .setHeader(XACCESS_KEY, ACCESS_KEY)
                    .build();
        }

        return usdRequest;
    }

    public HttpResponse<String> sendUsdRequest(HttpRequest httpRequest){
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
        return httpResponse;
    }

}
