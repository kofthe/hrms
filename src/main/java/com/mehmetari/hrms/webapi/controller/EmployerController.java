package com.mehmetari.hrms.webapi.controller;

import com.mehmetari.hrms.business.abstracts.EmployerService;
import com.mehmetari.hrms.core.utilities.results.DataResult;
import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.dto.request.EmployerRequest;
import com.mehmetari.hrms.dto.response.GetAllEmployerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eployer")
public class EmployerController {
    EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<GetAllEmployerResponse>>> getAll() {
        employerService.getall();
        return new ResponseEntity<>( employerService.getall(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody EmployerRequest employerRequest) {
        return new ResponseEntity<>(employerService.addEmployer(employerRequest), HttpStatus.OK);
    }

}
