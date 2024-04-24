package com.example.QUIZZ.HAPSA.LUNDI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class QuizzHapsaLundiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizzHapsaLundiApplication.class, args);
		QuizService quizService = new QuizService();
		try {
			List<Question> questions = quizService.getQuestions();
			// Supposons que nous sommes à la question index 2
			quizService.moveToNextQuestion(2, questions);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
