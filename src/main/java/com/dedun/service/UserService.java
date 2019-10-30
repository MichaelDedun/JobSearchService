package com.dedun.service;

import com.dedun.converter.EmployerConverter;
import com.dedun.converter.WorkerConverter;
import com.dedun.dto.request.EmployerRequest;
import com.dedun.dto.request.WorkerRequest;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Employer;
import com.dedun.model.User;
import com.dedun.model.Worker;
import com.dedun.model.enums.Role;
import com.dedun.repository.EmployerRepository;
import com.dedun.repository.UserRepository;
import com.dedun.repository.WorkerRepository;
import com.dedun.validator.EmployerValidator;
import com.dedun.validator.WorkerValidator;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final WorkerRepository workerRepository;
    private final EmployerRepository employerRepository;
    private final PasswordEncoder passwordEncoder;
    private final WorkerValidator workerValidator;
    private final EmployerValidator employerValidator;

    public UserService(UserRepository userRepository,
                       WorkerRepository workerRepository,
                       EmployerRepository employerRepository, WorkerValidator workerValidator,
                       EmployerValidator employerValidator) {
        this.userRepository = userRepository;
        this.workerRepository = workerRepository;
        this.employerRepository = employerRepository;
        this.workerValidator = workerValidator;
        this.employerValidator = employerValidator;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Worker saveWorker(WorkerRequest request) throws JobSearchException {
        workerValidator.checkUserAlreadyExist(request);
        Worker worker = WorkerConverter.toEntity(request);
        worker.setPassword(passwordEncoder.encode(request.getPassword()));
        worker.setRoles(Collections.singleton(Role.USER));
        workerRepository.save(worker);
        return worker;
    }

    public Employer saveEmployer(EmployerRequest request) throws JobSearchException {
        employerValidator.checkEmployerAlreadyExist(request);
        Employer employer = EmployerConverter.toEntity(request);
        employer.setPassword(passwordEncoder.encode(request.getPassword()));
        employer.setRoles(Collections.singleton(Role.ADMIN));
        employerRepository.save(employer);
        return employer;
    }

    public Set<Role> getRole(User user) {
        return user.getRoles();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.getByLogin(login);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        return user;
    }
}
