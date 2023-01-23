package com.matriz.lb;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MicronautTest
class DemoAppTest {

    @Inject
    @Client("/v1/api")
    HttpClient client;

    @Test
    void test(){
        HttpRequest<String> request = HttpRequest.GET("/demo");
        String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        assertEquals("Text for demo", body);
    }


}
