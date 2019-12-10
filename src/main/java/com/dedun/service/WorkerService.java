package com.dedun.service;

import com.dedun.dto.request.EmployerRequest;
import com.dedun.dto.request.WorkerRequest;
import com.dedun.exception.JobSearchErrorCode;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Employer;
import com.dedun.model.Worker;
import com.dedun.repository.WorkerRepository;
import com.dedun.validator.WorkerValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;
    private final WorkerValidator workerValidator;
    private final PasswordEncoder passwordEncoder;

    public WorkerService(WorkerRepository workerRepository,
                         WorkerValidator workerValidator) {
        this.workerRepository = workerRepository;
        this.workerValidator = workerValidator;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Worker get(Long id) throws JobSearchException {
        return workerRepository.findById(id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.WORKER_NOT_EXIST));
    }

    public Worker edit(Worker worker, WorkerRequest request) throws JobSearchException {
        workerValidator.checkEmployerExist(worker);
        worker.setFirstName(request.getFirstName());
        worker.setLastName(request.getLastName());
        worker.setEmail(request.getEmail());
        worker.setPassword(passwordEncoder.encode(request.getPassword()));
        workerRepository.save(worker);
        return worker;
    }

    public void delete(Long id) throws JobSearchException {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.WORKER_NOT_EXIST));
        workerRepository.delete(worker);
    }
}
