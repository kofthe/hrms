package com.mehmetari.hrms.webapi.controller;

import com.mehmetari.hrms.business.abstracts.JobAdvertisementService;
import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.dto.request.JobAdvertisementRequest;
import com.mehmetari.hrms.repository.JobAdvertisementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobadvertisement")
public class JobAdvertisementController {
    JobAdvertisementService jobAdvertisementService;
    private final JobAdvertisementRepository jobAdvertisementRepository;

    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService,
                                      JobAdvertisementRepository jobAdvertisementRepository) {
        this.jobAdvertisementService = jobAdvertisementService;
        this.jobAdvertisementRepository = jobAdvertisementRepository;
    }

    @PostMapping("/addjob")
    public ResponseEntity<Result> addjob(JobAdvertisementRequest jobAdvertisementRequest){
        return new ResponseEntity<>(jobAdvertisementService.add(jobAdvertisementRequest), HttpStatus.OK);
    }


}