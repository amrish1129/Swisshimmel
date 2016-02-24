package ch.swisshimmel.website.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Webapp initializer: configures web project instead of the classic web.xml
 * file.
 * 
 * @author amrish
 *
 */
//@Configuration
public class WebAppInitializer implements WebApplicationInitializer {
    
    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        /*// Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebMvcConfig.class);
        
        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));
        
        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(WebMvcConfig.class);
        
        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                AbstractDispatcherServletInitializer.DEFAULT_SERVLET_NAME,
                new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");*/
        
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebMvcConfig.class);
        ctx.setServletContext(servletContext);
        
        ServletRegistration.Dynamic servlet = servletContext.addServlet(
                "dispatcher", new DispatcherServlet(ctx));
        
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
    
}
