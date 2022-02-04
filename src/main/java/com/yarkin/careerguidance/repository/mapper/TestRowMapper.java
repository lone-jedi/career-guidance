package com.yarkin.careerguidance.repository.mapper;

import com.yarkin.careerguidance.entity.Test;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestRowMapper implements RowMapper<Test> {
    @Override
    public Test mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");

        return new Test(id, title, description);
    }
}
