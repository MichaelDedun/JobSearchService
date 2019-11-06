package com.dedun.service;

import com.dedun.dto.request.SkillsRequest;
import com.dedun.model.Requirements;
import com.dedun.model.Vacancy;
import com.dedun.repository.SummaryRepository;
import com.dedun.repository.VacancyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private final VacancyRepository vacancyRepository;
    private final SummaryRepository summaryRepository;

    public SearchService(VacancyRepository vacancyRepository, SummaryRepository summaryRepository) {
        this.vacancyRepository = vacancyRepository;
        this.summaryRepository = summaryRepository;
    }


    public List<Vacancy> getAllWithSimilar(SkillsRequest request) {
        List<String> skills = request.getSkills();
        List<Vacancy> vacancies = vacancyRepository.findAll();
        for (Vacancy vacancy: vacancies) {
            List<Requirements> req = vacancy.getRequirements();
            for (Requirements requirement : req) {
               if(skills.contains(requirement.getTitle())){
                  return vacancyRepository.findByRequirements(req);
               }
            }
        }
        return null;
    }
}
