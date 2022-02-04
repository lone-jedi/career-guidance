package com.yarkin.careerguidance.repository;

import com.yarkin.careerguidance.entity.Answer;

import java.util.List;

public interface AnswerRepository {
    List<Answer> getByQuestionId(int questionId);
}
