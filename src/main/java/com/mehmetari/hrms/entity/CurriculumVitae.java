package com.mehmetari.hrms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitae {

    @Id
    @GeneratedValue
    private int id;

    private LocalDateTime creationDate;

    @OneToMany
    private List<EducationDetail> educationDetailList;

    @ManyToOne
    private Seeker seeker;
}
