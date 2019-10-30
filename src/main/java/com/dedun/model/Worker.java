package com.dedun.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "worker")
public class Worker extends User {
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.REMOVE)
    private List<Summary> summary;

    public Worker() {
    }

    public Worker(String email, String login, String password, String firstName, String lastName) {
        super(email, login, password);
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public Worker setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Worker setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public List<Summary> getSummary() {
        return summary;
    }

    public Worker setSummary(List<Summary> summary) {
        this.summary = summary;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return Objects.equals(getFirstName(), worker.getFirstName()) &&
                Objects.equals(getLastName(), worker.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFirstName(), getLastName());
    }
}
