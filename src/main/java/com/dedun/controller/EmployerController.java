package com.dedun.controller;

import com.dedun.converter.EmployerConverter;
import com.dedun.dto.request.EmployerRequest;
import com.dedun.dto.response.EmployerResponse;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Employer;
import com.dedun.model.User;
import com.dedun.service.EmployerService;
import com.dedun.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employer")
public class EmployerController {
    private final UserService userService;
    private final EmployerService employerService;
    private final EmployerConverter employerConverter;

    public EmployerController(UserService userService,
                              EmployerConverter employerConverter,
                              EmployerService employerService) {
        this.userService = userService;
        this.employerService = employerService;
        this.employerConverter = employerConverter;
    }

    @PostMapping("registration")
    public EmployerResponse create(@RequestBody @Valid EmployerRequest request) throws JobSearchException {
        return employerConverter.from(userService.saveEmployer(request));
    }

    @GetMapping(value = "{id}")
    public EmployerResponse get(@PathVariable(value = "id") Long id) throws JobSearchException {
        return employerConverter.from(employerService.get(id));
    }

    @PutMapping
    public EmployerResponse editUser(@AuthenticationPrincipal Employer employer,
                                 @RequestBody EmployerRequest request) throws JobSearchException {
        return employerConverter.from(employerService.edit(employer,request));
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable(value = "id") Long id) throws JobSearchException {
        employerService.delete(id);
    }
}
