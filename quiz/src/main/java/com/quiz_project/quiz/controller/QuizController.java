package com.quiz_project.quiz.controller;

import com.quiz_project.quiz.entity.Quiz;
import com.quiz_project.quiz.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public void add(@RequestBody Quiz quiz) {
        quizService.add(quiz);
    }

    @GetMapping("{quizId}")
    public Quiz get(@PathVariable Integer quizId) {
        return quizService.get(quizId);
    }

    @GetMapping
    public List<Quiz> getAll() {
        return quizService.getAllQuiz();
    }

}
