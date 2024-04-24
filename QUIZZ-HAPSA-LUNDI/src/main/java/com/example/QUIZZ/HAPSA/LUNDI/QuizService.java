package com.example.QUIZZ.HAPSA.LUNDI;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class QuizService {

    // Méthode pour charger les questions depuis le fichier JSON
    private ObjectMapper objectMapper = new ObjectMapper();
    public QuizService() {
        this.objectMapper = objectMapper;
    }
    public List<Question> getQuestions() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/questions.json");
        return objectMapper.readValue(inputStream, new TypeReference<List<Question>>() {});
    }

    // Méthode pour passer à la question suivante
    public void moveToNextQuestion(int currentQuestionIndex, List<Question> questions) {
        // Vérifier si nous sommes à la dernière question
        if (currentQuestionIndex < questions.size() - 1) {
            // Passer à la question suivante
            Question nextQuestion = questions.get(currentQuestionIndex + 1);
            System.out.println("Question suivante : " + nextQuestion.getQuestion());
        } else {
            // Nous sommes déjà à la dernière question
            System.out.println("C'est la dernière question.");
        }
    }
}