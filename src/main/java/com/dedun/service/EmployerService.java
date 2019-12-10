package com.dedun.service;

import com.dedun.dto.request.EmployerRequest;
import com.dedun.exception.JobSearchErrorCode;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Employer;
import com.dedun.repository.EmployerRepository;
import com.dedun.validator.EmployerValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;
    private final EmployerValidator employerValidator;
    private final PasswordEncoder passwordEncoder;

    public EmployerService(EmployerRepository employerRepository,
                           EmployerValidator employerValidator) {
        this.employerRepository = employerRepository;
        this.employerValidator = employerValidator;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Employer get(Long id) throws JobSearchException {
        return employerRepository.findById(id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.EMPLOYER_NOT_EXIST));
    }

    public Employer edit(Employer employer, EmployerRequest request) throws JobSearchException {
        employerValidator.checkEmployerExist(employer);
        employer.setCompanyName(request.getCompanyName());
        employer.setFeedback(request.getFeedback());
        employer.setEmail(request.getEmail());
        employer.setPassword(passwordEncoder.encode(request.getPassword()));
        employerRepository.save(employer);
        return employer;
    }

    public void delete(Long id) throws JobSearchException {
        Employer employer = employerRepository.findById(id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.EMPLOYER_NOT_EXIST));
        employerRepository.delete(employer);
    }
}
