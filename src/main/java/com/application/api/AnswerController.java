package com.application.api;

import com.application.model.Answers;
import com.application.services.AnswerService;
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
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = "/api/answers/findall",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Answers>> findAll(){
        Collection<Answers> answers = answerService.findAll();
        return new ResponseEntity<Collection<Answers>>(answers, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/answers/find/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Answers> findById(@PathVariable("id") long id){
       Answers answer= answerService.findOne(id);
        if(answer==null){
            return new ResponseEntity<Answers>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Answers>(answer,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/answers/update",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Answers> update(@RequestBody Answers answers){
        Answers updatedAnswer= answerService.update(answers);
        if(updatedAnswer==null){
            return new ResponseEntity<Answers>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Answers>(updatedAnswer,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/answers/create",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Answers> create(@RequestBody Answers answers){
    Answers answer= answerService.create(answers);
        return new ResponseEntity<Answers>(answer,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/answers/remove/{id}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Answers> remove(@PathVariable("id") long id){
        answerService.remove(id);
        return new ResponseEntity<Answers>(HttpStatus.NO_CONTENT);
    }


}
