package com.drumandbase.dndspellapi.spells;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("spells")
public class SpellDataAccessService implements SpellDAO{

    private JdbcTemplate jdbcTemplate;

    public SpellDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Spell> selectAllSpells() {
        String sql = """
                     SELECT * FROM spells;
                     """;

        return jdbcTemplate.query(sql, new SpellRowMapper());
    }

    @Override
    public Optional<Spell> selectSpellByID(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Spell> selectSpellByName(String name) {
        return Optional.empty();
    }

    @Override
    public int updateSpell(long id, String spellName, Integer spellLevel,Integer schoolID, String range, String components, String duration, String description, String higherLevel, Boolean ritual, Boolean canSorcerer, Boolean canWizard, Boolean canWarlock, Boolean canBard, Boolean canPaladin, Boolean canDruid, Boolean canCleric, Boolean canRanger) {
        String sql ="""
                UPDATE spells 
                SET 
                spell_name = ?, 
                spell_level = ?, 
                school_id = ?, 
                range = ?, 
                components = ?,
                duration = ?, 
                description = ?, 
                higherLevel = ?, 
                ritual = ?, 
                canSorcerer = ?,
                canWizard = ?,
                canWarlock = ?,
                canBard = ?,
                canPaladin = ?,  
                canDruid = ?,
                canCleric = ?, 
                canRanger = ?,
                WHERE id = ?;
                """;

        return jdbcTemplate.update(sql,
                spellName,
                spellLevel,
                schoolID,
                range,
                components,
                duration,
                description,
                higherLevel,
                ritual,
                canSorcerer,
                canWizard,
                canWarlock,
                canBard,
                canPaladin,
                canDruid,
                canCleric,
                canRanger,
                id);
    }

    @Override
    public int insertSpell(Spell spell) {
        String sql = """
                    INSERT INTO spells (
                    spell_name, 
                    spell_level, 
                    school_id,
                    range, 
                    components, 
                    duration, 
                    description, 
                    higher_level,
                     ritual, 
                     canSorcerer, 
                     canWizard, 
                     canWarlock, 
                     canBard,
                      canPaladin, 
                      canDruid, 
                      canCleric, 
                      canRanger ) 
                    VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);
                """;

        return jdbcTemplate.update(sql,
                spell.getSpellName(),
                spell.getSpellLevel(),
                spell.getSchoolID(),
                spell.getRange(),
                spell.getComponents(),
                spell.getDuration(),
                spell.getDescription(),
                spell.getHigherLevel(),
                spell.getRitual(),
                spell.getCanSorcerer(),
                spell.getCanWizard(),
                spell.getCanWarlock(),
                spell.getCanBard(),
                spell.getCanPaladin(),
                spell.getCanDruid(),
                spell.getCanCleric(),
                spell.getCanRanger()
        );
    }

    @Override
    public int deleteSpell(long id) {
        String sql = """
                    DELETE FROM spells WHERE id = ?; 
                """;

        return jdbcTemplate.update(sql, id);
    };

}
//    @Override
//    public int updateSpell(String spellName, int spellLevel, int spellId, String range, String components, String duration,
//                            String description, String higherLevel, Boolean ritual, Boolean canSorcerer, Boolean canWizard,
//                            Boolean canWarlock, Boolean canBard, Boolean canPaladin, Boolean canDruid,
//                            Boolean canCleric, Boolean canRanger, long id) {
//        String sql ="""
//                UPDATE spells
//                SET school_name = ?,
//                school_level = ?,
//                spell_id = ?,
//                range = ?,
//                components = ?,
//                duration = ?,
//                description = ?,
//                higherLevel = ?,
//                ritual = ?,
//                canSorcerer = ?,
//                canWizard = ?,
//                canCleric = ?,
//                canBard = ?,
//                canPaladin = ?,
//                canDruid = ?,
//                canCleric = ?,
//                canRanger = ?,
//                WHERE id = ?;
//                """;
//
//        return jdbcTemplate.update(sql,
//                spellName,
//                spellLevel,
//                spellId,
//                range,
//                components,
//                duration,
//                description,
//                higherLevel,
//                ritual,
//                canSorcerer,
//                canWizard,
//                canWarlock,
//                canBard,
//                canPaladin,
//                canDruid,
//                canCleric,
//                canRanger,
//                id);
//    }
//
//}
