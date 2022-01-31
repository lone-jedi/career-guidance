package com.yarkin.careerguidance.entity.exam;

import lombok.Getter;

@Getter
public class ExamWithDescription extends Exam {
    private String description;

    public ExamWithDescription(String title, String description) {
        super(title);
        this.description = description;
    }

    public ExamWithDescription(int id, String title, String description) {
        super(id, title);
        this.description = description;
    }
}
