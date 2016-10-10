package com.application.api;

import com.application.model.Questions;
import com.application.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Brayan on 9/30/2016.
 */
@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/api/question/findall",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Questions>> getQuestions(){
        Collection<Questions> questions=questionService.findAll();
        return new ResponseEntity<Collection<Questions>>(questions, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/question/find/{id}",method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Questions> getQuestion(@PathVariable("id") long id){
        Questions questions=questionService.findOne(id);

        return new ResponseEntity<Questions>(questions,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/question/update",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Questions> updateQuestion(@RequestBody Questions questions){
        Questions questionUpdated=questionService.update(questions);
        if (questionUpdated==null){
            return new ResponseEntity<Questions>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Questions>(questionUpdated,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/question/create",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Questions> createQuestion(@RequestBody Questions questions){
        Questions questionCreated=questionService.create(questions);
        if (questionCreated==null){
            return new ResponseEntity<Questions>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<Questions>(questionCreated,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/question/remove/{id}",method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Questions> removeQuestion(@PathVariable long id){
        Questions findedQuestion=questionService.findOne(id);
        if(findedQuestion==null){
            return  new ResponseEntity<Questions>(HttpStatus.NO_CONTENT);
        }
        questionService.remove(id);
        return new ResponseEntity<Questions>(HttpStatus.OK);
    }
}
