package com.mehmetari.hrms.business.abstracts;

import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.dto.request.JobAdvertisementRequest;
import com.mehmetari.hrms.entity.JobAdvertisement;

public interface JobAdvertisementService {

    Result add(JobAdvertisementRequest jobAdvertisementRequest);

}
