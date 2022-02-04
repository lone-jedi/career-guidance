package com.yarkin.careerguidance.repository.test;

import com.yarkin.careerguidance.entity.Test;
import com.yarkin.careerguidance.repository.QuestionRepository;
import com.yarkin.careerguidance.repository.TestRepository;
import com.yarkin.careerguidance.repository.mapper.TestRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@AllArgsConstructor
public class DefaultTestRepository implements TestRepository {
    private static final TestRowMapper TEST_ROW_MAPPER = new TestRowMapper();

    private final QuestionRepository questionRepository;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Test getTestById(int testId) {
        Test test = jdbcTemplate.queryForObject("SELECT id, title, description FROM test WHERE id=:id;",
                Map.of("id", testId), TEST_ROW_MAPPER);
        test.setQuestions(questionRepository.getByTestIdWithAnswers(testId));
        return test;
    }
}
