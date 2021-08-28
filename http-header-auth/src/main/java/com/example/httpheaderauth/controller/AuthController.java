package com.example.httpheaderauth.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AuthController {

    @GetMapping
    private ResponseEntity<String> isAuthValid() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("principal = " + authentication.getPrincipal());

        String message = (authentication == null || authentication instanceof AnonymousAuthenticationToken) ? "false" : "true";

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
