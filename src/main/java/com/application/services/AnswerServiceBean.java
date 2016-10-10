package com.application.services;

import com.application.model.Answers;
import com.application.repository.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Brayan on 9/30/2016.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AnswerServiceBean implements AnswerService {

   @Autowired
   private AnswersRepository answersRepository;

    @Override
    public Collection<Answers> findAll() {

        return answersRepository.findAll();
    }

    @Override
    public Answers findOne(long id) {
        return answersRepository.findOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public Answers update(Answers answers) {
        Answers answersFinded=answersRepository.findOne(answers.getId());
        if(answersFinded==null){
            return null;
        }
        return answersRepository.save(answers);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void remove(long id) {
        answersRepository.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public Answers create(Answers answers) {
        return answersRepository.save(answers);
    }
}
