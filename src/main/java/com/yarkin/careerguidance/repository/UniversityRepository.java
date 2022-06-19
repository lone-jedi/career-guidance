package com.yarkin.careerguidance.repository;

import com.yarkin.careerguidance.entity.UniversityFull;

import java.util.List;

/**
 * TODO: add class / interface description
 *
 * @author OYarkin
 * @since 8.3.0
 **/
public interface UniversityRepository
{
    List<UniversityFull> getAll();
}
