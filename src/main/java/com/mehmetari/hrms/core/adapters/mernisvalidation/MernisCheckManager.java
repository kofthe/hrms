package com.mehmetari.hrms.core.adapters.mernisvalidation;

import com.mehmetari.hrms.core.utilities.results.ErrorResult;
import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.core.utilities.results.SuccessResult;
import com.mehmetari.hrms.dto.request.GetSeekerRequest;
import com.mehmetari.hrms.mernis.RDGKPSPublicSoap12;

public class MernisCheckManager  implements MernisCheckService{

    RDGKPSPublicSoap12 rdgkpsPublicSoap12;

    public MernisCheckManager(RDGKPSPublicSoap12 rdgkpsPublicSoap12) {
        this.rdgkpsPublicSoap12 = rdgkpsPublicSoap12;
    }

    @Override
    public Result isSeekerMernisVerified(GetSeekerRequest getSeekerRequest) throws Exception {

        RDGKPSPublicSoap12 rdgkpsPublicSoap121 = new RDGKPSPublicSoap12();

        boolean result = rdgkpsPublicSoap121.TCKimlikNoDogrula(Long.parseLong(getSeekerRequest.getIdentityNumber()),
                getSeekerRequest.getName(),
                getSeekerRequest.getLastName(),
                getSeekerRequest.getBirthYear());

        if (result) {
            return new SuccessResult();
        }
        return new ErrorResult();
    }
}
