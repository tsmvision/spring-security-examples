package com.example.springbootjwt.security;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomUserDetails implements UserDetails {

    private String username;

    private String password;

    private boolean isAccountNonExpired = true;

    private boolean isAccountNonLocked = true;

    private boolean isCredentialsNonExpired = true;

    private boolean isEnabled = true;

    @Setter(AccessLevel.PRIVATE)
    private List<GrantedAuthority> authorities = new ArrayList<>();
}
