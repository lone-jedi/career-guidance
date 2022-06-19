package com.yarkin.careerguidance.entity.exam;

import lombok.Getter;

@Getter
public class Exam {
    private int examId;
    private String title;

    public Exam(String title) {
        this.title = title;
    }

    public Exam(int examId, String title) {
        this(title);
        this.examId = examId;
    }
}
