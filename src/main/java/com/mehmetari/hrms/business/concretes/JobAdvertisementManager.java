package com.mehmetari.hrms.business.concretes;

import com.mehmetari.hrms.business.abstracts.JobAdvertisementService;
import com.mehmetari.hrms.core.converter.CityConverter;
import com.mehmetari.hrms.core.converter.GeneralJobPositionConverter;
import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.core.utilities.results.SuccessResult;
import com.mehmetari.hrms.dto.request.JobAdvertisementRequest;
import com.mehmetari.hrms.entity.JobAdvertisement;
import com.mehmetari.hrms.repository.JobAdvertisementRepository;
import org.springframework.stereotype.Service;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    JobAdvertisementRepository jobAdvertisementRepository;
    GeneralJobPositionConverter generalJobPositionConverter;
    CityConverter cityConverter;

    public JobAdvertisementManager(JobAdvertisementRepository jobAdvertisementRepository, GeneralJobPositionConverter generalJobPositionConverter, CityConverter cityConverter) {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
        this.generalJobPositionConverter = generalJobPositionConverter;
        this.cityConverter = cityConverter;
    }

    @Override
    public Result add(JobAdvertisementRequest jobAdvertisementRequest) {
        JobAdvertisement jobAdvertisement = new JobAdvertisement();
        jobAdvertisement.setJobAdversimentTitle(jobAdvertisementRequest.getJobAdversimentTitle());
        jobAdvertisement.setJobDescription(jobAdvertisementRequest.getJobDescription());
        jobAdvertisement.setGeneralJobPosition(generalJobPositionConverter.convertToEntityAttribute(jobAdvertisementRequest.getGeneralJobPosition()));
        jobAdvertisement.setCity(cityConverter.convertToEntityAttribute(jobAdvertisementRequest.getCity()));
        jobAdvertisement.setMinSalary(jobAdvertisementRequest.getMinSalary());
        jobAdvertisement.setMaxSalary(jobAdvertisementRequest.getMaxSalary());
        jobAdvertisement.setOpenPositions(jobAdvertisementRequest.getOpenPositions());
        jobAdvertisement.setApplicationDeadline(jobAdvertisementRequest.getApplicationDeadline());
        jobAdvertisementRepository.save(jobAdvertisement);

        return new SuccessResult("İş ilanı başarıyla eklendi");
    }
}
