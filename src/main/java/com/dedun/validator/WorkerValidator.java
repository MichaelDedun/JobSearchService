package com.dedun.validator;

import com.dedun.dto.request.WorkerRequest;
import com.dedun.exception.JobSearchErrorCode;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Employer;
import com.dedun.model.Worker;
import com.dedun.repository.UserRepository;
import com.dedun.repository.WorkerRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkerValidator {
    private final UserRepository userRepository;

    public WorkerValidator( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void checkEmployerExist(Worker worker) throws JobSearchException {
        if (worker == null)
            throw new JobSearchException(JobSearchErrorCode.WORKER_NOT_EXIST);
    }

    public void checkUserAlreadyExist(WorkerRequest request) throws JobSearchException {
        if (userRepository.getByLogin(request.getLogin()) != null)
            throw new JobSearchException(JobSearchErrorCode.WORKER_EXIST);
    }
}
