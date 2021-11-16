package com.drumandbase.dndspellapi.spells;

import java.util.List;
import java.util.Optional;


public interface SpellDAO {

    List<Spell> selectAllSpells();
    Optional<Spell> selectSpellByID(long id);
    Optional<Spell> selectSpellByName(String name);

    int insertSpell(Spell spell);

    int deleteSpell(long id);
    //TODO: updateSpell?


}
