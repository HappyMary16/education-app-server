package com.educationapp.server.common.api.admin;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddDepartmentApi {

    @NotNull
    private final Long universityId;

    @NotNull
    private final String instituteName;

    @NotNull
    private final String departmentName;
}
