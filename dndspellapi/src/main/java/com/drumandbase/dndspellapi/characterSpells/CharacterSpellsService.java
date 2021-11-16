package com.drumandbase.dndspellapi.characterSpells;

import com.drumandbase.dndspellapi.characters.CharacterDAO;
import com.drumandbase.dndspellapi.dndclasses.DnDClassDAO;
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
    public CharacterSpellsService(@Qualifier("spellbook") CharacterSpellsDAO csDAO){
        this.csDAO = csDAO;
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

//    public void addSpell(long characterID, long spellID){
    public void addSpell(CharacterSpells cs){
        csDAO.insertSpell(cs);
    }
}

