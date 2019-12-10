package com.dedun.service;

import com.dedun.dto.request.SearchRequest;
import com.dedun.repository.SummaryRepository;
import com.dedun.repository.VacancyRepository;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    private final VacancyRepository vacancyRepository;
    private final SummaryRepository summaryRepository;

    public SearchService(VacancyRepository vacancyRepository, SummaryRepository summaryRepository) {
        this.vacancyRepository = vacancyRepository;
        this.summaryRepository = summaryRepository;
    }


    public String getAllWithSimilar(SearchRequest request) {
         return request.getTitle();
    }
}
