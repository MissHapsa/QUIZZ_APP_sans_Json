package com.example.QUIZZ.HAPSA.LUNDI.controller;

import com.example.QUIZZ.HAPSA.LUNDI.service.QuizService;
import com.example.QUIZZ.HAPSA.LUNDI.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class QuizzController {

@Autowired

QuizService quizService;

    private int currentQuestionIndex = 0;

        // Route vers la page d'accueil du quiz
        @GetMapping("/")
        public String index() {
            return "index"; // Remplacez "index" par le nom de votre fichier HTML d'accueil
        }

        // Route vers la page questions.html
        @PostMapping("/questions")
        public List<Question>Questions (Model model) throws IOException {
            List<Question> questions = (List<Question>) quizService.getQuestions();
            model.addAttribute("questions", questions.get(currentQuestionIndex));
            return questions; //
        }
    @GetMapping("/nextQuestion")
    public String showNextQuestion(Model model) throws IOException {
        List<Question> questions = (List<Question>) quizService.getQuestions();
        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
            model.addAttribute("questions", quizService.showNextQuestion(currentQuestionIndex, questions));
            return "questions";
        } else {
            return "resultats"; // Remplacez "end" par le nom de votre fichier HTML de fin

        }
    }
}
