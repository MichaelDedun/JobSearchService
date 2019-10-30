package com.dedun.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employer")
public class Employer extends User {
    private String companyName;
    private String feedback;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.REMOVE)
    private List<Vacancy> vacancies;

    public Employer() {
    }

    public Employer(String email, String login, String password, String companyName, String feedback) {
        super(email, login, password);
        this.companyName = companyName;
        this.feedback = feedback;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Employer setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getFeedback() {
        return feedback;
    }

    public Employer setFeedback(String feedback) {
        this.feedback = feedback;
        return this;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public Employer setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        if (!super.equals(o)) return false;
        Employer employer = (Employer) o;
        return Objects.equals(getCompanyName(), employer.getCompanyName()) &&
                Objects.equals(getFeedback(), employer.getFeedback());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCompanyName(), getFeedback());
    }
}
