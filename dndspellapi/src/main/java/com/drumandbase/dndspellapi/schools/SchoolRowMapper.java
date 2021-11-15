package com.drumandbase.dndspellapi.schools;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/* This class classifies the columns of a given row
* Created by Oliver, Sabi, Rose and Anand.
* */
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
