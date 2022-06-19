package com.yarkin.careerguidance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

/**
 * TODO: add class / interface description
 *
 * @author OYarkin
 */
@Getter
@Builder
@AllArgsConstructor
public class UniversityFull
{
    private int universityId;
    private String title;
    private String description;
    private double rate;
    private String logo;
    private String location;
    private String website;
    private List<Cathedra> cathedraList;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UniversityFull that = (UniversityFull) object;
        return universityId == that.getUniversityId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(universityId);
    }
}
