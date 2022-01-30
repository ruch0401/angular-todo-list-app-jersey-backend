package com.example.app;

import com.example.controllers.PostResource;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApp extends ResourceConfig {
    public MyApp() {
        register(PostResource.class);
    }
}
