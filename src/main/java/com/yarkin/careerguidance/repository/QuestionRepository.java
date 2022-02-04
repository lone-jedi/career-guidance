package com.yarkin.careerguidance.repository;

import com.yarkin.careerguidance.entity.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> getByTestIdWithAnswers(int testId);
}
