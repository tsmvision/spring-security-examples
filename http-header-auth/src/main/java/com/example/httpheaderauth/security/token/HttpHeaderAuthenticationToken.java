package com.example.httpheaderauth.security.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import java.util.Collection;

public class HttpHeaderAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 550L;
    private final Object principal;
    private Object credentials;
    private String DUMMY_CREDENTIALS = "dummyCredentials";

    public HttpHeaderAuthenticationToken(Object principal) {
        super((Collection) null);
        this.principal = principal;
        this.credentials = DUMMY_CREDENTIALS;
        this.setAuthenticated(false);
    }

    public HttpHeaderAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = DUMMY_CREDENTIALS;
        super.setAuthenticated(true);
    }

    public Object getCredentials() {
        return this.credentials;
    }

    public Object getPrincipal() {
        return this.principal;
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        Assert.isTrue(!isAuthenticated, "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        super.setAuthenticated(false);
    }

    public void eraseCredentials() {
        super.eraseCredentials();
        this.credentials = null;
    }
}
