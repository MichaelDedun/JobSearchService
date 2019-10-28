package com.dedun.dto.request;

import java.util.List;

public class SkillsRequest {
    private List<String> skills;

    public SkillsRequest() {
    }

    public SkillsRequest(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getSkills() {
        return skills;
    }

    public SkillsRequest setSkills(List<String> skills) {
        this.skills = skills;
        return this;
    }
}
