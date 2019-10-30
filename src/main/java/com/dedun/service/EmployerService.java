package com.dedun.service;

import com.dedun.repository.EmployerRepository;
import com.dedun.validator.EmployerValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployerService  {
    private final EmployerRepository employerRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmployerValidator employerValidator;

    public EmployerService(EmployerRepository employerRepository,
                           EmployerValidator employerValidator) {
        this.employerRepository = employerRepository;
        this.employerValidator = employerValidator;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
}
