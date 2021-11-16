package com.drumandbase.dndspellapi.characters;

import java.util.List;
import java.util.Optional;

public interface CharacterDAO {

    List<Character> selectAllCharacters();
    Optional<Character> selectCharacterById(Long id);
    int insertCharacter(Character character);
    int deleteCharacter(Long id);
    //int updateCharacter(/* TODO*/);
    void setMax_cantrips_known(int cantrips);
    void setMax_spells_known(int spells);
    void setSpell_slot_1(int spell_slot_1);
    void setSpell_slot_2(int spell_slot_2);
    void setSpell_slot_3(int spell_slot_3);
    void setSpell_slot_4(int spell_slot_4);
    void setSpell_slot_5(int spell_slot_5);
    void setSpell_slot_6(int spell_slot_6);
    void setSpell_slot_7(int spell_slot_7);
    void setSpell_slot_8(int spell_slot_8);
    void setSpell_slot_9(int spell_slot_9);
    void setMax_spell_slot_1(int max_spell_slot_1);
    void setMax_spell_slot_2(int max_spell_slot_2);
    void setMax_spell_slot_3(int max_spell_slot_3);
    void setMax_spell_slot_4(int max_spell_slot_4);
    void setMax_spell_slot_5(int max_spell_slot_5);
    void setMax_spell_slot_6(int max_spell_slot_6);
    void setMax_spell_slot_7(int max_spell_slot_7);
    void setMax_spell_slot_8(int max_spell_slot_8);
    void setMax_spell_slot_9(int max_spell_slot_9);
    void setMax_ivocations_known(int max_ivocation_known);

    //void setMspellsips_known(Integer spellSlot);
}
