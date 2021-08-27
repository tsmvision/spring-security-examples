package com.springsecurity.loginserver.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
public class SessionAttributeController {

    @GetMapping
    public Attributes getAttribute1(HttpSession session) {
        session.setAttribute("test1", "test1 session attribute");
        session.setAttribute("test2", "test2 session attribute");

        return new Attributes(
                (String) session.getAttribute("test1"),
                (String) session.getAttribute("test2")
        );
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Attributes {
        private String test1;
        private String test2;
    }
}
