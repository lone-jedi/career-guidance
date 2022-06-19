package com.yarkin.careerguidance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@Builder
@AllArgsConstructor
public class University {
    private int universityId;
    private String title;
    private String description;
    private double rate;
    private String logo;
    private String location;
    private List<Cathedra> cathedraList;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        University that = (University) object;
        return universityId == that.getUniversityId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(universityId);
    }
}
