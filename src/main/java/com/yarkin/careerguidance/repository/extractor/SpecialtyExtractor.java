package com.yarkin.careerguidance.repository.extractor;

import com.yarkin.careerguidance.entity.Cathedra;
import com.yarkin.careerguidance.entity.Specialty;
import com.yarkin.careerguidance.entity.University;
import com.yarkin.careerguidance.entity.UniversityFull;
import com.yarkin.careerguidance.repository.mapper.CathedraRowMapper;
import com.yarkin.careerguidance.repository.mapper.SpecialtyRowMapper;
import com.yarkin.careerguidance.repository.mapper.UniversityOneRowMapper;
import com.yarkin.careerguidance.repository.mapper.UniversityRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialtyExtractor implements ResultSetExtractor<List<Specialty>> {
    private final UniversityOneRowMapper universityRowMapper = new UniversityOneRowMapper();
    private final CathedraRowMapper cathedraRowMapper = new CathedraRowMapper();
    private final SpecialtyRowMapper specialtyRowMapper = new SpecialtyRowMapper();

    @Override
    public List<Specialty> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Specialty> specialties = new ArrayList<>();
        int lastSpecialtyListId = -1;
        int lastUniversityListId = -1;

        while (resultSet.next()) {
            Specialty specialty = specialtyRowMapper.mapRow(resultSet, -1);

            if (!specialties.contains(specialty)) {
                specialties.add(specialty);
                lastSpecialtyListId++;
                lastUniversityListId = -1;
            }

            UniversityFull university = universityRowMapper.mapRow(resultSet, -1);

            if (!specialties.get(lastSpecialtyListId).getUniversities().contains(university)) {
                specialties.get(lastSpecialtyListId).getUniversities().add(university);
                lastUniversityListId++;
            }

            Cathedra cathedra = cathedraRowMapper.mapRow(resultSet, -1);

            specialties.get(lastSpecialtyListId)
                    .getUniversities()
                    .get(lastUniversityListId)
                    .getCathedraList()
                    .add(cathedra);
        }

        return specialties;
    }
}
