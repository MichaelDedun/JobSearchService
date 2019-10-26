package com.dedun.service;

import com.dedun.dto.request.SummaryRequest;
import com.dedun.dto.response.SummaryResponse;
import com.dedun.dto.response.WorkerResponse;
import com.dedun.exception.HeadHunterErrorCode;
import com.dedun.exception.HeadHunterException;
import com.dedun.model.Summary;
import com.dedun.model.Worker;
import com.dedun.repository.SummaryRepository;
import com.dedun.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SummaryService {
    private final SummaryRepository summaryRepository;
    private final WorkerRepository workerRepository;

    public SummaryService(SummaryRepository summaryRepository, WorkerRepository workerRepository) {
        this.summaryRepository = summaryRepository;
        this.workerRepository = workerRepository;
    }

    public SummaryResponse create(SummaryRequest summaryRequest, int id) throws HeadHunterException {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new HeadHunterException(HeadHunterErrorCode.WORKER_NOT_EXIST));
        if (worker.getSummary() != null) {
            throw new HeadHunterException(HeadHunterErrorCode.WORKER_EXIST_SUMMARY);
        }
        Summary summary = new Summary(summaryRequest.getMobilePhone(), summaryRequest.getCity(), summaryRequest.getDateOfBirth(), summaryRequest.getSex(), summaryRequest.getWorkExperience(), summaryRequest.getEducarionalInstitution(), summaryRequest.getDesiredSalary(), worker);
        summaryRepository.save(summary);
        return new SummaryResponse(summary.getId(), summary.getMobilePhone(), summary.getCity(), summary.getDateOfBirth(), summary.getSex(), summary.getWorkExperience(), summary.getEducarionalInstitution(), summary.getDesiredSalary(), new WorkerResponse(worker.getId(), worker.getLogin(), worker.getFirstName(), worker.getLastName(), worker.getEmail()));
    }

    public SummaryResponse edit(SummaryRequest summaryRequest, int id) throws HeadHunterException {
        Summary summary = summaryRepository.findById(id)
                .orElseThrow(() -> new HeadHunterException(HeadHunterErrorCode.SUMMARY_NOT_EXIST));
        summary.setCity(summaryRequest.getCity());
        summary.setDateOfBirth(summaryRequest.getDateOfBirth());
        summary.setDesiredSalary(summaryRequest.getDesiredSalary());
        summary.setEducarionalInstitution(summaryRequest.getEducarionalInstitution());
        summary.setMobilePhone(summaryRequest.getMobilePhone());
        summary.setSex(summaryRequest.getSex());
        summary.setWorkExperience(summaryRequest.getWorkExperience());
        summaryRepository.save(summary);
        return new SummaryResponse(summary.getId(), summary.getMobilePhone(), summary.getCity(), summary.getDateOfBirth(), summary.getSex(), summary.getWorkExperience(), summary.getEducarionalInstitution(), summary.getDesiredSalary(), new WorkerResponse(summary.getWorker().getId(), summary.getWorker().getLogin(), summary.getWorker().getFirstName(), summary.getWorker().getLastName(), summary.getWorker().getEmail()));
    }

    public List<SummaryResponse> getAll() {
        return summaryRepository.findAll().stream()
                .map(summary -> new SummaryResponse(summary.getId(), summary.getMobilePhone(), summary.getCity(), summary.getDateOfBirth(), summary.getSex(), summary.getWorkExperience(), summary.getEducarionalInstitution(), summary.getDesiredSalary(), new WorkerResponse(summary.getWorker().getId(), summary.getWorker().getLogin(), summary.getWorker().getFirstName(), summary.getWorker().getLastName(), summary.getWorker().getEmail())))
                .collect(Collectors.toList());
    }
}
