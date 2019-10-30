package com.dedun.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RequirementsRequest {
    @NotNull(message = "Requirements can'be null")
    private List<String> requirements;

    public RequirementsRequest() {
    }

    public RequirementsRequest(List<String> requirements) {
        this.requirements = requirements;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public RequirementsRequest setRequirements(List<String> requirements) {
        this.requirements = requirements;
        return this;
    }
}
