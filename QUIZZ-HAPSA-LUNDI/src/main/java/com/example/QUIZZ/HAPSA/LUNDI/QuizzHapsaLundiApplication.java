package com.example.QUIZZ.HAPSA.LUNDI;

import com.example.QUIZZ.HAPSA.LUNDI.model.Question;
import com.example.QUIZZ.HAPSA.LUNDI.service.QuizService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class QuizzHapsaLundiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizzHapsaLundiApplication.class, args);
		QuizService quizService = new QuizService();
		try {
			List<Question> questions = Collections.singletonList(quizService.getQuestions().get(1));
			// Supposons que nous sommes à la question index 2
			quizService.showNextQuestion(0, questions);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
