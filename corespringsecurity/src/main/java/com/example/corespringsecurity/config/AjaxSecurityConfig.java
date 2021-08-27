package com.example.corespringsecurity.config;

//import com.example.corespringsecurity.security.filter.AjaxLoginProcessingFilter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@Order(0)
//@RequiredArgsConstructor
//public class AjaxSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final AuthenticationProvider ajaxAuthenticationProvider;
////    private final AuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;
////    private final AuthenticationFailureHandler ajaxAuthenticationFailureHandler;
////    private final AuthenticationEntryPoint ajaxAuthenticationEntryPoint;
////    private final AccessDeniedHandler ajaxAccessDeniedHandler;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(ajaxAuthenticationProvider);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .antMatcher("/api/**")
//                .authorizeRequests()
//                .antMatchers("/api/messages").hasRole("MANAGER")
//                .anyRequest()
//                .authenticated()
//        ;
////        http
////                .addFilterBefore(ajaxLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
////        ;
//
//        http
//                .exceptionHandling()
////                .authenticationEntryPoint(ajaxAuthenticationEntryPoint)
////                .accessDeniedHandler(ajaxAccessDeniedHandler)
//                ;
//
//        http.csrf().disable();
//    }
//
////    @Bean
////    public AjaxLoginProcessingFilter ajaxLoginProcessingFilter() throws Exception {
////        AjaxLoginProcessingFilter ajaxLoginProcessingFilter = new AjaxLoginProcessingFilter();
////        ajaxLoginProcessingFilter.setAuthenticationManager(authenticationManagerBean());
////        ajaxLoginProcessingFilter.setAuthenticationSuccessHandler(ajaxAuthenticationSuccessHandler);
////        ajaxLoginProcessingFilter.setAuthenticationFailureHandler(ajaxAuthenticationFailureHandler);
////        return ajaxLoginProcessingFilter;
////    }
//}
