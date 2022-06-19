package com.yarkin.careerguidance.service.university;

import com.yarkin.careerguidance.entity.University;
import com.yarkin.careerguidance.entity.UniversityFull;
import com.yarkin.careerguidance.repository.UniversityRepository;
import com.yarkin.careerguidance.service.UniversityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: add class / interface description
 *
 * @author OYarkin
 * @since 8.3.0
 */
@Service
@AllArgsConstructor
public class DefaultUniversityService implements UniversityService
{
    private final UniversityRepository universityRepository;

    @Override public List<UniversityFull> getAll()
    {
        return universityRepository.getAll();
    }
}
