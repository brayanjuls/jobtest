package com.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Brayan on 9/30/2016.
 */
@Entity
public class Questions {

    @Id
    @GeneratedValue
    private long id;
    private String description;
    private QuestionDifficulty difficulty;
    private long type;
    private String createdby;

    public Questions(String createdby, String description, QuestionDifficulty difficulty, long type) {
        this.createdby = createdby;
        this.description = description;
        this.difficulty = difficulty;
        this.type = type;
    }

    public Questions() {
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
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

    public QuestionDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(QuestionDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }
}
