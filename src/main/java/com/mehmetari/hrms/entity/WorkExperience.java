package com.mehmetari.hrms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkExperience {
    @Id
    @GeneratedValue
    private int id;

    private Date beginDate;

    private Date exitDate;

    private Boolean isWorking;


}
