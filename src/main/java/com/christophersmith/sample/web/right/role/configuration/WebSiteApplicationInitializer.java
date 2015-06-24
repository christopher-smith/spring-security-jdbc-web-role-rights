package com.christophersmith.sample.web.right.role.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * This class initializes a Spring WebApplicationContext, in place of doing this in the web.xml
 * file.
 * 
 * @author Christopher Smith (https://github.com/christopher-smith)
 */
public class WebSiteApplicationInitializer implements WebApplicationInitializer
{
    private static final String WEB_APPLICATION_CONTEXT_CONFIG_LOCATION = "com.christophersmith.sample.web.right.role.configuration";
    private static final String DISPATCHER_SERVLET_NAME                 = "dispatcher";
    private static final int    DISPATCHER_SERVLET_STARTUP_LOAD_ORDER   = 1;
    private static final String DISPATCHER_SERVLET_MAPPING              = "/";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(WEB_APPLICATION_CONTEXT_CONFIG_LOCATION);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME,
            new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(DISPATCHER_SERVLET_STARTUP_LOAD_ORDER);
        dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING);
    }
}
