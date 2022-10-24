package com.example.springbootjwt.security.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GrantAuthorityImpl implements GrantedAuthority {

    private String authority;
}
