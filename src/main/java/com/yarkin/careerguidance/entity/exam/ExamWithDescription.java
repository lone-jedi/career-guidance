package com.yarkin.careerguidance.entity.exam;

import lombok.Getter;

@Getter
public class ExamWithDescription extends Exam {
    private String description;

    public ExamWithDescription(String title, String description) {
        super(title);
        this.description = description;
    }

    public ExamWithDescription(int examId, String title, String description) {
        super(examId, title);
        this.description = description;
    }
}
