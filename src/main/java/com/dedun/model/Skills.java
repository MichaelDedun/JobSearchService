package com.dedun.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "skills")
@Embeddable
public class Skills {
    @Id
    @AttributeOverrides({
            @AttributeOverride(name = "Summary",
                    column = @Column(name = "summary_id")),
            @AttributeOverride(name = "title",
                    column = @Column(name = "title"))
    })
    private String title;
    @ManyToOne
    @JoinColumn(name = "summary_id")
    private Summary summary;

    public Skills() {
    }

    public Skills(String title, Summary summary) {
        this.title = title;
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public Skills setTitle(String title) {
        this.title = title;
        return this;
    }

    public Summary getSummary() {
        return summary;
    }

    public Skills setSummary(Summary summary) {
        this.summary = summary;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skills)) return false;
        Skills skills = (Skills) o;
        return Objects.equals(getTitle(), skills.getTitle()) &&
                Objects.equals(getSummary(), skills.getSummary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getSummary());
    }
}
