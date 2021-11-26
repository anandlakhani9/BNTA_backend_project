package com.drumandbase.dndspellapi.DNDRaces;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RaceRowMapper implements RowMapper<Race> {

    @Override
    public Race mapRow(ResultSet rs, int rowNum) throws SQLException {
        Race race = new Race(
                rs.getInt("id"),
                rs.getString("race_name"),
                rs.getString("race_description")
        );

        return race;

    }


}

