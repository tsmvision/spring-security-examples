package com.example.httpheaderauth.security.config;

import com.example.httpheaderauth.security.filter.HttpHeaderAuthenticationProcessingFilter;
import com.example.httpheaderauth.security.handler.HttpHeaderAuthenticationFailureHandler;
import com.example.httpheaderauth.security.provider.HttpHeaderAuthenticationProvider;

import com.example.httpheaderauth.security.service.CustomUserDetailsService;
import com.example.httpheaderauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Profile(value = {"!test"})
@RequiredArgsConstructor
class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

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
                .csrf().disable()
                .cors();
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .authenticationProvider(httpHeaderAuthenticationProvider())
                .addFilterBefore(httpHeaderAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);

        http
                .authorizeRequests()
                // TODO: /api/auth -> permitAll()
                .antMatchers("/api/auth").permitAll()
                .antMatchers("/api/**").hasAnyRole("USER", "MANAGER") // setup Role
                .antMatchers("/**").permitAll()
                .anyRequest()
                .authenticated()
        ;
        // TODO: exception handling
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(httpHeaderAuthenticationProvider());
    }

    @Bean
    public AuthenticationFailureHandler httpHeaderAuthenticationFailureHandler() {
        return new HttpHeaderAuthenticationFailureHandler();
    }

    @Bean
    public UserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService(userService);
    }

    @Bean
    public AuthenticationProvider httpHeaderAuthenticationProvider() {
        return new HttpHeaderAuthenticationProvider(customUserDetailsService());
    }

    @Bean
    public AbstractAuthenticationProcessingFilter httpHeaderAuthenticationProcessingFilter() throws Exception {
        HttpHeaderAuthenticationProcessingFilter httpHeaderAuthenticationFilter = new HttpHeaderAuthenticationProcessingFilter();
        httpHeaderAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
//        httpHeaderAuthenticationFilter.setAuthenticationFailureHandler(httpHeaderAuthenticationFailureHandler());
//        httpHeaderAuthenticationFilter.setRequiresAuthenticationRequestMatcher(
//                new OrRequestMatcher(
//                        new AntPathRequestMatcher("/api/**")
//                )
//        )
        ;
        return httpHeaderAuthenticationFilter;
    }

    @Bean
    public GrantedAuthoritiesMapper authoritiesMapper() {
        SimpleAuthorityMapper mapper = new SimpleAuthorityMapper();
        mapper.setPrefix(""); // this line is not required
        mapper.setConvertToUpperCase(true); // convert your roles to uppercase
//        mapper.setDefaultAuthority("USER"); // set a default role

        return mapper;
    }
}
