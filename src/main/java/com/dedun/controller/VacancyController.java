package com.dedun.controller;

import com.dedun.converter.VacancyConverter;
import com.dedun.dto.request.SummaryRequest;
import com.dedun.dto.request.VacancyRequest;
import com.dedun.dto.response.SummaryResponse;
import com.dedun.dto.response.VacancyResponse;
import com.dedun.exception.JobSearchException;
import com.dedun.model.Employer;
import com.dedun.model.User;
import com.dedun.model.Worker;
import com.dedun.service.VacancySerivce;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {
    private final VacancySerivce vacancySerivce;
    private final VacancyConverter vacancyConverter;

    public VacancyController(VacancySerivce vacancySerivce,
                             VacancyConverter vacancyConverter) {
        this.vacancySerivce = vacancySerivce;
        this.vacancyConverter = vacancyConverter;
    }

    @PostMapping
    private VacancyResponse create(@AuthenticationPrincipal User user,
                                   @RequestBody @Valid VacancyRequest request) throws JobSearchException {
        return vacancyConverter.from(vacancySerivce.create(request, user.getId()));
    }

    @GetMapping("/fresh")
    public List<VacancyResponse> getAllFresh() {
        return vacancySerivce.getAllFresh()
                .stream()
                .map(vacancyConverter::from)
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<VacancyResponse> getAll(@AuthenticationPrincipal Employer employer) throws JobSearchException {
        return vacancySerivce.getAll(employer.getId())
                .stream()
                .map(vacancyConverter::from)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "{id}")
    public VacancyResponse get(@AuthenticationPrincipal Employer employer,
                               @PathVariable(value = "id") Long id) throws JobSearchException {
        return vacancyConverter.from(vacancySerivce.get(employer, id));
    }

    @PutMapping(value = "{id}")
    public VacancyResponse edit(@PathVariable(value = "id") Long id,
                                @RequestBody VacancyRequest vacancyRequest) throws JobSearchException {
        return vacancyConverter.from(vacancySerivce.edit(vacancyRequest, id));
    }

    @PatchMapping(value = "{id}")
    public VacancyResponse updateState(@AuthenticationPrincipal Employer employer,
                                       @PathVariable(value = "id") Long id) throws JobSearchException {
        return vacancyConverter.from(vacancySerivce.updateState(employer, id));
    }

    @DeleteMapping
    public void deleteAll(@AuthenticationPrincipal Employer employer) {
        vacancySerivce.deleteAll(employer);
    }

    @DeleteMapping(value = "{id}")
    public void deleteById(@AuthenticationPrincipal Employer employer,
                                 @PathVariable(value = "id") Long id) throws JobSearchException {
        vacancySerivce.delete(employer, id);
    }
}
