package com.educationapp.server.users.model;

import java.util.Collections;

import javax.validation.constraints.NotEmpty;

import com.educationapp.server.common.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends User {

    private String departmentId;

    private String scienceDegree;

    @Builder(toBuilder = true)
    public Teacher(final Long id,
                   final String firstName,
                   final String lastName,
                   final String surname,
                   @NonNull @NotEmpty final String username,
                   @NonNull @NotEmpty final String password,
                   final String phone,
                   @NonNull @NotEmpty final String email,
                   final Boolean isAdmin,
                   final Long universityId,
                   final String departmentId,
                   final String scienceDegree) {
        super(id,
              firstName,
              lastName,
              surname,
              username,
              password,
              phone,
              email,
              Role.TEACHER,
              isAdmin,
              universityId,
              Collections.singletonList(Role.TEACHER.name()));

        this.departmentId = departmentId;
        this.scienceDegree = scienceDegree;
    }
}
