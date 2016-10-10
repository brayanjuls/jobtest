package com.application.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Brayan on 9/30/2016.
 */
@Entity
public class QuestionType {

    @Id
    @GeneratedValue
    private long id;
    private String description;

    public QuestionType(String description) {
        this.description = description;
    }

    public QuestionType(){}

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
}
