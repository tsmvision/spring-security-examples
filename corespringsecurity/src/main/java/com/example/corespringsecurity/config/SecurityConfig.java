package com.example.corespringsecurity.config;

import com.example.corespringsecurity.helper.PageUrl;
import com.example.corespringsecurity.helper.Role;
import com.example.corespringsecurity.helper.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        String password = passwordEncoder().encode("1111");

        auth.inMemoryAuthentication().withUser(UserId.USER.label).password(password).roles(Role.USER.toString());
        auth.inMemoryAuthentication().withUser(UserId.MANAGER.label).password(password).roles(Role.MANAGER.toString());
        auth.inMemoryAuthentication().withUser(UserId.ADMIN.label).password(password).roles(Role.ADMIN.toString());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(PageUrl.ROOT.url).permitAll()
                .antMatchers(PageUrl.MY_PAGE.url).hasRole(Role.USER.toString())
                .antMatchers(PageUrl.MESSAGES.url).hasRole(Role.MANAGER.toString())
                .antMatchers(PageUrl.CONFIGURATION.url).hasRole(Role.ADMIN.toString())
                .anyRequest().authenticated()
        ;

        http
                .formLogin()
        ;
    }
}
