package com.mehmetari.hrms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRequest {

    private String email;
    private String password;
    private String repeatPassword;
    private String companyName;
    private String companyEmail;
    private String conpanyWebsite;
    private String phoneNumber;


}
