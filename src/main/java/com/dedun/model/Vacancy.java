package com.dedun.model;

import com.dedun.model.enums.State;

import javax.persistence.*;
import java.time.ZonedDateTime;
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
    private ZonedDateTime date;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @OneToMany(mappedBy = "vacancy", cascade = CascadeType.REMOVE)
    private List<Requirements> requirements;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private State state;

    public Vacancy() {
    }

    public Vacancy(String category, Integer necessaryExperience, Integer salary, ZonedDateTime date, Employer employer) {
        this.category = category;
        this.necessaryExperience = necessaryExperience;
        this.salary = salary;
        this.date = date;
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

    public State getState() {
        return state;
    }

    public Vacancy setState(State state) {
        this.state = state;
        return this;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public Vacancy setDate(ZonedDateTime date) {
        this.date = date;
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
                Objects.equals(getDate(), vacancy.getDate()) &&
                Objects.equals(getEmployer(), vacancy.getEmployer()) &&
                Objects.equals(getRequirements(), vacancy.getRequirements()) &&
                getState() == vacancy.getState();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategory(), getNecessaryExperience(), getSalary(), getDate(), getEmployer(), getRequirements(), getState());
    }
}
