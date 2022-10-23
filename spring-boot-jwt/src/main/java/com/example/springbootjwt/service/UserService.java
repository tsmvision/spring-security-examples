package com.example.springbootjwt.service;

import com.example.springbootjwt.dto.AuthRequest;
import com.example.springbootjwt.entity.User;
import com.example.springbootjwt.repository.UserRepository;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    // TODO: udpate / fix code
    @Transactional
    public Optional<User> saveUser(@NotNull AuthRequest authRequest) {
        User user = new User();
        user.setUsername(authRequest.getUsername());

        String encodedPassword = passwordEncoder.encode(authRequest.getPassword());
        user.setPassword(encodedPassword);
//        user.setRoles(UserRole.ROLE_USER);

        userRepository.save(user);

        return Optional.of(user);
    }

    public Optional<User> findByAuthRequest(AuthRequest authRequest) {
        return userRepository.findByUsername(authRequest.getUsername());
    }

    public boolean hasUsername(String username) {
        Optional<User> foundUser = userRepository.findByUsername(username);

        return foundUser.isPresent();
    }
}
