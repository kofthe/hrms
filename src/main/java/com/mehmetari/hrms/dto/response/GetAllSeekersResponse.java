package com.mehmetari.hrms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSeekersResponse {

    private String name;
    private String lastName;
    private Integer birthYear;
    private String email;

}
