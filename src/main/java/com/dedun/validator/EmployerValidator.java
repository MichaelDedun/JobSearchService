package com.dedun.validator;

import com.dedun.dto.request.EmployerRequest;
import com.dedun.exception.JobSearchErrorCode;
import com.dedun.exception.JobSearchException;
import com.dedun.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployerValidator {
    private final UserRepository userRepository;

    public EmployerValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void checkEmployerAlreadyExist(EmployerRequest request) throws JobSearchException {
        if (userRepository.getByLogin(request.getLogin()) != null)
            throw new JobSearchException(JobSearchErrorCode.EMPLOYER_EXIST);
    }
}
