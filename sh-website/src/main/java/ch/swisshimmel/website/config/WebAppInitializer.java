package ch.swisshimmel.website.config;

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
    
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return new Class<?>[] { RootConfig.class, DbConfig.class };
    }
    
    /**
     * Specify configuration class
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        // TODO Auto-generated method stub
        return new Class<?>[] { WebMvcConfig.class };
    }
    
    //Map DispatcherServlet to
    /**
     * Dispatcher-
     *Servlet load its application context with beans 
     *defined in the WebConfig configuration
     *class
     */
    @Override
    protected String[] getServletMappings() {
        // TODO Auto-generated method stub
        return new String[] { "/" };
    }
    
}
