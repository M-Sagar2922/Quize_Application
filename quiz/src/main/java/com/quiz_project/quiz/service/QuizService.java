package com.quiz_project.quiz.service;

import com.quiz_project.quiz.entity.Quiz;

import java.util.List;

public interface QuizService {

    public void add(Quiz quiz);

    public Quiz get(Integer quizId);

    public List<Quiz> getAllQuiz();

}
