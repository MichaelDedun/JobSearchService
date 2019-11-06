package com.dedun.service;

import com.dedun.converter.SummaryConverter;
import com.dedun.dto.request.SummaryRequest;
import com.dedun.exception.JobSearchErrorCode;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Summary;
import com.dedun.model.Worker;
import com.dedun.model.enums.State;
import com.dedun.repository.SummaryRepository;
import com.dedun.repository.WorkerRepository;
import com.dedun.validator.SummaryValidator;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SummaryService {
    private final SummaryRepository summaryRepository;
    private final WorkerRepository workerRepository;
    private final SummaryValidator summaryValidator;

    public SummaryService(SummaryRepository summaryRepository,
                          WorkerRepository workerRepository,
                          SummaryValidator summaryValidator) {
        this.summaryRepository = summaryRepository;
        this.workerRepository = workerRepository;
        this.summaryValidator = summaryValidator;
    }

    public Summary create(SummaryRequest request, Long id) throws JobSearchException {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.WORKER_NOT_EXIST));
        Summary summary = SummaryConverter.toEntity(request, worker);
        summary.setState(State.ACTIVE);
        summaryRepository.save(summary);
        return summary;
    }

    public List<Summary> getAllFresh() {
        return summaryRepository.findByDateBetween(ZonedDateTime.now().minusDays(2), ZonedDateTime.now())
                .stream()
                .filter(summary -> summary.getState().equals(State.ACTIVE)).collect(Collectors.toList());
    }

    public List<Summary> getAll(Long id) throws JobSearchException {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.WORKER_NOT_EXIST));
        summaryValidator.checkRole(worker);
        return summaryRepository.findAllByWorkerId(id)
                .stream()
                .filter(summary -> summary.getState().equals(State.ACTIVE))
                .collect(Collectors.toList());
    }

    public Summary get(Worker worker, Long id) throws JobSearchException {
        return summaryRepository.findByWorkerIdAndId(worker.getId(), id)
                .filter(summary -> summary.getState().equals(State.ACTIVE))
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.WORKER_NOT_EXIST));
    }

    public Summary edit(SummaryRequest request, Long id) throws JobSearchException {
        Summary summary = summaryRepository.findById(id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.SUMMARY_NOT_EXIST));
        summary.setCity(request.getCity());
        summary.setDateOfBirth(request.getDateOfBirth());
        summary.setDesiredSalary(request.getDesiredSalary());
        summary.setEducationalInstitution(request.getEducationalInstitution());
        summary.setMobilePhone(request.getMobilePhone());
        summary.setSex(request.getSex());
        summary.setWorkExperience(request.getWorkExperience());
        summary.setCareerObjective(request.getCareerObjective());
        summaryRepository.save(summary);
        return summary;
    }

    public Summary updateState(Worker worker, Long id) throws JobSearchException {
        Summary summary = summaryRepository.findByWorkerIdAndId(worker.getId(), id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.SUMMARY_NOT_EXIST));
        summaryValidator.checkSummaryIsActive(summary);
        summary.setState(State.ACTIVE);
        summaryRepository.save(summary);
        return summary;
    }

    public void deleteAll(Worker worker) {
        List<Summary> summaries = summaryRepository.findAllByWorkerId(worker.getId()).stream()
                .filter(summary -> summary.getWorker().getId().equals(worker.getId()))
                .peek(summary -> summary.setState(State.INACTIVE))
                .collect(Collectors.toList());
        summaryRepository.saveAll(summaries);
    }

    public void delete(Worker worker, Long id) throws JobSearchException {
        Summary summary = summaryRepository.findByWorkerIdAndId(worker.getId(), id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.SUMMARY_NOT_EXIST));
        summary.setState(State.INACTIVE);
        summaryRepository.save(summary);
    }
}
