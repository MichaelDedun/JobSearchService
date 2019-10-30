package com.dedun.controller;

import com.dedun.converter.EmployerConverter;
import com.dedun.dto.request.EmployerRequest;
import com.dedun.dto.response.EmployerResponse;
import com.dedun.exception.JobSearchException;
import com.dedun.service.EmployerService;
import com.dedun.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/employer")
public class EmployerController {
    private final UserService userService;
    private final EmployerConverter employerConverter;

    public EmployerController(UserService userService,
                              EmployerConverter employerConverter) {
        this.userService = userService;
        this.employerConverter = employerConverter;
    }

    @PostMapping("registration")
    public EmployerResponse create(@RequestBody @Valid EmployerRequest request) throws JobSearchException {
        return employerConverter.from(userService.saveEmployer(request));
    }
}
