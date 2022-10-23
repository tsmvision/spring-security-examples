package com.example.springbootjwt.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
    @NotNull
//    @Email @Length(min = 5, max = 50)
//    private String email;
    private String username;

    @NotNull
//    @Length(min = 5, max = 10)
    private String password;

    // getters and setters are not shown...
}
