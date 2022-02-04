package com.yarkin.careerguidance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Test {
    private int id;
    private String title;
    private String description;
    private List<Question> questions;

    public Test(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
