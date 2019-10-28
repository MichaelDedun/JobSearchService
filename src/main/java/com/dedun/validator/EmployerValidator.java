package com.dedun.validator;

import com.dedun.dto.request.EmployerRequest;
import com.dedun.exception.JobSearchErrorCode;
import com.dedun.exception.JobSearchException;
import com.dedun.repository.EmployerRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployerValidator {
    private final EmployerRepository employerRepository;

    public EmployerValidator(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }


    public void checkWorkerAlreadyExist(EmployerRequest employerRequest) throws JobSearchException {
        if (employerRepository.getByLogin(employerRequest.getLogin()) != null)
            throw new JobSearchException(JobSearchErrorCode.EMPLOYER_EXIST);
    }
}
