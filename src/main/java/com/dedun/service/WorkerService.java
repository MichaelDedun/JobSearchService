package com.dedun.service;

import com.dedun.dto.request.WorkerRequest;
import com.dedun.dto.response.WorkerResponse;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Worker;
import com.dedun.model.enums.Role;
import com.dedun.repository.SummaryRepository;
import com.dedun.repository.WorkerRepository;
import com.dedun.validator.WorkerValidator;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class WorkerService implements UserDetailsService {

    private final WorkerRepository workerRepository;
    private final WorkerValidator workerValidator;
    private final PasswordEncoder passwordEncoder;

    public WorkerService(WorkerRepository workerRepository,
                         WorkerValidator workerValidator) {
        this.workerRepository = workerRepository;
        this.workerValidator = workerValidator;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public WorkerResponse saveWorker(WorkerRequest workerRequest) throws JobSearchException {
        workerValidator.checkWorkerAlreadyExist(workerRequest);
        Worker worker = new Worker(workerRequest.getLogin(),null, workerRequest.getFirstName(), workerRequest.getLastName(), workerRequest.getEmail());
        worker.setPassword(passwordEncoder.encode(workerRequest.getPassword()));
        worker.setRoles(Collections.singleton(Role.USER));
        workerRepository.save(worker);
        return new WorkerResponse(worker.getId(), worker.getLogin(), worker.getFirstName(), worker.getLastName(), worker.getEmail());
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Worker worker = workerRepository.getByLogin(login);
        if (worker == null)
            throw new UsernameNotFoundException("User not found");
        return worker;
    }
}
