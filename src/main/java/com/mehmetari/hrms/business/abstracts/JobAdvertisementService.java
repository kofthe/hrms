package com.mehmetari.hrms.business.abstracts;

import com.mehmetari.hrms.core.utilities.results.DataResult;
import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.dto.request.JobAdvertisementRequest;
import com.mehmetari.hrms.dto.response.GetActiveJobAdvertisementResponse;
import com.mehmetari.hrms.entity.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {

    Result add(JobAdvertisementRequest jobAdvertisementRequest);

    DataResult<List<GetActiveJobAdvertisementResponse>> getActive();

    DataResult<List<JobAdvertisement>> getByEmployerId(int employerId);


}
