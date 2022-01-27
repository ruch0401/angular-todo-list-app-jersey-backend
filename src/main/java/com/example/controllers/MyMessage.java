package com.example.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("msg")
public class MyMessage {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMessage() {
        return "My Message!";
    }
}
