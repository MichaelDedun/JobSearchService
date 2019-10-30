//package com.dedun.service;
//
//import com.dedun.dto.request.SkillsRequest;
//import com.dedun.exception.JobSearchErrorCode;
//import com.dedun.exception.JobSearchException;
//import com.dedun.model.Skills;
//import com.dedun.model.Summary;
//import com.dedun.repository.SkillsRepository;
//import com.dedun.repository.SummaryRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class SkillsSerivce {
//    private final SkillsRepository skillsRepository;
//    private final SummaryRepository summaryRepository;
//
//    public SkillsSerivce(SkillsRepository skillsRepository,
//                         SummaryRepository summaryRepository) {
//        this.skillsRepository = skillsRepository;
//        this.summaryRepository = summaryRepository;
//    }
//
//    public List<Skills> create(int summaryId, SkillsRequest request) throws JobSearchException {
//        Summary summary = summaryRepository.findById(summaryId)
//                .orElseThrow(() -> new JobSearchException(JobSearchErrorCode.SUMMARY_NOT_EXIST));
//        List<Skills> skills = request.getSkills()
//                .stream()
//                .map(s -> new Skills(s, summary))
//                .collect(Collectors.toList());
//        return skillsRepository.saveAll(skills);
//    }
//}
