package com.example.corespringsecurity.helper;

public enum PageUrl {
    ROOT("/"),
    MY_PAGE("/myPage"),
    MESSAGES("/messages"),
    CONFIGURATION("/configuration"),
    USER("/user"),
    LOGIN("/login"),
    REGISTER("/users")
    ;

    public final String url;

    private PageUrl(String url) {
        this.url = url;
    }
}
