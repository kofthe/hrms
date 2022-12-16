package com.mehmetari.hrms.business.abstracts;

import com.mehmetari.hrms.core.utilities.results.DataResult;
import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.dto.request.GetSeekerRequest;
import com.mehmetari.hrms.dto.response.GetAllSeekersResponse;

import java.util.List;

public interface SeekerService {


    Result addSeeker(GetSeekerRequest getSeekerRequest) throws Exception;

    DataResult<List<GetAllSeekersResponse>> getAll();


}
