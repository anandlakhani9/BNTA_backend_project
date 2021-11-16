package com.drumandbase.dndspellapi.characters;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CharacterRowMapper implements RowMapper<Character> {
    @Override
    public Character mapRow(ResultSet rs, int rowNum) throws SQLException {
        Character character = new Character(
                rs.getLong("id"),
                rs.getInt("race_id"),
                rs.getInt("class_id"),
                rs.getInt("character_level"),
                rs.getString("name"),
                rs.getInt("max_cantrips_known"),
                rs.getInt("max_spells_known"),
                rs.getInt("spell_slot_1"),
                rs.getInt("spell_slot_2"),
                rs.getInt("spell_slot_3"),
                rs.getInt("spell_slot_4"),
                rs.getInt("spell_slot_5"),
                rs.getInt("spell_slot_6"),
                rs.getInt("spell_slot_7"),
                rs.getInt("spell_slot_8"),
                rs.getInt("spell_slot_9"),
                rs.getInt("max_spell_slot_1"),
                rs.getInt("max_spell_slot_2"),
                rs.getInt("max_spell_slot_3"),
                rs.getInt("max_spell_slot_4"),
                rs.getInt("max_spell_slot_5"),
                rs.getInt("max_spell_slot_6"),
                rs.getInt("max_spell_slot_7"),
                rs.getInt("max_spell_slot_8"),
                rs.getInt("max_spell_slot_9"),
                rs.getInt("max_ivocations_known")
        );
        return character;



    }

}
