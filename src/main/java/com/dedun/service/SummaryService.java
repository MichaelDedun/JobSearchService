package com.dedun.service;

import com.dedun.converter.SummaryConverter;
import com.dedun.dto.request.SummaryRequest;
import com.dedun.exception.JobSearchErrorCode;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Summary;
import com.dedun.model.Worker;
import com.dedun.repository.SummaryRepository;
import com.dedun.repository.WorkerRepository;
import com.dedun.validator.SummaryValidator;
import org.springframework.stereotype.Service;

import java.util.List;

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
        summaryRepository.save(summary);
        return summary;
    }

    public Summary edit(SummaryRequest request, int id) throws JobSearchException {
        Summary summary = summaryRepository.findById(id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.SUMMARY_NOT_EXIST));
        summary.setCity(request.getCity());
        summary.setDateOfBirth(request.getDateOfBirth());
        summary.setDesiredSalary(request.getDesiredSalary());
        summary.setEducationalInstitution(request.getEducationalInstitution());
        summary.setMobilePhone(request.getMobilePhone());
        summary.setSex(request.getSex());
        summary.setWorkExperience(request.getWorkExperience());
        summaryRepository.save(summary);
        return summary;
    }

    public List<Summary> getAll(Long id) throws JobSearchException {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.WORKER_NOT_EXIST));
        summaryValidator.checkRole(worker);
        return summaryRepository.findAllByWorkerId(id);
    }
}
