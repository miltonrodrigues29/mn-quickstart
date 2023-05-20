package com.milton.udemy;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.json.tree.JsonNode;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class HelloWorldControllerTest {

    @Inject
    @Client("/")
    HttpClient client;


    @Test
    void helloworldtest()
    {
        var response = client.toBlocking().retrieve("/hello");
        assertEquals("Hello From service",response);
    }

    @Test
    void helloworldtestwithstatuscode()
    {
        var response = client.toBlocking().exchange("/hello",String.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals("Hello From service",response.getBody().get());

    }

    @Test
    void helloFromConfig()
    {
        var response = client.toBlocking().exchange("/hello/config",String.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals("Hello from application.yml",response.getBody().get());

    }

    @Test
    void helloFromTranslationEndPoint()
    {
        var response = client.toBlocking().exchange("/hello/translation", JsonNode.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals("-",response.getBody().get().toString());

    }



}
