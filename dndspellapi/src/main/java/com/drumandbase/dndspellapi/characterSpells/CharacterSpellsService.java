package com.drumandbase.dndspellapi.characterSpells;

import com.drumandbase.dndspellapi.characters.CharacterDAO;
import com.drumandbase.dndspellapi.characters.CharacterService;
import com.drumandbase.dndspellapi.dndclasses.DnDClassDAO;
import com.drumandbase.dndspellapi.exceptions.ResourceNotFound;
import com.drumandbase.dndspellapi.schools.School;
import com.drumandbase.dndspellapi.spells.SpellDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.drumandbase.dndspellapi.characters.Character;
import com.drumandbase.dndspellapi.spells.Spell;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterSpellsService {

    private final CharacterSpellsDAO csDAO;
    private final CharacterDAO characterDAO;
    private final SpellDAO spellDAO;
    private final DnDClassDAO classDAO;

    @Autowired
    public CharacterSpellsService(@Qualifier("spellbook") CharacterSpellsDAO csDAO, CharacterDAO characterDAO, SpellDAO spellDAO, DnDClassDAO classDAO) {
        this.csDAO = csDAO;
        this.characterDAO = characterDAO;
        this.spellDAO = spellDAO;
        this.classDAO = classDAO;
    }

    public List<SpellbookDisplay> getACharactersSpellsByID(long id) {
        return csDAO.selectAllSpellsByCharacterID(id);
    }

    //in the add method, check if the character has the appropriate slot free
    //also need to check canWizard or canBard etc
    //add method logic
    /*public void addSpell(long characterID, long spellID){

        Character character = characterDAO.selectCharacterById(characterID).get();
        Spell spell = spellDAO.selectSpellByID(spellID).get();
        //needed?
        *//*if (character.getCharacter_level() >= spell.getSpellLevel()){

        }*//*
        String characterClass = classDAO.selectDnDClassById(character.getClass_id())
                .get()
                .getClass_name();
        int spellLevel = spell.getSpellLevel();
        //if (characterClass.equals())
        //if (spellLevel==0){
            //do we need a cantrips known and spells known so we can decrement?
            //if(character.getCantripsKnown() > 0)
                // if wizard&&canWizard || bard&&canBard etc
                    // add spell, decrement cantrips known
                //else
                    //throw error this class can't learn this
            //else
                //throw error - not enough free spell slots
        //else if (spellLevel == 1)
        //...

    }*/

    public boolean canKnowSpell(String characterClass, Spell spell) {
        System.out.println(characterClass);
        if (characterClass.equals("Sorcerer") && spell.getCanSorcerer()) {
            return true;
        } else if (characterClass.equals("Wizard") && spell.getCanWizard()) {
            return true;
        } else if (characterClass.equals("Warlock") && spell.getCanWarlock()) {
            return true;
        } else if (characterClass.equals("Bard") && spell.getCanBard()) {
            return true;
        } else if (characterClass.equals("Paladin") && spell.getCanPaladin()) {
            return true;
        } else if (characterClass.equals("Druid") && spell.getCanDruid()) {
            return true;
        } else if (characterClass.equals("Cleric") && spell.getCanCleric()) {
            return true;
        } else return characterClass.equals("Ranger") && spell.getCanRanger();
    }

    //    public void addSpell(long characterID, long spellID){
    /*public void addSpell2(CharacterSpells cs) {
        csDAO.insertSpell(cs);
    }*/

    //refactor abstract out functionality
    public void addSpell3(CharacterSpells cs) {
        Character character = characterDAO
                .selectCharacterById(cs.getCharacterID()).orElseThrow(() -> new IllegalStateException("something wrong"));
        System.out.println(character);
        String className = classDAO.selectDnDClassById(character.getClass_id()).get().getClass_name();
        Spell spell = spellDAO
                .selectSpellByID(cs.getSpellID()).get();
        // if it is not a spell the character actually wants to know
        // add it to the database
        if (!cs.getSpellIsKnown()) {
            csDAO.insertSpell(cs);
        }
        //otherwise, need to check it can learn the spell
        else {
            if (spell.getSpellLevel() == 0) {
                if (character.getMax_cantrips_known() == -1) {
                    if (canKnowSpell(className, spell)) {
                        List<CharacterSpells> spellbook = csDAO.selectAllCharacterSpellsByCharacterID(character.getId());
                        boolean exists = false;
                        for (CharacterSpells someSpell : spellbook) {
                            if (someSpell.getSpellID() == spell.getId()) {
                                exists = true;
                                break;
                            }
                        }
                        if (!exists) {
                            csDAO.insertSpell(cs);
                            character.setCantrips_known(character.getCantrips_known() + 1);
                            //need to update character db, method needs to be defined first
                            characterDAO.updateCharacter(character);
                        } else {
                            throw new IllegalStateException("spell with this id is already in spellbook");
                        }
                    }
                }
                else if (character.getCantrips_known() < character.getMax_cantrips_known()
                        && character.getMax_cantrips_known() != 0) {
                    if (canKnowSpell(className, spell)) {
                        List<CharacterSpells> spellbook = csDAO.selectAllCharacterSpellsByCharacterID(character.getId());
                        boolean exists = false;
                        for (CharacterSpells someSpell : spellbook) {
                            if (someSpell.getSpellID() == spell.getId()) {
                                exists = true;
                                break;
                            }
                        }
                        if (!exists) {
                            csDAO.insertSpell(cs);
                            character.setCantrips_known(character.getCantrips_known() + 1);
                            //need to update character db, method needs to be defined first
                            characterDAO.updateCharacter(character);
                        } else {
                            throw new IllegalStateException("spell with this id is already in spellbook");
                        }
                    } else {
                        throw new IllegalStateException("this character cannot learn this cantrip");
                    }
                } else {
                    throw new IllegalStateException("number of cantrips full");
                }
            }
            else if (spell.getSpellLevel() == 1) {
                if (character.getMax_spells_known() == -1 && character.getMax_spell_slot_1() > 0) {
                    if (canKnowSpell(className, spell)) {
                        List<CharacterSpells> spellbook = csDAO.selectAllCharacterSpellsByCharacterID(character.getId());
                        boolean exists = false;
                        for (CharacterSpells someSpell : spellbook) {
                            if (someSpell.getSpellID() == spell.getId()) {
                                exists = true;
                                break;
                            }
                        }
                        if (!exists) {
                            csDAO.insertSpell(cs);
                            character.setSpell_slot_1(character.getSpell_slot_1() + 1);
                            //need to update character db, method needs to be defined first
                            characterDAO.updateCharacter(character);
                        } else {
                            throw new IllegalStateException("spell with this id is already in spellbook");
                        }
                    }
                } else if (character.getSpells_known() < character.getMax_spells_known()
                        && character.getMax_spells_known() != 0
                        && character.getMax_spell_slot_1() != 0) {
                    if (canKnowSpell(className, spell)) {
                        List<CharacterSpells> spellbook = csDAO.selectAllCharacterSpellsByCharacterID(character.getId());
                        boolean exists = false;
                        for (CharacterSpells someSpell : spellbook) {
                            if (someSpell.getSpellID() == spell.getId()) {
                                exists = true;
                                break;
                            }

                        }
                        if (!exists) {
                            csDAO.insertSpell(cs);
                            character.setSpell_slot_1(character.getSpell_slot_1() + 1);
                            //need to update character db, method needs to be defined first
                            characterDAO.updateCharacter(character);
                        } else {
                            throw new IllegalStateException("spell with this id is already in spellbook");
                        }

                    } else {
                        throw new IllegalStateException("this character cannot learn this spell");
                    }
                } else {
                    throw new IllegalStateException("number of spells full");
                }
            } else if (spell.getSpellLevel() == 2) {
                if (character.getMax_spells_known() == -1 && character.getMax_spell_slot_1() > 0) {
                    if (canKnowSpell(className, spell)) {
                        List<CharacterSpells> spellbook = csDAO.selectAllCharacterSpellsByCharacterID(character.getId());
                        boolean exists = false;
                        for (CharacterSpells someSpell : spellbook) {
                            if (someSpell.getSpellID() == spell.getId()) {
                                exists = true;
                                break;
                            }
                        }
                        if (!exists) {
                            csDAO.insertSpell(cs);
                            character.setSpell_slot_2(character.getSpell_slot_2() + 1);
                            //need to update character db, method needs to be defined first
                            characterDAO.updateCharacter(character);
                        } else {
                            throw new IllegalStateException("spell with this id is already in spellbook");
                        }
                    }
                } else if (character.getSpells_known() < character.getMax_spells_known()
                        && character.getMax_spells_known() != 0
                        && character.getMax_spell_slot_2() != 0) {
                    if (canKnowSpell(className, spell)) {
                        List<CharacterSpells> spellbook = csDAO.selectAllCharacterSpellsByCharacterID(character.getId());
                        boolean exists = false;
                        for (CharacterSpells someSpell : spellbook) {
                            if (someSpell.getSpellID() == spell.getId()) {
                                exists = true;
                                break;
                            }

                        }
                        if (!exists) {
                            csDAO.insertSpell(cs);
                            character.setSpell_slot_2(character.getSpell_slot_2() + 1);
                            //need to update character db, method needs to be defined first
                            characterDAO.updateCharacter(character);
                        } else {
                            throw new IllegalStateException("spell with this id is already in spellbook");
                        }

                    } else {
                        throw new IllegalStateException("this character cannot learn this spell");
                    }
                } else {
                    throw new IllegalStateException("number of spells full");
                }
            } else if (spell.getSpellLevel() == 3) {
                if (character.getMax_spells_known() == -1 && character.getMax_spell_slot_3() > 0) {
                    if (canKnowSpell(className, spell)) {
                        List<CharacterSpells> spellbook = csDAO.selectAllCharacterSpellsByCharacterID(character.getId());
                        boolean exists = false;
                        for (CharacterSpells someSpell : spellbook) {
                            if (someSpell.getSpellID() == spell.getId()) {
                                exists = true;
                                break;
                            }
                        }
                        if (!exists) {
                            csDAO.insertSpell(cs);
                            character.setSpell_slot_1(character.getSpell_slot_3() + 1);
                            //need to update character db, method needs to be defined first
                            characterDAO.updateCharacter(character);
                        } else {
                            throw new IllegalStateException("spell with this id is already in spellbook");
                        }
                    }
                } else if (character.getSpells_known() < character.getMax_spells_known()
                        && character.getMax_spells_known() != 0
                        && character.getMax_spell_slot_3() != 0) {
                    if (canKnowSpell(className, spell)) {
                        List<CharacterSpells> spellbook = csDAO.selectAllCharacterSpellsByCharacterID(character.getId());
                        boolean exists = false;
                        for (CharacterSpells someSpell : spellbook) {
                            if (someSpell.getSpellID() == spell.getId()) {
                                exists = true;
                                break;
                            }

                        }
                        if (!exists) {
                            csDAO.insertSpell(cs);
                            character.setSpell_slot_3(character.getSpell_slot_3() + 1);
                            //need to update character db, method needs to be defined first
                            characterDAO.updateCharacter(character);
                        } else {
                            throw new IllegalStateException("spell with this id is already in spellbook");
                        }

                    } else {
                        throw new IllegalStateException("this character cannot learn this spell");
                    }
                } else {
                    throw new IllegalStateException("number of spells full");
                }
            }
            else if (spell.getSpellLevel() == 4) {
                if (character.getMax_spells_known() == -1 && character.getMax_spell_slot_4() > 0) {
                    if (canKnowSpell(className, spell)) {
                        List<CharacterSpells> spellbook = csDAO.selectAllCharacterSpellsByCharacterID(character.getId());
                        boolean exists = false;
                        for (CharacterSpells someSpell : spellbook) {
                            if (someSpell.getSpellID() == spell.getId()) {
                                exists = true;
                                break;
                            }
                        }
                        if (!exists) {
                            csDAO.insertSpell(cs);
                            character.setSpell_slot_4(character.getSpell_slot_4() + 1);
                            //need to update character db, method needs to be defined first
                            characterDAO.updateCharacter(character);
                        } else {
                            throw new IllegalStateException("spell with this id is already in spellbook");
                        }
                    }
                } else if (character.getSpells_known() < character.getMax_spells_known()
                        && character.getMax_spells_known() != 0
                        && character.getMax_spell_slot_4() != 0) {
                    if (canKnowSpell(className, spell)) {
                        List<CharacterSpells> spellbook = csDAO.selectAllCharacterSpellsByCharacterID(character.getId());
                        boolean exists = false;
                        for (CharacterSpells someSpell : spellbook) {
                            if (someSpell.getSpellID() == spell.getId()) {
                                exists = true;
                                break;
                            }

                        }
                        if (!exists) {
                            csDAO.insertSpell(cs);
                            character.setSpell_slot_4(character.getSpell_slot_4() + 1);
                            //need to update character db, method needs to be defined first
                            characterDAO.updateCharacter(character);
                        } else {
                            throw new IllegalStateException("spell with this id is already in spellbook");
                        }

                    } else {
                        throw new IllegalStateException("this character cannot learn this spell");
                    }
                } else {
                    throw new IllegalStateException("number of spells full");
                }
            }
        }

    }


    private boolean isSpellAlreadyInBook(long id, Spell spell){
        List<CharacterSpells> spellbook = csDAO.selectAllCharacterSpellsByCharacterID(id);
        System.out.println(spellbook.toArray().length);
        for (CharacterSpells someSpell : spellbook) {
            System.out.println(someSpell);
            if (someSpell.getSpellID() == spell.getId()) {
                System.out.println("found");
                return true;
            }
        }
        System.out.println("not found");
        return false;
    }

    private  void addCanTrip(CharacterSpells cs, Character character, Spell spell){
        if(!isSpellAlreadyInBook(character.getId(), spell) && spell.getId() == 0){
            csDAO.insertSpell(cs);
            character.setCantrips_known(character.getCantrips_known() + 1);
            //need to update character db, method needs to be defined first
            characterDAO.updateCharacter(character);
        }
        else {
            throw new IllegalStateException("spell with this id is already in spellbook");
        }
    }

    private void addCanTripLogic(Character character, Spell spell, CharacterSpells cs){
        if (spell.getSpellLevel() == 0){
            if (character.getMax_cantrips_known() == -1){
                addCanTrip(cs, character, spell);
            }
            else if(character.getCantrips_known() < character.getMax_cantrips_known()
                    && character.getMax_cantrips_known() != 0){
                addCanTrip(cs, character, spell);
            }
            else{
                throw new IllegalStateException("number of cantrips full");
            }
        }
    }

    private  void addSpell(CharacterSpells cs, Character character, Spell spell){
        if(!isSpellAlreadyInBook(character.getId(), spell) && spell.getId() > 0){
            csDAO.insertSpell(cs);
            character.setSpells_known(character.getSpells_known() + 1);
            //need to update character db, method needs to be defined first
            characterDAO.updateCharacter(character);
        }
        else {
            throw new IllegalStateException("spell with this id is already in spellbook");
        }
    }

    private void addSpellLv1Logic(Character character, Spell spell, CharacterSpells cs){
        if (spell.getSpellLevel() == 1){
            if (character.getMax_spells_known() == -1){
                addSpell(cs, character, spell);
            }
            else if(character.getSpells_known() < character.getMax_spells_known()
                    && character.getMax_spells_known() != 0){
                if(character.getMax_spell_slot_1() > 0){
                    addSpell(cs, character, spell);
                }
                else {
                    throw new IllegalStateException("spell too high level");
                }
            }
            else{
                throw new IllegalStateException("number of spells full");
            }
        }
    }

    private void addSpellLv2Logic(Character character, Spell spell, CharacterSpells cs){
        if (spell.getSpellLevel() == 2){
            if (character.getMax_spells_known() == -1){
                addSpell(cs, character, spell);
            }
            else if(character.getSpells_known() < character.getMax_spells_known()
                    && character.getMax_spells_known() != 0){
                if(character.getMax_spell_slot_2() > 0){
                    addSpell(cs, character, spell);
                }
                else {
                    throw new IllegalStateException("spell too high level");
                }
            }
            else{
                throw new IllegalStateException("number of spells full");
            }
        }
    }

    private void addSpellLv3Logic(Character character, Spell spell, CharacterSpells cs){
        if (spell.getSpellLevel() == 3){
            if (character.getMax_spells_known() == -1){
                addSpell(cs, character, spell);
            }
            else if(character.getSpells_known() < character.getMax_spells_known()
                    && character.getMax_spells_known() != 0){
                if(character.getMax_spell_slot_3() > 0){
                    addSpell(cs, character, spell);
                }
                else {
                    throw new IllegalStateException("spell too high level");
                }
            }
            else{
                throw new IllegalStateException("number of spells full");
            }
        }
    }
    private void addSpellLv4Logic(Character character, Spell spell, CharacterSpells cs){
        if (spell.getSpellLevel() == 4){
            if (character.getMax_spells_known() == -1){
                addSpell(cs, character, spell);
            }
            else if(character.getSpells_known() < character.getMax_spells_known()
                    && character.getMax_spells_known() != 0){
                if(character.getMax_spell_slot_4() > 0){
                    addSpell(cs, character, spell);
                }
                else {
                    throw new IllegalStateException("spell too high level");
                }
            }
            else{
                throw new IllegalStateException("number of spells full");
            }
        }
    }

    private void addSpellLv5Logic(Character character, Spell spell, CharacterSpells cs){
        if (spell.getSpellLevel() == 5){
            if (character.getMax_spells_known() == -1){
                addSpell(cs, character, spell);
            }
            else if(character.getSpells_known() < character.getMax_spells_known()
                    && character.getMax_spells_known() != 0){
                if(character.getMax_spell_slot_5() > 0){
                    addSpell(cs, character, spell);
                }
                else {
                    throw new IllegalStateException("spell too high level");
                }
            }
            else{
                throw new IllegalStateException("number of spells full");
            }
        }
    }
    private void addSpellLv6Logic(Character character, Spell spell, CharacterSpells cs){
        if (spell.getSpellLevel() == 6){
            if (character.getMax_spells_known() == -1){
                addSpell(cs, character, spell);
            }
            else if(character.getSpells_known() < character.getMax_spells_known()
                    && character.getMax_spells_known() != 0){
                if(character.getMax_spell_slot_6() > 0){
                    addSpell(cs, character, spell);
                }
                else {
                    throw new IllegalStateException("spell too high level");
                }
            }
            else{
                throw new IllegalStateException("number of spells full");
            }
        }
    }
    private void addSpellLv7Logic(Character character, Spell spell, CharacterSpells cs){
        if (spell.getSpellLevel() == 7){
            if (character.getMax_spells_known() == -1){
                addSpell(cs, character, spell);
            }
            else if(character.getSpells_known() < character.getMax_spells_known()
                    && character.getMax_spells_known() != 0){
                if(character.getMax_spell_slot_7() > 0){
                    addSpell(cs, character, spell);
                }
                else {
                    throw new IllegalStateException("spell too high level");
                }
            }
            else{
                throw new IllegalStateException("number of spells full");
            }
        }
    }

    private void addSpellLv8Logic(Character character, Spell spell, CharacterSpells cs){
        if (spell.getSpellLevel() == 8){
            if (character.getMax_spells_known() == -1){
                addSpell(cs, character, spell);
            }
            else if(character.getSpells_known() < character.getMax_spells_known()
                    && character.getMax_spells_known() != 0){
                if(character.getMax_spell_slot_8() > 0){
                    addSpell(cs, character, spell);
                }
                else {
                    throw new IllegalStateException("spell too high level");
                }
            }
            else{
                throw new IllegalStateException("number of spells full");
            }
        }
    }

    private void addSpellLv9Logic(Character character, Spell spell, CharacterSpells cs){
        if (spell.getSpellLevel() == 9){
            if (character.getMax_spells_known() == -1){
                addSpell(cs, character, spell);
            }
            else if(character.getSpells_known() < character.getMax_spells_known()
                    && character.getMax_spells_known() != 0){
                if(character.getMax_spell_slot_9() > 0){
                    addSpell(cs, character, spell);
                }
                else {
                    throw new IllegalStateException("spell too high level");
                }
            }
            else{
                throw new IllegalStateException("number of spells full");
            }
        }
    }

    public void addSpell4(CharacterSpells cs){
        Character character = characterDAO.selectCharacterById(cs.getCharacterID()).get();
        Spell spell = spellDAO.selectSpellByID(cs.getSpellID()).get();

        if (!cs.getSpellIsKnown()){
            addCanTrip(cs, character, spell);
            addSpell(cs, character, spell);
        }
        else{
            addCanTripLogic(character, spell, cs);
            addSpellLv1Logic(character, spell, cs);
            addSpellLv2Logic(character, spell, cs);
            addSpellLv3Logic(character, spell, cs);
            addSpellLv4Logic(character, spell, cs);
            addSpellLv5Logic(character, spell, cs);
            addSpellLv6Logic(character, spell, cs);
            addSpellLv7Logic(character, spell, cs);
            addSpellLv8Logic(character, spell, cs);
            addSpellLv9Logic(character, spell, cs);
        }

    }

    public void deleteSpell(long id) {
        CharacterSpells cs = getSpell(id)
                .orElseThrow(() ->
                        new ResourceNotFound("School with this id:" + id + " doesn't exist")
                );
        csDAO.deleteSpell(id);
    }

    private Optional<CharacterSpells> getSpell(long id) {
        return csDAO.getRecord(id);
    }
}



