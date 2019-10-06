package com.kodstrukt.demo.swagger.springfox.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected static final String PUBLIC_APIS_URL_MAIN_PART = "/query/";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("password1"))
                .roles("ADMIN");

        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("password2"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        StringBuilder publicApisUrlPatternBuilder = new StringBuilder();
        publicApisUrlPatternBuilder.append(PUBLIC_APIS_URL_MAIN_PART).append("**");

        http
                .authorizeRequests()
                .antMatchers(publicApisUrlPatternBuilder.toString())
                .permitAll()
                .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**", "/csrf","/")
                .permitAll()
                .and()
                .csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/command/**").hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
