package com.dedun.controller;

import com.dedun.converter.SummaryConverter;
import com.dedun.dto.request.SummaryRequest;
import com.dedun.dto.response.SummaryResponse;
import com.dedun.exception.JobSearchException;
import com.dedun.model.User;
import com.dedun.model.Worker;
import com.dedun.service.SummaryService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/summary")
public class SummaryController {
    private final SummaryService summaryService;
    private final SummaryConverter summaryConverter;

    public SummaryController(SummaryService summaryService,
                             SummaryConverter summaryConverter) {
        this.summaryService = summaryService;
        this.summaryConverter = summaryConverter;
    }

    @PostMapping
    public SummaryResponse create(@AuthenticationPrincipal User user,
                                  @RequestBody @Valid SummaryRequest summaryRequest) throws JobSearchException {
        return summaryConverter.from(summaryService.create(summaryRequest, user.getId()));
    }

    @GetMapping("/fresh")
    public List<SummaryResponse> getAllFresh() {
        return summaryService.getAllFresh()
                .stream()
                .map(summaryConverter::from)
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<SummaryResponse> getAll(@AuthenticationPrincipal Worker worker) throws JobSearchException {
        return summaryService.getAll(worker.getId())
                .stream()
                .map(summaryConverter::from)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "{id}")
    public SummaryResponse get(@AuthenticationPrincipal Worker worker,
                               @PathVariable(value = "id") Long id) throws JobSearchException {
        return summaryConverter.from(summaryService.get(worker, id));
    }

    @PutMapping(value = "{id}")
    public SummaryResponse edit(@PathVariable(value = "id") Long id,
                                @RequestBody SummaryRequest summaryRequest) throws JobSearchException {
        return summaryConverter.from(summaryService.edit(summaryRequest, id));
    }

    @PatchMapping(value = "{id}")
    public SummaryResponse updateState(@AuthenticationPrincipal Worker worker,
                                       @PathVariable(value = "id") Long id) throws JobSearchException {
        return summaryConverter.from(summaryService.updateState(worker, id));
    }

    @DeleteMapping
    public void deleteAll(@AuthenticationPrincipal Worker worker) {
        summaryService.deleteAll(worker);
    }

    @DeleteMapping(value = "{id}")
    public void deleteById(@AuthenticationPrincipal Worker worker,
                           @PathVariable(value = "id") Long id) throws JobSearchException {
        summaryService.delete(worker, id);
    }
}
