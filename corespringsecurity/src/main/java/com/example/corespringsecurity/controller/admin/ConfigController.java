package com.example.corespringsecurity.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/configuration")
public class ConfigController {

    @GetMapping
    public String getConfiguration() {
        return "admin/configurationPage";
    }
}
