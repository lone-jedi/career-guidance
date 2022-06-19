package com.yarkin.careerguidance.repository.university;

import com.yarkin.careerguidance.entity.University;
import com.yarkin.careerguidance.entity.UniversityFull;
import com.yarkin.careerguidance.repository.UniversityRepository;
import com.yarkin.careerguidance.repository.mapper.ExamRowMapper;
import com.yarkin.careerguidance.repository.mapper.UniversityOneRowMapper;
import com.yarkin.careerguidance.repository.mapper.UniversityRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO: add class / interface description
 *
 * @author OYarkin
 * @since 8.3.0
 */
@Repository
@AllArgsConstructor
public class DefaultUniversityRepository implements UniversityRepository
{
    private static final UniversityOneRowMapper UNIVERSITY_ROW_MAPPER = new UniversityOneRowMapper();

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<UniversityFull> getAll()
    {
        return jdbcTemplate.query(
            "SELECT university_id, title, description, rate, logo, location, website "
              + "FROM university;", UNIVERSITY_ROW_MAPPER);
    }
}
