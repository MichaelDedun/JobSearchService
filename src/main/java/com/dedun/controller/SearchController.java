package com.dedun.controller;

import com.dedun.dto.request.SearchRequest;
import com.dedun.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    private String find( @RequestBody SearchRequest request) {
        return  searchService.getAllWithSimilar(request);
    }
}
