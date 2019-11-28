package com.ffc.examples.java.rest;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Web service runner.
 *
 * You might run it via maven:  mvn exec:java -Dexec.mainClass=com.ffc.examples.java.rest.Main
 */
public class Main {

    private static final int PORT = 8080;
    private static final String BASE_PATH = "/rest/*";
    private static final String RESOURCE_PACKAGES = "com.ffc.examples.java.rest.services";

    public static void main(String[] args) {

        Server server = new Server(PORT);
        ServletContextHandler ctx =
                new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

        ctx.setContextPath("/");
        server.setHandler(ctx);

        ServletHolder serHol = ctx.addServlet(ServletContainer.class, BASE_PATH);
        serHol.setInitOrder(1);
        serHol.setInitParameter("jersey.config.server.provider.packages", RESOURCE_PACKAGES);

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            server.destroy();
        }
    }
}
