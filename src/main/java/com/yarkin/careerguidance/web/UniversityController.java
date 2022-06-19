package com.yarkin.careerguidance.web;

import com.yarkin.careerguidance.entity.University;
import com.yarkin.careerguidance.entity.UniversityFull;

import java.util.List;

/**
 * TODO: add class / interface description
 *
 * @author OYarkin
 **/
public interface UniversityController
{
    List<UniversityFull> getAll();
}
