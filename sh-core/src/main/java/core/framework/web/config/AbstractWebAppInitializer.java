package core.framework.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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
public abstract class AbstractWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] { AbstractRootConfig.class };
	}
	
	/**
	 * Specify configuration class
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] { AbstractWebConfig.class };
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
