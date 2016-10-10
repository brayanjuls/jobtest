package com.application.services;

import com.application.model.Questions;

import java.util.Collection;

/**
 * Created by Brayan on 9/30/2016.
 */
public interface QuestionService {

    Collection<Questions> findAll();

    Questions findOne(long id);

    Questions update(Questions questions);

    void remove(long id);

    Questions create(Questions questions);
}
