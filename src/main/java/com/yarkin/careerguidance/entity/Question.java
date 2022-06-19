package com.yarkin.careerguidance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Question {
    private final int questionId;
    private final String title;
    private List<Answer> answers;

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Question question = (Question) object;

        return questionId == question.questionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId);
    }
}
