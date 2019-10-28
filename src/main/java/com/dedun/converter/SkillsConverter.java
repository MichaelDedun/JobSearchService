package com.dedun.converter;

import com.dedun.dto.response.SkillsResponse;
import com.dedun.model.Skills;
import org.springframework.stereotype.Service;

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
