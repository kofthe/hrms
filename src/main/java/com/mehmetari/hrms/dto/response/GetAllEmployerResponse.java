package com.mehmetari.hrms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployerResponse {

    private String email;
    private String companyEmail;
    private String companyName;
    private String phoneNumber;



}
