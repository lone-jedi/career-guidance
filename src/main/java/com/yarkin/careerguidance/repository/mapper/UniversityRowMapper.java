package com.yarkin.careerguidance.repository.mapper;

import com.yarkin.careerguidance.entity.University;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UniversityRowMapper implements RowMapper<University> {

    @Override
    public University mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        int id = resultSet.getInt("u_id");
        String title = resultSet.getString("u_title");
        String description = resultSet.getString("u_description");
        double rate = resultSet.getDouble("rate");
        String location = resultSet.getString("location");
        String logo = resultSet.getString("u_logo");

        return new University(id, title, description, rate, logo, location, new ArrayList<>());
    }
}
