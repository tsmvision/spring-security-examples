package com.example.springbootjwt.controller;

import com.example.springbootjwt.dto.AuthRequest;
import com.example.springbootjwt.dto.AuthResponse;
import com.example.springbootjwt.security.service.AuthService;
import com.example.springbootjwt.security.service.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    private final JwtTokenService jwtTokenHelper;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

            return authService.generateLoginResponseEntity(request);
    }

    // TODO: refactor this.
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody AuthRequest authRequest) {
            return authService.generateSignUpResponseEntity(authRequest);
    }

    // TODO: refactor this. authentication process is already completed before executing this method.
    @GetMapping("/status")
    public ResponseEntity<Boolean> getStatus(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
        // read header
        // return status or update jwt token
        String jwtToken = jwtTokenHelper.extractTokenFromAuthorizationString(authorization);
        boolean tokenValidated = jwtTokenHelper.validateAccessToken(jwtToken);
        return new ResponseEntity<>(tokenValidated, HttpStatus.OK);
    }
}
