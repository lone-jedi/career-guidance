package com.yarkin.careerguidance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Result {
    private final int resultId;
    private final String title;
    private final String description;
    private int answersCount;
    private double scoreFrom;
    private double scoreTo;
    List<Specialty> specialties;

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }
}
