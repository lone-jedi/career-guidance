package com.yarkin.careerguidance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Test {
    private int testId;
    private String title;
    private String description;
    private List<Question> questions;

    public Test(int testId, String title, String description) {
        this.testId = testId;
        this.title = title;
        this.description = description;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
