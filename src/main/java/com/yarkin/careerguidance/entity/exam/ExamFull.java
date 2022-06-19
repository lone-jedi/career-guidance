package com.yarkin.careerguidance.entity.exam;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExamFull extends ExamWithDescription {
    private LocalDateTime creationDate;

    public ExamFull(int examId, String title, String description, LocalDateTime creationDate) {
        super(examId, title, description);
        this.creationDate = creationDate;
    }
}
