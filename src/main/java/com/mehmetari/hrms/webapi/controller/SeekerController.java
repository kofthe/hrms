package com.mehmetari.hrms.webapi.controller;

import com.mehmetari.hrms.business.abstracts.SeekerService;
import com.mehmetari.hrms.core.utilities.results.DataResult;
import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.dto.request.GetSeekerRequest;
import com.mehmetari.hrms.dto.response.GetAllSeekersResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobseeker")
public class SeekerController {

    SeekerService seekerService;

    public SeekerController(SeekerService seekerService) {
        this.seekerService = seekerService;
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody GetSeekerRequest getSeekerRequest) throws Exception {
        return new ResponseEntity<>(seekerService.addSeeker(getSeekerRequest), HttpStatus.OK);
    }

    @GetMapping("/listall")
    public ResponseEntity<DataResult<List<GetAllSeekersResponse>>> getAll() {
        return new ResponseEntity<>(seekerService.getAll(), HttpStatus.OK);
    }
}
