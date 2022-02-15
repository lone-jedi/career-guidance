package com.yarkin.careerguidance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class Specialty {
    private int id;
    private String title;
    private String description;
    private List<University> universities;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Specialty specialty = (Specialty) object;
        return id == specialty.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
