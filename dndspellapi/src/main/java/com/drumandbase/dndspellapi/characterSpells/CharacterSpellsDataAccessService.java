package com.drumandbase.dndspellapi.characterSpells;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("spellbook")
public class CharacterSpellsDataAccessService implements CharacterSpellsDAO{
    private JdbcTemplate jdbcTemplate;


    public CharacterSpellsDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //select the characterSpellID as csID
    @Override
    public List<SpellbookDisplay> selectAllSpellsByCharacterID(long id) {
        String sql = """
                SELECT 
                    character_spells.id as csID,
                    characters.name as character_name,
                    characters.character_level,
                    spells.spell_name,
                    spells.spell_level,
                    schools.school_name,
                    spells.range,
                    spells.components,
                    spells.duration,
                    spells.description,
                    spells.higher_level,
                    spells.ritual
                FROM characters
                INNER JOIN character_spells
                ON character_spells.character_id = characters.id
                INNER JOIN spells
                ON character_spells.spell_id = spells.id
                INNER JOIN schools
                ON schools.id = spells.school_id
                WHERE characters.id = ?;
                """;

        return jdbcTemplate.query(sql, new SpellbookDisplayRowMapper(), id);
    }

    @Override
    public List<CharacterSpells> selectAllCharacterSpellsByCharacterID(long id) {
        String sql = """
                SELECT * FROM character_spells
                WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new CharacterSpellsRowMapper(), id);
    }

    @Override
    public int insertSpell(CharacterSpells cs) {
    //public int insertSpell(long characterID, long spellID) {
        String sql = """
                INSERT INTO character_spells (character_id, spell_id, spell_is_known)
                VALUES (?, ?,?);
                """;
        return jdbcTemplate.update(sql, cs.getCharacterID(), cs.getSpellID(), cs.getSpellIsKnown());
    }

    @Override
    public int deleteSpell(long id) {
        String sql = """
                DELETE FROM character_spells
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }

    /*@Override
    public int updateSpell(long id, long characterId, long spellID) {
        return 0;
    }*/
}
