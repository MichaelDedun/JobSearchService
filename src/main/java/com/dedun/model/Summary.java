package com.dedun.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="summary")
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mobilePhone;
    private String city;
    private LocalDate dateOfBirth;
    private String sex;
    private Integer workExperience;
    private String educarionalInstitution;
    private int desiredSalary;

    @OneToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    public Summary() {
    }

    public Summary(String mobilePhone, String city, LocalDate dateOfBirth, String sex, Integer workExperience, String educarionalInstitution, int desiredSalary, Worker worker) {
        this.mobilePhone = mobilePhone;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.workExperience = workExperience;
        this.educarionalInstitution = educarionalInstitution;
        this.desiredSalary = desiredSalary;
        this.worker = worker;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEducarionalInstitution() {
        return educarionalInstitution;
    }

    public void setEducarionalInstitution(String educarionalInstitution) {
        this.educarionalInstitution = educarionalInstitution;
    }

    public int getDesiredSalary() {
        return desiredSalary;
    }

    public void setDesiredSalary(int desiredSalary) {
        this.desiredSalary = desiredSalary;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Summary)) return false;
        Summary summary = (Summary) o;
        return getDesiredSalary() == summary.getDesiredSalary() &&
                Objects.equals(getId(), summary.getId()) &&
                Objects.equals(getMobilePhone(), summary.getMobilePhone()) &&
                Objects.equals(getCity(), summary.getCity()) &&
                Objects.equals(getDateOfBirth(), summary.getDateOfBirth()) &&
                Objects.equals(getSex(), summary.getSex()) &&
                Objects.equals(getWorkExperience(), summary.getWorkExperience()) &&
                Objects.equals(getEducarionalInstitution(), summary.getEducarionalInstitution()) &&
                Objects.equals(getWorker(), summary.getWorker());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMobilePhone(), getCity(), getDateOfBirth(), getSex(), getWorkExperience(), getEducarionalInstitution(), getDesiredSalary(), getWorker());
    }
}
