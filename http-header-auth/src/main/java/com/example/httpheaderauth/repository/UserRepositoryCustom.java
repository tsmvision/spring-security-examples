package com.example.httpheaderauth.repository;

import com.example.httpheaderauth.domain.dto.UserAndRoleDto;
import java.util.List;

public interface UserRepositoryCustom {
    List<UserAndRoleDto> findUserWithRoles(String username);
}
