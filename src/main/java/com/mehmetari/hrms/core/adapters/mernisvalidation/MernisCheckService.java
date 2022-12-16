package com.mehmetari.hrms.core.adapters.mernisvalidation;

import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.dto.request.GetSeekerRequest;

public interface MernisCheckService {

        Result isSeekerMernisVerified(GetSeekerRequest getSeekerRequest) throws Exception;

}

