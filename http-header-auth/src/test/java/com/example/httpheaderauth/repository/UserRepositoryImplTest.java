package com.example.httpheaderauth.repository;

import com.example.httpheaderauth.domain.dto.UserAndRoleDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
class UserRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUserWithRolesTest() {
        List<UserAndRoleDto> users = userRepository.findUserWithRoles("user");
        for (UserAndRoleDto user: users) {
            System.out.println(user.getUserId());
            System.out.println(user.getUsername());
            System.out.println(user.getRoleId());
            System.out.println(user.getRoleName());
            System.out.println();
        }
    }
}