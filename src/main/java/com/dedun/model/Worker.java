package com.dedun.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(mappedBy = "worker", cascade = CascadeType.REMOVE)
    private Summary summary;

    public Worker() {
    }

    public Worker(String login, String password, String firstName, String lastName, String email) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        Worker worker = (Worker) o;
        return Objects.equals(getId(), worker.getId()) &&
                Objects.equals(getLogin(), worker.getLogin()) &&
                Objects.equals(getPassword(), worker.getPassword()) &&
                Objects.equals(getFirstName(), worker.getFirstName()) &&
                Objects.equals(getLastName(), worker.getLastName()) &&
                Objects.equals(getEmail(), worker.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword(), getFirstName(), getLastName(), getEmail());
    }
}
