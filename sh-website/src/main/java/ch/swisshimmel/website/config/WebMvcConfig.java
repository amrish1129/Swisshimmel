package ch.swisshimmel.website.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Spring MVC Configuration.
 * 
 * Extends {@link WebMvcConfigurerAdapter}, which provides convenient callbacks
 * that allow us to customize aspects of the Spring Web MVC framework. These
 * callbacks allow us to register custom interceptors, message converters,
 * argument resovlers, a validator, resource handling, and other things.
 * 
 * @author amrish
 * @see WebMvcConfigurerAdapter
 */
@Configuration
@EnableWebMvc
@ComponentScan( { "ch.swisshimmel.website" })
@EnableTransactionManagement(proxyTargetClass = true)
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    
    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations(
                "/resources/");
    }
    
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }*/
    
    @Bean(name = "HelloWorld")
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        return bean;
    }
    
    
    
   /* @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getMultipartResolver() {
        return new CommonsMultipartResolver();
    }
    
    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:messages");
        resource.setDefaultEncoding("UTF-8");
        return resource;
    }*/
    
}
