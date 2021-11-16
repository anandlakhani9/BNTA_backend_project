package com.drumandbase.dndspellapi.characterSpells;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//this is a display object so a frontend can display the desired fields
public class SpellbookDisplayRowMapper implements RowMapper {
    @Override
    public SpellbookDisplay mapRow(ResultSet rs, int rowNum) throws SQLException {
        SpellbookDisplay sd = new SpellbookDisplay(
                //select character_spells.id as csID
                rs.getLong("csID"),
                rs.getString("character_name"),
                rs.getString("character_level"),
                rs.getString("spell_name"),
                rs.getInt("spell_level"),
                rs.getString("school_name"),
                rs.getString("range"),
                rs.getString("components"),
                rs.getString("duration"),
                rs.getString("description"),
                rs.getString("higher_level"),
                rs.getBoolean("ritual")
        );
        return sd;
    }
}
