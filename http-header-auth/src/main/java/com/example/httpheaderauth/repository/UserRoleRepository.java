package com.example.httpheaderauth.repository;

import com.example.httpheaderauth.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
