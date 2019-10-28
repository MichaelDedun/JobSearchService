package com.dedun.dto.response;

public class EmployerResponse {
    private Integer id;
    private String email;
    private String companyName;
    private String login;
    private String feedback;

    public EmployerResponse() {
    }

    public Integer getId() {
        return id;
    }

    public EmployerResponse setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmployerResponse setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public EmployerResponse setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public EmployerResponse setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getFeedback() {
        return feedback;
    }

    public EmployerResponse setFeedback(String feedback) {
        this.feedback = feedback;
        return this;
    }
}
