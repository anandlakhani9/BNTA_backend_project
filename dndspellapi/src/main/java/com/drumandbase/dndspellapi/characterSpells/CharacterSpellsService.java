package com.drumandbase.dndspellapi.characterSpells;

import com.drumandbase.dndspellapi.characters.CharacterDAO;
import com.drumandbase.dndspellapi.dndclasses.DnDClassDAO;
import com.drumandbase.dndspellapi.schools.School;
import com.drumandbase.dndspellapi.spells.SpellDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.drumandbase.dndspellapi.characters.Character;
import com.drumandbase.dndspellapi.spells.Spell;

import java.util.List;

@Service
public class CharacterSpellsService {

    private final CharacterSpellsDAO csDAO;
    private CharacterDAO characterDAO;
    private SpellDAO spellDAO;
    private DnDClassDAO classDAO;

    @Autowired
    public CharacterSpellsService(@Qualifier("spellbook") CharacterSpellsDAO csDAO, CharacterDAO characterDAO, SpellDAO spellDAO, DnDClassDAO classDAO){
        this.csDAO = csDAO;
        this.characterDAO = characterDAO;
        this.spellDAO=spellDAO;
        this.classDAO = classDAO;
    }

    public List<SpellbookDisplay> getACharactersSpellsByID(long id){
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

    public boolean canKnowSpell(String characterClass, Spell spell){
        System.out.println(characterClass);
        if (characterClass.equals("Sorcerer") && spell.getCanSorcerer()) {
            return true;
        }
        else if (characterClass.equals("Wizard") && spell.getCanWizard()){
            return true;
        }
        else if (characterClass.equals("Warlock") && spell.getCanWarlock()){
            return true;
        }
        else if (characterClass.equals("Bard") && spell.getCanBard()){
            return true;
        }
        else if (characterClass.equals("Paladin") && spell.getCanPaladin()){
            return true;
        }
        else if (characterClass.equals("Druid") && spell.getCanDruid()){
            return true;
        }
        else if (characterClass.equals("Cleric") && spell.getCanCleric()){
            return true;
        }
        else if (characterClass.equals("Ranger") && spell.getCanRanger()){
            return true;
        }
        return false;
    }

//    public void addSpell(long characterID, long spellID){
    public void addSpell2(CharacterSpells cs){
        csDAO.insertSpell(cs);
    }

    public void addSpell(CharacterSpells cs){
        Character character = characterDAO
                .selectCharacterById(cs.getCharacterID()).orElseThrow(() -> new IllegalStateException("something wrong"));
        System.out.println(character);
        String className = classDAO.selectDnDClassById(character.getClass_id()).get().getClass_name();
        Spell spell = spellDAO
                .selectSpellByID(cs.getSpellID()).get();
        // if it is not a spell the character actually wants to know
        // add it to the database
        if (!cs.getSpellIsKnown()){
            csDAO.insertSpell(cs);
        }
        //otherwise, need to check it can learn the spell
        else {
            if (spell.getSpellLevel() == 0){
                if (character.getCantrips_known()< character.getMax_cantrips_known()
                        && character.getMax_cantrips_known()!=0){
                    if(canKnowSpell(className, spell)){
                        List<CharacterSpells> spellbook = csDAO.selectAllCharacterSpellsByCharacterID(character.getId());
                        boolean exists = false;
                        for (CharacterSpells someSpell:spellbook) {
                            if (someSpell.getSpellID() == spell.getId()){
                                exists = true;
                                break;
                            }
                        }
                        if(!exists){
                            csDAO.insertSpell(cs);
                            character.setCantrips_known(character.getCantrips_known()+1);
                            //need to update character db, method needs to be defined first
                            //characterDAO.updateCharacterByID(character);
                        }
                        else {
                            throw new IllegalStateException("spell with this id is already in spellbook");
                        }
                    }
                    else {
                        throw new IllegalStateException("this character cannot learn this cantrip");
                    }
                }
                else {
                    throw new IllegalStateException("number of cantrips full");
                }
            }
            else if (spell.getSpellLevel() == 1){
                if (character.getSpells_known()< character.getMax_spells_known()
                        && character.getMax_spells_known()!=0
                        && character.getMax_spell_slot_1()!=0){
                    if(canKnowSpell(className, spell)){
                        List<CharacterSpells> spellbook = csDAO.selectAllCharacterSpellsByCharacterID(character.getId());
                        boolean exists = false;
                        for (CharacterSpells someSpell:spellbook) {
                            if (someSpell.getSpellID() == spell.getId()){
                                exists = true;
                                break;
                            }

                        }
                        if(!exists){
                            csDAO.insertSpell(cs);
                            character.setCantrips_known(character.getCantrips_known()+1);
                            //need to update character db, method needs to be defined first
                            //characterDAO.updateCharacterByID(character);
                        }
                        else {
                            throw new IllegalStateException("spell with this id is already in spellbook");
                        }

                    }
                    else {
                        throw new IllegalStateException("this character cannot learn this spell");
                    }
                }
                else {
                    throw new IllegalStateException("number of spells full");
                }
            }
        }

    }
}



