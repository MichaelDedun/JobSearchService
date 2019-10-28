package com.dedun.controller;


import com.dedun.dto.request.WorkerRequest;
import com.dedun.dto.response.WorkerResponse;
import com.dedun.exception.JobSearchException;
import com.dedun.service.WorkerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping("registration")
    public WorkerResponse create(@RequestBody WorkerRequest workerRequest) throws JobSearchException {
        return workerService.saveWorker(workerRequest);
    }
}
