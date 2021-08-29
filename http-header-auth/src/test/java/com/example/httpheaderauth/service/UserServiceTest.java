package com.example.httpheaderauth.service;

import com.example.httpheaderauth.domain.dto.UserAndRoleDto;
import com.example.httpheaderauth.domain.dto.UserWithRoleListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void findUserWithRolesTest() {
        UserWithRoleListDto user = userService.findUserWithRoles("user3");

        System.out.println(user.getUserId());
        System.out.println(user.getUsername());

        for (String role: user.getRoles()) {
            System.out.println(role);
        }
    }
}