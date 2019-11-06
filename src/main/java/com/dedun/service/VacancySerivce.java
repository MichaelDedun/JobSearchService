package com.dedun.service;

import com.dedun.converter.VacancyConverter;
import com.dedun.dto.request.VacancyRequest;
import com.dedun.exception.JobSearchErrorCode;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Employer;
import com.dedun.model.Vacancy;
import com.dedun.model.enums.State;
import com.dedun.repository.EmployerRepository;
import com.dedun.repository.VacancyRepository;
import com.dedun.validator.VacancyValidator;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        vacancy.setState(State.ACTIVE);
        vacancyRepository.save(vacancy);
        return vacancy;
    }

    public List<Vacancy> getAllFresh() {
        return vacancyRepository.findByDateBetween(ZonedDateTime.now().minusDays(2), ZonedDateTime.now())
                .stream()
                .filter(vacancy -> vacancy.getState().equals(State.ACTIVE)).collect(Collectors.toList());
    }

    public List<Vacancy> getAll(Long id) throws JobSearchException {
        Employer employer = employerRepository.findById(id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.WORKER_NOT_EXIST));
        vacancyValidator.checkRole(employer);
        return vacancyRepository.findAllByEmployerId(id)
                .stream()
                .filter(vacancy -> vacancy.getState().equals(State.ACTIVE))
                .collect(Collectors.toList());
    }

    public Vacancy get(Employer employer, Long id) throws JobSearchException {
        return vacancyRepository.findByEmployerIdAndId(employer.getId(), id)
                .filter(vacancy -> vacancy.getState().equals(State.ACTIVE))
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.EMPLOYER_NOT_EXIST));
    }

    public Vacancy edit(VacancyRequest request, Long id) throws JobSearchException {
        Vacancy vacancy = vacancyRepository.findById(id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.SUMMARY_NOT_EXIST));
        vacancy.setCategory(request.getCategory());
        vacancy.setNecessaryExperience(request.getNecessaryExperience());
        vacancy.setSalary(request.getSalary());
        vacancyRepository.save(vacancy);
        return vacancy;
    }

    public Vacancy updateState(Employer employer, Long id) throws JobSearchException {
        Vacancy vacancy = vacancyRepository.findByEmployerIdAndId(employer.getId(), id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.SUMMARY_NOT_EXIST));
        vacancyValidator.checkVacancyIsActive(vacancy);
        vacancy.setState(State.ACTIVE);
        vacancyRepository.save(vacancy);
        return vacancy;
    }

    public void deleteAll(Employer employer) {
        List<Vacancy> vacancies = vacancyRepository.findAllByEmployerId(employer.getId()).stream()
                .filter(vacancy -> vacancy.getEmployer().getId().equals(employer.getId()))
                .peek(vacancy -> vacancy.setState(State.INACTIVE))
                .collect(Collectors.toList());
        vacancyRepository.saveAll(vacancies);
    }

    public void delete(Employer employer, Long id) throws JobSearchException {
        Vacancy vacancy = vacancyRepository.findByEmployerIdAndId(employer.getId(), id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.VACANCY_NOT_EXIST));
        vacancy.setState(State.INACTIVE);
        vacancyRepository.save(vacancy);
    }
}
