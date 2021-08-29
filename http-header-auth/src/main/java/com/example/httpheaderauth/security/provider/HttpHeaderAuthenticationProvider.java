package com.example.httpheaderauth.security.provider;

import com.example.httpheaderauth.domain.dto.UserWithRoleListDto;
//import com.example.httpheaderauth.security.service.CustomUserContext;
//import com.example.httpheaderauth.security.service.CustomUserDetailsService;
import com.example.httpheaderauth.security.token.HttpHeaderAuthenticationToken;
import com.example.httpheaderauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class HttpHeaderAuthenticationProvider implements AuthenticationProvider {

//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
    private final UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String auth = authentication.getName();

        hasAuth(auth);

//        CustomUserContext customUserContext =
//                (CustomUserContext) customUserDetailsService.loadUserByUsername(auth);
//
//        return new HttpHeaderAuthenticationToken(
//                auth,
//                customUserContext.getAuthorities()
//        );
//
//        UserWithRoleListDto userWithRoles = userService.findUserWithRoles(auth);
        return new HttpHeaderAuthenticationToken(
                auth,
                generateRoles(
                        userService.findUserWithRoles(auth)
                )
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(HttpHeaderAuthenticationToken.class);
    }

    private void hasAuth(String auth) {
        if (auth == null || auth.equals("")
        ) {
            throw new BadCredentialsException("");
        }
    }

    private List<GrantedAuthority> generateRoles(UserWithRoleListDto userWithRoles) {
        List<GrantedAuthority> roles = new ArrayList<>();

        for (String role : userWithRoles.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role));
        }

        return roles;
    }
}
