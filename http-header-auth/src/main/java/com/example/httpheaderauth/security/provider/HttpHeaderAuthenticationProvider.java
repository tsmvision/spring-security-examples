package com.example.httpheaderauth.security.provider;

import com.example.httpheaderauth.security.token.HttpHeaderAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class HttpHeaderAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

//        String auth = authentication.getName();
//        String password = (String) authentication.getCredentials();

//        AccountContext accountContext = (AccountContext) userDetailsService.loadUserByUsername(username);
//
//        passwordMatched(password, accountContext.getPassword());
////        secretKeyMatched(authentication);

        // TODO: auth from http header
        // TODO: if auth not valid -> throw error
        // TODO: if authenticated -> do something

        // TODO: user credential validation code here!!!!! from service layer

        if (authentication.getPrincipal() == null
                || authentication.getPrincipal().equals("")
                || !authentication.getPrincipal().equals("test")) {
            throw new BadCredentialsException("");
        }

        // TODO: add roles (authorities)
        return new HttpHeaderAuthenticationToken(
                authentication.getPrincipal(),
                null
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(HttpHeaderAuthenticationToken.class);
    }
}
