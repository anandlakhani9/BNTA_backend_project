package com.drumandbase.dndspellapi.spells;

import java.util.List;
import java.util.Optional;


public interface SpellDAO {

    List<Spell> selectAllSpells();
    Optional<Spell> selectSpellByID(long id);
    Optional<Spell> selectSpellByName(String name);
    int updateSpell(long id, String spellName, Integer spellLevel, Integer schoolID, String range, String components, String duration,
                    String description, String higherLevel, Boolean ritual, Boolean canSorcerer, Boolean canWizard,
                    Boolean canWarlock, Boolean canBard, Boolean canPaladin, Boolean canDruid,
                    Boolean canCleric, Boolean canRanger);

    int insertSpell(Spell spell);

    int deleteSpell(long id);

}
