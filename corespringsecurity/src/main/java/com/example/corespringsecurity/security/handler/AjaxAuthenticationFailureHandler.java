package com.example.corespringsecurity.security.handler;

import com.example.corespringsecurity.dto.ErrorMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Primary
@Configuration
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException exception) throws IOException, ServletException {

        writeHeaderAndErrorMessageToHttpServletResponse(
                configureHttpServletResponse(httpServletResponse),
                generateErrorMessage(exception)
                );
    }

    private void writeHeaderAndErrorMessageToHttpServletResponse(HttpServletResponse httpServletResponse, String errorMessage) throws IOException {
        objectMapper.writeValue(
                httpServletResponse.getWriter(),
                ErrorMessage
                        .builder()
                        .errorMessage(errorMessage)
                        .build()
        );
    }

    private HttpServletResponse configureHttpServletResponse(HttpServletResponse httpServletResponse) {
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        return httpServletResponse;
    }

    private String generateErrorMessage(Exception exception) {

        String errorMessage = "Invalid Username or Password";

        if (exception instanceof BadCredentialsException) {
            errorMessage = "Invalid Username or Password";
        }
        else if (exception instanceof DisabledException) {
            errorMessage = "Locked";
        }
        else if (exception instanceof CredentialsExpiredException) {
            errorMessage = "Expired Password";
        }

        return errorMessage;
    }
}
