package com.example.corespringsecurity.repository;

import com.example.corespringsecurity.domain.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleRepository extends JpaRepository<AccountRole, Long>, AccountRoleRepositoryCustom {
}
