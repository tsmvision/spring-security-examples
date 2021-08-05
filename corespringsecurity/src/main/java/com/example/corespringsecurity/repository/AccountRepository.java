package com.example.corespringsecurity.repository;

import com.example.corespringsecurity.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
