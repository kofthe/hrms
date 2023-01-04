package com.mehmetari.hrms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String schoolName;


    private String schoolDepartment;


    private String degree;


    private LocalDateTime startingDate;


    private LocalDateTime graduationDate;


    private Boolean isGraduated;

    @ManyToOne
    private CurriculumVitae curriculumVitae;

}
