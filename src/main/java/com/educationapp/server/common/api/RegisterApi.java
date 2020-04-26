package com.educationapp.server.common.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterApi {

    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;

    private String lastName;

    @NotNull
    @Size(min = 2, max = 20)
    private String surname;

    private String username;

    @NotNull
    @Size(min = 6, max = 50)
    private String password;

    @NotNull
    @Size(min = 6, max = 50)
    private String confirmPassword;

    private String phone;

    private String email;

    @NotNull
    @Size(max = 3)
    private Integer role;

    private String studentId;

    private Long studyGroupId;

    private Long departmentId;

    private Long scienceDegreeId;

    @NotNull
    private Long universityId;
}
