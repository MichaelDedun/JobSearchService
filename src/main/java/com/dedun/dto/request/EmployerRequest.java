package com.dedun.dto.request;

public class EmployerRequest {
    private String email;
    private String companyName;
    private String login;
    private String password;
    private String feedback;

    public EmployerRequest() {
    }

    public EmployerRequest(String email, String companyName, String login, String password, String feedback) {
        this.email = email;
        this.companyName = companyName;
        this.login = login;
        this.password = password;
        this.feedback = feedback;
    }

    public String getEmail() {
        return email;
    }

    public EmployerRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public EmployerRequest setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public EmployerRequest setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public EmployerRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFeedback() {
        return feedback;
    }

    public EmployerRequest setFeedback(String feedback) {
        this.feedback = feedback;
        return this;
    }
}
