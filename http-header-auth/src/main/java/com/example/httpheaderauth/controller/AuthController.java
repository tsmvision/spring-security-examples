package com.example.httpheaderauth.controller;

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
public class AuthController {

//    @GetMapping
//    public ResponseEntity<String> getAuth() {
//        return new ResponseEntity<>("Not Authenticated", HttpStatus.OK);
//    }

    @GetMapping
    private ResponseEntity<String> isLoggedIn(Authentication authentication) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String message = !(authentication == null || authentication instanceof AnonymousAuthenticationToken) ? "true" : "false";

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
