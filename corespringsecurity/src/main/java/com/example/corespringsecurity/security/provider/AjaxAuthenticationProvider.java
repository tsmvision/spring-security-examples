package com.example.corespringsecurity.security.provider;

//import com.example.corespringsecurity.security.common.FormWebAuthenticationDetails;
//import com.example.corespringsecurity.security.token.AjaxAuthenticationToken;
//import com.example.corespringsecurity.service.AccountContext;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.InsufficientAuthenticationException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.transaction.annotation.Transactional;
//
////@Primary
//@Configuration
//@RequiredArgsConstructor
//public class AjaxAuthenticationProvider implements AuthenticationProvider {
//
//    @Lazy
//    private final UserDetailsService userDetailsService;
//
//    // TODO: find the way to remove @Authowired here
//    @Autowired
////    @Lazy
//    private  PasswordEncoder passwordEncoder;
//
//    @Override
//    @Transactional
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//        String username = authentication.getName();
//        String password = (String) authentication.getCredentials();
//
//        AccountContext accountContext = (AccountContext) userDetailsService.loadUserByUsername(username);
//
//        passwordMatched(password, accountContext.getPassword());
////        secretKeyMatched(authentication);
//
//        return new AjaxAuthenticationToken(
//                accountContext.getAccount(), null, accountContext.getAuthorities()
//        );
//    }
//
//    private void passwordMatched(String originalPassword, String passwordFromContext) {
//        if (!passwordEncoder.matches(originalPassword, passwordFromContext)) {
//            throw new BadCredentialsException("BadCredentialException");
//        }
//    }
//
//    private void secretKeyMatched(Authentication authentication) {
//        FormWebAuthenticationDetails formAuthenticationDetails =
//                (FormWebAuthenticationDetails) authentication.getDetails();
//        String secretKey = formAuthenticationDetails.getSecretKey();
//        if (!"secret".equals(secretKey)) {
//            throw new InsufficientAuthenticationException("InsufficientAuthenticationException");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(AjaxAuthenticationToken.class);
//    }
//}
