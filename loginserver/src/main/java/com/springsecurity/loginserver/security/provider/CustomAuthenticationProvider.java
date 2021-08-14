package com.springsecurity.loginserver.security.provider;

import com.springsecurity.loginserver.security.service.AccountContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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

        AccountContext accountContext = (AccountContext) userDetailsService.loadUserByUsername(username);

        passwordMatched(password, accountContext.getPassword());

        return new UsernamePasswordAuthenticationToken(
            accountContext.getAccount(), null, accountContext.getAuthorities()
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
