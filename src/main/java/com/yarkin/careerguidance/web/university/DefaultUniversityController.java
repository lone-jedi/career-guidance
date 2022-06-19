package com.yarkin.careerguidance.web.university;

import com.yarkin.careerguidance.entity.UniversityFull;
import com.yarkin.careerguidance.service.UniversityService;
import com.yarkin.careerguidance.web.UniversityController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO: add class / interface description
 *
 * @author OYarkin
 */
@RestController
@RequestMapping(path = "/api/v1/universities")
@RequiredArgsConstructor
public class DefaultUniversityController implements UniversityController
{
    private final UniversityService universityService;

    @Override
    @GetMapping
    public List<UniversityFull> getAll()
    {
        return universityService.getAll();
    }
}
