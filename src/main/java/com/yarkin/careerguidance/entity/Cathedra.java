package com.yarkin.careerguidance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Cathedra {
    private int cathedraId;
    private String title;
    private String description;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Cathedra cathedra = (Cathedra) object;
        return cathedraId == cathedra.cathedraId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cathedraId);
    }
}
