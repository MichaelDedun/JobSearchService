package com.dedun.service;

import com.dedun.converter.WorkerConverter;
import com.dedun.dto.request.WorkerRequest;
import com.dedun.exception.JobSearchException;
import com.dedun.model.User;
import com.dedun.model.Worker;
import com.dedun.model.enums.Role;
import com.dedun.repository.UserRepository;
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
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final WorkerRepository workerRepository;
    private final PasswordEncoder passwordEncoder;
    private final WorkerValidator workerValidator;
    private final WorkerConverter workerConverter;

    public UserService(UserRepository userRepository,
                       WorkerRepository workerRepository,
                       WorkerValidator workerValidator,
                       WorkerConverter workerConverter) {
        this.userRepository = userRepository;
        this.workerRepository = workerRepository;
        this.workerValidator = workerValidator;
        this.workerConverter = workerConverter;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Worker saveWorker(WorkerRequest request) {
        Worker worker = workerConverter.toEntity(request);
        worker.setPassword(passwordEncoder.encode(request.getPassword()));
        worker.setRoles(Collections.singleton(Role.USER));
        workerRepository.save(worker);
        return worker;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.getByLogin(login);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        return user;
    }
}
