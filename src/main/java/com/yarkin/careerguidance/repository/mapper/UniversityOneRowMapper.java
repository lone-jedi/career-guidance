package com.yarkin.careerguidance.repository.mapper;

import com.yarkin.careerguidance.entity.University;
import com.yarkin.careerguidance.entity.UniversityFull;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * TODO: add class / interface description
 *
 * @author OYarkin
 */
public class UniversityOneRowMapper implements RowMapper<UniversityFull>
{
    @Override
    public UniversityFull mapRow(ResultSet resultSet, int rowNumber) throws SQLException
    {
        int id = resultSet.getInt("university_id");
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        double rate = resultSet.getDouble("rate");
        String location = resultSet.getString("location");
        String logo = resultSet.getString("logo");
        String website = resultSet.getString("website");

        return new UniversityFull(id, title, description, rate, logo, location, website, new ArrayList<>());
    }
}
