package com.example.httpheaderauth.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserWithRolesDto {
    private Long userId;
    private String username;
    private Long roleId;
    private String roleName;
}
