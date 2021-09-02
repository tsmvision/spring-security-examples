package com.example.httpheaderauth.security.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class CustomUserContext extends User {

    public CustomUserContext(String username, Collection<? extends GrantedAuthority> authorities) {
        super(username, "",authorities);
    }
}
