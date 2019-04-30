package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class UserInfo {

    private String uid;
    @NotNull
    @Email
    private String email;
    private String firstName;
    private String lastName;
}
