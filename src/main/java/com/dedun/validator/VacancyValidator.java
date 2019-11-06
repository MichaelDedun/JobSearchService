package com.dedun.validator;

import com.dedun.exception.JobSearchErrorCode;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Employer;
import com.dedun.model.Summary;
import com.dedun.model.Vacancy;
import com.dedun.model.enums.Role;
import com.dedun.model.enums.State;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class VacancyValidator {
    public void checkRole(Employer employer) throws JobSearchException {
        if (!employer.getRoles().equals(Collections.singleton(Role.ADMIN)))
            throw new JobSearchException(JobSearchErrorCode.CANT_CREATE_VACANCY);
    }

    public void checkVacancyIsActive(Vacancy vacancy) throws JobSearchException {
        if (vacancy.getState().equals(State.ACTIVE))
            throw new JobSearchException(JobSearchErrorCode.VACANCY_ALREADY_ACTIVE);
    }
}
