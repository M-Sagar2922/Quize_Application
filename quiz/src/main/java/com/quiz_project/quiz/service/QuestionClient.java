package com.quiz_project.quiz.service;

import com.quiz_project.quiz.entity.Questions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8081", value = "Question-Client")
@FeignClient(name="questions-service")
public interface QuestionClient {

    @GetMapping("/question/quiz/{QuizId}")
    public List<Questions> getQuestionsByQuizId(@PathVariable Integer QuizId);

}
