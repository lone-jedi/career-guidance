package com.yarkin.careerguidance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * TODO: add class / interface description
 *
 * @author OYarkin
 */
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ResultFull {
    private final int resultId;
    private final String title;
    private final String description;
    List<Result> results;
    List<Specialty> specialties;

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
