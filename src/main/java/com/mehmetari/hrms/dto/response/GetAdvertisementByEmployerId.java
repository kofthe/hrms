package com.mehmetari.hrms.dto.response;

import com.mehmetari.hrms.entity.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAdvertisementByEmployerId {
    private String jobAdversimentTitle;
    private String generalJobPosition;

    private String jobDescription;
    private City city;

    private double minSalary;
    private double maxSalary;

    private int openPositions;

    private LocalDate applicationDeadline;

    private Boolean isActiveAdvertisement;

    private LocalDate relaseDate;
}
