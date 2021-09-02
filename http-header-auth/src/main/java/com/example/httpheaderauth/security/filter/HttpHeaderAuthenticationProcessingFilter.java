package com.example.httpheaderauth.security.filter;

import com.example.httpheaderauth.security.token.HttpHeaderAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpHeaderAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    private final String HEADER_AUTHENTICATION_KEY = "auth";

    public HttpHeaderAuthenticationProcessingFilter() {
        super(new AntPathRequestMatcher("/api/**"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        return getAuthenticationManager()
                .authenticate(
                        new HttpHeaderAuthenticationToken(
                                httpServletRequest.getHeader(HEADER_AUTHENTICATION_KEY)
                        )
                );
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
    }
}
