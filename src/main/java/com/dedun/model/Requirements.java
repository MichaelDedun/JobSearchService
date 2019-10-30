package com.dedun.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "requirements")
@Embeddable
public class Requirements {
    @Id
    @AttributeOverrides({
            @AttributeOverride(name = "Vacancy",
                    column = @Column(name = "vacancy_id")),
            @AttributeOverride(name = "title",
                    column = @Column(name = "title"))
    })
    private String title;
    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;


    public Requirements() {
    }

    public Requirements(String title, Vacancy vacancy) {
        this.title = title;
        this.vacancy = vacancy;
    }

    public String getTitle() {
        return title;
    }

    public Requirements setTitle(String title) {
        this.title = title;
        return this;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public Requirements setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Requirements)) return false;
        Requirements that = (Requirements) o;
        return Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getVacancy(), that.getVacancy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getVacancy());
    }
}
