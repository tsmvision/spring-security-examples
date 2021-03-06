package com.example.corespringsecurity.repository;

import com.example.corespringsecurity.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
    int countByUsername(String username);
}
