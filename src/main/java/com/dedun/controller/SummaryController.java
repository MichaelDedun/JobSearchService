package com.dedun.controller;

import com.dedun.dto.request.SummaryRequest;
import com.dedun.dto.response.SummaryResponse;
import com.dedun.exception.HeadHunterException;
import com.dedun.service.SummaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/summary")
public class SummaryController {

    private final SummaryService summaryService;

    public SummaryController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @PostMapping(value = "{id}")
    public SummaryResponse create(@PathVariable(value = "id") int id, @RequestBody SummaryRequest summaryRequest) throws HeadHunterException {
        return summaryService.create(summaryRequest, id);
    }

    @GetMapping
    public List<SummaryResponse> getAll() {
        return summaryService.getAll();
    }

    @PutMapping(value = "{id}")
    public SummaryResponse edit(@PathVariable(value = "id") int id, @RequestBody SummaryRequest summaryRequest) throws HeadHunterException {
        return summaryService.edit(summaryRequest,id);
    }
}
