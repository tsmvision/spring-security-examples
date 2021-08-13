package com.example.corespringsecurity.security.handler;

import com.example.corespringsecurity.domain.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Primary
@Configuration
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        writeHeaderAndAccountToHttpServletResponse(
                configureHttpServletResponse(httpServletResponse),
                retrieveAccountFromAuthentication(authentication)
        );
    }

    private void writeHeaderAndAccountToHttpServletResponse(HttpServletResponse httpServletResponse, Account account) throws IOException {
        objectMapper.writeValue(httpServletResponse.getWriter(), account);
    }

    private HttpServletResponse configureHttpServletResponse(HttpServletResponse httpServletResponse) {
        httpServletResponse.setStatus(HttpStatus.OK.value());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);

        return httpServletResponse;
    }

    private Account retrieveAccountFromAuthentication(Authentication authentication) {
        return (Account) authentication.getPrincipal();
    }
}
