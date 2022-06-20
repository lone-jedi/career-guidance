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
                      " SELECT university.university_id,                                 "
                        + "        university.title ,                                        "
                        + "        university.description ,                                  "
                        + "        university.logo ,                                         "
                        + "        university.rate, university.location, university.website, "
                        + "        cathedra.cathedra_id AS c_id,                             "
                        + "        cathedra.title AS c_title,                                "
                        + "        cathedra.description AS c_description,                    "
                        + "        specialty.specialty_id AS s_id,                           "
                        + "        specialty.title AS s_title,                               "
                        + "        specialty.description AS s_description                    "
                        + " FROM cathedra                                                    "
                        + " JOIN university                                                  "
                        + "  ON university.university_id = cathedra.university_id            "
                        + " JOIN cathedra_specialty                                          "
                        + "   ON cathedra.cathedra_id = cathedra_specialty.cathedra_id       "
                        + " JOIN specialty                                                   "
                        + "   ON specialty.specialty_id = cathedra_specialty.specialty_id    "
                        + " JOIN result_specialty ON result_specialty.result_id = :id        "
                        + "   AND specialty.specialty_id = result_specialty.specialty_id     ",
                Map.of("id", resultId), SPECIALTY_EXTRACTOR);

        return specialties;
    }
}
