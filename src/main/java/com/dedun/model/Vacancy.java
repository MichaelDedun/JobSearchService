package com.dedun.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vacancy")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private Integer necessaryExperience;
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @OneToMany(mappedBy = "vacancy", cascade = CascadeType.REMOVE)
    private List<Requirements> requirements;

    public Vacancy() {
    }

    public Vacancy(String category, Integer necessaryExperience, Integer salary, Employer employer) {
        this.category = category;
        this.necessaryExperience = necessaryExperience;
        this.salary = salary;
        this.employer = employer;
    }

    public Long getId() {
        return id;
    }

    public Vacancy setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Vacancy setCategory(String category) {
        this.category = category;
        return this;
    }

    public Integer getNecessaryExperience() {
        return necessaryExperience;
    }

    public Vacancy setNecessaryExperience(Integer necessaryExperience) {
        this.necessaryExperience = necessaryExperience;
        return this;
    }

    public Integer getSalary() {
        return salary;
    }

    public Vacancy setSalary(Integer salary) {
        this.salary = salary;
        return this;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Vacancy setEmployer(Employer employer) {
        this.employer = employer;
        return this;
    }

    public List<Requirements> getRequirements() {
        return requirements;
    }

    public Vacancy setRequirements(List<Requirements> requirements) {
        this.requirements = requirements;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vacancy)) return false;
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(getId(), vacancy.getId()) &&
                Objects.equals(getCategory(), vacancy.getCategory()) &&
                Objects.equals(getNecessaryExperience(), vacancy.getNecessaryExperience()) &&
                Objects.equals(getSalary(), vacancy.getSalary()) &&
                Objects.equals(getEmployer(), vacancy.getEmployer()) &&
                Objects.equals(getRequirements(), vacancy.getRequirements());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategory(), getNecessaryExperience(), getSalary(), getEmployer(), getRequirements());
    }
}
