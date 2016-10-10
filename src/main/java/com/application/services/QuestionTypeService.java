package com.application.services;

import com.application.model.QuestionType;

import java.util.Collection;

/**
 * Created by Brayan on 9/30/2016.
 */
public interface QuestionTypeService {

    Collection<QuestionType> findAll();

    QuestionType findOne(long id);

    QuestionType update(QuestionType questionType);

    void delete(long id);

    QuestionType create(QuestionType questionType);
}
