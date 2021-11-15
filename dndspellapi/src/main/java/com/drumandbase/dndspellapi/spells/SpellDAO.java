package com.drumandbase.dndspellapi.spells;

import java.util.List;
import java.util.Optional;


public interface SpellDAO {

    List<Spell> selectAllSpells();
    Optional<Spell> selectSpellByID(long id);
    Optional<Spell> selectSpellByName(String name);
    int insertSpell(long id, String spell_name, String spell_level, String range, String components, String duration,
                    Boolean ritual, Boolean canSorcerer, Boolean canWizard, Boolean canWarlock, Boolean canBard,
                    Boolean canPaladin, Boolean canDruid, Boolean canCleric, Boolean canRanger);
    int deleteSpell(long id);
    //TODO: updateSpell?


}
