package com.quiz_project.quiz.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Questions {
    private Integer id;
    private String question;
    private String answer;

    private Integer quizId;
}
