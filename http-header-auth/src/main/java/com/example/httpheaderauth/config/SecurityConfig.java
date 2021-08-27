package com.example.httpheaderauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("resources/static/**");
        web.ignoring().antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
//                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/api/**").hasAnyRole("ADMIN")
                .antMatchers("/**").permitAll()
                .anyRequest()
                .authenticated()
        ;

        http
                .csrf().disable()
                .cors().disable();


    }
}
