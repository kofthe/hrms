package com.mehmetari.hrms.webapi.controller;

import com.mehmetari.hrms.business.abstracts.JobAdvertisementService;
import com.mehmetari.hrms.core.utilities.results.DataResult;
import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.dto.request.JobAdvertisementRequest;
import com.mehmetari.hrms.dto.response.GetActiveJobAdvertisementResponse;
import com.mehmetari.hrms.dto.response.GetAdvertisementByEmployerId;
import com.mehmetari.hrms.entity.JobAdvertisement;
import com.mehmetari.hrms.repository.JobAdvertisementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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

    @GetMapping("/active")
    public ResponseEntity<DataResult> getActiveList(GetActiveJobAdvertisementResponse getActiveJobAdvertisementResponse){
        return new ResponseEntity<>(jobAdvertisementService.getActive(), HttpStatus.OK);
    }

    @GetMapping("/listByEmployerId/{id}")
    public ResponseEntity<DataResult<List<GetAdvertisementByEmployerId>>>getAdvertisementByEmployerId(@PathVariable int id) {
        return new ResponseEntity<>(jobAdvertisementService.getAdvertisementByEmployerId(id), HttpStatus.OK);
    }

}
