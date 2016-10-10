package com.application;

import com.application.model.Answers;
import com.application.services.AnswerService;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

/**
 * Created by Brayan on 10/9/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public  class AbstractTest {

    @Autowired
    AnswerService answerService;

    @Test
    public void testFindAll(){
        Collection<Answers> answersesfound =answerService.findAll();
        Assert.assertNotNull("fail null element retrieve",answersesfound);
    }

}
