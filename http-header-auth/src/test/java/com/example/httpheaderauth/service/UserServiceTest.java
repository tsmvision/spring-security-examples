package com.example.httpheaderauth.service;

import com.example.httpheaderauth.domain.dto.UserWithRoleListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void findUserWithRolesTest() {
        Optional<UserWithRoleListDto> user = userService.findUserWithRoles("user3");

        if (user.isPresent()) {
            System.out.println(user.get().getUserId());
            System.out.println(user.get().getUsername());

            for (String role: user.get().getRoles()) {
                System.out.println(role);
            }
        }
    }
}