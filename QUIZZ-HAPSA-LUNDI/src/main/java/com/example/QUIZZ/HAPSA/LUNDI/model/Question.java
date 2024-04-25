package com.example.QUIZZ.HAPSA.LUNDI.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Question {
    private int quesId;
    private String questionNom;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String rep;
    private String choix;


    public Question(int questid, String questionNom, String title, String optionA, String optionB, String optionC, String optionD, String rep, String choix) {
        this.quesId = questid;
        this.questionNom = questionNom;
        this.title = title;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.rep = rep;
        this.choix = choix;
    }

}
