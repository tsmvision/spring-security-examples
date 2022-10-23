package com.example.springbootjwt.enums;

import lombok.Getter;

@Getter
public enum TokenBody {
    USERNAME("username");

    private String name;

    private TokenBody(String name) {
        this.name = name;
    }
}
