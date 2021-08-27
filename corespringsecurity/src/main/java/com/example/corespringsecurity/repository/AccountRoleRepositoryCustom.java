package com.example.corespringsecurity.repository;

import com.example.corespringsecurity.dto.RoleDto;

import java.util.List;

public interface AccountRoleRepositoryCustom {
    List<RoleDto> findRolesByAccountId(Long id);
}
