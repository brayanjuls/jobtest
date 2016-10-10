package com.application.services;

import com.application.model.QuestionType;
import com.application.repository.QuestionTypeRepository;
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
public class QuestionTypeServiceBean implements QuestionTypeService {

    @Autowired
    private QuestionTypeRepository questionTypeRepository;

    @Override
    public Collection<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public QuestionType findOne(long id) {
        return questionTypeRepository.findOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public QuestionType update(QuestionType questionType) {
        QuestionType questionfinded=questionTypeRepository.findOne(questionType.getId());

        if(questionfinded==null ){
            return null;
        }
        return questionTypeRepository.save(questionType);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void delete(long id) {
        questionTypeRepository.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public QuestionType create(QuestionType questionType) {
        return questionTypeRepository.save(questionType);
    }
}
