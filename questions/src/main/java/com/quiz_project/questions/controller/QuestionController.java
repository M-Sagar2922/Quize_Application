package com.quiz_project.questions.controller;

import com.quiz_project.questions.entity.Question;
import com.quiz_project.questions.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public void add(@RequestBody Question question) {
        questionService.add(question);
    }

    @GetMapping("{questionId}")
    public Question get(@PathVariable Integer questionId) {
        return questionService.get(questionId);
    }

    @GetMapping()
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Integer quizId) {
        return questionService.getQuestionsOfQuiz(quizId);
    }
    @GetMapping("/duplicate")
    public ResponseEntity<?> getDuplicateQuestions()
    {
        return questionService.getDuplicateQuestion();
    }
}
