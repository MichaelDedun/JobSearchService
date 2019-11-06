package com.dedun.model;

import com.dedun.model.enums.State;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="summary")
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mobilePhone;
    private String city;
    private LocalDate dateOfBirth;
    private String sex;
    private Integer workExperience;
    private String educationalInstitution;
    private BigDecimal desiredSalary;
    private String careerObjective;
    private ZonedDateTime date;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @OneToMany(mappedBy = "summary", cascade = CascadeType.REMOVE)
    private List<Skills> skills;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private State state;

    public Summary() {
    }

    public Summary(String mobilePhone, String city, LocalDate dateOfBirth, String sex, Integer workExperience, String educationalInstitution, BigDecimal desiredSalary, String careerObjective ,ZonedDateTime date , Worker worker) {
        this.mobilePhone = mobilePhone;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.workExperience = workExperience;
        this.educationalInstitution = educationalInstitution;
        this.desiredSalary = desiredSalary;
        this.careerObjective = careerObjective;
        this.date = date;
        this.worker = worker;
    }

    public Long getId() {
        return id;
    }

    public Summary setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }

    public String getEducationalInstitution() {
        return educationalInstitution;
    }

    public void setEducationalInstitution(String educationalInstitution) {
        this.educationalInstitution = educationalInstitution;
    }

    public BigDecimal getDesiredSalary() {
        return desiredSalary;
    }

    public void setDesiredSalary(BigDecimal desiredSalary) {
        this.desiredSalary = desiredSalary;
    }

    public String getCareerObjective() {
        return careerObjective;
    }

    public Summary setCareerObjective(String careerObjective) {
        this.careerObjective = careerObjective;
        return this;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public Summary setDate(ZonedDateTime date) {
        this.date = date;
        return this;
    }

    public State getState() {
        return state;
    }

    public Summary setState(State state) {
        this.state = state;
        return this;
    }

    public Worker getWorker() {
        return worker;
    }

    public Summary setWorker(Worker worker) {
        this.worker = worker;
        return this;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public Summary setSkills(List<Skills> skills) {
        this.skills = skills;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Summary)) return false;
        Summary summary = (Summary) o;
        return Objects.equals(getId(), summary.getId()) &&
                Objects.equals(getMobilePhone(), summary.getMobilePhone()) &&
                Objects.equals(getCity(), summary.getCity()) &&
                Objects.equals(getDateOfBirth(), summary.getDateOfBirth()) &&
                Objects.equals(getSex(), summary.getSex()) &&
                Objects.equals(getWorkExperience(), summary.getWorkExperience()) &&
                Objects.equals(getEducationalInstitution(), summary.getEducationalInstitution()) &&
                Objects.equals(getDesiredSalary(), summary.getDesiredSalary()) &&
                Objects.equals(getCareerObjective(), summary.getCareerObjective()) &&
                Objects.equals(getDate(), summary.getDate()) &&
                Objects.equals(getWorker(), summary.getWorker()) &&
                Objects.equals(getSkills(), summary.getSkills()) &&
                getState() == summary.getState();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMobilePhone(), getCity(), getDateOfBirth(), getSex(), getWorkExperience(), getEducationalInstitution(), getDesiredSalary(), getCareerObjective(), getDate(), getWorker(), getSkills(), getState());
    }
}
