package com.example.QUIZZ.HAPSA.LUNDI;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

    public class QuestionParser {

        public static List<Question> parse(InputStream inputStream) throws IOException {
            List<Question> questions = new ArrayList<>();
            Document document = Jsoup.parse(inputStream, "UTF-8", "");

            Elements questionElements = document.select("div.question");
            for (Element questionElement : questionElements) {
                String questionText;
                questionText = questionElement.select("p.question-text").text();
                Elements optionsElements = questionElement.select("ul.options li");
                List<String> options = new ArrayList<>();
                for (Element optionElement : optionsElements) {
                    options.add(optionElement.text());
                }
                String correctAnswer = questionElement.select("span.correct-answer").text();
                questions.add(new Question(questionText, options, correctAnswer));
            }

            return questions;
        }
    }


