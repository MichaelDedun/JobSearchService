package com.dedun.controller;


import com.dedun.dto.request.WorkerRequest;
import com.dedun.dto.response.WorkerResponse;
import com.dedun.exception.HeadHunterException;
import com.dedun.service.WorkerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping("/registration")
    public WorkerResponse registerWorker(@RequestBody WorkerRequest workerRequest) throws HeadHunterException {
        return workerService.saveWorker(workerRequest);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable(value = "id") int id) throws HeadHunterException {
        workerService.delete(id);
    }

}
