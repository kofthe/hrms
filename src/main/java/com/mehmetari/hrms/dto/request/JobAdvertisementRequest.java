package com.mehmetari.hrms.dto.request;

import com.mehmetari.hrms.entity.City;
import com.mehmetari.hrms.entity.GeneralJobPosition;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementRequest {
    private String jobAdversimentTitle;
    private String generalJobPosition;

    private String jobDescription;
    private String city;

    private double minSalary;
    private double maxSalary;

    private int openPositions;

    private String applicationDeadline;

    private Boolean isActiveAdvertisement;

}
