package com.example.corespringsecurity.controller.user;

import com.example.corespringsecurity.domain.Account;
import com.example.corespringsecurity.domain.AccountDto;
import com.example.corespringsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/myPage")
    public String getMessages() {
        return "user/myPage";
    }

    @GetMapping("/users")
    public String createUser() {
        return "user/login/register";
    }

    @PostMapping(value = "/users")
    public String createUser(AccountDto accountDto) throws Exception {
        userService.createUser(
                new Account(
                        accountDto.getUsername(),
                        passwordEncoder.encode(
                                accountDto.getPassword()
                        ),
                        accountDto.getEmail(),
                        accountDto.getAge(),
                        accountDto.getRole()
                )
        );
        return "redirect:/";
    }
}
