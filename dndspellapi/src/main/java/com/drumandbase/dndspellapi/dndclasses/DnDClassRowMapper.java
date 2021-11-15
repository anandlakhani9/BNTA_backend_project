package com.drumandbase.dndspellapi.dndclasses;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DnDClassRowMapper implements RowMapper<DnDClass> {
    @Override
    public DnDClass mapRow(ResultSet rs, int rowNum) throws SQLException {
        DnDClass dndClass = new DnDClass(
                rs.getInt("id"),
                rs.getString("class_name"),
                rs.getString("class_description")
        );

        return dndClass;

    }
}
