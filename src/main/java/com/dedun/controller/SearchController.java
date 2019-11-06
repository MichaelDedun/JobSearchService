package com.dedun.controller;

import com.dedun.dto.request.SkillsRequest;
import com.dedun.model.Vacancy;
import com.dedun.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    private List<Vacancy> find(SkillsRequest request) {
        return  searchService.getAllWithSimilar(request);
    }
}
