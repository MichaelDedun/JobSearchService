package com.dedun.converter;

import com.dedun.dto.response.SummaryResponse;
import com.dedun.model.Summary;
import org.springframework.stereotype.Service;

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
                .setDesiredSalary(summary.getDesiredSalary());
    }
}
