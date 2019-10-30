package com.dedun.dto.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmployerRequest {
    @Email(message = "Email address has invalid format: ${validatedValue}",
            regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    private String email;
    @NotBlank(message = "Company name can't be empty")
    @NotNull(message = "Company name can'be null")
    @Length(min = 6)
    private String companyName;
    @NotBlank(message = "Login can't be empty")
    @NotNull(message = "Login can'be null")
    @Length(min = 6)
    private String login;
    @NotBlank(message = "Password can't be empty")
    @NotNull(message = "Password can'be null")
    @Length(min = 6)
    private String password;
    @NotBlank(message = "Feedback can't be empty")
    @NotNull(message = "Feedback can'be null")
    private String feedback;

    public EmployerRequest() {
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
