package com.dedun.model;

import com.dedun.model.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "employer")
public class Employer implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String companyName;
    private String login;
    private String password;
    private String feedback;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public Employer() {
    }

    public Employer(String email, String companyName, String login, String password, String feedback) {
        this.email = email;
        this.companyName = companyName;
        this.login = login;
        this.password = password;
        this.feedback = feedback;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public Employer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Employer setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public Employer setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFeedback() {
        return feedback;
    }

    public Employer setFeedback(String feedback) {
        this.feedback = feedback;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Employer setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        Employer employer = (Employer) o;
        return Objects.equals(getId(), employer.getId()) &&
                Objects.equals(getEmail(), employer.getEmail()) &&
                Objects.equals(getCompanyName(), employer.getCompanyName()) &&
                Objects.equals(getLogin(), employer.getLogin()) &&
                Objects.equals(getPassword(), employer.getPassword()) &&
                Objects.equals(getFeedback(), employer.getFeedback()) &&
                Objects.equals(getRoles(), employer.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getCompanyName(), getLogin(), getPassword(), getFeedback(), getRoles());
    }
}
