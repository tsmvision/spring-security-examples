package com.example.springbootjwt.service;

import com.example.springbootjwt.dto.AuthRequest;
import com.example.springbootjwt.entity.Authority;
import com.example.springbootjwt.entity.User;
import com.example.springbootjwt.entity.UserAuthority;
import com.example.springbootjwt.enums.AuthorityType;
import com.example.springbootjwt.repository.UserAuthorityRepository;
import com.example.springbootjwt.repository.UserRepository;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    private final UserAuthorityRepository userAuthorityRepository;

    private final PasswordEncoder passwordEncoder;

    // TODO: udpate / fix code
    public Optional<User> saveUser(@NotNull AuthRequest authRequest) {
        User user = new User();
        user.setUsername(authRequest.getUsername());

        String encodedPassword = passwordEncoder.encode(authRequest.getPassword());
        user.setPassword(encodedPassword);

        addDefaultAuthorityToNewUser(user);

        return Optional.of(user);
    }

    private void addDefaultAuthorityToNewUser(@NotNull User user) {
        UserAuthority userAuthority = new UserAuthority();
        userAuthority.saveUser(user);

        Authority authority = new Authority();
        authority.setAuthorityType(AuthorityType.ROLE_USER);
        userAuthority.saveAuthority(authority);

        userAuthorityRepository.save(userAuthority);
    }

    public Optional<User> findByAuthRequest(AuthRequest authRequest) {
        return userRepository.findByUsername(authRequest.getUsername());
    }
}
