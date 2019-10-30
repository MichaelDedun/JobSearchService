package com.dedun.service;

import com.dedun.dto.request.RequirementsRequest;
import com.dedun.exception.JobSearchErrorCode;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Requirements;
import com.dedun.model.Vacancy;
import com.dedun.repository.RequirementsRepository;
import com.dedun.repository.VacancyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequirementsService {
    private final VacancyRepository vacancyRepository;
    private final RequirementsRepository requirementsRepository;

    public RequirementsService(VacancyRepository vacancyRepository,
                               RequirementsRepository requirementsRepository) {
        this.vacancyRepository = vacancyRepository;
        this.requirementsRepository = requirementsRepository;
    }

    public List<Requirements> create(Long vacancyId, RequirementsRequest request) throws JobSearchException {
        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.VACANCY_NOT_EXIST));
        List<Requirements> requirements = request.getRequirements()
                .stream()
                .map(s -> new Requirements(s, vacancy))
                .collect(Collectors.toList());
        return requirementsRepository.saveAll(requirements);
    }
}
