package com.example.httpheaderauth.security.handler;

import com.example.httpheaderauth.security.dto.ErrorMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpHeaderAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException exception) throws IOException, ServletException {

//        writeHeaderAndErrorMessageToHttpServletResponse(
//                configureHttpServletResponse(httpServletResponse),
//                ErrorMessage.generateErrorMessageByException(exception)
//        );
        throw new AuthorizationServiceException("");
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
}
