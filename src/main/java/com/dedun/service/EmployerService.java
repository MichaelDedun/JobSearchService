package com.dedun.service;

import com.dedun.dto.request.EmployerRequest;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Employer;
import com.dedun.model.enums.Role;
import com.dedun.repository.EmployerRepository;
import com.dedun.validator.EmployerValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.javac.util.List;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;

@Service
public class EmployerService implements UserDetailsService {
    private final EmployerRepository employerRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmployerValidator employerValidator;

    public EmployerService(EmployerRepository employerRepository, EmployerValidator employerValidator) {
        this.employerRepository = employerRepository;
        this.employerValidator = employerValidator;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Employer save(EmployerRequest employerRequest) throws JobSearchException {
        employerValidator.checkWorkerAlreadyExist(employerRequest);
        Employer employer = new Employer(employerRequest.getEmail(),employerRequest.getCompanyName(),employerRequest.getLogin(), null, employerRequest.getFeedback());
        employer.setPassword(passwordEncoder.encode(employerRequest.getPassword()));
        employer.setRoles(Collections.singleton(Role.ADMIN));
        employerRepository.save(employer);
        return employer;
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Employer employer = employerRepository.getByLogin(login);
        if (employer == null)
            throw new UsernameNotFoundException("User not found");
        return employer;
    }
}
