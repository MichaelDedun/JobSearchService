package com.dedun.converter;

import com.dedun.dto.request.SummaryRequest;
import com.dedun.dto.response.SummaryResponse;
import com.dedun.model.Summary;
import com.dedun.model.Worker;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class SummaryConverter extends JobEntityConverter<Summary, SummaryResponse> {
    public SummaryConverter() {
        super(SummaryResponse::new);
    }

    @Override
    protected SummaryResponse inflateResponse(Summary summary, SummaryResponse summaryResponse) {
        return summaryResponse
                .setId(summary.getId())
                .setMobilePhone(summary.getMobilePhone())
                .setCity(summary.getCity())
                .setDateOfBirth(summary.getDateOfBirth())
                .setSex(summary.getSex())
                .setWorkExperience(summary.getWorkExperience())
                .setEducarionalInstitution(summary.getEducationalInstitution())
                .setCareerObjective(summary.getCareerObjective())
                .setDesiredSalary(summary.getDesiredSalary());
    }

    public static Summary toEntity(SummaryRequest request, Worker worker) {
        return new Summary(request.getMobilePhone(), request.getCity(), request.getDateOfBirth(), request.getSex(), request.getWorkExperience(), request.getEducationalInstitution(), request.getDesiredSalary(), request.getCareerObjective() ,ZonedDateTime.now(), worker);
    }
}
