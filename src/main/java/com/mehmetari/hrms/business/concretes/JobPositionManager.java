package com.mehmetari.hrms.business.concretes;

import com.mehmetari.hrms.business.abstracts.JobPositionService;
import com.mehmetari.hrms.core.converter.GeneralJobPositionConverter;
import com.mehmetari.hrms.core.utilities.results.DataResult;
import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.core.utilities.results.SuccessDataResult;
import com.mehmetari.hrms.core.utilities.results.SuccessResult;
import com.mehmetari.hrms.dto.request.JobPositionRequest;
import com.mehmetari.hrms.entity.GeneralJobPosition;
import com.mehmetari.hrms.entity.JobPosition;
import com.mehmetari.hrms.repository.JobPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    JobPositionRepository jobPositionRepository;

    GeneralJobPositionConverter converter;

    public JobPositionManager(JobPositionRepository jobPositionRepository, GeneralJobPositionConverter converter) {
        this.jobPositionRepository = jobPositionRepository;
        this.converter = converter;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(jobPositionRepository.findAll(), "Başarıyla Pozisyonlar Listelendi");
    }

    @Override
    public Result add(JobPositionRequest jobPositionRequest) {
        JobPosition jobPosition = new JobPosition();
        jobPosition.setJobPosition(jobPositionRequest.getPositionName());
        jobPosition.setJobDescription(jobPositionRequest.getPositionDescription());
        jobPosition.setGeneralJobPosition(converter.convertToEntityAttribute(jobPositionRequest.getGeneralJobPosition()));
        jobPositionRepository.save(jobPosition);

        return new SuccessResult("İş Pozisyonu Eklendi");
    }
}
