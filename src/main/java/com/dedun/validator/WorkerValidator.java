package com.dedun.validator;

import com.dedun.dto.request.WorkerRequest;
import com.dedun.exception.JobSearchErrorCode;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Worker;
import com.dedun.repository.WorkerRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkerValidator {
    private final WorkerRepository workerRepository;

    public WorkerValidator(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public void checkWorkerAlreadyExist(WorkerRequest workerRequest) throws JobSearchException {
        if (workerRepository.getByLogin(workerRequest.getLogin()) != null)
            throw new JobSearchException(JobSearchErrorCode.WORKER_EXIST);
    }
}
