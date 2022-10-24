package com.example.springbootjwt.security.service;

import com.example.springbootjwt.entity.Authority;
import com.example.springbootjwt.entity.User;
import com.example.springbootjwt.repository.UserRepository;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> foundUserOptional = userRepository.findByUsername(username);

        if (foundUserOptional.isEmpty()) {
            return new UserDetailsImpl();
        }

        return generateUserDetails(foundUserOptional.get());
    }

    private UserDetails generateUserDetails(@NotNull User foundUser) {

        UserDetailsImpl userDetails = new UserDetailsImpl();

        userDetails.setUsername(foundUser.getUsername());
        userDetails.setPassword(foundUser.getPassword());
        userDetails.setAccountNonLocked(foundUser.isAccountNonLocked());

        userDetails.setEnabled(foundUser.isEnabled());
        userDetails.setAccountNonExpired(foundUser.isCredentialsNonExpired());

        userDetails.setAccountNonLocked(foundUser.isAccountNonLocked());
        userDetails.setCredentialsNonExpired(foundUser.isCredentialsNonExpired());

        List<Authority> authorityList = foundUser.getAuthorityList();

        for (Authority authority : authorityList) {
            GrantedAuthority grantedAuthority = new GrantAuthorityImpl(authority.getAuthorityType().name());
            userDetails.getAuthorities().add(grantedAuthority);
        }

        return userDetails;
    }
}
