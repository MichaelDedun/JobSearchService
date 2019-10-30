package com.dedun.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employer")
public class Employer extends User {
    private String companyName;
    private String feedback;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Employer() {
    }

    public Employer(String companyName, String feedback, User user) {
        this.companyName = companyName;
        this.feedback = feedback;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public Employer setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        if (!super.equals(o)) return false;
        Employer employer = (Employer) o;
        return Objects.equals(getCompanyName(), employer.getCompanyName()) &&
                Objects.equals(getFeedback(), employer.getFeedback()) &&
                Objects.equals(getUser(), employer.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCompanyName(), getFeedback(), getUser());
    }
}
