package com.yarkin.careerguidance.entity.exam;

import lombok.Getter;

@Getter
public class Exam {
    private int id;
    private String title;

    public Exam(String title) {
        this.title = title;
    }

    public Exam(int id, String title) {
        this(title);
        this.id = id;
    }
}
