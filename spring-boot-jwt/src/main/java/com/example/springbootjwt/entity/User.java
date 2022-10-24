package com.example.springbootjwt.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    // TODO: prevent duplicated Authority
    @OneToMany(mappedBy = "user")
    @Setter(AccessLevel.PRIVATE)
    private List<UserAuthority> userAuthorityList = new ArrayList<>();

    @Column(name = "account_non_Expired")
    private boolean isAccountNonExpired = true;

    @Column(name = "account_non_locked")
    private boolean isAccountNonLocked = true;

    @Column(name = "credentials_non_expired")
    private boolean isCredentialsNonExpired = true;

    @Column(name = "enabled")
    private boolean isEnabled = true;

    // TODO: convert to querydsl if performance issue found
    public List<Authority> getAuthorityList() {
        List<UserAuthority> userAuthorityList = this.getUserAuthorityList();

        return userAuthorityList.stream().map(UserAuthority::getAuthority).toList();
    }
}

