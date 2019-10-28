package com.dedun.validator;

import com.dedun.exception.JobSearchErrorCode;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Worker;
import com.dedun.model.enums.Role;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SummaryValidator {

    public void checkRole(Worker worker) throws JobSearchException {
        if (!worker.getRoles().equals(Collections.singleton(Role.USER)))
            throw new JobSearchException(JobSearchErrorCode.CANT_CREATE_SUMMARY);
    }
}
