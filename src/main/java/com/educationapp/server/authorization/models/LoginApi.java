package com.educationapp.server.authorization.models;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginApi {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
