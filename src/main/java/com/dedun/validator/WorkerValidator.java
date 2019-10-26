package com.dedun.validator;

import com.dedun.dto.request.WorkerRequest;
import com.dedun.exception.HeadHunterErrorCode;
import com.dedun.exception.HeadHunterException;
import com.dedun.model.Worker;
import com.dedun.repository.WorkerRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkerValidator {
    private final WorkerRepository workerRepository;

    public WorkerValidator(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public void checkWorkerAlreadyExist(WorkerRequest workerRequest) throws HeadHunterException {
        if (workerRepository.getByLogin(workerRequest.getLogin()) != null)
            throw new HeadHunterException(HeadHunterErrorCode.WORKER_EXIST);
    }

    public void checkWorkerExist(Worker worker) throws HeadHunterException {
        if (worker == null)
            throw new HeadHunterException(HeadHunterErrorCode.WORKER_NOT_EXIST);
    }
}
