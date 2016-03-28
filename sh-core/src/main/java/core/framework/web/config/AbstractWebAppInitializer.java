package core.framework.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * Under the covers, AbstractAnnotationConfigDispatcherServletInitializer creates
 * both a DispatcherServlet and a ContextLoaderListener. The @Configuration
 * classes returned from getServletConfigClasses() will define beans for Dispatcher-
 * Servlet’s application context. Meanwhile, the @Configuration class’s returned get-
 * RootConfigClasses() will be used to configure the application context created by
 * ContextLoaderListener.
 * 
 * @author amrish
 *
 */
public abstract class AbstractWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.getServletRegistration("default").addMapping("/resource/*");
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		registerRootConfigClasses(rootContext);
        
        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));
        
        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        registerDispatcherConfigClasses(dispatcherServlet);
        
        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                AbstractDispatcherServletInitializer.DEFAULT_SERVLET_NAME,
                new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        //Add servlet mapping.
        dispatcher.addMapping("/");
        setMultipartConfig(dispatcher);
        
        //servletContext.addFilter("platformFilter", new SignatureFilter()).addMappingForUrlPatterns(null, false, "/*");
	}
	
	/*protected void setMultipartConfig(Dynamic registration) {
		registration.setMultipartConfig(
				new MultipartConfigElement("/tmp/spittr/uploads"));
	}*/
	
	public abstract void setMultipartConfig(Dynamic registration);
	
	/**
	 * Register Root application contexts
	 * @param rootContext
	 */
	public abstract void registerRootConfigClasses(AnnotationConfigWebApplicationContext rootContext);
	
	/**
	 *  Register dispatcher servlet's Spring application context
	 * @param dispatcherServlet
	 */
	public abstract void registerDispatcherConfigClasses(AnnotationConfigWebApplicationContext dispatcherServlet);

}
