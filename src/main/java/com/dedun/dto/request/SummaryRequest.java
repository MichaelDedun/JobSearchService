package com.dedun.dto.request;

import java.time.LocalDate;

public class SummaryRequest {
    private String mobilePhone;
    private String city;
    private LocalDate dateOfBirth;
    private String sex;
    private Integer workExperience;
    private String educarionalInstitution;
    private int desiredSalary;

    public SummaryRequest() {
    }

    public SummaryRequest(String mobilePhone, String city, LocalDate dateOfBirth, String sex, Integer workExperience, String educarionalInstitution, int desiredSalary) {
        this.mobilePhone = mobilePhone;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.workExperience = workExperience;
        this.educarionalInstitution = educarionalInstitution;
        this.desiredSalary = desiredSalary;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }

    public String getEducarionalInstitution() {
        return educarionalInstitution;
    }

    public void setEducarionalInstitution(String educarionalInstitution) {
        this.educarionalInstitution = educarionalInstitution;
    }

    public int getDesiredSalary() {
        return desiredSalary;
    }

    public void setDesiredSalary(int desiredSalary) {
        this.desiredSalary = desiredSalary;
    }
}
