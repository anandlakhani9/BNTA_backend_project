package com.drumandbase.dndspellapi.characters;

import com.drumandbase.dndspellapi.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService{

    private final CharacterDAO characterDAO;

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

    // use Character set methods for spell slots
    public void initSpellSlots(int character_level, int class_id){

    }
}
