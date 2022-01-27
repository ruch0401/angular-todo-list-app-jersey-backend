package com.example.app;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class MyCustomServer {
    static void startJetty() {
        try {
            Server jettyServer = new Server(0);
            ServletContextHandler context = new ServletContextHandler(0);
            jettyServer.setHandler(context);
            ServerConnector connector = new ServerConnector(jettyServer);
            connector.setPort(8080);
            jettyServer.setConnectors(new Connector[]{connector});
            ServletHolder holder = context.addServlet(ServletContainer.class, "/*");
            holder.setInitParameter("javax.ws.rs.Application", "com.example.app.MyApp");
            jettyServer.start();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {
        startJetty();
    }
}
