package com.example.httpheaderauth.service;

import com.example.httpheaderauth.domain.dto.UserAndRoleDto;
import com.example.httpheaderauth.domain.dto.UserWithRoleListDto;
import com.example.httpheaderauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserWithRoleListDto findUserWithRoles(String username) {
        List<UserAndRoleDto> userAndRoles = userRepository.findUserWithRoles(username);

        if (userAndRoles.isEmpty()) {
            return null;
        }

        UserWithRoleListDto userWithRoleListDtos = new UserWithRoleListDto();
        userWithRoleListDtos.setUserId(userAndRoles.get(0).getUserId());
        userWithRoleListDtos.setUsername(userAndRoles.get(0).getUsername());

        for (UserAndRoleDto userAndRole: userAndRoles) {
            userWithRoleListDtos.addRole(userAndRole.getRoleName());
        }

        return userWithRoleListDtos;
    }
}
