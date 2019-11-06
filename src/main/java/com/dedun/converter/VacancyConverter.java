package com.dedun.converter;

import com.dedun.dto.request.VacancyRequest;
import com.dedun.dto.response.VacancyResponse;
import com.dedun.model.Employer;
import com.dedun.model.Vacancy;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class VacancyConverter extends JobEntityConverter<Vacancy, VacancyResponse> {
    public VacancyConverter() {
        super(VacancyResponse::new);
    }

    @Override
    protected VacancyResponse inflateResponse(Vacancy vacancy, VacancyResponse vacancyResponse) {
        return vacancyResponse
                .setId(vacancy.getId())
                .setCategory(vacancy.getCategory())
                .setNecessaryExperience(vacancy.getNecessaryExperience())
                .setSalary(vacancy.getSalary());
    }

    public static Vacancy toEntity(VacancyRequest request, Employer employer) {
        return new Vacancy(request.getCategory(), request.getNecessaryExperience(), request.getSalary(), ZonedDateTime.now(), employer);
    }
}
