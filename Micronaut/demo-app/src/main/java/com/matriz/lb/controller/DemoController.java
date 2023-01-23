package com.matriz.lb.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/v1/api")
public class DemoController {

    @Get("/demo")
    @Produces(MediaType.TEXT_PLAIN)
    public String text(){
        return "Text for demo";
    }

}
