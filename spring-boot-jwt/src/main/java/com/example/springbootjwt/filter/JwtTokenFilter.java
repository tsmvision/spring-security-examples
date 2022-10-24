package com.example.springbootjwt.filter;

import com.example.springbootjwt.entity.Authority;
import com.example.springbootjwt.entity.User;
import com.example.springbootjwt.repository.UserRepository;
import com.example.springbootjwt.security.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    private final JwtTokenHelper jwtTokenHelper;

    private final CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (!hasAuthorizationBearer(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = getAccessToken(request);

        if (!jwtTokenHelper.validateAccessToken(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        setAuthenticationContext(token, request);
        filterChain.doFilter(request, response);
    }

    private boolean hasAuthorizationBearer(HttpServletRequest request) {
        String header = request.getHeader(JwtTokenHelper.AUTHORIZATION);

        return !ObjectUtils.isEmpty(header) && header.startsWith(JwtTokenHelper.BEARER);
    }

    private String getAccessToken(HttpServletRequest request) {
        String header = request.getHeader(JwtTokenHelper.AUTHORIZATION);

        if (ObjectUtils.isEmpty(header)) {
            return "";
        }

        String[] authorizationArray = header.split(JwtTokenHelper.BEARER);

        if (authorizationArray.length < 2) {
            return "";
        }

        return authorizationArray[1].trim();
    }

    private void setAuthenticationContext(String token, HttpServletRequest request) {

        String username = jwtTokenHelper.getUsernameFromJwtToken(token);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

        // TODO: set authorities and credentials if necessary
        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(userDetails, null, null);

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
