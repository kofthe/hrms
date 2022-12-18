package com.mehmetari.hrms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPositionRequest {

    private String positionName;
    private String positionDescription;

    private String generalJobPosition;

}
