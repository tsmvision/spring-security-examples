package com.example.httpheaderauth.security.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;

@Getter
@Setter
@Builder
public class ErrorMessage {
    private String errorMessage;

    public static String generateErrorMessageByException(Exception exception) {

        String errorMessage = "Auth is null or invalid";

        if (exception instanceof BadCredentialsException) {
            errorMessage = "Auth is null or invalid";
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
