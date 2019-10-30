package com.dedun.dto.response;

public class VacancyResponse {
    private Long id;
    private String category;
    private Integer necessaryExperience;
    private Integer salary;

    public VacancyResponse() {
    }

    public Long getId() {
        return id;
    }

    public VacancyResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public VacancyResponse setCategory(String category) {
        this.category = category;
        return this;
    }

    public Integer getNecessaryExperience() {
        return necessaryExperience;
    }

    public VacancyResponse setNecessaryExperience(Integer necessaryExperience) {
        this.necessaryExperience = necessaryExperience;
        return this;
    }

    public Integer getSalary() {
        return salary;
    }

    public VacancyResponse setSalary(Integer salary) {
        this.salary = salary;
        return this;
    }
}
