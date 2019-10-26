package com.dedun.service;

import com.dedun.dto.request.WorkerRequest;
import com.dedun.dto.response.WorkerResponse;
import com.dedun.exception.HeadHunterErrorCode;
import com.dedun.exception.HeadHunterException;
import com.dedun.model.Summary;
import com.dedun.model.Worker;
import com.dedun.repository.SummaryRepository;
import com.dedun.repository.WorkerRepository;
import com.dedun.validator.WorkerValidator;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerValidator workerValidator;
    private final SummaryRepository summaryRepository;

    public WorkerService(WorkerRepository workerRepository, WorkerValidator workerValidator, SummaryRepository summaryRepository) {
        this.workerRepository = workerRepository;
        this.workerValidator = workerValidator;
        this.summaryRepository = summaryRepository;
    }

    public WorkerResponse saveWorker(WorkerRequest workerRequest) throws HeadHunterException {
        workerValidator.checkWorkerAlreadyExist(workerRequest);
        Worker worker = new Worker(workerRequest.getLogin(),null,workerRequest.getFirstName(),workerRequest.getLastName(),workerRequest.getEmail());
        worker.setPassword(workerRequest.getPassword());
        workerRepository.save(worker);
        return new WorkerResponse(worker.getId(),worker.getLogin(),worker.getFirstName(),worker.getLastName(),worker.getEmail());
    }

    public void delete(int id) throws HeadHunterException {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(()-> new HeadHunterException(HeadHunterErrorCode.WORKER_NOT_EXIST));
        Summary summary = summaryRepository.findByWorkerId(id);
        workerRepository.delete(worker);
        summaryRepository.delete(summary);
    }
}
