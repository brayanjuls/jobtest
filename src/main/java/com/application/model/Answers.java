package com.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Brayan on 9/30/2016.
 */
@Entity
public class Answers {

    @Id
    @GeneratedValue
    private long id;
    private String description;
    private String advise;
    private AnswersValue point;
    private long idquestion;

    public Answers(String description, String advise, AnswersValue point, long idquestion) {
        this.description = description;
        this.advise = advise;
        this.point = point;
        this.idquestion = idquestion;
    }

    public Answers() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdvise() {
        return advise;
    }

    public void setAdvise(String advise) {
        this.advise = advise;
    }

    public AnswersValue getPoint() {
        return point;
    }

    public void setPoint(AnswersValue point) {
        this.point = point;
    }

    public long getIdquestion() {
        return idquestion;
    }

    public void setIdquestion(long idquestion) {
        this.idquestion = idquestion;
    }
}
