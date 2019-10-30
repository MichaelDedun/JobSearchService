package com.dedun.validator;

import com.dedun.dto.request.WorkerRequest;
import com.dedun.exception.JobSearchErrorCode;
import com.dedun.exception.JobSearchException;
import com.dedun.repository.WorkerRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkerValidator {
    private final WorkerRepository workerRepository;

    public WorkerValidator(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }
}
