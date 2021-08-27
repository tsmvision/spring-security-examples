package com.springsecurity.restapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDto {

    @JsonProperty("isAuthenticated")
    private boolean isAuthenticated;
}
