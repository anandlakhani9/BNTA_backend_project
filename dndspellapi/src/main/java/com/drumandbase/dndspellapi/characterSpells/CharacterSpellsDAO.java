package com.drumandbase.dndspellapi.characterSpells;

import com.drumandbase.dndspellapi.characters.Character;

import java.util.List;
import java.util.Optional;

public interface CharacterSpellsDAO {
    Optional<CharacterSpells> getRecord(long id);
    List<SpellbookDisplay> selectAllSpellsByCharacterID(long id);
    List<CharacterSpells> selectAllCharacterSpellsByCharacterID(long id);
//    int insertSpell(long characterID, long spellID);
    int insertSpell(CharacterSpells cs);
    int deleteSpell(long id);
    //int updateSpell(long id, long characterId, long spellID);
}
