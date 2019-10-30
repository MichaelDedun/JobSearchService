package com.dedun.dto.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class SummaryRequest {
    @NotBlank(message = "Mobile phone name can't be empty")
    @NotNull(message = "Mobile phone name can'be null")
    @Length(min = 8)
    private String mobilePhone;
    @NotBlank(message = "City  can't be empty")
    @NotNull(message = "City can'be null")
    private String city;
    @NotBlank(message = "Date 0f birth name can't be empty")
    @NotNull(message = "Date 0f birth can'be null")
    private LocalDate dateOfBirth;
    @NotBlank(message = "Sex name can't be empty")
    @NotNull(message = "Sex can'be null")
    private String sex;
    @NotBlank(message = "Work expirience can't be empty")
    @NotNull(message = "Work expirience can'be null")
    @Positive(message = "The value must be positive")
    private Integer workExperience;
    @NotBlank(message = "Educational institution can't be empty")
    @NotNull(message = "Educational institution can'be null")
    private String educationalInstitution;
    @NotBlank(message = "Desired salary can't be empty")
    @NotNull(message = "Desired salary can'be null")
    @Positive(message = "The value must be positive")
    private int desiredSalary;

    public SummaryRequest() {
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

    public String getEducationalInstitution() {
        return educationalInstitution;
    }

    public void setEducationalInstitution(String educationalInstitution) {
        this.educationalInstitution = educationalInstitution;
    }

    public int getDesiredSalary() {
        return desiredSalary;
    }

    public void setDesiredSalary(int desiredSalary) {
        this.desiredSalary = desiredSalary;
    }
}
