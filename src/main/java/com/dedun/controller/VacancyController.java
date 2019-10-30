package com.dedun.controller;

import com.dedun.converter.VacancyConverter;
import com.dedun.dto.request.VacancyRequest;
import com.dedun.dto.response.VacancyResponse;
import com.dedun.exception.JobSearchException;
import com.dedun.model.User;
import com.dedun.service.VacancySerivce;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
