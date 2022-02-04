package com.yarkin.careerguidance.repository.question;

import com.yarkin.careerguidance.entity.Question;
import com.yarkin.careerguidance.repository.QuestionRepository;
import com.yarkin.careerguidance.repository.extractor.AnswerExtractor;
import com.yarkin.careerguidance.repository.mapper.QuestionFullRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class DefaultQuestionRepository implements QuestionRepository {
    private static final AnswerExtractor ANSWER_EXTRACTOR = new AnswerExtractor();

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Question> getByTestIdWithAnswers(int testId) {
        return jdbcTemplate.query("""
                        SELECT question.id AS q_id, question.title AS q_title,
                        	   answer.id AS a_id, answer.title AS a_title, weight
                        FROM question
                        LEFT JOIN answer ON question.id = question_id 
                        WHERE question.test_id = :id;""",
                Map.of("id", testId), ANSWER_EXTRACTOR);
    }
}
