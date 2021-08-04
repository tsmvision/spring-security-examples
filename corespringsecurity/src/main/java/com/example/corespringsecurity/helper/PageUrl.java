package com.example.corespringsecurity.helper;

public enum PageUrl {
    ROOT("/"),
    MY_PAGE("/myPage"),
    MESSAGES("/messages"),
    CONFIGURATION("/configuration");

    public final String url;

    private PageUrl(String url) {
        this.url = url;
    }
}
