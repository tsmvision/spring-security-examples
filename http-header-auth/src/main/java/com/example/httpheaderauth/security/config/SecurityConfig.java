package com.example.httpheaderauth.security.config;

import com.example.httpheaderauth.security.filter.HttpHeaderAuthenticationProcessingFilter;
import com.example.httpheaderauth.security.handler.HttpHeaderAuthenticationFailureHandler;
import com.example.httpheaderauth.security.provider.HttpHeaderAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "resources/static/**",
                "/h2-console/**",
                "/api/auth"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .authenticationProvider(httpHeaderAuthenticationProvider());

        http
                .addFilterBefore(httpHeaderAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);

        http
                .authorizeRequests()
                // TODO: /api/auth -> permitAll()
                .antMatchers("/api/auth").permitAll()
                .antMatchers("/api/**").permitAll() // setup Role
                .antMatchers("/**").permitAll()
                .anyRequest()
                .authenticated()
        ;

        // TODO: authentication processing
        // TODO: exception handling

        http
                .csrf().disable()
                .cors().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(httpHeaderAuthenticationProvider());
    }

    @Bean
    public HttpHeaderAuthenticationFailureHandler httpHeaderAuthenticationFailureHandler() {
        return new HttpHeaderAuthenticationFailureHandler();
    }

    @Bean
    public HttpHeaderAuthenticationProvider httpHeaderAuthenticationProvider() {
        return new HttpHeaderAuthenticationProvider();
    }

    @Bean
    public HttpHeaderAuthenticationProcessingFilter httpHeaderAuthenticationProcessingFilter() throws Exception {
        HttpHeaderAuthenticationProcessingFilter httpHeaderAuthenticationFilter = new HttpHeaderAuthenticationProcessingFilter();
        httpHeaderAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
        httpHeaderAuthenticationFilter.setAuthenticationFailureHandler(httpHeaderAuthenticationFailureHandler());
        return httpHeaderAuthenticationFilter;
    }
}
