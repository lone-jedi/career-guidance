package com.yarkin.careerguidance.repository.mapper;

import com.yarkin.careerguidance.entity.Cathedra;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CathedraRowMapper implements RowMapper<Cathedra> {

    @Override
    public Cathedra mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        int id = resultSet.getInt("c_id");
        String title = resultSet.getString("c_title");
        String description = resultSet.getString("c_description");

        return new Cathedra(id, title, description);
    }
}
