package com.yarkin.careerguidance.repository.mapper;

import com.yarkin.careerguidance.entity.Result;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultRowMapper implements RowMapper<Result> {
    @Override
    public Result mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");

        return new Result(id, title, description);
    }
}
