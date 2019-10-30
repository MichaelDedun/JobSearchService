package com.dedun.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class VacancyRequest {
    @NotBlank(message = "Category name can't be empty")
    @NotNull(message = "Category name can'be null")
    private String category;
    @NotBlank(message = "Necessary experience name can't be empty")
    @NotNull(message = "Necessary experience  name can'be null")
    @Positive(message = "The value must be positive")
    private Integer necessaryExperience;
    @NotBlank(message = "Salary name can't be empty")
    @NotNull(message = "Salary name can'be null")
    @Positive(message = "The value must be positive")
    private Integer salary;

    public VacancyRequest() {
    }

    public String getCategory() {
        return category;
    }

    public VacancyRequest setCategory(String category) {
        this.category = category;
        return this;
    }

    public Integer getNecessaryExperience() {
        return necessaryExperience;
    }

    public VacancyRequest setNecessaryExperience(Integer necessaryExperience) {
        this.necessaryExperience = necessaryExperience;
        return this;
    }

    public Integer getSalary() {
        return salary;
    }

    public VacancyRequest setSalary(Integer salary) {
        this.salary = salary;
        return this;
    }
}
