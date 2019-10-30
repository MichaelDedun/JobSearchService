package com.dedun.dto.response;

public class WorkerResponse {
    private Integer id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;

    public WorkerResponse() {
    }

    public Integer getId() {
        return id;
    }

    public WorkerResponse setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public WorkerResponse setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public WorkerResponse setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public WorkerResponse setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public WorkerResponse setEmail(String email) {
        this.email = email;
        return this;
    }
}
