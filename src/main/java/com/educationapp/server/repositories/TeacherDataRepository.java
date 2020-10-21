package com.educationapp.server.repositories;

import java.util.List;

import com.educationapp.server.models.persistence.TeacherDataDb;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TeacherDataRepository extends CrudRepository<TeacherDataDb, Long> {

    @Query(value = "SELECT DISTINCT t.id, science_degree_id, department_id, " +
            "u.first_name, last_name, surname, username, password, phone, email, role, is_admin, university_id " +
            "FROM teachers t JOIN users u ON u.id = t.id " +
            "LEFT JOIN subjects s ON u.id = s.teacher_id " +
            "LEFT JOIN schedule s2 on s.id = s2.subject_id " +
            "JOIN schedule_group sg on s2.id = sg.schedule_id " +
            "WHERE sg.group_id = :groupId",
            nativeQuery = true)
    List<TeacherDataDb> findAllByGroupId(@Param("groupId") Long groupId);

    List<TeacherDataDb> findAllByUniversityId(final Long groupId);
}
