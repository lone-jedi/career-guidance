package com.yarkin.careerguidance.repository.mapper;

import com.yarkin.careerguidance.entity.Specialty;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SpecialtyRowMapper implements RowMapper<Specialty> {

    @Override
    public Specialty mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        int id = resultSet.getInt("s_id");
        String title = resultSet.getString("s_title");
        String description = resultSet.getString("s_description");

        return new Specialty(id, title, description, new ArrayList<>());
    }
}
