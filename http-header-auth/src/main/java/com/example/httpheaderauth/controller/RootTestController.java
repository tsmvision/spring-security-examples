package com.example.httpheaderauth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootTestController {

    @GetMapping("/abcd")
    public ResponseEntity<String> getAbcd() {
        return new ResponseEntity<>("ABCD!!!", HttpStatus.OK);
    }
}
