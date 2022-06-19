package com.yarkin.careerguidance.repository.mapper;

import com.yarkin.careerguidance.entity.exam.Exam;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamRowMapper implements RowMapper<Exam> {
    @Override
    public Exam mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        int id = resultSet.getInt("exam_id");
        String title = resultSet.getString("title");
        return new Exam(id, title);
    }
}
