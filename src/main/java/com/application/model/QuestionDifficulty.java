package com.application.model;

/**
 * Created by Brayan on 9/30/2016.
 */
public enum QuestionDifficulty {

    EASE(1),
    MEDIUM(2),
    HARD(3);

    private int v;
    QuestionDifficulty(int v){
        this.v=v;
    }

    public int value(){
        return v;
    }
}
