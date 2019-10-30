package com.dedun.service;

import com.dedun.converter.VacancyConverter;
import com.dedun.dto.request.VacancyRequest;
import com.dedun.exception.JobSearchErrorCode;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Employer;
import com.dedun.model.Vacancy;
import com.dedun.repository.EmployerRepository;
import com.dedun.repository.VacancyRepository;
import com.dedun.validator.VacancyValidator;
import org.springframework.stereotype.Service;

@Service
public class VacancySerivce {
    private final VacancyRepository vacancyRepository;
    private final VacancyValidator vacancyValidator;
    private final EmployerRepository employerRepository;

    public VacancySerivce(VacancyRepository vacancyRepository,
                          VacancyValidator vacancyValidator, EmployerRepository employerRepository) {
        this.vacancyRepository = vacancyRepository;
        this.vacancyValidator = vacancyValidator;
        this.employerRepository = employerRepository;
    }

    public Vacancy create(VacancyRequest request, Long id) throws JobSearchException {
        Employer employer = employerRepository.findById(id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.WORKER_NOT_EXIST));
        Vacancy vacancy = VacancyConverter.toEntity(request, employer);
        vacancyRepository.save(vacancy);
        return vacancy;
    }
}
