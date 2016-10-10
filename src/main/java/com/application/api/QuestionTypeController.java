package com.application.api;

import com.application.model.QuestionType;
import com.application.services.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Brayan on 10/1/2016.
 */
@RestController
public class QuestionTypeController {

    @Autowired
    private QuestionTypeService questionTypeService;

    @RequestMapping(value = "/api/questiontype/findall",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<QuestionType>> findAll(){
            Collection<QuestionType> questionTypes= questionTypeService.findAll();
        return new ResponseEntity<Collection<QuestionType>>(questionTypes, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/questiontype/find/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionType> findOne(@PathVariable("id") long id){
        QuestionType questionType= questionTypeService.findOne(id);
        if(questionType==null){
            return new ResponseEntity<QuestionType>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<QuestionType>(questionType,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/questiontype/update",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionType> update(@RequestBody QuestionType questionType){
        QuestionType updatedQuestionType= questionTypeService.update(questionType);
        if(updatedQuestionType==null){
            return new ResponseEntity<QuestionType>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<QuestionType>(updatedQuestionType,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/questiontype/create",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionType> create(@RequestBody QuestionType questionType){
        QuestionType createdQuestionType= questionTypeService.create(questionType);
        return new ResponseEntity<QuestionType>(createdQuestionType,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/questiontype/remove/{id}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionType> remove(@PathVariable("id") long id){
        questionTypeService.delete(id);

        return new ResponseEntity<QuestionType>(HttpStatus.NO_CONTENT);
    }

}
