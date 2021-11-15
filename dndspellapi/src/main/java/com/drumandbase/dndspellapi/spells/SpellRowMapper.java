package com.drumandbase.dndspellapi.spells;

import com.drumandbase.dndspellapi.schools.School;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpellRowMapper implements RowMapper<Spell> {

    @Override
    public Spell mapRow(ResultSet rs, int rowNum) throws SQLException {
        Spell spell = new Spell(
                rs.getLong("id"),
                rs.getString("spell_name"),
                rs.getString("spell_level"),
                rs.getString("range"),
                rs.getString("components"),
                rs.getString("duration"),
                rs.getBoolean("ritual"),
                rs.getBoolean("canSorcerer"),
                rs.getBoolean("canWizard"),
                rs.getBoolean("canWarlock"),
                rs.getBoolean("canBard"),
                rs.getBoolean("canPaladin"),
                rs.getBoolean("canDruid"),
                rs.getBoolean("canCleric"),
                rs.getBoolean("canRanger")
        );

        return spell;

    }

}
