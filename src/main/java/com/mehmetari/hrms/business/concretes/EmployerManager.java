package com.mehmetari.hrms.business.concretes;

import com.mehmetari.hrms.business.abstracts.EmployerService;
import com.mehmetari.hrms.core.utilities.results.*;
import com.mehmetari.hrms.dto.request.EmployerRequest;
import com.mehmetari.hrms.dto.response.GetAllEmployerResponse;
import com.mehmetari.hrms.entity.Employer;
import com.mehmetari.hrms.repository.EmployeeRepository;
import com.mehmetari.hrms.repository.EmployerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    EmployerRepository employerRepository;
    private final EmployeeRepository employeeRepository;

    public EmployerManager(EmployerRepository employerRepository,
                           EmployeeRepository employeeRepository) {
        this.employerRepository = employerRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Result addEmployer(EmployerRequest employerRequest) {

        if (employerRepository.existsEmployerByEmail(employerRequest.getEmail())) {
            return new ErrorResult("Daha önce böyle bir mail kullanılmıştır.");
        } else if (employerRepository.existsEmployerByCompanyEmail(employerRequest.getCompanyEmail())) {
            return new ErrorResult("Şirket E-Maili Daha Önce Kullanılmıştır");
        }
        Employer employer = new Employer();
        employer.setEmail(employerRequest.getEmail());
        employer.setCompanyEmail(employerRequest.getCompanyEmail());
        employer.setPhoneNumber(employerRequest.getPhoneNumber());
        employer.setCompanyName(employerRequest.getCompanyName());
        employer.setPassword(employerRequest.getPassword());
        employer.setRepeatPassword(employerRequest.getRepeatPassword());
        employer.setCompanyWebSite(employerRequest.getConpanyWebsite());
        employerRepository.save(employer);
        return new SuccessResult("İş Veren Başarıyla Eklendi");
    }

    @Override
    public DataResult<List<GetAllEmployerResponse>> getall() {
        List<Employer> employerList = employerRepository.findAll();
        List<GetAllEmployerResponse> getAllEmployerResponse = new ArrayList<>();
        for (Employer employer : employerList) {
            GetAllEmployerResponse getAllEmployerResponse1 = new GetAllEmployerResponse();
            getAllEmployerResponse1.setEmail(employer.getEmail());
            getAllEmployerResponse1.setCompanyName(employer.getCompanyName());
            getAllEmployerResponse1.setCompanyEmail(employer.getCompanyEmail());
            getAllEmployerResponse1.setPhoneNumber(employer.getPhoneNumber());
            getAllEmployerResponse.add(getAllEmployerResponse1);
        }

        return new SuccessDataResult<>(getAllEmployerResponse ,"Kullanıcılar Listelendi");
    }


}
