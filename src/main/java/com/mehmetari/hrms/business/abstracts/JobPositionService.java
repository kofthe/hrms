package com.mehmetari.hrms.business.abstracts;

import com.mehmetari.hrms.core.utilities.results.DataResult;
import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.dto.request.JobPositionRequest;
import com.mehmetari.hrms.entity.JobPosition;

import java.util.List;

public interface JobPositionService {

    DataResult<List<JobPosition>> getAll();

    Result add(JobPositionRequest jobPositionRequest);
}
