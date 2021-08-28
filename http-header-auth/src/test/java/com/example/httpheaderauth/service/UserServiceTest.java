package com.example.httpheaderauth.service;

import com.example.httpheaderauth.domain.dto.UserWithRolesDto;
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
        List<UserWithRolesDto> users = userService.findUserWithRoles("user3");

        for (UserWithRolesDto user: users) {
            System.out.println(user.getUserId());
            System.out.println(user.getUsername());
            System.out.println(user.getRoleId());
            System.out.println(user.getRoleName());
            System.out.println(user.getRoleId());
            System.out.println();
        }
    }
}