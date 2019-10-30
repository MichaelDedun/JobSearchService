package com.dedun.converter;

import com.dedun.dto.request.WorkerRequest;
import com.dedun.dto.response.WorkerResponse;
import com.dedun.model.Worker;
import org.springframework.stereotype.Service;

@Service
public class WorkerConverter extends JobEntityConverter<Worker, WorkerResponse> {
    public WorkerConverter() {
        super(WorkerResponse::new);
    }

    @Override
    protected WorkerResponse inflateResponse(Worker worker, WorkerResponse workerResponse) {
        return workerResponse
                .setId(Math.toIntExact(worker.getId()))
                .setLogin(worker.getLogin())
                .setEmail(worker.getEmail())
                .setFirstName(worker.getFirstName())
                .setLastName(worker.getLastName());


    }

    public static Worker toEntity(WorkerRequest request) {
         return new Worker(request.getEmail(),request.getLogin(),request.getPassword(),request.getFirstName(),request.getLastName());
    }
}
