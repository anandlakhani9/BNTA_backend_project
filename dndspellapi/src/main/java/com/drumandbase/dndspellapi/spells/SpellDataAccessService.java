package com.drumandbase.dndspellapi.spells;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("spells")
public class SpellDataAccessService implements SpellDAO{


    @Override
    public List<Spell> selectAllSpells() {
        return null;
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
    public int insertSpell(long id, String spell_name, String spell_level, String range, String components, String duration, Boolean ritual, Boolean canSorcerer, Boolean canWizard, Boolean canWarlock, Boolean canBard, Boolean canPaladin, Boolean canDruid, Boolean canCleric, Boolean canRanger) {
        return 0;
    }

    @Override
    public int deleteSpell(long id) {
        return 0;
    }


}
