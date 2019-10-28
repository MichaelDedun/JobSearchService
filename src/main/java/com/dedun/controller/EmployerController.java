package com.dedun.controller;

import com.dedun.converter.EmployerConverter;
import com.dedun.dto.request.EmployerRequest;
import com.dedun.dto.response.EmployerResponse;
import com.dedun.exception.JobSearchException;
import com.dedun.service.EmployerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employer")
public class EmployerController {
    private final EmployerService employerService;
    private final EmployerConverter employerConverter;

    public EmployerController(EmployerService employerService, EmployerConverter employerConverter) {
        this.employerService = employerService;
        this.employerConverter = employerConverter;
    }

    @PostMapping("registration")
    public EmployerResponse create(@RequestBody EmployerRequest employerRequest) throws JobSearchException {
        return employerConverter.from(employerService.save(employerRequest));
    }
}
