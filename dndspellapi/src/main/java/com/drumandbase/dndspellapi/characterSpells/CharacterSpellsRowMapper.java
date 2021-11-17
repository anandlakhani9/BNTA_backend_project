package com.drumandbase.dndspellapi.characterSpells;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CharacterSpellsRowMapper implements RowMapper{
    @Override
    public CharacterSpells mapRow(ResultSet rs, int rowNum) throws SQLException {
        CharacterSpells cSpell = new CharacterSpells(
                rs.getLong("id"),
                rs.getLong("character_id"),
                rs.getLong("spell_id"),
                rs.getBoolean("spell_is_known")
        );
        return cSpell;
    }
}
