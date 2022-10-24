package com.example.springbootjwt.security.service;

import com.example.springbootjwt.dto.AuthRequest;
import com.example.springbootjwt.dto.AuthResponse;
import com.example.springbootjwt.dto.UserDto;
import com.example.springbootjwt.entity.User;
import com.example.springbootjwt.service.UserService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;

    private final JwtTokenService jwtUtil;

    private final PasswordEncoder passwordEncoder;

    private HttpHeaders updateHeaderWithJwtToken(UserDto userDto) {

        HttpHeaders responseHeaders = new HttpHeaders();

        // TODO: find automatic way than this manual implementation
        String accessToken = jwtUtil.generateAccessTokenFromUserDto(userDto);
        String authorizationHeaderString = jwtUtil.generateAuthorizationHeaderWithJwt(accessToken);
        responseHeaders.set(HttpHeaders.AUTHORIZATION, authorizationHeaderString);

        return responseHeaders;
    }

    private HttpHeaders generateResponseHttpHeadersWithJwt(AuthRequest request, User user) {

        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());

        return updateHeaderWithJwtToken(userDto);
    }

    private AuthResponse generateAuthResponseByAuthRequest(@NotNull AuthRequest authRequest) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setUsername(authRequest.getUsername());

        return authResponse;
    }

    private ResponseEntity<AuthResponse> generateResponseEntityByJwtHeader(AuthRequest authRequest, User user) {
        HttpHeaders responseHeaders = generateResponseHttpHeadersWithJwt(authRequest, user);
        AuthResponse authResponse = generateAuthResponseByAuthRequest(authRequest);

        return ResponseEntity.ok().headers(responseHeaders).body(authResponse);
    }

    // TODO: refactor this
    public ResponseEntity<AuthResponse> generateSignUpResponseEntity(AuthRequest authRequest) {

        Optional<User> foundUser = userService.findByAuthRequest(authRequest);

        if (foundUser.isPresent()) {
            return generateBadRequestResponseEntity();
        }

        Optional<User> user = userService.saveUser(authRequest);

        return user.isEmpty() ? generateBadRequestResponseEntity()
                : generateResponseEntityByJwtHeader(authRequest, user.get());
    }

    public ResponseEntity<AuthResponse> generateLoginResponseEntity(@NotNull AuthRequest authRequest) {

        Optional<User> foundUser = userService.findByAuthRequest(authRequest);

        return (!validateUser(authRequest, foundUser)) ? generateBadRequestResponseEntity()
                : generateResponseEntityByJwtHeader(authRequest, foundUser.get());
    }

    private boolean validateUser(@NotNull AuthRequest request, Optional<User> user) {
        return user.isPresent() && passwordEncoder.matches(request.getPassword(), user.get().getPassword());
    }

    private ResponseEntity<AuthResponse> generateBadRequestResponseEntity() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthResponse());
    }
}
