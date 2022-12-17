package com.mehmetari.hrms.business.concretes;

import com.mehmetari.hrms.business.abstracts.SeekerService;
import com.mehmetari.hrms.core.adapters.mernisvalidation.MernisCheckService;
import com.mehmetari.hrms.core.utilities.results.*;
import com.mehmetari.hrms.dto.request.GetSeekerRequest;
import com.mehmetari.hrms.dto.response.GetAllSeekersResponse;
import com.mehmetari.hrms.entity.Seeker;
import com.mehmetari.hrms.repository.SeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class SeekerManager implements SeekerService {
    SeekerRepository seekerRepository;
    MernisCheckService mernisCheckService;

    @Autowired
    public SeekerManager(SeekerRepository seekerRepository, MernisCheckService mernisCheckService) {
        this.seekerRepository = seekerRepository;
        this.mernisCheckService = mernisCheckService;
    }

    @Override
    public Result addSeeker(GetSeekerRequest getSeekerRequest) throws Exception {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
        Pattern pattern =	Pattern.compile(passwordRegex,Pattern.UNICODE_CHARACTER_CLASS);

        if (seekerRepository.existsSeekerByEmail(getSeekerRequest.getEmail())) {
            return new ErrorResult("Girmiş Olduğunuz E-Mail Daha Önce Kullanılmıştır.");
        }else if(seekerRepository.existsSeekerByIdentityNumber(getSeekerRequest.getIdentityNumber())) {
            return new ErrorResult("Girmiş Olduğunuz Kimlik Numarası Mevcuttur.");
        } else if (!pattern.matches(passwordRegex, getSeekerRequest.getPassword())) {
            return new ErrorResult("Girmiş olduğunuz şifre geçerli değil."
                    + "Şifre en az 8 karakterden ve bir küçük bir büyük harf ve"
                    + "rakam içermek zorundadır."
                    + "Lütfen geçerli bir şifre giriniz.");
        }

        if (isValidPerson(getSeekerRequest).isSuccess()) {
            return new ErrorResult("Böyle birisi yok. Lütfen daha sonra tekrar deneyiniz.");
        }

        Seeker seeker = new Seeker();
        seeker.setFirstName(getSeekerRequest.getName());
        seeker.setLastName(getSeekerRequest.getLastName());
        seeker.setEmail(getSeekerRequest.getEmail());
        seeker.setBirthYear(getSeekerRequest.getBirthYear());
        seeker.setPassword(getSeekerRequest.getPassword());
        seeker.setIdentityNumber(getSeekerRequest.getIdentityNumber());
        seekerRepository.save(seeker);
        return new SuccessResult("İş Arayan Başarıyla Eklendi.");
    }

    @Override
    public DataResult<List<GetAllSeekersResponse>> getAll() {

        List<GetAllSeekersResponse> getAllSeekersResponse = new ArrayList<>();
        List<Seeker> seekerList = seekerRepository.findAll();
        for(Seeker seeker: seekerList) {
            GetAllSeekersResponse getAllSeekersResponse1 = new GetAllSeekersResponse();
            getAllSeekersResponse1.setName(seeker.getFirstName());
            getAllSeekersResponse1.setLastName(seeker.getLastName());
            getAllSeekersResponse1.setEmail(seeker.getEmail());
            getAllSeekersResponse1.setBirthYear(seeker.getBirthYear());
            getAllSeekersResponse.add(getAllSeekersResponse1);
        }


        return new SuccessDataResult<>(getAllSeekersResponse,"Kullanıcılar Listelendi");
    }


    public Result isValidPerson(GetSeekerRequest getSeekerRequest) throws Exception {
        if (mernisCheckService.isSeekerMernisVerified(getSeekerRequest).isSuccess()) {
            return new ErrorResult();
        }
        return new SuccessResult();
    }


}
