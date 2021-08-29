package com.example.httpheaderauth.security.service;

//import com.example.httpheaderauth.domain.dto.UserAndRoleDto;
//import com.example.httpheaderauth.domain.dto.UserWithRoleListDto;
//import com.example.httpheaderauth.service.UserService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // TODO: add roles by username
//
//           UserWithRoleListDto userWithRoles = userService.findUserWithRoles(username);
//
//           if (userWithRoles == null) {
//               throw new UsernameNotFoundException("USERNAME NOT FOUND");
//           }
//
//            List<GrantedAuthority> roles = new ArrayList<>();
//
//           for (String role: userWithRoles.getRoles()) {
//               roles.add(new SimpleGrantedAuthority(role));
//           }
//
//           return new CustomUserContext(userWithRoles.getUsername(), roles);
//
//
////        Optional<Account> account = accountRepository.findByUsername(username);
////        if (account.isEmpty()) {
////            throw new UsernameNotFoundException("UsernameNotFoundException");
////        }
////
////        List<GrantedAuthority> roles = new ArrayList<>();
////
//////        log.info("getRole() = {}",account.get().getRole());
////
////        for (RoleDto roleDto : accountRoleRepository.findRolesByAccountId(account.get().getId())) {
////            roles.add(new SimpleGrantedAuthority(roleDto.getRoleName()));
////        }
////
////        // join account, accountRole and role
////        // iterate above
////        // insert new SimpleGrantedAuthority into the roles
////        // setup querydsl
////        // get roles
////
//////        roles.add(new SimpleGrantedAuthority(account.get().getRole()));
//////
////        return new AccountContext(account.get(), roles);
////        return null;
//    }
//}
