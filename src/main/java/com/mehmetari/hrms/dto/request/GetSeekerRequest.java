package com.mehmetari.hrms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSeekerRequest {

    private String name;
    private String lastName;
    private int birthYear;
    private String identityNumber;
    private String email;
    private String password;
    private String repeatPassword;



}
