package com.example.corespringsecurity.helper;

public enum UserId {
    USER("user"), MANAGER("manager"), ADMIN("admin");

    public final String label;

    private UserId(String label) {
        this.label = label;
    }
}
