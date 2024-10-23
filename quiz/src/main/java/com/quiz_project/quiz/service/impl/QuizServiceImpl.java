package com.quiz_project.quiz.service.impl;

import com.quiz_project.quiz.entity.Quiz;
import com.quiz_project.quiz.repository.QuizRepository;
import com.quiz_project.quiz.service.QuestionClient;
import com.quiz_project.quiz.service.QuizService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {


    private final QuestionClient questionClient;
    QuizRepository quizRepository;


    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
        ;
    }

    public void add(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public Quiz get(Integer quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("No Quiz found with id " + quizId));
        quiz.setQuizQuestions(questionClient.getQuestionsByQuizId(quiz.getQuizId()));
        return quiz;
    }

    public List<Quiz> getAllQuiz() {
        List<Quiz> quizes = quizRepository.findAll();

        List<Quiz> quizList = quizes.stream().map(quiz -> {
            quiz.setQuizQuestions(questionClient.getQuestionsByQuizId(quiz.getQuizId()));
            return quiz;
        }).collect(Collectors.toList());

        return quizList;
    }
}
