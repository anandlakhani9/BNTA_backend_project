package com.drumandbase.dndspellapi.characterSpells;

import java.util.List;

public interface CharacterSpellsDAO {
    List<SpellbookDisplay> selectAllSpellsByCharacterID(long id);
//    int insertSpell(long characterID, long spellID);
    int insertSpell(CharacterSpells cs);
    int deleteSpell(long id);
    //int updateSpell(long id, long characterId, long spellID);
}
