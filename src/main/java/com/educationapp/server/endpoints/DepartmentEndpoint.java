package com.educationapp.server.endpoints;

import static org.springframework.http.HttpStatus.OK;

import com.educationapp.server.models.api.admin.AddDepartmentApi;
import com.educationapp.server.models.persistence.DepartmentDb;
import com.educationapp.server.models.persistence.InstituteDb;
import com.educationapp.server.repositories.DepartmentRepository;
import com.educationapp.server.repositories.InstituteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentEndpoint {

    private final InstituteRepository instituteRepository;

    private final DepartmentRepository departmentRepository;

    @PostMapping
    public ResponseEntity<?> addDepartment(@RequestBody final AddDepartmentApi addDepartmentApi) {
        final Long universityId = addDepartmentApi.getUniversityId();
        final String instituteName = addDepartmentApi.getInstituteName();

        final InstituteDb institute = instituteRepository.findByUniversityIdAndName(universityId, instituteName)
                                                         .orElseGet(() -> InstituteDb.builder()
                                                                                     .universityId(universityId)
                                                                                     .name(instituteName)
                                                                                     .build());
        final DepartmentDb department = DepartmentDb.builder()
                                                    .name(addDepartmentApi.getDepartmentName())
                                                    .institute(institute)
                                                    .build();

        return new ResponseEntity<>(departmentRepository.save(department), OK);
    }
}
