package com.example.QUIZZ.HAPSA.LUNDI;

import lombok.Getter;

import java.util.List;

public class Question {
    private final String questionText;
    @Getter
    private final List<String> options;

    public Question(String questionText, List<String> options, String correctAnswer) {
            this.questionText = questionText;
            this.options = options;
    }

    public String getQuestion() {
        return questionText;
    }

}
