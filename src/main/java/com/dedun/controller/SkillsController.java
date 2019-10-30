//package com.dedun.controller;
//
//import com.dedun.converter.SkillsConverter;
//import com.dedun.dto.request.SkillsRequest;
//import com.dedun.dto.response.SkillsResponse;
//import com.dedun.exception.JobSearchException;
//import com.dedun.service.SkillsSerivce;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/skills")
//public class SkillsController {
//    private final SkillsSerivce skillsSerivce;
//    private final SkillsConverter skillsConverter;
//
//    public SkillsController(SkillsSerivce skillsSerivce, SkillsConverter skillsConverter) {
//        this.skillsSerivce = skillsSerivce;
//        this.skillsConverter = skillsConverter;
//    }
//
//    @PostMapping(value = "{id}")
//    public List<SkillsResponse> create(@PathVariable(value = "id") int id,
//                                       @RequestBody SkillsRequest skillsRequest) throws JobSearchException {
//        return skillsSerivce.create(id,skillsRequest)
//                .stream()
//                .map(skillsConverter::from)
//                .collect(Collectors.toList());
//    }
//}
