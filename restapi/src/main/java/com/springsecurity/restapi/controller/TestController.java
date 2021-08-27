package com.springsecurity.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/test")
    public ResponseEntity<String> getTest() {
        return new ResponseEntity<>("TEST!!!", HttpStatus.OK);
    }

    @GetMapping("/api/hello")
    public ResponseEntity<String> getHelloWorld() {
        return new ResponseEntity<>("Hello World!!!", HttpStatus.OK);
    }
}
