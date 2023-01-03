package com.mehmetari.hrms.business.concretes;

import com.mehmetari.hrms.business.abstracts.EmployerService;
import com.mehmetari.hrms.business.abstracts.JobAdvertisementService;
import com.mehmetari.hrms.core.converter.CityConverter;
import com.mehmetari.hrms.core.converter.GeneralJobPositionConverter;
import com.mehmetari.hrms.core.utilities.results.*;
import com.mehmetari.hrms.dto.request.JobAdvertisementRequest;
import com.mehmetari.hrms.dto.response.GetActiveJobAdvertisementResponse;
import com.mehmetari.hrms.dto.response.GetAdvertisementByEmployerId;
import com.mehmetari.hrms.entity.Employer;
import com.mehmetari.hrms.entity.JobAdvertisement;
import com.mehmetari.hrms.repository.EmployerRepository;
import com.mehmetari.hrms.repository.JobAdvertisementRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    JobAdvertisementRepository jobAdvertisementRepository;
    GeneralJobPositionConverter generalJobPositionConverter;
    CityConverter cityConverter;
    EmployerRepository employerRepository;
    EmployerService employerService;

    public JobAdvertisementManager(JobAdvertisementRepository jobAdvertisementRepository, GeneralJobPositionConverter generalJobPositionConverter, CityConverter cityConverter, EmployerRepository employerRepository, EmployerService employerService) {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
        this.generalJobPositionConverter = generalJobPositionConverter;
        this.cityConverter = cityConverter;
        this.employerRepository = employerRepository;
        this.employerService = employerService;
    }

    @Override
    public Result add(JobAdvertisementRequest jobAdvertisementRequest) {
        Employer employer1 = employerService.getEmployerId(jobAdvertisementRequest.getEmployerId());
        if (Objects.nonNull(employer1)) {

            JobAdvertisement jobAdvertisement = new JobAdvertisement();
            jobAdvertisement.setJobAdversimentTitle(jobAdvertisementRequest.getJobAdversimentTitle());
            jobAdvertisement.setJobDescription(jobAdvertisementRequest.getJobDescription());
            jobAdvertisement.setGeneralJobPosition(generalJobPositionConverter.convertToEntityAttribute(jobAdvertisementRequest.getGeneralJobPosition()));
            jobAdvertisement.setCity(cityConverter.convertToEntityAttribute(jobAdvertisementRequest.getCity()));
            jobAdvertisement.setMinSalary(jobAdvertisementRequest.getMinSalary());
            jobAdvertisement.setMaxSalary(jobAdvertisementRequest.getMaxSalary());
            jobAdvertisement.setOpenPositions(jobAdvertisementRequest.getOpenPositions());
            jobAdvertisement.setApplicationDeadline(jobAdvertisementRequest.getApplicationDeadline());
            jobAdvertisement.setIsActiveAdvertisement(jobAdvertisementRequest.getIsActiveAdvertisement());
            jobAdvertisement.setRelaseDate(LocalDate.now());
            jobAdvertisement.setEmployer(employer1);
            jobAdvertisementRepository.save(jobAdvertisement);

            return new SuccessResult("İş ilanı başarıyla eklendi");
        }
        return new ErrorResult("Hata! Tekrar Deneyin. ");
//        JobAdvertisement jobAdvertisement = new JobAdvertisement();
//        jobAdvertisement.setJobAdversimentTitle(jobAdvertisementRequest.getJobAdversimentTitle());
//        jobAdvertisement.setJobDescription(jobAdvertisementRequest.getJobDescription());
//        jobAdvertisement.setGeneralJobPosition(generalJobPositionConverter.convertToEntityAttribute(jobAdvertisementRequest.getGeneralJobPosition()));
//        jobAdvertisement.setCity(cityConverter.convertToEntityAttribute(jobAdvertisementRequest.getCity()));
//        jobAdvertisement.setMinSalary(jobAdvertisementRequest.getMinSalary());
//        jobAdvertisement.setMaxSalary(jobAdvertisementRequest.getMaxSalary());
//        jobAdvertisement.setOpenPositions(jobAdvertisementRequest.getOpenPositions());
//        jobAdvertisement.setApplicationDeadline(jobAdvertisementRequest.getApplicationDeadline());
//        jobAdvertisement.setIsActiveAdvertisement(jobAdvertisementRequest.getIsActiveAdvertisement());
//        jobAdvertisement.setEmployer();
//        jobAdvertisementRepository.save(jobAdvertisement);
//
//        return new SuccessResult("İş ilanı başarıyla eklendi");
    }

    @Override
    public DataResult<List<GetActiveJobAdvertisementResponse>> getActive() {
        List<GetActiveJobAdvertisementResponse> activeList = new ArrayList<>();
        List<JobAdvertisement> allList = jobAdvertisementRepository.findAll();
        for (JobAdvertisement jobAdvertisement : allList) {

            if (jobAdvertisement.getIsActiveAdvertisement() == true){
                GetActiveJobAdvertisementResponse getActiveJobAdvertisementResponse = new GetActiveJobAdvertisementResponse();
                getActiveJobAdvertisementResponse.setJobAdvertisementTitle(jobAdvertisement.getJobAdversimentTitle());
                activeList.add(getActiveJobAdvertisementResponse);
            }
        }

        return new SuccessDataResult<>(activeList ,"Aktif İlanlar Getirildi.");
    }

    @Override
    public DataResult<List<GetAdvertisementByEmployerId>> getAdvertisementByEmployerId(int id) {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementRepository.getByEmployerId(id);
        List<GetAdvertisementByEmployerId> getAdvertisementByEmployerIds = new ArrayList<>();
        for (JobAdvertisement jobAdvertisement : jobAdvertisements){
            GetAdvertisementByEmployerId getAdvertisementByEmployerId = new GetAdvertisementByEmployerId();
            getAdvertisementByEmployerId.setJobAdversimentTitle(jobAdvertisement.getJobAdversimentTitle());
            getAdvertisementByEmployerId.setJobDescription(jobAdvertisement.getJobDescription());
            getAdvertisementByEmployerId.setIsActiveAdvertisement(jobAdvertisement.getIsActiveAdvertisement());
            getAdvertisementByEmployerId.setCity(jobAdvertisement.getCity());
            getAdvertisementByEmployerId.setMaxSalary(jobAdvertisement.getMaxSalary());
            getAdvertisementByEmployerId.setRelaseDate(jobAdvertisement.getRelaseDate());
            getAdvertisementByEmployerId.setApplicationDeadline(jobAdvertisement.getApplicationDeadline());
            getAdvertisementByEmployerId.setMinSalary(jobAdvertisement.getMinSalary());
            getAdvertisementByEmployerIds.add(getAdvertisementByEmployerId);
        }

        return new SuccessDataResult<>(getAdvertisementByEmployerIds, "İşveren ilanları getirildi.");
    }

    @Override
    public Result changeStatus(int id, Boolean isActive) {
        JobAdvertisement jobAdvertisement = jobAdvertisementRepository.findById(id).get();
        jobAdvertisement.setIsActiveAdvertisement(isActive);
        jobAdvertisementRepository.save(jobAdvertisement);
        return new SuccessResult("İş İlanı Güncellendi. ");

    }


}
