package com.springsecurity.loginserver.security.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = (User) userDetailsService.loadUserByUsername(username);

        passwordMatched(password, user.getPassword());

        return new UsernamePasswordAuthenticationToken(
            user.getUsername(), user.getPassword(), user.getAuthorities()
        );
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }

    private void passwordMatched(String passwordFromStore, String passwordFromContext) {
//        if (!passwordEncoder.matches(passwordFromStore, passwordFromContext)) {
//            throw new BadCredentialsException("BadCredentialException");
//        }
        if (!passwordFromStore.equals(passwordFromContext)) {
            throw new BadCredentialsException("BadCredentialException");
        }
    }
}
