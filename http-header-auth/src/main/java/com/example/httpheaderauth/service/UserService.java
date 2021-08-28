package com.example.httpheaderauth.service;

import com.example.httpheaderauth.domain.dto.UserWithRolesDto;
import com.example.httpheaderauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserWithRolesDto> findUserWithRoles(String username) {
        return userRepository.findUserWithRoles(username);
    }
}
