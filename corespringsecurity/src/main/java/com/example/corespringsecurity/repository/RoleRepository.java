package com.example.corespringsecurity.repository;

import com.example.corespringsecurity.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
