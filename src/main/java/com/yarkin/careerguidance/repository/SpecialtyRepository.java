package com.yarkin.careerguidance.repository;

import com.yarkin.careerguidance.entity.Specialty;

import java.util.List;

public interface SpecialtyRepository {
    List<Specialty> getAllByResultId(int resultId);
}
