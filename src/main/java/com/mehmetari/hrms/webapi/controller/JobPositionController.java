package com.mehmetari.hrms.webapi.controller;

import com.mehmetari.hrms.business.abstracts.JobPositionService;
import com.mehmetari.hrms.core.utilities.results.DataResult;
import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.dto.request.JobPositionRequest;
import com.mehmetari.hrms.entity.JobPosition;
import com.mehmetari.hrms.repository.JobPositionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobposition")
public class JobPositionController {

    JobPositionService jobPositionService;
    private final JobPositionRepository jobPositionRepository;

    public JobPositionController(JobPositionService jobPositionService,
                                 JobPositionRepository jobPositionRepository) {
        this.jobPositionService = jobPositionService;
        this.jobPositionRepository = jobPositionRepository;
    }


    @GetMapping("/listall")
    public ResponseEntity<DataResult<List<JobPosition>>> getAll() {
        return new ResponseEntity<>(jobPositionService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> addJobPosition(@RequestBody JobPositionRequest jobPositionRequest) {
        return new ResponseEntity<>(jobPositionService.add(jobPositionRequest), HttpStatus.OK);

    }
}
