package com.drumandbase.dndspellapi.characters;

import com.drumandbase.dndspellapi.dndclasses.DnDClass;
import com.drumandbase.dndspellapi.dndclasses.DnDClassController;
import com.drumandbase.dndspellapi.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CharacterService{

    private final CharacterDAO characterDAO;
    private HashMap<Integer,Integer[]> spellMap;

    private DnDClassController dnDClassController;

    @Autowired
    public CharacterService(@Qualifier("character") CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    public List<Character> getCharacters() {
        return characterDAO.selectAllCharacters();
    }

    public Optional<Character> getCharacter(Long id) {
        return characterDAO.selectCharacterById(id);
    }

    public void addCharacter(Character character) {
        if (character.getName() != null && character.getName().trim().length() > 0 && character.getRace_id() > 0 && character.getClass_id()> 0 && character.getCharacter_level() > 0) {
            characterDAO.insertCharacter(character);
        } else {
            throw new NullPointerException("Must contain valid variables");
        }
    }

    public void updateCharacter(/*TODO: */) {
        Character character = getCharacter(id)
                .orElseThrow(() ->
                        new ResourceNotFound("Character with this id: " + id + " does not exist")
                );
        if (/*TODO: this is going to be terrible: every single spell slot*/){
            /*whichever thing they're updating*/
        }
    }

    public void deleteCharacter(Long id) {
        Character character = getCharacter(id)
                .orElseThrow(() ->
                new ResourceNotFound("Character with this id: " + id + " does not exist")
        );
        characterDAO.deleteCharacter(id);
    }


    public void putSpellSlots(Character character){
        createSpellSlotHashMap(character);
        Integer[] spellSlots = spellMap.get(character.getCharacter_level());
        character.setMax_cantrips_known(spellSlots[0]);
        character.setMax_spells_known(spellSlots[1]);

        character.setMax_spell_slot_1(spellSlots[2]);
        character.setSpell_slot_1(spellSlots[2]);
        character.setMax_spell_slot_2(spellSlots[3]);
        character.setSpell_slot_2(spellSlots[3]);
        character.setMax_spell_slot_3(spellSlots[4]);
        character.setSpell_slot_3(spellSlots[4]);
        character.setMax_spell_slot_4(spellSlots[5]);
        character.setSpell_slot_4(spellSlots[5]);
        character.setMax_spell_slot_5(spellSlots[6]);
        character.setSpell_slot_5(spellSlots[6]);
        character.setMax_spell_slot_6(spellSlots[7]);
        character.setSpell_slot_6(spellSlots[7]);
        character.setMax_spell_slot_7(spellSlots[8]);
        character.setSpell_slot_7(spellSlots[8]);
        character.setMax_spell_slot_8(spellSlots[9]);
        character.setSpell_slot_8(spellSlots[9]);
        character.setMax_spell_slot_9(spellSlots[10]);
        character.setSpell_slot_9(spellSlots[10]);
        }

    }
    // use Character set methods for spell slots
//    public void initSpellSlots(int character_level, int class_id){
//
//        this.spellMap = new HashMap<>();
//
//        DnDClass dnDClass = dnDClassController.getDnDClassesById(class_id)
//                .orElseThrow(() ->
//                        new ResourceNotFound("class_id does not match any class")
//                );
//        String name = dnDClass.getClass_name();
//
//
//        if (name.equals("Sorcerer")) {
//            HashMap<Integer,Integer[]> sorcererMap = new HashMap<Integer, Integer[]>();
//            sorcererMap.put(1, new Integer[]{4, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0});
//            sorcererMap.put(2, new Integer[]{4,3,3,0,0,0,0,0,0,0,0});
//            sorcererMap.put(3, new Integer[]{4,4,4,2,0,0,0,0,0,0,0});
//            sorcererMap.put(4, new Integer[]{5,5,4,3,0,0,0,0,0,0,0});
//            sorcererMap.put(5, new Integer[]{5,6,4,3,2,0,0,0,0,0,0});
//            sorcererMap.put(6, new Integer[]{5,7,4,3,3,0,0,0,0,0,0});
//            sorcererMap.put(7, new Integer[]{5,8,4,3,3,1,0,0,0,0,0});
//            sorcererMap.put(8, new Integer[]{5,9,4,3,3,2,0,0,0,0,0});
//            sorcererMap.put(9, new Integer[]{5,10,4,3,3,3,1,0,0,0,0});
//            sorcererMap.put(10, new Integer[]{6,11,4,3,3,3,2,0,0,0,0});
//            sorcererMap.put(11, new Integer[]{6,12,4,3,3,3,2,1,0,0,0});
//            sorcererMap.put(12, new Integer[]{6,12,4,3,3,3,2,1,0,0,0});
//            sorcererMap.put(13, new Integer[]{6,13,4,3,3,3,2,1,1,0,0});
//            sorcererMap.put(14, new Integer[]{6,13,4,3,3,3,2,1,1,0,0});
//            sorcererMap.put(15, new Integer[]{6,14,4,3,3,3,2,1,1,1,0});
//            sorcererMap.put(16, new Integer[]{6,14,4,3,3,3,2,1,1,1,0});
//            sorcererMap.put(17, new Integer[]{6,15,4,3,3,3,2,1,1,1,1});
//            sorcererMap.put(18, new Integer[]{6,15,4,3,3,3,3,1,1,1,1});
//            sorcererMap.put(19, new Integer[]{6,15,4,3,3,3,3,2,1,1,1});
//            sorcererMap.put(20, new Integer[]{6,15,4,3,3,3,3,2,2,1,1});
//
//        } else if (name.equals("The Bard")) {
//            HashMap<Integer,Integer[]> bardMap = new HashMap<Integer, Integer[]>();
//            bardMap.put(1, new Integer[]{2,4,2,0,0,0,0,0,0,0,0});
//            bardMap.put(2, new Integer[]{2,5,3,0,0,0,0,0,0,0,0});
//            bardMap.put(3, new Integer[]{2,6,4,2,0,0,0,0,0,0,0});
//            bardMap.put(4, new Integer[]{3,7,4,3,0,0,0,0,0,0,0});
//            bardMap.put(5, new Integer[]{3,8,4,3,2,0,0,0,0,0,0});
//            bardMap.put(6, new Integer[]{3,9,4,3,3,0,0,0,0,0,0});
//            bardMap.put(7, new Integer[]{3,10,4,3,3,1,0,0,0,0,0});
//            bardMap.put(8, new Integer[]{3,11,4,3,3,2,0,0,0,0,0});
//            bardMap.put(9, new Integer[]{3,12,4,3,3,3,1,0,0,0,0});
//            bardMap.put(10, new Integer[]{4,14,4,3,3,3,2,0,0,0,0});
//            bardMap.put(11, new Integer[]{4,15,4,3,3,3,2,1,0,0,0});
//            bardMap.put(12, new Integer[]{4,15,4,3,3,3,2,1,0,0,0});
//            bardMap.put(13, new Integer[]{4,16,4,3,3,3,2,1,1,0,0});
//            bardMap.put(14, new Integer[]{4,18,4,3,3,3,2,1,1,0,0});
//            bardMap.put(15, new Integer[]{4,19,4,3,3,3,2,1,1,1,0});
//            bardMap.put(16, new Integer[]{4,19,4,3,3,3,2,1,1,1,0});
//            bardMap.put(17, new Integer[]{4,20,4,3,3,3,2,1,1,1,1});
//            bardMap.put(18, new Integer[]{4,22,4,3,3,3,3,1,1,1,1});
//            bardMap.put(19, new Integer[]{4,22,4,3,3,3,3,2,1,1,1});
//            bardMap.put(20, new Integer[]{4,22,4,3,3,3,3,2,2,1,1});
//        } else if (name.equals("Warlock")) {
//            //Might have to add another row to characters for evocations
//            HashMap<Integer, Integer[]> rangerMap = new HashMap<Integer, Integer[]>();
//            rangerMap.put(1, new Integer[]{2,2,1,0,0,0,0,0,0,0,0});
//            rangerMap.put(2, new Integer[]{2,3,2,0,0,0,0,0,0,0,0});
//            rangerMap.put(3, new Integer[]{2,4,0,2,0,0,0,0,0,0,0});
//            rangerMap.put(4, new Integer[]{3,5,0,2,0,0,0,0,0,0,0});
//            rangerMap.put(5, new Integer[]{3,6,0,0,2,0,0,0,0,0,0});
//            rangerMap.put(6, new Integer[]{3,7,0,0,2,0,0,0,0,0,0});
//            spellMap.put(7, new Integer[]{3,8,0,0,0,2,0,0,0,0,0});
//            spellMap.put(8, new Integer[]{3,9,0,0,0,2,0,0,0,0,0});
//            spellMap.put(9, new Integer[]{3,10,0,0,0,0,2,0,0,0,0});
//            spellMap.put(10, new Integer[]{4,10,0,0,0,0,2,0,0,0,0});
//            spellMap.put(11, new Integer[]{4,11,0,0,0,0,3,0,0,0,0});
//            spellMap.put(12, new Integer[]{4,11,0,0,0,0,3,0,0,0,0});
//            spellMap.put(13, new Integer[]{4,12,0,0,0,0,3,0,0,0,0});
//            spellMap.put(14, new Integer[]{4,12,0,0,0,0,3,0,0,0,0});
//            spellMap.put(15, new Integer[]{4,13,0,0,0,0,3,0,0,0,0});
//            spellMap.put(16, new Integer[]{4,13,0,0,0,0,3,0,0,0,0});
//            spellMap.put(17, new Integer[]{4,14,0,0,0,0,4,0,0,0,0});
//            spellMap.put(18, new Integer[]{4,14,0,0,0,0,4,0,0,0,0});
//            spellMap.put(19, new Integer[]{4,15,0,0,0,0,4,0,0,0,0});
//            spellMap.put(20, new Integer[]{4,15,0,0,0,0,4,0,0,0,0});
//
//        } else if (name.equals("The Ranger")) {
//            HashMap<Integer,Integer[]> spellMap = new HashMap<Integer, Integer[]>();
//            spellMap.put(1, new Integer[]{0,0,0,0,0,0,0,0,0,0,0});
//            spellMap.put(2, new Integer[]{0,2,2,0,0,0,0,0,0,0,0});
//            spellMap.put(3, new Integer[]{0,3,3,0,0,0,0,0,0,0,0});
//            spellMap.put(4, new Integer[]{0,3,3,0,0,0,0,0,0,0,0});
//            spellMap.put(5, new Integer[]{0,4,4,2,0,0,0,0,0,0,0});
//            spellMap.put(6, new Integer[]{0,4,4,2,0,0,0,0,0,0,0});
//            spellMap.put(7, new Integer[]{0,5,4,3,0,0,0,0,0,0,0});
//            spellMap.put(8, new Integer[]{0,5,4,3,0,0,0,0,0,0,0});
//            spellMap.put(9, new Integer[]{0,6,4,3,2,0,0,0,0,0,0});
//            spellMap.put(10, new Integer[]{0,6,4,3,2,0,0,0,0,0,0});
//            spellMap.put(11, new Integer[]{0,7,4,3,3,0,0,0,0,0,0});
//            spellMap.put(12, new Integer[]{0,7,4,3,3,0,0,0,0,0,0});
//            spellMap.put(13, new Integer[]{0,8,4,3,3,1,0,0,0,0,0});
//            spellMap.put(14, new Integer[]{0,8,4,3,3,1,0,0,0,0,0});
//            spellMap.put(15, new Integer[]{0,9,4,3,3,2,0,0,0,0,0});
//            spellMap.put(16, new Integer[]{0,9,4,3,3,2,0,0,0,0,0});
//            spellMap.put(17, new Integer[]{0,10,4,3,3,3,1,0,0,0,0});
//            spellMap.put(18, new Integer[]{0,10,4,3,3,3,1,0,0,0,0});
//            spellMap.put(19, new Integer[]{0,11,4,3,3,3,2,0,0,0,0});
//            spellMap.put(20, new Integer[]{0,11,4,3,3,3,2,0,0,0,0});
//
//
//        } else if (name.equals("Cleric")) {
//            HashMap<Integer,Integer[]> clericMap = new HashMap<Integer, Integer[]>();
//            clericMap.put(1, new Integer[]{3,0,2,0,0,0,0,0,0,0,0});
//            clericMap.put(2, new Integer[]{3,0,3,0,0,0,0,0,0,0,0});
//            clericMap.put(3, new Integer[]{3,0,4,2,0,0,0,0,0,0,0});
//            clericMap.put(4, new Integer[]{4,0,4,3,0,0,0,0,0,0,0});
//            clericMap.put(5, new Integer[]{4,0,4,3,2,0,0,0,0,0,0});
//            clericMap.put(6, new Integer[]{4,0,4,3,3,0,0,0,0,0,0});
//            clericMap.put(7, new Integer[]{4,0,4,3,3,1,0,0,0,0,0});
//            clericMap.put(8, new Integer[]{4,0,4,3,3,2,0,0,0,0,0});
//            clericMap.put(9, new Integer[]{4,0,4,3,3,3,1,0,0,0,0});
//            clericMap.put(10, new Integer[]{5,0,4,3,3,3,2,0,0,0,0});
//            clericMap.put(11, new Integer[]{5,0,4,3,3,3,2,1,0,0,0});
//            clericMap.put(12, new Integer[]{5,0,4,3,3,3,2,1,0,0,0});
//            clericMap.put(13, new Integer[]{5,0,4,3,3,3,2,1,1,0,0});
//            clericMap.put(14, new Integer[]{5,0,4,3,3,3,2,1,1,0,0});
//            clericMap.put(15, new Integer[]{5,0,4,3,3,3,2,1,1,1,0});
//            clericMap.put(16, new Integer[]{5,0,4,3,3,3,2,1,1,1,0});
//            clericMap.put(17, new Integer[]{5,0,4,3,3,3,2,1,1,1,1});
//            clericMap.put(18, new Integer[]{5,0,4,3,3,3,3,1,1,1,1});
//            clericMap.put(19, new Integer[]{5,0,4,3,3,3,3,2,1,1,1});
//            clericMap.put(20, new Integer[]{5,0,4,3,3,3,3,2,2,1,1});
//
//
//        } else if (name.equals("Druid")) {
//            HashMap<Integer,Integer[]> druidMap = new HashMap<Integer, Integer[]>();
//            druidMap.put(1, new Integer[]{2,0,2,0,0,0,0,0,0,0,0});
//            druidMap.put(2, new Integer[]{2,0,3,0,0,0,0,0,0,0,0});
//            druidMap.put(3, new Integer[]{2,0,4,2,0,0,0,0,0,0,0});
//            druidMap.put(4, new Integer[]{3,0,4,3,0,0,0,0,0,0,0});
//            druidMap.put(5, new Integer[]{3,0,4,3,2,0,0,0,0,0,0});
//            druidMap.put(6, new Integer[]{3,0,4,3,3,0,0,0,0,0,0});
//            druidMap.put(7, new Integer[]{3,0,4,3,3,1,0,0,0,0,0});
//            druidMap.put(8, new Integer[]{3,0,4,3,3,2,0,0,0,0,0});
//            druidMap.put(9, new Integer[]{3,0,4,3,3,3,1,0,0,0,0});
//            druidMap.put(10, new Integer[]{4,0,4,3,3,3,2,0,0,0,0});
//            druidMap.put(11, new Integer[]{4,0,4,3,3,3,2,1,0,0,0});
//            druidMap.put(12, new Integer[]{4,0,4,3,3,3,2,1,0,0,0});
//            druidMap.put(13, new Integer[]{4,0,4,3,3,3,2,1,1,0,0});
//            druidMap.put(14, new Integer[]{4,0,4,3,3,3,2,1,1,0,0});
//            druidMap.put(15, new Integer[]{4,0,4,3,3,3,2,1,1,1,0});
//            druidMap.put(16, new Integer[]{4,0,4,3,3,3,2,1,1,1,0});
//            druidMap.put(17, new Integer[]{4,0,4,3,3,3,3,1,1,1,1});
//            druidMap.put(18, new Integer[]{4,0,4,3,3,3,3,1,1,1,1});
//            druidMap.put(19, new Integer[]{4,0,4,3,3,3,3,2,1,1,1});
//            druidMap.put(20, new Integer[]{4,0,4,3,3,3,3,2,2,1,1});
//
//        } else if (name.equals("Paladin")) {
//            HashMap<Integer,Integer[]> paladinMap = new HashMap<Integer, Integer[]>();
//            paladinMap.put(1, new Integer[]{0,0,0,0,0,0,0,0,0,0,0});
//            paladinMap.put(2, new Integer[]{0,0,2,0,0,0,0,0,0,0,0});
//            paladinMap.put(3, new Integer[]{0,0,3,0,0,0,0,0,0,0,0});
//            paladinMap.put(4, new Integer[]{0,0,3,0,0,0,0,0,0,0,0});
//            paladinMap.put(5, new Integer[]{0,0,4,2,0,0,0,0,0,0,0});
//            paladinMap.put(6, new Integer[]{0,0,4,2,0,0,0,0,0,0,0});
//            paladinMap.put(7, new Integer[]{0,0,4,3,0,0,0,0,0,0,0});
//            paladinMap.put(8, new Integer[]{0,0,4,3,0,0,0,0,0,0,0});
//            paladinMap.put(9, new Integer[]{0,0,4,3,2,0,0,0,0,0,0});
//            paladinMap.put(10, new Integer[]{0,0,4,3,2,0,0,0,0,0,0});
//            paladinMap.put(11, new Integer[]{0,0,4,3,3,0,0,0,0,0,0});
//            paladinMap.put(12, new Integer[]{0,0,4,3,3,0,0,0,0,0,0});
//            paladinMap.put(13, new Integer[]{0,0,4,3,3,1,0,0,0,0,0});
//            paladinMap.put(14, new Integer[]{0,0,4,3,3,1,0,0,0,0,0});
//            paladinMap.put(15, new Integer[]{0,0,4,3,3,2,0,0,0,0,0});
//            paladinMap.put(16, new Integer[]{0,0,4,3,3,2,0,0,0,0,0});
//            paladinMap.put(17, new Integer[]{0,0,4,3,3,3,1,0,0,0,0});
//            paladinMap.put(18, new Integer[]{0,0,4,3,3,3,1,0,0,0,0});
//            paladinMap.put(19, new Integer[]{0,0,4,3,3,3,2,0,0,0,0});
//            paladinMap.put(20, new Integer[]{0,0,4,3,3,3,2,0,0,0,0});
//
//        } else if (name.equals("Wizard")) {
//            HashMap<Integer,Integer[]> wizardMap = new HashMap<Integer, Integer[]>();
//            wizardMap.put(1, new Integer[]{3,0,2,0,0,0,0,0,0,0,0});
//            wizardMap.put(2, new Integer[]{3,0,3,0,0,0,0,0,0,0,0});
//            wizardMap.put(3, new Integer[]{3,0,4,2,0,0,0,0,0,0,0});
//            wizardMap.put(4, new Integer[]{4,0,4,3,0,0,0,0,0,0,0});
//            wizardMap.put(5, new Integer[]{4,0,4,3,2,0,0,0,0,0,0});
//            wizardMap.put(6, new Integer[]{4,0,4,3,3,0,0,0,0,0,0});
//            wizardMap.put(7, new Integer[]{4,0,4,3,3,1,0,0,0,0,0});
//            wizardMap.put(8, new Integer[]{4,0,4,3,3,2,0,0,0,0,0});
//            wizardMap.put(9, new Integer[]{4,0,4,3,3,3,1,0,0,0,0});
//            wizardMap.put(10, new Integer[]{5,0,4,3,3,3,2,0,0,0,0});
//            wizardMap.put(11, new Integer[]{5,0,4,3,3,3,2,1,0,0,0});
//            wizardMap.put(12, new Integer[]{5,0,4,3,3,3,2,1,0,0,0});
//            wizardMap.put(13, new Integer[]{5,0,4,3,3,3,2,1,1,0,0});
//            wizardMap.put(14, new Integer[]{5,0,4,3,3,3,2,1,1,0,0});
//            wizardMap.put(15, new Integer[]{5,0,4,3,3,3,2,1,1,1,0});
//            wizardMap.put(16, new Integer[]{5,0,4,3,3,3,2,1,1,1,0});
//            wizardMap.put(17, new Integer[]{5,0,4,3,3,3,2,1,1,1,0});
//            wizardMap.put(18, new Integer[]{5,0,4,3,3,3,3,1,1,1,1});
//            wizardMap.put(19, new Integer[]{5,0,4,3,3,3,3,2,1,1,1});
//            wizardMap.put(20, new Integer[]{5,0,4,3,3,3,3,2,2,1,1});
//
//        }
//        character.setMax_cantrips_known(map.get(character_level)[0]);
//        character.setMax_spells_known(map.get(character_level)[1]);
//        Integer[] spellSlots = map.get(character_level);
//        character.setMax_spell_slot_1(spellSlots[2]);
//        character.setSpell_slot_1(spellSlots[2]);
//
//    }

    private void createSpellSlotHashMap(Character character){

        this.spellMap = new HashMap<>();

        DnDClass dnDClass = dnDClassController.getDnDClassesById(character.getClass_id())
                .orElseThrow(() ->
                        new ResourceNotFound("class_id does not match any class")
                );
        String name = dnDClass.getClass_name();


        if (name.equals("Sorcerer")) {
            spellMap.put(1, new Integer[]{4, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0});
            spellMap.put(2, new Integer[]{4,3,3,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{4,4,4,2,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{5,5,4,3,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{5,6,4,3,2,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{5,7,4,3,3,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{5,8,4,3,3,1,0,0,0,0,0});
            spellMap.put(8, new Integer[]{5,9,4,3,3,2,0,0,0,0,0});
            spellMap.put(9, new Integer[]{5,10,4,3,3,3,1,0,0,0,0});
            spellMap.put(10, new Integer[]{6,11,4,3,3,3,2,0,0,0,0});
            spellMap.put(11, new Integer[]{6,12,4,3,3,3,2,1,0,0,0});
            spellMap.put(12, new Integer[]{6,12,4,3,3,3,2,1,0,0,0});
            spellMap.put(13, new Integer[]{6,13,4,3,3,3,2,1,1,0,0});
            spellMap.put(14, new Integer[]{6,13,4,3,3,3,2,1,1,0,0});
            spellMap.put(15, new Integer[]{6,14,4,3,3,3,2,1,1,1,0});
            spellMap.put(16, new Integer[]{6,14,4,3,3,3,2,1,1,1,0});
            spellMap.put(17, new Integer[]{6,15,4,3,3,3,2,1,1,1,1});
            spellMap.put(18, new Integer[]{6,15,4,3,3,3,3,1,1,1,1});
            spellMap.put(19, new Integer[]{6,15,4,3,3,3,3,2,1,1,1});
            spellMap.put(20, new Integer[]{6,15,4,3,3,3,3,2,2,1,1});

        } else if (name.equals("The Bard")) {
            spellMap.put(1, new Integer[]{2,4,2,0,0,0,0,0,0,0,0});
            spellMap.put(2, new Integer[]{2,5,3,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{2,6,4,2,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{3,7,4,3,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{3,8,4,3,2,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{3,9,4,3,3,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{3,10,4,3,3,1,0,0,0,0,0});
            spellMap.put(8, new Integer[]{3,11,4,3,3,2,0,0,0,0,0});
            spellMap.put(9, new Integer[]{3,12,4,3,3,3,1,0,0,0,0});
            spellMap.put(10, new Integer[]{4,14,4,3,3,3,2,0,0,0,0});
            spellMap.put(11, new Integer[]{4,15,4,3,3,3,2,1,0,0,0});
            spellMap.put(12, new Integer[]{4,15,4,3,3,3,2,1,0,0,0});
            spellMap.put(13, new Integer[]{4,16,4,3,3,3,2,1,1,0,0});
            spellMap.put(14, new Integer[]{4,18,4,3,3,3,2,1,1,0,0});
            spellMap.put(15, new Integer[]{4,19,4,3,3,3,2,1,1,1,0});
            spellMap.put(16, new Integer[]{4,19,4,3,3,3,2,1,1,1,0});
            spellMap.put(17, new Integer[]{4,20,4,3,3,3,2,1,1,1,1});
            spellMap.put(18, new Integer[]{4,22,4,3,3,3,3,1,1,1,1});
            spellMap.put(19, new Integer[]{4,22,4,3,3,3,3,2,1,1,1});
            spellMap.put(20, new Integer[]{4,22,4,3,3,3,3,2,2,1,1});
        } else if (name.equals("Warlock")) {
            //Might have to add another row to characters for evocations
            spellMap.put(1, new Integer[]{2,2,1,0,0,0,0,0,0,0,0});
            spellMap.put(2, new Integer[]{2,3,2,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{2,4,0,2,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{3,5,0,2,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{3,6,0,0,2,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{3,7,0,0,2,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{3,8,0,0,0,2,0,0,0,0,0});
            spellMap.put(8, new Integer[]{3,9,0,0,0,2,0,0,0,0,0});
            spellMap.put(9, new Integer[]{3,10,0,0,0,0,2,0,0,0,0});
            spellMap.put(10, new Integer[]{4,10,0,0,0,0,2,0,0,0,0});
            spellMap.put(11, new Integer[]{4,11,0,0,0,0,3,0,0,0,0});
            spellMap.put(12, new Integer[]{4,11,0,0,0,0,3,0,0,0,0});
            spellMap.put(13, new Integer[]{4,12,0,0,0,0,3,0,0,0,0});
            spellMap.put(14, new Integer[]{4,12,0,0,0,0,3,0,0,0,0});
            spellMap.put(15, new Integer[]{4,13,0,0,0,0,3,0,0,0,0});
            spellMap.put(16, new Integer[]{4,13,0,0,0,0,3,0,0,0,0});
            spellMap.put(17, new Integer[]{4,14,0,0,0,0,4,0,0,0,0});
            spellMap.put(18, new Integer[]{4,14,0,0,0,0,4,0,0,0,0});
            spellMap.put(19, new Integer[]{4,15,0,0,0,0,4,0,0,0,0});
            spellMap.put(20, new Integer[]{4,15,0,0,0,0,4,0,0,0,0});

        } else if (name.equals("The Ranger")) {
            spellMap.put(1, new Integer[]{0,0,0,0,0,0,0,0,0,0,0});
            spellMap.put(2, new Integer[]{0,2,2,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{0,3,3,0,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{0,3,3,0,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{0,4,4,2,0,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{0,4,4,2,0,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{0,5,4,3,0,0,0,0,0,0,0});
            spellMap.put(8, new Integer[]{0,5,4,3,0,0,0,0,0,0,0});
            spellMap.put(9, new Integer[]{0,6,4,3,2,0,0,0,0,0,0});
            spellMap.put(10, new Integer[]{0,6,4,3,2,0,0,0,0,0,0});
            spellMap.put(11, new Integer[]{0,7,4,3,3,0,0,0,0,0,0});
            spellMap.put(12, new Integer[]{0,7,4,3,3,0,0,0,0,0,0});
            spellMap.put(13, new Integer[]{0,8,4,3,3,1,0,0,0,0,0});
            spellMap.put(14, new Integer[]{0,8,4,3,3,1,0,0,0,0,0});
            spellMap.put(15, new Integer[]{0,9,4,3,3,2,0,0,0,0,0});
            spellMap.put(16, new Integer[]{0,9,4,3,3,2,0,0,0,0,0});
            spellMap.put(17, new Integer[]{0,10,4,3,3,3,1,0,0,0,0});
            spellMap.put(18, new Integer[]{0,10,4,3,3,3,1,0,0,0,0});
            spellMap.put(19, new Integer[]{0,11,4,3,3,3,2,0,0,0,0});
            spellMap.put(20, new Integer[]{0,11,4,3,3,3,2,0,0,0,0});


        } else if (name.equals("Cleric")) {
            spellMap.put(1, new Integer[]{3,0,2,0,0,0,0,0,0,0,0});
            spellMap.put(2, new Integer[]{3,0,3,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{3,0,4,2,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{4,0,4,3,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{4,0,4,3,2,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{4,0,4,3,3,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{4,0,4,3,3,1,0,0,0,0,0});
            spellMap.put(8, new Integer[]{4,0,4,3,3,2,0,0,0,0,0});
            spellMap.put(9, new Integer[]{4,0,4,3,3,3,1,0,0,0,0});
            spellMap.put(10, new Integer[]{5,0,4,3,3,3,2,0,0,0,0});
            spellMap.put(11, new Integer[]{5,0,4,3,3,3,2,1,0,0,0});
            spellMap.put(12, new Integer[]{5,0,4,3,3,3,2,1,0,0,0});
            spellMap.put(13, new Integer[]{5,0,4,3,3,3,2,1,1,0,0});
            spellMap.put(14, new Integer[]{5,0,4,3,3,3,2,1,1,0,0});
            spellMap.put(15, new Integer[]{5,0,4,3,3,3,2,1,1,1,0});
            spellMap.put(16, new Integer[]{5,0,4,3,3,3,2,1,1,1,0});
            spellMap.put(17, new Integer[]{5,0,4,3,3,3,2,1,1,1,1});
            spellMap.put(18, new Integer[]{5,0,4,3,3,3,3,1,1,1,1});
            spellMap.put(19, new Integer[]{5,0,4,3,3,3,3,2,1,1,1});
            spellMap.put(20, new Integer[]{5,0,4,3,3,3,3,2,2,1,1});


        } else if (name.equals("Druid")) {
            spellMap.put(1, new Integer[]{2,0,2,0,0,0,0,0,0,0,0});
            spellMap.put(2, new Integer[]{2,0,3,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{2,0,4,2,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{3,0,4,3,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{3,0,4,3,2,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{3,0,4,3,3,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{3,0,4,3,3,1,0,0,0,0,0});
            spellMap.put(8, new Integer[]{3,0,4,3,3,2,0,0,0,0,0});
            spellMap.put(9, new Integer[]{3,0,4,3,3,3,1,0,0,0,0});
            spellMap.put(10, new Integer[]{4,0,4,3,3,3,2,0,0,0,0});
            spellMap.put(11, new Integer[]{4,0,4,3,3,3,2,1,0,0,0});
            spellMap.put(12, new Integer[]{4,0,4,3,3,3,2,1,0,0,0});
            spellMap.put(13, new Integer[]{4,0,4,3,3,3,2,1,1,0,0});
            spellMap.put(14, new Integer[]{4,0,4,3,3,3,2,1,1,0,0});
            spellMap.put(15, new Integer[]{4,0,4,3,3,3,2,1,1,1,0});
            spellMap.put(16, new Integer[]{4,0,4,3,3,3,2,1,1,1,0});
            spellMap.put(17, new Integer[]{4,0,4,3,3,3,3,1,1,1,1});
            spellMap.put(18, new Integer[]{4,0,4,3,3,3,3,1,1,1,1});
            spellMap.put(19, new Integer[]{4,0,4,3,3,3,3,2,1,1,1});
            spellMap.put(20, new Integer[]{4,0,4,3,3,3,3,2,2,1,1});

        } else if (name.equals("Paladin")) {
            spellMap.put(1, new Integer[]{0,0,0,0,0,0,0,0,0,0,0});
            spellMap.put(2, new Integer[]{0,0,2,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{0,0,3,0,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{0,0,3,0,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{0,0,4,2,0,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{0,0,4,2,0,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{0,0,4,3,0,0,0,0,0,0,0});
            spellMap.put(8, new Integer[]{0,0,4,3,0,0,0,0,0,0,0});
            spellMap.put(9, new Integer[]{0,0,4,3,2,0,0,0,0,0,0});
            spellMap.put(10, new Integer[]{0,0,4,3,2,0,0,0,0,0,0});
            spellMap.put(11, new Integer[]{0,0,4,3,3,0,0,0,0,0,0});
            spellMap.put(12, new Integer[]{0,0,4,3,3,0,0,0,0,0,0});
            spellMap.put(13, new Integer[]{0,0,4,3,3,1,0,0,0,0,0});
            spellMap.put(14, new Integer[]{0,0,4,3,3,1,0,0,0,0,0});
            spellMap.put(15, new Integer[]{0,0,4,3,3,2,0,0,0,0,0});
            spellMap.put(16, new Integer[]{0,0,4,3,3,2,0,0,0,0,0});
            spellMap.put(17, new Integer[]{0,0,4,3,3,3,1,0,0,0,0});
            spellMap.put(18, new Integer[]{0,0,4,3,3,3,1,0,0,0,0});
            spellMap.put(19, new Integer[]{0,0,4,3,3,3,2,0,0,0,0});
            spellMap.put(20, new Integer[]{0,0,4,3,3,3,2,0,0,0,0});

        } else if (name.equals("Wizard")) {
            spellMap.put(1, new Integer[]{3,0,2,0,0,0,0,0,0,0,0});
            spellMap.put(2, new Integer[]{3,0,3,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{3,0,4,2,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{4,0,4,3,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{4,0,4,3,2,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{4,0,4,3,3,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{4,0,4,3,3,1,0,0,0,0,0});
            spellMap.put(8, new Integer[]{4,0,4,3,3,2,0,0,0,0,0});
            spellMap.put(9, new Integer[]{4,0,4,3,3,3,1,0,0,0,0});
            spellMap.put(10, new Integer[]{5,0,4,3,3,3,2,0,0,0,0});
            spellMap.put(11, new Integer[]{5,0,4,3,3,3,2,1,0,0,0});
            spellMap.put(12, new Integer[]{5,0,4,3,3,3,2,1,0,0,0});
            spellMap.put(13, new Integer[]{5,0,4,3,3,3,2,1,1,0,0});
            spellMap.put(14, new Integer[]{5,0,4,3,3,3,2,1,1,0,0});
            spellMap.put(15, new Integer[]{5,0,4,3,3,3,2,1,1,1,0});
            spellMap.put(16, new Integer[]{5,0,4,3,3,3,2,1,1,1,0});
            spellMap.put(17, new Integer[]{5,0,4,3,3,3,2,1,1,1,0});
            spellMap.put(18, new Integer[]{5,0,4,3,3,3,3,1,1,1,1});
            spellMap.put(19, new Integer[]{5,0,4,3,3,3,3,2,1,1,1});
            spellMap.put(20, new Integer[]{5,0,4,3,3,3,3,2,2,1,1});

        }


    }
}
