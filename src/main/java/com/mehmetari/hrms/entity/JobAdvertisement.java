package com.mehmetari.hrms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

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

    private Date applicationDeadline;

    private Boolean isActiveAdvertisement;
    private Date relaseDate;
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;
}
