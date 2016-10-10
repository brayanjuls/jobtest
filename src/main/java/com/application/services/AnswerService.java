package com.application.services;

import com.application.model.Answers;

import java.util.Collection;

/**
 * Created by Brayan on 9/30/2016.
 */

public interface AnswerService {
    Collection<Answers> findAll();

    Answers findOne(long id);

    Answers update(Answers answers);

    void remove(long id);

    Answers create(Answers answers);


}
