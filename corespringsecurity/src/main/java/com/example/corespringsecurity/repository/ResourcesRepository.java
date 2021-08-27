package com.example.corespringsecurity.repository;

import com.example.corespringsecurity.domain.entity.Resources;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourcesRepository extends JpaRepository<Resources, Long> {
    List<Resources> findAllResources();
}
