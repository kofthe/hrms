package com.mehmetari.hrms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_advertisement_id")
    private int id;
    private String jobAdversimentTitle;
    @Enumerated(EnumType.STRING)
    private GeneralJobPosition generalJobPosition;

    private String jobDescription;
    @Enumerated(EnumType.STRING)
    private City city;

    private double minSalary;
    private double maxSalary;

    private int openPositions;

    private LocalDate applicationDeadline;

    private Boolean isActiveAdvertisement;
    private LocalDate relaseDate;
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;
}
