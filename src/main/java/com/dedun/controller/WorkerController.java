package com.dedun.controller;


import com.dedun.converter.WorkerConverter;
import com.dedun.dto.request.EmployerRequest;
import com.dedun.dto.request.WorkerRequest;
import com.dedun.dto.response.EmployerResponse;
import com.dedun.dto.response.WorkerResponse;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Employer;
import com.dedun.model.Worker;
import com.dedun.service.UserService;
import com.dedun.service.WorkerService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/worker")
public class WorkerController {
    private final WorkerConverter workerConverter;
    private final UserService userService;
    private final WorkerService workerService;

    public WorkerController(WorkerConverter workerConverter,
                            UserService userService,
                            WorkerService workerService) {
        this.workerConverter = workerConverter;
        this.userService = userService;
        this.workerService = workerService;
    }


    @PostMapping("registration")
    public WorkerResponse create(@RequestBody @Valid WorkerRequest request) throws JobSearchException {
        return workerConverter.from(userService.saveWorker(request));
    }

    @GetMapping(value = "{id}")
    public WorkerResponse get(@PathVariable(value = "id") Long id) throws JobSearchException {
        return workerConverter.from(workerService.get(id));
    }

    @PutMapping
    public WorkerResponse editUser(@AuthenticationPrincipal Worker worker,
                                     @RequestBody WorkerRequest request) throws JobSearchException {
        return workerConverter.from(workerService.edit(worker,request));
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable(value = "id") Long id) throws JobSearchException {
        workerService.delete(id);
    }
}
