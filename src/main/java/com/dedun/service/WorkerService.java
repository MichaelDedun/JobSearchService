package com.dedun.service;

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
}
