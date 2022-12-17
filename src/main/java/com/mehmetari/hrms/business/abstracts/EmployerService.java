package com.mehmetari.hrms.business.abstracts;

import com.mehmetari.hrms.core.utilities.results.DataResult;
import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.dto.request.EmployerRequest;
import com.mehmetari.hrms.dto.response.GetAllEmployerResponse;

import java.util.List;

public interface EmployerService {



    Result addEmployer(EmployerRequest employerRequest);

    DataResult<List<GetAllEmployerResponse>> getall();

}
