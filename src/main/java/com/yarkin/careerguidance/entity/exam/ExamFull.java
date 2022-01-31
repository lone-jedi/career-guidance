package com.yarkin.careerguidance.entity.exam;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExamFull extends ExamWithDescription {
    private LocalDateTime creationDate;

    public ExamFull(int id, String title, String description, LocalDateTime creationDate) {
        super(id, title, description);
        this.creationDate = creationDate;
    }
}
