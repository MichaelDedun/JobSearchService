package com.dedun.dto.response;

public class SkillsResponse {
    private String skills;

    public SkillsResponse() {
    }

    public SkillsResponse(String skills) {
        this.skills = skills;
    }

    public String getSkills() {
        return skills;
    }

    public SkillsResponse setSkills(String skills) {
        this.skills = skills;
        return this;
    }
}
