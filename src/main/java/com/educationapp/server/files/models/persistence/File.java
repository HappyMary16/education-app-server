package com.educationapp.server.files.models.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "files")
public class File {

    public File(final String path, final String subjectName, final Long fileTypeId) {
        this.path = path;
        this.subjectName = subjectName;
        this.fileTypeId = fileTypeId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    @Column(name = "subject_id")
    private String  subjectName;

    @Column(name = "type_id")
    private Long fileTypeId;
}