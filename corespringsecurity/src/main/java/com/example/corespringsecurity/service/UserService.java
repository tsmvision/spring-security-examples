package com.example.corespringsecurity.service;

import com.example.corespringsecurity.domain.Account;
import com.example.corespringsecurity.domain.AccountDto;
import com.example.corespringsecurity.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AccountRepository accountRepository;

    @Transactional
    public void createUser(Account account) {
        accountRepository.save(account);
    }
}
