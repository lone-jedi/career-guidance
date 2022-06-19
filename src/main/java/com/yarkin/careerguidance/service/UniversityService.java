package com.yarkin.careerguidance.service;

import com.yarkin.careerguidance.entity.University;
import com.yarkin.careerguidance.entity.UniversityFull;

import java.util.List;

/**
 * TODO: add class / interface description
 *
 * @author OYarkin
 * @since 8.3.0
 **/
public interface UniversityService
{
    List<UniversityFull> getAll();
}
