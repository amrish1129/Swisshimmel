package ch.swisshimmel.website.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import core.framework.web.config.AbstractWebAppInitializer;

/**
 * Webapp initializer: configures web project instead of the classic web.xml
 * file.
 * 
 * @author amrish
 *
 */
public class WebAppInitializer extends AbstractWebAppInitializer {
    
   /* @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        // Create the 'root' Spring application context
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
        dispatcher.addMapping("/");
        
        servletContext.addFilter("platformFilter", new SignatureFilter()).addMappingForUrlPatterns(null, false, "/*");
        
        /*AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebMvcConfig.class);
        ctx.setServletContext(servletContext);
        
        ServletRegistration.Dynamic servlet = servletContext.addServlet(
                "dispatcher", new DispatcherServlet(ctx));
        
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");*/
    //}*/
    
    /*@Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return new Class<?>[] { RootConfig.class, DbConfig.class };
    }*/
    
    /**
     * Specify configuration class
     */
    /*@Override
    protected Class<?>[] getServletConfigClasses() {
        // TODO Auto-generated method stub
        return new Class<?>[] { WebMvcConfig.class };
    }*/
    
    //Map DispatcherServlet to
    /**
     * Dispatcher-
     *Servlet load its application context with beans 
     *defined in the WebConfig configuration
     *class
     */
    /*@Override
    protected String[] getServletMappings() {
        // TODO Auto-generated method stub
        return new String[] { "/" };
    }*/

    @Override
    public void registerRootConfigClasses(
            AnnotationConfigWebApplicationContext rootContext) {
        rootContext.register(new Class<?>[] { RootConfig.class, DbConfig.class });
    }

    @Override
    public void registerDispatcherConfigClasses(
            AnnotationConfigWebApplicationContext dispatcherServlet) {
        dispatcherServlet.register(new Class<?>[] { WebMvcConfig.class });
    }
    
    
    /**
     * The maximum size (in bytes) of any file uploaded. By default there is no limit.
        The maximum size (in bytes) of the entire multipart request, regardless of how
        many parts or how big any of the parts are. By default there is no limit.
        The maximum size (in bytes) of a file that can be uploaded without being written
        to the temporary location. The default is 0, meaning that all uploaded files
        will be written to disk.
     */
    @Override
    public void setMultipartConfig(Dynamic registration) {
        // limit files to no more than 2 MB, to limit the entire
        // request to no more than 4 MB, and to write all files to disk
        registration.setMultipartConfig(new MultipartConfigElement(
                "/tmp/sh/uploads", 2097152, 4194304, 0));
    }
    
}
