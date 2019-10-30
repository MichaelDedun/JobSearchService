package com.dedun.dto.response;

import java.time.LocalDate;

public class SummaryResponse {
    private Long id;
    private String mobilePhone;
    private String city;
    private LocalDate dateOfBirth;
    private String sex;
    private Integer workExperience;
    private String educarionalInstitution;
    private int desiredSalary;

    public SummaryResponse() {
    }

    public Long getId() {
        return id;
    }

    public SummaryResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public SummaryResponse setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getCity() {
        return city;
    }

    public SummaryResponse setCity(String city) {
        this.city = city;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public SummaryResponse setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public SummaryResponse setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public SummaryResponse setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
        return this;
    }

    public String getEducarionalInstitution() {
        return educarionalInstitution;
    }

    public SummaryResponse setEducarionalInstitution(String educarionalInstitution) {
        this.educarionalInstitution = educarionalInstitution;
        return this;
    }

    public int getDesiredSalary() {
        return desiredSalary;
    }

    public SummaryResponse setDesiredSalary(int desiredSalary) {
        this.desiredSalary = desiredSalary;
        return this;
    }
}
