package ch.swisshimmel.website.config;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import core.framework.web.config.AbstractWebConfig;

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
public class WebMvcConfig extends AbstractWebConfig {
    
    @Inject
    Environment env;

    @Inject
    SessionFactory sessionFactory;
    
   /* @Bean(name = "swisshimmel")
    @Override
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        //resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }*/
    
    @Bean
    public ViewResolver viewResolver() {
    return new TilesViewResolver();
    }
    
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions(new String[] { "/WEB-INF/layout/website-tiles.xml" });
        tiles.setCheckRefresh(true);
        return tiles;
    }
    
    
    
   @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
    }
 
}
