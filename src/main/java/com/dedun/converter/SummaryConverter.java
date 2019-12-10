package com.dedun.converter;

import com.dedun.dto.request.SummaryRequest;
import com.dedun.dto.response.SummaryResponse;
import com.dedun.model.Summary;
import com.dedun.model.Worker;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class SummaryConverter extends JobEntityConverter<Summary, SummaryResponse> {
    private final SkillsConverter converter;

    public SummaryConverter(SkillsConverter converter) {
        super(SummaryResponse::new);
        this.converter = converter;
    }

    @Override
    protected SummaryResponse inflateResponse(Summary summary, SummaryResponse summaryResponse) {
        if (summary.getSkills() == null)
            summaryResponse.setSkills(new ArrayList<>());
        else
            summaryResponse.setSkills(summary.getSkills().stream().map(converter::from).collect(Collectors.toList()));
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
        return new Summary(request.getMobilePhone(), request.getCity(), request.getDateOfBirth(), request.getSex(), request.getWorkExperience(), request.getEducationalInstitution(), request.getDesiredSalary(), request.getCareerObjective(), ZonedDateTime.now(), worker);
    }
}
