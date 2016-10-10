package com.application.services;

import com.application.model.Questions;
import com.application.repository.QuestionsRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


/**
 * Created by Brayan on 9/30/2016.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class QuestionServiceBean implements QuestionService  {
    @Autowired
    QuestionsRepository questionsRepository;

    @Override
    public Collection<Questions> findAll() {

        Collection<Questions> questions=questionsRepository.findAll();
        return questions;
    }

    @Override
    public Questions findOne(long id) {
        return questionsRepository.findOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public Questions update(Questions questions) {
        Questions questionFinded=questionsRepository.findOne(questions.getId());
        if(questionFinded==null){
            return null;
        }
        return questionsRepository.save(questions);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void remove(long id) {
        questionsRepository.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public Questions create(Questions questions) {
        return questionsRepository.save(questions);
    }
}
