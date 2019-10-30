package com.dedun.controller;


import com.dedun.converter.WorkerConverter;
import com.dedun.dto.request.WorkerRequest;
import com.dedun.dto.response.WorkerResponse;
import com.dedun.exception.JobSearchException;
import com.dedun.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/worker")
public class WorkerController {
    private final WorkerConverter workerConverter;
    private final UserService userService;

    public WorkerController(WorkerConverter workerConverter,
                            UserService userService) {
        this.workerConverter = workerConverter;
        this.userService = userService;
    }


    @PostMapping("registration")
    public WorkerResponse create(@RequestBody @Valid WorkerRequest request) throws JobSearchException {
        return workerConverter.from(userService.saveWorker(request));
    }
}
