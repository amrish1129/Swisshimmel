package ch.swisshimmel.website.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

//@SuppressWarnings("unused")
public class SecurityInitializer
        extends AbstractSecurityWebApplicationInitializer {
    @Override
    protected boolean enableHttpSessionEventPublisher() {
        return true;
    }
}
