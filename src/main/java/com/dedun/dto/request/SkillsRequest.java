package com.dedun.dto.request;

import javax.validation.constraints.NotNull;
import java.util.List;

public class SkillsRequest {
    @NotNull(message = "Skills name can'be null")
    private List<String> skills;

    public SkillsRequest() {
    }

    public SkillsRequest(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getSkills() {
        return  skills;
    }

    public SkillsRequest setSkills(List<String> skills) {
        this.skills = skills;
        return this;
    }
}
