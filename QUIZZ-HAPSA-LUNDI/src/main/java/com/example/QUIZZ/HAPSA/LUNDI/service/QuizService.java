package com.example.QUIZZ.HAPSA.LUNDI.service;

import com.example.QUIZZ.HAPSA.LUNDI.model.Question;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class QuizService {

    // Méthode pour charger les questions depuis le fichier JSON
    private ObjectMapper objectMapper = new ObjectMapper();

    public QuizService() {
        this.objectMapper = objectMapper;
    }

    public <Questions> List<Question> getQuestions() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/questions.json");
        return objectMapper.readValue(inputStream, new TypeReference<List<Question>>() {
        });
    }
    // methode pour afficher qu une seule question à la fois
    public Question getQuestion(int quesId, List<Question> questions) throws IOException {
        for (Question question : questions) {
            if (question.getQuesId() == quesId) {
                return objectMapper.readValue(objectMapper.writeValueAsString(question), Question.class);
            }
        }
        return null;
    }

    public Question showNextQuestion(int i, List<Question> questions) throws IOException {
        if (i < questions.size()) {
            Question question = getQuestion(i + 1, questions);
            return question;
        }
        return null;
    }
}