package com.example.corespringsecurity.repository;

import com.example.corespringsecurity.domain.entity.RoleResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleResourceRepository extends JpaRepository<RoleResource, Long> {
}
