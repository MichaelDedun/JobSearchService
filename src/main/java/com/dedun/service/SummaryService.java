package com.dedun.service;

import com.dedun.dto.request.SummaryRequest;
import com.dedun.dto.response.SummaryResponse;
import com.dedun.dto.response.WorkerResponse;
import com.dedun.exception.JobSearchErrorCode;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Summary;
import com.dedun.model.Worker;
import com.dedun.repository.SummaryRepository;
import com.dedun.repository.WorkerRepository;
import com.dedun.validator.SummaryValidator;
import org.springframework.stereotype.Service;

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

    public Summary create(SummaryRequest summaryRequest, int id) throws JobSearchException {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.WORKER_NOT_EXIST));
        summaryValidator.checkRole(worker);
        Summary summary = new Summary(summaryRequest.getMobilePhone(), summaryRequest.getCity(), summaryRequest.getDateOfBirth(), summaryRequest.getSex(), summaryRequest.getWorkExperience(), summaryRequest.getEducarionalInstitution(), summaryRequest.getDesiredSalary(), worker);
        summaryRepository.save(summary);
        return summary;
    }

    public Summary edit(SummaryRequest summaryRequest, int id) throws JobSearchException {
        Summary summary = summaryRepository.findById(id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.SUMMARY_NOT_EXIST));
        summary.setCity(summaryRequest.getCity());
        summary.setDateOfBirth(summaryRequest.getDateOfBirth());
        summary.setDesiredSalary(summaryRequest.getDesiredSalary());
        summary.setEducationalInstitution(summaryRequest.getEducarionalInstitution());
        summary.setMobilePhone(summaryRequest.getMobilePhone());
        summary.setSex(summaryRequest.getSex());
        summary.setWorkExperience(summaryRequest.getWorkExperience());
        summaryRepository.save(summary);
        return summary;
    }

    public List<Summary> getAll(int id) throws JobSearchException {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.WORKER_NOT_EXIST));
        summaryValidator.checkRole(worker);
        return summaryRepository.findAllByWorkerId(id);
    }
}
