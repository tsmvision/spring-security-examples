package com.example.corespringsecurity.controller.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MessageController {

    @GetMapping("/messages")
    public String getMessages() {
        return "user/messagePage";
    }

    @GetMapping("/api/messages")
    @ResponseBody
    public ResponseEntity<String> apiMessage() {
        return new ResponseEntity<>("ok message", HttpStatus.OK);
    }
}
