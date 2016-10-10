package com.application.model;

/**
 * Created by Brayan on 9/30/2016.
 */
public enum AnswersValue {
    EXCELLENT(100),
    GOOD(70),
    NOTBAD(50),
    WEAK(30),
    BAD(0);

    private long point;
    AnswersValue(long point){
        this.point=point;
    }

    public long point(){
        return point;
    }



}
