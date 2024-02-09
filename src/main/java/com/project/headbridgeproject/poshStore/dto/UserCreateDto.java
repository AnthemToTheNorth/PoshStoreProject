package com.project.headbridgeproject.poshStore.dto;

import com.project.headbridgeproject.poshStore.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class UserCreateDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    public Role role;
}
