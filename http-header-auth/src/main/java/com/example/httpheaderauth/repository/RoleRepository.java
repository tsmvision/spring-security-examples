package com.example.httpheaderauth.repository;

import com.example.httpheaderauth.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
