package com.halyph;

import com.halyph.config.AppConfig;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;


public class Launcher {

    public static final int PORT = 8080;

    public static void main(final String[] args) throws Exception {
        Server server = new Server(PORT);

        // Register and map the dispatcher servlet
        final ServletHolder servletHolder = new ServletHolder(new CXFServlet());
        final ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(servletHolder, AppConfig.API_BASE);
        context.addEventListener(new ContextLoaderListener());

        context.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
        context.setInitParameter("contextConfigLocation", AppConfig.class.getName());

        server.setHandler(context);
        server.start();
        server.join();
    }
}

