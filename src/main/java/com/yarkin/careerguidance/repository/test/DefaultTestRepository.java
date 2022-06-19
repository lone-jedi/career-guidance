package com.yarkin.careerguidance.repository.test;

import com.yarkin.careerguidance.entity.Result;
import com.yarkin.careerguidance.entity.ResultFull;
import com.yarkin.careerguidance.entity.Test;
import com.yarkin.careerguidance.repository.QuestionRepository;
import com.yarkin.careerguidance.repository.SpecialtyRepository;
import com.yarkin.careerguidance.repository.TestRepository;
import com.yarkin.careerguidance.repository.extractor.ResultExtractor;
import com.yarkin.careerguidance.repository.mapper.ResultRowMapper;
import com.yarkin.careerguidance.repository.mapper.TestRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class DefaultTestRepository implements TestRepository {
    private static final TestRowMapper TEST_ROW_MAPPER = new TestRowMapper();
    private static final ResultRowMapper RESULT_ROW_MAPPER = new ResultRowMapper();
    private static final ResultExtractor RESULT_EXTRACTOR = new ResultExtractor();

    private final QuestionRepository questionRepository;
    private final SpecialtyRepository specialtyRepository;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Test getTestById(int testId) {
        Test test = jdbcTemplate.queryForObject("SELECT test_id, title, description FROM test WHERE test_id=:id;",
                Map.of("id", testId), TEST_ROW_MAPPER);
        test.setQuestions(questionRepository.getByTestIdWithAnswers(testId));
        return test;
    }

    @Override
    public Result getTestResult(int testId, double score) {
        Result result = jdbcTemplate.queryForObject("" +
                        " SELECT result_id, title, description, score_from, score_to FROM result " +
                        " WHERE :score BETWEEN score_from AND score_to; ",
                Map.of("id", testId, "score", score), RESULT_ROW_MAPPER);
        result.setSpecialties(specialtyRepository.getAllByResultId(result.getResultId()));
        return result;
    }

    @Override
    public ResultFull getTestResult(int testId, int[] answersIds)
    {
        String inArray = Arrays.stream(answersIds)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(", "));

        String sql = String.format(""
            + "SELECT result.result_id, result.title, result.description, "
            + "       COUNT(result.result_id) AS answers_count            "
            + "FROM result                                                "
            + "JOIN answer ON answer.result_id = result.result_id         "
            + "WHERE answer_id IN (%s)                            "
            + "GROUP BY result.result_id                                  "
            + "ORDER BY COUNT(result.result_id) DESC                      ",
            inArray);

        ResultFull resultFull = jdbcTemplate.query(sql, RESULT_EXTRACTOR);
        resultFull.setSpecialties(specialtyRepository.getAllByResultId(resultFull.getResultId()));
        return resultFull;
    }
}
