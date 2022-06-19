package com.yarkin.careerguidance.repository.exam;

import com.yarkin.careerguidance.entity.exam.Exam;
import com.yarkin.careerguidance.repository.ExamRepository;
import com.yarkin.careerguidance.repository.mapper.ExamRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class DefaultExamRepository implements ExamRepository {
    private static final ExamRowMapper EXAM_ROW_MAPPER = new ExamRowMapper();

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Exam> findAll() {
        return jdbcTemplate.query("SELECT exam_id, title FROM exam;", EXAM_ROW_MAPPER);
    }
}
