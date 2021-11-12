package com.drumandbase.dndspellapi.schools;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolRowMapper implements RowMapper<School> {

    @Override
    public School mapRow(ResultSet rs, int rowNum) throws SQLException {
        School school = new School(
                rs.getInt("id"),
                rs.getString("school_name"),
                rs.getString("school_description")
        );

        return school;

    }


}
