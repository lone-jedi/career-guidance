package com.yarkin.careerguidance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class Specialty {
    private int specialtyId;
    private String title;
    private String description;
    private List<UniversityFull> universities;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Specialty specialty = (Specialty) object;
        return specialtyId == specialty.specialtyId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialtyId);
    }
}
