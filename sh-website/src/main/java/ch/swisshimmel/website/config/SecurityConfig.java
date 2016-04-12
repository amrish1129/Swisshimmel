package ch.swisshimmel.website.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    /*@Autowired
    DataSource dataSource;*/
    
    /**
     * Override to configure user-details services.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        
        auth
            .inMemoryAuthentication()
                    .withUser("user")
                    .password("password")
                    .roles("USER")
                    //.authorities("USER")
                .and()
                    .withUser("admin")
                    .password("password")
                    .roles("USER", "ADMIN");
                    //.authorities("USER", "ADMIN");
         
        /*auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, 1 "
                        + "FROM swisshimmel.USER_AUTHENTICATION WHERE username=?")
                .authoritiesByUsernameQuery(
                        "SELECT username, 'ROLE_USER' FROM swisshimmel.login where username=?")
                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));*/
    }
    
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }*/
    
    
    //TODO will use it later for configuring a custom user service
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth)
        throws Exception {
        auth
            .userDetailsService(new SpitterUserService());
    }*/
    
    /**
     * Override to configure Spring Security’s filter chain.
     */
    @Override
    public void configure(WebSecurity security) {
        security.ignoring().antMatchers("/resource/**");
    }
    
    /**
     * Override to configure how requests are secured by interceptors.
     */
    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
                .authorizeRequests()
                    .antMatchers("/signup", "/about", "/policies").permitAll()
                    .antMatchers("/secure/**").hasRole("USER")
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                .and().formLogin()
                    .loginPage("/login").failureUrl("/login?error")
                    .defaultSuccessUrl("/", true)
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .permitAll()
                .and().logout()
                    .logoutUrl("/logout").logoutSuccessUrl("/login?loggedOut")
                    .invalidateHttpSession(true).deleteCookies("JSESSIONID")
                    .permitAll()
                .and().exceptionHandling().accessDeniedPage("/403")
                .and().sessionManagement()
                    .sessionFixation().changeSessionId()
                    .maximumSessions(1).maxSessionsPreventsLogin(true)
                .and().and().csrf().disable();
    }
    
}
