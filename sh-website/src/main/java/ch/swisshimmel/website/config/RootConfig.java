package ch.swisshimmel.website.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import core.framework.web.config.AbstractRootConfig;

@Configuration
@ComponentScan(
        basePackages = "ch.swisshimmel.website",
        excludeFilters = @ComponentScan.Filter(Controller.class)
)
public class RootConfig extends AbstractRootConfig{
    
}
