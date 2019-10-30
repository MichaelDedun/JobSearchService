//package com.dedun.converter;
//
//import com.dedun.dto.response.EmployerResponse;
//import com.dedun.dto.response.SkillsResponse;
//import com.dedun.model.Employer;
//import com.dedun.model.Skills;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmployerConverter extends JobEntityConverter<Employer, EmployerResponse> {
//    public EmployerConverter() {
//        super(EmployerResponse::new);
//    }
//
//    @Override
//    protected EmployerResponse inflateResponse(Employer employer, EmployerResponse employerResponse) {
//        return employerResponse
//                .setId(employer.getId())
//                .setEmail(employer.getEmail())
//                .setCompanyName(employer.getCompanyName())
//                .setLogin(employer.getLogin())
//                .setFeedback(employer.getFeedback());
//    }
//}
