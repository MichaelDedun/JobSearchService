package com.dedun.converter;

import com.dedun.dto.request.SkillsRequest;
import com.dedun.dto.request.SummaryRequest;
import com.dedun.dto.response.SkillsResponse;
import com.dedun.model.Skills;
import com.dedun.model.Summary;
import com.dedun.model.Worker;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class SkillsConverter extends JobEntityConverter<Skills, SkillsResponse> {
    public SkillsConverter() {
        super(SkillsResponse::new);
    }

    @Override
    protected SkillsResponse inflateResponse(Skills skills, SkillsResponse skillsResponse) {
        return skillsResponse
                .setSkills(skills.getTitle());
    }
}
