package com.dedun.converter;

import com.dedun.dto.response.RequirementsResponse;
import com.dedun.model.Requirements;
import org.springframework.stereotype.Service;

@Service
public class RequirementsConverter extends JobEntityConverter<Requirements, RequirementsResponse> {
    public RequirementsConverter() {
        super(RequirementsResponse::new);
    }

    @Override
    protected RequirementsResponse inflateResponse(Requirements requirements, RequirementsResponse requirementsResponse) {
        return requirementsResponse
                .setRequirements(requirements.getTitle());
    }
}
