package com.example.app;

import com.example.controllers.MyMessage;
import com.example.controllers.MyResource;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApp extends ResourceConfig {
    public MyApp() {
        register(MyResource.class);
        register(MyMessage.class);
    }
}
