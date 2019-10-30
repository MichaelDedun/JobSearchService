package com.dedun.controller;

import com.dedun.converter.RequirementsConverter;
import com.dedun.dto.request.RequirementsRequest;
import com.dedun.dto.response.RequirementsResponse;
import com.dedun.exception.JobSearchException;
import com.dedun.service.RequirementsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/requirements")
public class RequirementsController {
    private final RequirementsService requirementsService;
    private final RequirementsConverter requirementsConverter;

    public RequirementsController(RequirementsService requirementsService,
                                  RequirementsConverter requirementsConverter) {
        this.requirementsService = requirementsService;
        this.requirementsConverter = requirementsConverter;
    }


    @PostMapping(value = "{id}")
    public List<RequirementsResponse> create(@PathVariable(value = "id") Long id,
                                             @RequestBody @Valid RequirementsRequest request) throws JobSearchException {
        return requirementsService.create(id, request)
                .stream()
                .map(requirementsConverter::from)
                .collect(Collectors.toList());
    }
}
