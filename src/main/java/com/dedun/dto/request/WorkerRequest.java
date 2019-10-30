package com.dedun.dto.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class WorkerRequest {
    @NotBlank(message = "Login can't be empty")
    @NotNull(message = "Login can'be null")
    @Length(min = 6)
    private String login;
    @NotBlank(message = "Password can't be empty")
    @NotNull(message = "Password can'be null")
    @Length(min = 6)
    private String password;
    @NotBlank(message = "First name can't be empty")
    @NotNull(message = "First name  can'be null")
    @Length(min = 2)
    private String firstName;
    @NotBlank(message = "Last name can't be empty")
    @NotNull(message = "Last name can'be null")
    @Length(min = 2)
    private String lastName;
    @Email(message = "Email address has invalid format: ${validatedValue}",
            regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    private String email;

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
}
