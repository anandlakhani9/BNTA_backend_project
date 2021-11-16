package com.drumandbase.dndspellapi.characters;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("character")
public class CharacterDataAccessServer  implements CharacterDAO{

    private JdbcTemplate jdbcTemplate;

    public CharacterDataAccessServer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate =jdbcTemplate;
    }

    // Remember to do inner join
    @Override
    public List<Character> selectAllCharacters() {
        return null;
    }

    @Override
    public Optional<Character> selectCharacterById() {
        return Optional.empty();
    }

    @Override
    public int insertCharacter(Character character) {
        String sql = """
                INSERT INTO characters (race_id, class_id, character_level, name, max_cantrips_known, max_spells_known,
                spell_slot_1, spell_slot_2, spell_slot_3, spell_slot_4, spell_slot_5, spell_slot_6, spell_slot_7, spell_slot_8, spell_slot_9,
                max_spell_slot_1, max_spell_slot_2, max_spell_slot_3, max_spell_slot_4, max_spell_slot_5, max_spell_slot_6, max_spell_slot_7, max_spell_slot_8, max_spell_slot_9)
                VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
                """;
        return jdbcTemplate.update(sql, character.getRace_id(), character.getClass_id(), character.getCharacter_level(), character.getName(), character.getMax_cantrips_known(), character.getMax_spells_known(),
                character.getSpell_slot_1(), character.getSpell_slot_2(), character.getSpell_slot_3(), character.getSpell_slot_4(), character.getSpell_slot_5(), character.getSpell_slot_6(), character.getSpell_slot_7(),
                character.getSpell_slot_8(), character.getSpell_slot_9(), character.getMax_spell_slot_1(), character.getMax_spell_slot_2(), character.getMax_spell_slot_3(), character.getMax_spell_slot_4(), character.getMax_spell_slot_5(), character.getMax_spell_slot_6(),
                character.getMax_spell_slot_7(),character.getMax_spell_slot_8(), character.getMax_spell_slot_9());
    }

    @Override
    public int deleteCharacter(Long id) {
        String sql = """
                DELETE FROM characters WHERE id = ?;
                """;
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int updateCharacter() {
        return 0;
    }
}
