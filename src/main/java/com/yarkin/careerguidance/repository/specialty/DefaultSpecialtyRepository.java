package com.yarkin.careerguidance.repository.specialty;

import com.yarkin.careerguidance.entity.Specialty;
import com.yarkin.careerguidance.repository.SpecialtyRepository;
import com.yarkin.careerguidance.repository.extractor.SpecialtyExtractor;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class DefaultSpecialtyRepository implements SpecialtyRepository {
    private static final SpecialtyExtractor SPECIALTY_EXTRACTOR = new SpecialtyExtractor();
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Specialty> getAllByResultId(int resultId) {
        List<Specialty> specialties = jdbcTemplate.query(
                      " SELECT university.id AS u_id,                             "
                        + "        university.title AS u_title,                       "
                        + "        university.description AS u_description,           "
                        + "        university.logo AS u_logo,                         "
                        + "        university.rate, university.location,              "
                        + "        cathedra.id AS c_id,                               "
                        + "        cathedra.title AS c_title,                         "
                        + "        cathedra.description AS c_description,             "
                        + "        specialty.id AS s_id,                              "
                        + "        specialty.title AS s_title,                        "
                        + "        specialty.description AS s_description             "
                        + " FROM cathedra                                             "
                        + " JOIN university ON university.id = cathedra.university_id "
                        + " JOIN specialty  ON cathedra.specialty_id = specialty.id   "
                        + " JOIN result_specialty ON result_specialty.result_id = :id "
                        + "        AND specialty.id = result_specialty.specialty_id   ",
                Map.of("id", resultId), SPECIALTY_EXTRACTOR);

        return specialties;
    }
}
