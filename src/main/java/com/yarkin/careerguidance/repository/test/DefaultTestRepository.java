package com.yarkin.careerguidance.repository.test;

import com.yarkin.careerguidance.entity.Result;
import com.yarkin.careerguidance.entity.Test;
import com.yarkin.careerguidance.repository.QuestionRepository;
import com.yarkin.careerguidance.repository.SpecialtyRepository;
import com.yarkin.careerguidance.repository.TestRepository;
import com.yarkin.careerguidance.repository.mapper.ResultRowMapper;
import com.yarkin.careerguidance.repository.mapper.TestRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@AllArgsConstructor
public class DefaultTestRepository implements TestRepository {
    private static final TestRowMapper TEST_ROW_MAPPER = new TestRowMapper();
    private static final ResultRowMapper RESULT_ROW_MAPPER = new ResultRowMapper();

    private final QuestionRepository questionRepository;
    private final SpecialtyRepository specialtyRepository;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Test getTestById(int testId) {
        Test test = jdbcTemplate.queryForObject("SELECT id, title, description FROM test WHERE id=:id;",
                Map.of("id", testId), TEST_ROW_MAPPER);
        test.setQuestions(questionRepository.getByTestIdWithAnswers(testId));
        return test;
    }

    @Override
    public Result getTestResult(int testId, double score) {
        Result result = jdbcTemplate.queryForObject("" +
                        " SELECT id, title, description, score_from, score_to FROM result " +
                        " WHERE :score BETWEEN score_from AND score_to; ",
                Map.of("id", testId, "score", score), RESULT_ROW_MAPPER);
        result.setSpecialties(specialtyRepository.getAllByResultId(result.getId()));
        return result;
    }
}
