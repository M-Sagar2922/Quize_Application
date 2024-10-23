package com.quiz_project.questions.service;

import com.quiz_project.questions.entity.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {

    public void add(Question question);

    Question get(Integer id);

    public List<Question> getAll();

    public List<Question> getQuestionsOfQuiz(Integer quizId);

    public ResponseEntity<?> getDuplicateQuestion();
}
