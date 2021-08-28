package com.example.httpheaderauth.repository;

import com.example.httpheaderauth.domain.dto.UserWithRolesDto;
import java.util.List;

public interface UserRepositoryCustom {
    List<UserWithRolesDto> findUserWithRoles(String username);
}
