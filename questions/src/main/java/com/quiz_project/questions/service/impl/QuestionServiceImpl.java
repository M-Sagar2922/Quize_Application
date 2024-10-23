package com.quiz_project.questions.service.impl;

import com.quiz_project.questions.entity.Question;
import com.quiz_project.questions.repository.QuestionRepository;
import com.quiz_project.questions.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void add(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Question get(Integer id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found with id" + id));
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Integer quizId) {
        return questionRepository.findByQuizId(quizId);
    }

    @Override
    public ResponseEntity<?> getDuplicateQuestion() {
         Map<Integer, List<Question>> map=questionRepository.findAll().stream().collect(Collectors.groupingBy(x->x.getQuizId()));

                 return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
