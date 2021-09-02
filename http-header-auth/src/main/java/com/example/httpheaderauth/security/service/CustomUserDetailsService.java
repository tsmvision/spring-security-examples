package com.example.httpheaderauth.security.service;

import com.example.httpheaderauth.domain.dto.UserWithRoleListDto;
import com.example.httpheaderauth.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO: add roles by username

        Optional<UserWithRoleListDto> userWithRolesOptional = userService.findUserWithRoles(username);

        if (userWithRolesOptional.isEmpty()) {
            throw new UsernameNotFoundException("");
        }

        UserWithRoleListDto userWithRoles = userWithRolesOptional.get();

        return new CustomUserContext(
                userWithRoles.getUsername(),
                generateRoles(userWithRoles)
        );
    }

    private List<GrantedAuthority> generateRoles(@NotNull UserWithRoleListDto userWithRoles) {
        List<GrantedAuthority> roles = new ArrayList<>();

        for (String role : userWithRoles.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role));
        }

        return roles;
    }
}
