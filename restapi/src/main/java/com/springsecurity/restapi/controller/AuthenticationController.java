package com.springsecurity.restapi.controller;

import com.springsecurity.restapi.dto.AuthResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
// TODO: add logout
// TODO: create isAuthenticated()
public class AuthenticationController {

    @GetMapping
    public ResponseEntity<AuthResponseDto> isAuthenticated() {
        return new ResponseEntity<>(new AuthResponseDto(isLoggedIn()), HttpStatus.OK);
    }

    private boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !(authentication == null || authentication instanceof AnonymousAuthenticationToken);
    }
}
