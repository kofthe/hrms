package com.mehmetari.hrms.business.concretes;

import com.mehmetari.hrms.business.abstracts.JobAdvertisementService;
import com.mehmetari.hrms.core.converter.CityConverter;
import com.mehmetari.hrms.core.converter.GeneralJobPositionConverter;
import com.mehmetari.hrms.core.utilities.results.DataResult;
import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.core.utilities.results.SuccessDataResult;
import com.mehmetari.hrms.core.utilities.results.SuccessResult;
import com.mehmetari.hrms.dto.request.JobAdvertisementRequest;
import com.mehmetari.hrms.dto.response.GetActiveJobAdvertisementResponse;
import com.mehmetari.hrms.entity.JobAdvertisement;
import com.mehmetari.hrms.repository.JobAdvertisementRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        jobAdvertisement.setIsActiveAdvertisement(jobAdvertisementRequest.getIsActiveAdvertisement());
        jobAdvertisementRepository.save(jobAdvertisement);

        return new SuccessResult("İş ilanı başarıyla eklendi");
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
    public DataResult<List<JobAdvertisement>> getByEmployerId(int employerId) {
        return new SuccessDataResult<>(this.jobAdvertisementRepository.getByEmployerId(employerId), "İşveren ilanları getirildi.");
    }


}
