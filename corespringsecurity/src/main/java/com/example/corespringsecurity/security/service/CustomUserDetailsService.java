package com.example.corespringsecurity.security.service;

import com.example.corespringsecurity.domain.entity.Account;
import com.example.corespringsecurity.dto.RoleDto;
import com.example.corespringsecurity.repository.AccountRepository;
import com.example.corespringsecurity.repository.AccountRoleRepository;
import com.example.corespringsecurity.repository.RoleRepository;
import com.example.corespringsecurity.service.AccountContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final AccountRoleRepository accountRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Account> account = accountRepository.findByUsername(username);
        if (account.isEmpty()) {
            throw new UsernameNotFoundException("UsernameNotFoundException");
        }

        List<GrantedAuthority> roles = new ArrayList<>();

//        log.info("getRole() = {}",account.get().getRole());

        for (RoleDto roleDto : accountRoleRepository.findRolesByAccountId(account.get().getId())) {
            roles.add(new SimpleGrantedAuthority(roleDto.getRoleName()));
        }

        // join account, accountRole and role
        // iterate above
        // insert new SimpleGrantedAuthority into the roles
        // setup querydsl
        // get roles

//        roles.add(new SimpleGrantedAuthority(account.get().getRole()));
//
        return new AccountContext(account.get(), roles);
    }
}
