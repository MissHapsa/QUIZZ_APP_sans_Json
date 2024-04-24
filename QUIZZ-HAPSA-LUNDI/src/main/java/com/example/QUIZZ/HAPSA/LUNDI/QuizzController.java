package com.example.QUIZZ.HAPSA.LUNDI;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuizzController {


        // Route vers la page d'accueil du quiz
        @GetMapping("/")
        public String index() {
            return "index"; // Remplacez "index" par le nom de votre fichier HTML d'accueil
        }

        // Route vers la page questions.html
        @PostMapping("/questions")
        public String questions() {
            return "questions"; // Remplacez "questions" par le nom de votre fichier HTML de questions
        }



}
