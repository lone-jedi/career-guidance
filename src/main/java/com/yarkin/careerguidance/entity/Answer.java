package com.yarkin.careerguidance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Answer {
    private int answerId;
    private String title;
    private double weight;
}
