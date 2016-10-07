package com.blueradix.ws;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;



/**
 * The SecurityConfiguration class provides a centralized location for
 * application security configuration. This class bootstraps the Spring Security
 * components during application startup.
 * 
 * @author Matt Warman
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {



    /**
     * This inner class configures the WebSecurityConfigurerAdapter instance for
     * the web service API context paths.
     * 
     * @author Matt Warman
     */
    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
        	http
        		.authorizeRequests().anyRequest().permitAll();
        		
        		//.antMatcher("/**").authorizeRequests().anyRequest().authenticated();
            // @formatter:off
            
            http
            .csrf().disable();
            /*
            .antMatcher("/api/**")
              .authorizeRequests()
                .anyRequest().hasRole("USER")
            .and()
            .httpBasic()
            .and()
            .sessionManagement()
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            
            // @formatter:on
             */
        }

    }

    /**
     * This inner class configures the WebSecurityConfigurerAdapter instance for
     * the Spring Actuator web service context paths.
     * 
     * @author Matt Warman
     */
    @Configuration
    @Order(2)
    public static class ActuatorWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            // @formatter:off
            
            http
            .csrf().disable()
            .antMatcher("/actuators/**")
              .authorizeRequests()
                .anyRequest().hasRole("SYSADMIN")
            .and()
            .httpBasic()
            .and()
            .sessionManagement()
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS); 
            
            // @formatter:on

        }

    }

    /**
     * This inner class configures the WebSecurityConfigurerAdapter instance for
     * any remaining context paths not handled by other adapters.
     * 
     * @author Matt Warman
     */
    @Profile("docs")
    @Configuration
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            // @formatter:off
            
            http
              .csrf().disable()
              .authorizeRequests()
                .anyRequest().authenticated()
              .and()
              .formLogin();
            
            // @formatter:on

        }

    }

}